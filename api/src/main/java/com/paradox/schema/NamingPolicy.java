package com.paradox.schema;

/**
 * Policy and restrictions for naming {@link SchemaElement schema elements}.
 * <p>
 * The {@link Schema type system} being described uses naming policy to represent
 * container types. 
 * 
 * @author pinaki poddar
 *
 */
public interface NamingPolicy {
	/**
	 * Affirms if the given name is syntactically valid as a type name.
	 */
	boolean isValidTypeName(String typeName);

	/**
	 * Affirms if the given name is syntactically valid as an attribute name.
	 */
	boolean isValidAttributeName(String attrName);
	
	/**
	 * Affirms if the given name denotes a type name for container type.
	 * An array type name e.g. {@code string[]} will return {@code true}.
	 * 
	 */
	boolean isPluralTypeName(String typeName);
	
	/**
	 * Gets the name of the element type name for the given type name.
	 * A multi-dimensional array type name e.g. {@code Person[][]} will return 
	 * {@code Person[]}.
	 * @return null if the given name does not denote a container type.
	 */
	String  getComponentTypeName(String typeName);
	
	/**
	 * Creates a name for a container type from the given element type name.
	 */
	String createPluralTypeName(String name);
}
