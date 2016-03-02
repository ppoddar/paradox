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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A command after is has been parsed.
 * 
 * @author pinaki poddar
 *
 */
class ParsedCommand  {
	private final Command _original;
	private final String line;
	private final Map<String,String> _optionValues = new HashMap<String, String>();
	private final List<String> _argValues = new ArrayList<String>();
	
	/**
	 * Create from the original command and the line it has been parsed from 
	 * @param cmd
	 * @param line
	 */
	ParsedCommand(Command cmd, String line) {
		_original = cmd;
		this.line = line;
	}
	
	/**
	 * Records an option with its value during parse.
	 * @param key
	 * @param v
	 */
	void recordOption(String key, String v) {
		assertOption(key);
		_optionValues.put(key, v);
	}
	
	/**
	 * Records an argument during parse.
	 * @param key
	 * @param v
	 */
	void recordArgs(String v) {
		_argValues.add(v);
	}
	
	/**
	 * Gets all the parsed arguments.
	 * @return
	 */
	List<String> getArgs() {
		return Collections.unmodifiableList(_argValues);
	}
	
	
	/**
	 * Gets the parsed argument in given index.
	 * @return
	 */
	String getArgs(int i) {
		return _argValues.get(i);
	}
	
	/**
	 * Gets value of a parsed option.
	 * @param key
	 * @return
	 */
	String getOption(String key) {
		assertOption(key);
		return _optionValues.get(key);
	}
	
	/**
	 * Gets the line that was parsed.
	 * @return
	 */
	String getLine() {
		return line;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public Command getOriginal() {
		return _original;
	}

	void assertOption(String key) {
		if (!_original.hasOption(key))
			throw new IllegalArgumentException("Undefined option " + key);
	}

}
