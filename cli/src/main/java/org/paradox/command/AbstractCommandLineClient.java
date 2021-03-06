/**

      Copyright ©2016. Author Pinaki Poddar. All Rights Reserved. 

	Permission to use, copy, modify, and distribute this software and its documentation 
	for educational, research, and not-for-profit purposes, without fee and without a 
	signed licensing agreement, is hereby granted, provided that the above copyright notice, 
	this paragraph and the following two paragraphs appear in all copies, modifications, 
	and distributions. 


	IN NO EVENT SHALL THE AUTHOR BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, 
	OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE 
	AND ITS DOCUMENTATION, EVEN IF THE AUTHOR HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

	THE AUTHOR SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE AND 
	ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED HEREUNDER IS PROVIDED "AS IS". THE AUTHOR HAS 
	NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

package org.paradox.command;

import java.io.Console;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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

	private String _description = "";
	private String _prompt;
	private String _greetings;
	private HelpCommand _help;
	private Map<String, Command> _metas = new TreeMap<String,Command>();

	protected AbstractCommandLineClient() {
		_console = System.console();
		if (_console == null) {
			throw new RuntimeException("Console is not available");
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));
	}

	public void registerCommand(Command cmd) {
		if (cmd == null)
			throw new NullPointerException("Can not register null command");
		if (_metas.containsKey(cmd.getIdenetifierString()))
			throw new IllegalArgumentException("Duplicate command " + cmd.getIdenetifierString());
		_metas.put(cmd.getIdenetifierString(), cmd);
	}

	protected HelpCommand getHelp() {
		return _help;
	}
	protected void setHelp(String key) {
		_help = new HelpCommand(this, key);
		_help.setDescription("Prints this message");
		registerCommand(_help);
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
				System.err.println("Executing [" + line + "]");
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
	 * Execute the command registered as the given command.
	 * 
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
	 * values and arguments.
	 * 
	 * @param line
	 *            a command line
	 */
	protected void executeCommandLine(String line) throws Exception {
		for (Command cmd : _metas.values()) {
			if (cmd.recognizes(line)) {
				if (cmd == _help) {
					_help.run(line);
				} else {
					execute(cmd.parse(line));
				}
				return;
			}
		}
		if (_help != null) {
			getWriter().println("Unknown command [" + line + "]");
			_help.printHelp();
		}
	}
	
	@Override
	public Command getCommand(String id) {
		for (Command cmd : this) {
			if (cmd.recognizes(id)) {
				return cmd;
			}
		}
		return null;
	}

	@Override
	public final Iterator<Command> iterator() {
		return _metas.values().iterator();
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
