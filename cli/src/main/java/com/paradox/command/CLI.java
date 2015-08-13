package com.paradox.command;

import java.io.PrintWriter;

public interface CLI extends Iterable<Command>, Runnable {
	/**
	 * Gets a command as identified by the given identifier.
	 * @param id
	 * @return
	 */
	Command getCommand(String id);
	
	/**
	 * Registers the given command.
	 * @param cmd must not be null. No command with same
	 *  {@link Command#getIdenetifierString() identifier} must
	 *  not be registered before.
	 */
	void registerCommand(Command cmd);
	
	/**
	 * Gets a writer.
	 * @return
	 */
	PrintWriter getWriter();
}
