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

import java.io.PrintWriter;
import java.util.List;

import org.paradox.util.MultiColumnPrinter;

class HelpCommand extends Command {
	final CLI _cli;
	
	public HelpCommand(CLI cli) {
		this(cli, "help");
	}

	public HelpCommand(CLI cli, String key) {
		super(key);
		_cli = cli;
	}

	/**
	 * Prints short help message for all available commands. 
	 */
	public void printHelp() {
		PrintWriter writer = _cli.getWriter();
		writer.println("Available commands are:");
		writer.println();
		int wmax = 0;
		for (Command cmd : _cli) {
			wmax = Math.max(wmax, cmd.getIdenetifierString().length());
		}
		MultiColumnPrinter.ColumnSpec[] tabs = {
				new MultiColumnPrinter.ColumnSpec(4,wmax+2),
				new MultiColumnPrinter.ColumnSpec(wmax+8,4),
				new MultiColumnPrinter.ColumnSpec(wmax+16,80),
				};
		MultiColumnPrinter printer = new MultiColumnPrinter(writer, tabs);
		for (Command cmd : _cli) {
			printer.printColumn(cmd.getIdenetifierString(), "--", cmd.getDescription());
		}
		writer.println();
		writer.println("Type " + getIdenetifierString() + " <command> for information on specific command");
		writer.println();
	}
	
	void run(String line) {
		ParsedCommand parsed = parse(line);
		List<String> args = parsed.getArgs();
		if (args.isEmpty()) {
			printHelp();
		} else {
			ColumnPrinter printer = new ColumnPrinter(_cli.getWriter(),	new int[]{8,16,2,64});
			String id = line.substring(getIdenetifierString().length()).trim();
			Command cmd = _cli.getCommand(id);
			if (cmd == null) {
				printer.printLine("*** Unknown command " + id);
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
