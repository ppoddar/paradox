package com.paradox.command;

import java.io.PrintWriter;
import java.util.List;

class HelpCommand extends Command {
	final CLI _cli;
	final PrintWriter _writer;
	
	public HelpCommand(CLI cli) {
		this(cli, "help");
	}

	public HelpCommand(CLI cli, String key) {
		super(key);
		_cli = cli;
		_writer = cli.getWriter();
	}

	void help() {
		_writer.println("Available commands are:");
		_writer.println();
		int wmax = 0;
		for (Command cmd : _cli) {
			wmax = Math.max(wmax, cmd.getIdenetifierString().length());
		}
		int[] indentAndWidth = { 8, wmax, 4, Math.max(80 - (8 + wmax - 4), 20) };
		ColumnPrinter printer = new ColumnPrinter(_writer,	indentAndWidth);
		for (Command cmd : _cli) {
			printer.print(cmd.getIdenetifierString(), cmd.getDescription());
		}
		_writer.println();
		_writer.println("Type " + getIdenetifierString() + " <command> for information on specific command");
		_writer.println();
	}
	
	void run(String line) {
		ParsedCommand parsed = parse(line, true);
		List<String> args = parsed.getArgs();
		if (args.isEmpty()) {
			help();
		} else {
			ColumnPrinter printer = new ColumnPrinter(_writer,	new int[]{8,80});
			for (String arg : args) {
				Command cmd = _cli.getCommand(arg);
				if (cmd == null) {
					printer.print("*** Unknown command " + arg);
					continue;
				} else {
					printer.print(arg);
					printer.print(cmd.getDescription());
					printer.print("Usage: " + cmd.getUsage());
				}
			}
		}
	}

}
