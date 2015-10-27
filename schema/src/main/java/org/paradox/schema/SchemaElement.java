package org.paradox.schema;

/**
 * The generic element in a {@link Schema} description. 
 * At its broadest generalization, Each element has a name, occurs in an defining scope and
 * may have children that are referred by their name.  
 * 
 * @author pinaki poddar
 *
 * @param <T> type of its children
 */
public interface SchemaElement<T> {
	/**
	 * Gets the immutable name of this receiver. 
	 * @return a non-null name that is unique within the scope of this receiver.
	 */
	String getName();
	
	/**
	 * Gets the scope in which this receiver has been defined.
	 * @return can be null for a Schema itself. For a type, the scope is schema. For attribute the scope is a Type.
	 */
	SchemaElement<?> getScope();
	
	/**
	 * Gets the child of the given name.
	 * @return null if no such child exists
	 */
	T getChild(String childName);
	
	/**
	 * Affirms if this receiver has defined a child of the given name.
	 */
	boolean hasChild(String childName);
	
}
