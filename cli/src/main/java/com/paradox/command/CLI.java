package com.paradox.command;

import java.io.PrintWriter;

public interface CLI extends Iterable<Command>, Runnable {
	PrintWriter getWriter();
	Command getCommand(String cmd);
}
