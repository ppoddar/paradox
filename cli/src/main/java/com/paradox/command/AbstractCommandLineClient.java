package com.paradox.command;

import java.io.Console;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A command-line client. Uses JVM console for i/o. The command descriptions are
 * specified in a XML descriptor compliant to a <a href="./commands.xsd">Command
 * Specification Schema</a> . See <a
 * href="./paradox-commands.xml">comamnds.xml</a> for an example. <br>
 * Provides help for registered commands. <br>
 * 
 * @author pinaki poddar
 *
 */
public abstract class AbstractCommandLineClient implements CLI {
	private final Console _console;

	private String _description;
	private String _prompt;
	private String _greetings;
	private HelpCommand _help;
	private Set<Command> _metas = new HashSet<Command>();

	protected AbstractCommandLineClient() {
		_console = System.console();
		if (_console == null) {
			throw new RuntimeException("Console is not available");
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));
	}

	protected void registerCommand(Command cmd) {
		_metas.add(cmd);
	}

	protected void setHelp(String key) {
		registerCommand(_help = new HelpCommand(this, key));
	}

	/**
	 * Execution loop reads command line and executes commands.
	 */
	@Override
	public final void run() {
		greet();
		String line = null;
		while ((line = _console.readLine("%s", _prompt)) != null) {
			if (line.isEmpty())
				continue;
			try {
				executeCommandLine(line);
			} catch (ParseException ex) {
				getWriter().println("*** ERROR: " + ex.getMessage());
			} catch (InvocationTargetException ex) {
				getWriter().println(
						"*** ERROR: " + ex.getTargetException().getMessage());
				getWriter().println("Execution Stacktrace:");
				ex.getTargetException().printStackTrace();
			} catch (Throwable t) {
				handleError(t);
			}
		}
	}

	/**
	 * Execute the command registered as the given command moniker.
	 * 
	 * @param cmd
	 *            moniker of the command
	 * @param line
	 *            the entire command line
	 * @param options
	 *            the parsed options and their values
	 * @param args
	 *            the parsed arguments
	 * @throws Exception
	 *             raise exception from execution. This receiver will print
	 *             stack trace on console.
	 */
	protected abstract void execute(ParsedCommand cmd) throws Exception;

	public void handleError(Throwable t) {
		getWriter().println(
				"*** ERROR: " + t.getClass().getName() + ": " + t.getMessage());
		if (t.getCause() != null && t.getCause() != t) {
			handleError(t.getCause());
		}
	}

	void greet() {
		if (_greetings == null)
			return;
		getWriter().println();
		getWriter().println("\t\t" + _greetings);
		getWriter().println();
	}

	protected void setPrompt(String p) {
		if (p != null)
			_prompt = p;
	}

	protected void setGreeting(String p) {
		_greetings = p;
	}

	/**
	 * Parses the command line according to command metadata and invokes
	 * execution of the command to the concrete subclass with the parsed option
	 * values and arguments
	 * 
	 * @param line
	 *            a command line
	 */
	protected void executeCommandLine(String line) throws Exception {
		for (Command cmd : _metas) {
			if (cmd.matches(line)) {
				if (cmd == _help)
					_help.run(line);
				else
					execute(cmd.parse(line, true));
				return;
			}
		}
		if (_help != null)
			_help.help();
	}
	
	@Override
	public Command getCommand(String id) {
		for (Command cmd : this) {
			if (cmd.matches(id)) {
				return cmd;
			}
		}
		return null;
	}

	@Override
	public final Iterator<Command> iterator() {
		return _metas.iterator();
	}

	@Override
	public PrintWriter getWriter() {
		return _console.writer();
	}

	private class ShutdownHook implements Runnable {

		@Override
		public void run() {
			_console.writer().println("Bye...");
		}
	}

}
