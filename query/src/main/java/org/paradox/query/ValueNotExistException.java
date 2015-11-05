package org.paradox.query;

@SuppressWarnings("serial")
public class ValueNotExistException extends RuntimeException {
	public ValueNotExistException(String path) {
		super(path + "not found");
	}
	public ValueNotExistException(String seg, String path) {
		super(seg + "not found in " + path);
	}
}
