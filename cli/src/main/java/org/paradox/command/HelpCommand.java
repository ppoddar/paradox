package org.paradox.command;

import java.util.List;

class HelpCommand extends Command {
	final CLI _cli;
	
	public HelpCommand(CLI cli) {
		this(cli, "help");
	}

	public HelpCommand(CLI cli, String key) {
		super(key);
		_cli = cli;
	}

	void help() {
		_cli.getWriter().println("Available commands are:");
		_cli.getWriter().println();
		int wmax = 0;
		for (Command cmd : _cli) {
			wmax = Math.max(wmax, cmd.getIdenetifierString().length());
		}
		_cli.getWriter().println();
		_cli.getWriter().println("Type " + getIdenetifierString() + " <command> for information on specific command");
		_cli.getWriter().println();
	}
	
	void run(String line) {
		ParsedCommand parsed = parse(line, true);
		List<String> args = parsed.getArgs();
		if (args.isEmpty()) {
			help();
		} else {
			ColumnPrinter printer = new ColumnPrinter(_cli.getWriter(),	new int[]{8,16,2,64});
			String id = line.substring(getIdenetifierString().length()).trim();
			Command cmd = _cli.getCommand(id);
			if (cmd == null) {
				printer.print("*** Unknown command " + id);
			} else {
				printer.printLine(cmd.getIdenetifierString());
				printer.printLine(cmd.getDescription());
				printer.printLine("Usage: " + cmd.getUsage());
				if (!cmd.getOptions().isEmpty())
					printer.printLine("where options are:");
				for (Option opt : cmd.getOptions()) {
					printer.printColumn(opt.key(), opt.description());
				}
				if (!cmd.getArguments().isEmpty())
					printer.printLine("where arguments are:");
				for (Argument arg : cmd.getArguments()) {
					printer.printColumn(arg.name(), arg.getDescription());
				}
			}
			printer.close();
		}
	}

}
