package org.paradox.command;

public class Argument {
	public String name;
	public String _description;
	public int maxOccurs;
	public int minOccurs;
	
	String name() {
		return name;
	}
	
	Argument setName(String name) {
		this.name = name;
		return this;
	}
	Argument setDescription(String d) {
		_description = d;
		return this;
	}
	public String getDescription() {
		return _description;
	}

}