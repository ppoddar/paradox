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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * A command is defined with zero or more options and arguments.
 * A command also has one or more identifiers that are used to
 * detect if a command line begins with the same tokens.
 *  
 * @author pinaki poddar
 *
 */
public class Command {
	private final List<String> _identifiers = new ArrayList<String>();
	private final Map<String, Option> _options = new TreeMap<String, Option>();
	private final List<Argument> _args = new ArrayList<Argument>();
	private String _description = "";
	private String _usage;
	private boolean _removeIdentifier = true;
	private boolean _requiresParse = true;

	private static enum ParseState {READ_OPTION_KEY, READ_OPTION_VALUE, READ_ARGS};

	/**
	 * Supply each identifier in order that helps to recognize a command line.
	 * 
	 * @see #recognizes(String)
	 * @param identifiers
	 */
	public Command(String...identifiers) {
		if (identifiers == null || identifiers.length == 0)
			throw new IllegalArgumentException("Command must have at least one identifier");
		for (int i = 0; identifiers != null && i < identifiers.length; i++) {
			this._identifiers.add(identifiers[i]);
		}
	}
	
	/**
	 * Gets a description of this command.
	 * @return
	 */
	public String getDescription() {
		return _description;
	}
	
	/**
	 * Sets a description for this command.
	 * @param desc
	 * @return
	 */
	Command setDescription(String desc) {
		_description = desc;
		return this;
	}
	
	/**
	 * Sets usage description for this command.
	 * @param u
	 * @return
	 */
	Command setUsage(String u) {
		_usage = u;
		return this;
	}
	
	/**
	 * Affirms if this command has the given option. 
	 * @param key
	 * @return
	 */
	boolean hasOption(String key) {
		return _options.containsKey(key);
	}
	
	/**
	 * Sets whether this command requires to be parsed.
	 * @param flag
	 * @return
	 */
	Command requiresParse(boolean flag) {
		_requiresParse = flag;
		return this;
	}
	
	/**
	 * Returns whether this command requires parsing.
	 * @return
	 */
	public boolean requiresParse() {
		return _requiresParse;
	}
	
	/**
	 * defines an option.
	 * @param key
	 * @return
	 */
	protected Option defineOption(String key) {
		if (key == null || !key.startsWith("-")) {
			throw new IllegalArgumentException("invalid option key " + key
					+ ". Must begine with a -");
		}
		if (_options.containsKey(key)) {
			throw new IllegalArgumentException("Duplicate option key " + key);
		}
		Option option = new Option(key);
		_options.put(key, option);
		return option;
	}

	protected Argument defineArgument() {
		Argument arg = new Argument();
		_args.add(arg);
		return arg;
	}
	
	/**
	 * Parse the given line.
	 * 
	 * @param line input command line
	 * @return result of the parse. never null.
	 */
	ParsedCommand parse(String line) {
		if (_removeIdentifier) {
			line = this.removeIdentifier(line);
		}
	    StringTokenizer tokenizer = new StringTokenizer(line);
	    ParsedCommand parsed = new ParsedCommand(this, line);
		if (!_requiresParse) return parsed;
	    Option option = null;
	    ParseState state = ParseState.READ_OPTION_KEY;
	    
	    while (tokenizer.hasMoreElements()) {
	      switch (state) {
	      case READ_OPTION_KEY:
		    String token = tokenizer.nextToken();
	        option = _options.get(token);
	        if (option == null) {
		      parsed.recordArgs(token);
	          state = ParseState.READ_ARGS;
	        }  else if (option.requiresValue()) {
	        	state = ParseState.READ_OPTION_VALUE;
	        } else {
	        	parsed.recordOption(token, null);
	        }
	        break;
	      case READ_OPTION_VALUE:
			 String value = tokenizer.nextToken();
	         parsed.recordOption(option.key(), value);
	         state = ParseState.READ_OPTION_KEY;
	         break;
	      case READ_ARGS:
		      while (tokenizer.hasMoreElements()) {
		    	  parsed.recordArgs(tokenizer.nextToken());
		      }
	        break;
	      }
	    }
	    return parsed;
	}
	
	
	
	/**
	 * Affirm if this command recognizes this line.
	 * A command recognizes a line if each word in the beginning
	 * matches the identifiers of this command. 
	 * @param line
	 * @return
	 */
	boolean recognizes(String line) {
	    StringTokenizer tokenizer = new StringTokenizer(line);
	    int i = 0;
	    while (tokenizer.hasMoreElements() && i < _identifiers.size()) {
		    String token = tokenizer.nextToken();
		    if (_identifiers.get(i++).equals(token)) continue;
		    else return false;
	    }
	    return i >= _identifiers.size();
	}
	
	String getIdenetifierString() {
	    StringBuffer buf = new StringBuffer();
	    for (String id : _identifiers) {
		    if (buf.length() > 0) buf.append(" ");
	    	    buf.append(id);
	    }
	    return buf.toString();
	}
	
	String getUsage() {
		if (_usage != null) return _usage;
	    StringBuffer buf = new StringBuffer();
	    buf.append(getIdenetifierString());
	    for (Option opt : _options.values()) {
		    if (buf.length() > 0) buf.append(" ");
		    if (!opt.mandatory()) buf.append('<');
	    	buf.append(opt.key()).append(' ');
	    	if (opt.requiresValue()) buf.append(opt.name());
		    if (!opt.mandatory()) buf.append('>');
	    }
	    for (Argument arg : _args) {
		    if (buf.length() > 0) buf.append(" ");
		    buf.append(arg.name());
	    }
	    return buf.toString();
	}
	
	
	Collection<Option> getOptions() {
		return _options.values();
	}
	Collection<Argument> getArguments() {
		return _args;
	}
		
	public Command removesIdentifier(boolean flag) {
		_removeIdentifier = flag;
		return this;
	}
	
	/**
	 * Inspect the line to affirm if this receiver can process the given line.
	 * @param line a given string
	 * @return the string that can be parsed by this receiver. null if the given
	 * line does not match.
	 */
	String removeIdentifier(String line) {
	    StringTokenizer tokenizer = new StringTokenizer(line);
	    int i = 0;
	    while (tokenizer.hasMoreElements() && i < _identifiers.size()) {
		    String token = tokenizer.nextToken();
		    if (_identifiers.get(i++).equals(token)) continue;
		    else return null;
	    }
	    StringBuffer buf = new StringBuffer();
	    while (tokenizer.hasMoreElements()) {
		    String token = tokenizer.nextToken();
		    if (buf.length() > 0) buf.append(" ");
	    	buf.append(token);
	    }
	    return buf.toString();
	}

	}

	

	

		
	

