package org.paradox.command;

class Option {
	private String key;
	private String name;
	private String description;
	private boolean requiresValue = true;
	private boolean mandatory;

	Option(String key) {
		this.key = key;
	}
	
	String key() {
		return key;
	}
	
	String name() {
		return name;
	}
	
	boolean requiresValue() {
		return requiresValue;
	}
	
	boolean mandatory() {
		return mandatory;
	}
	
	String description() {
		return description;
	}
	
	Option setName(String name) {
		this.name = name;
		return this;
	}
	
	Option setDescription(String d) {
		this.description = d;
		return this;
	}
	Option requiresValue(boolean flag) {
		requiresValue = flag;
		return this;
	}
	
}