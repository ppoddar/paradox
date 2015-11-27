package org.paradox.query.kv;

/**
 * Raised when a property does not exist in a given record.
 * Different than property having a null value.
 * 
 * @author pinaki poddar
 *
 */
@SuppressWarnings("serial")
public class ValueNotExistException extends RuntimeException {
	public ValueNotExistException(String path) {
		super(path + "not found");
	}
	public ValueNotExistException(String seg, String path) {
		super(seg + "not found in " + path);
	}
}
