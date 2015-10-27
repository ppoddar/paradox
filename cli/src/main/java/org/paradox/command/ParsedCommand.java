package org.paradox.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParsedCommand  {
	private final Command original;
	private final String line;
	Map<String,String> _optionValues = new HashMap<String, String>();
	List<String> _argValues = new ArrayList<String>();
	
	ParsedCommand(Command cmd, String line) {
		original = cmd;
		this.line = line;
	}
	void recordOption(String key, String v) {
		assertOption(key);
		_optionValues.put(key, v);
	}
	void recordArgs(String v) {
		_argValues.add(v);
	}
	
	List<String> getArgs() {
		return Collections.unmodifiableList(_argValues);
	}
	String getArgs(int i) {
		return _argValues.get(i);
	}
	
	String getOption(String key) {
		assertOption(key);
		return _optionValues.get(key);
	}
	
	String getLine() {
		return line;
	}
	
	boolean matches(String s) {
		return original.matches(s);
	}
	String match(String s) {
		return original.match(s);
	}
	
	void assertOption(String key) {
		if (!original.hasOption(key))
			throw new IllegalArgumentException("Undefined option " + key);
	}

}
