package com.paradox.command;

public class Argument {
	public String name;
	public String description;
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
		this.description = d;
		return this;
	}

}