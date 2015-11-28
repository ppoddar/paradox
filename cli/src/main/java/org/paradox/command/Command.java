package org.paradox.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * A command is defined with zero or more options and arguments.
 * A command also has zero or more identifiers that are used to
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
	private boolean requiresParse = true;

	private static enum ParseState {READ_OPTION_KEY, READ_OPTION_VALUE, READ_ARGS};

	/**
	 * Supply each identifier in order that helps to recognize a command line.
	 * 
	 * @see #matches(String)
	 * @param identifiers
	 */
	public Command(String...identifiers) {
		if (identifiers == null || identifiers.length == 0)
			throw new IllegalArgumentException("Command must have at least one identifier");
		for (int i = 0; identifiers != null && i < identifiers.length; i++) {
			this._identifiers.add(identifiers[i]);
		}
	}
	
	public String getDescription() {
		return _description;
	}
	Command setDescription(String desc) {
		_description = desc;
		return this;
	}
	Command setUsage(String u) {
		_usage = u;
		return this;
	}
	boolean hasOption(String key) {
		return _options.containsKey(key);
	}
	
	Command requiresParse(boolean flag) {
		requiresParse = flag;
		return this;
	}
	
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
	
	ParsedCommand parse(String line) {
		return parse(line, false);
	}
	/**
	 * Parse the given line.
	 * 
	 * @param line input command line
	 * @param removeIdentifer if true the identifiers that match the first
	 * word(s) are removed from the input.
	 * @return result of the parse. never null.
	 */
	ParsedCommand parse(String line, boolean removeIdentifer) {
		if (removeIdentifer) {
			line = this.removeIdentifier(line);
		}
	    StringTokenizer tokenizer = new StringTokenizer(line);
	    ParsedCommand parsed = new ParsedCommand(this, line);
		if (!requiresParse) return parsed;
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
	boolean matches(String line) {
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

	

	

		
	

