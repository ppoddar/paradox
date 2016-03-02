package org.paradox.schema;

/**
 * An exception raised for invalid or non-existent schema element.
 * <p>
 * This exception can be raised during {@link Schema#validatePath(String, String) validation} of a path.
 * 
 * @author pinaki poddar
 *
 */
@SuppressWarnings("serial")
public class SchemaValidationException extends RuntimeException {
	public SchemaValidationException(String message) {
		super(message);
	}
	public SchemaValidationException(String message, Exception nested) {
		super(message, nested);
	}
}
