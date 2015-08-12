package com.paradox.schema;


/**
 * The basic unit of a {@link Schema}. Each type {@link #getSchema() belongs} to a Schema.
 * <br>
 * A plural type is composed of another type as elements. For example, an array of integer.
 *  
 * @author pinaki poddar
 *
 */
public interface Type extends SchemaElement<Attribute> {
	/**
	 * Gets the schema that owns this type.
	 */
	Schema getSchema();
	
	/**
	 * Affirms if this type is plural. 
	 */
	boolean isPlural();
	
	/**
	 * Affirms if this type is enumerated.
	 */
	boolean isEnumerated();
	
	
	/**
	 * Affirms if this type is primitive. 
	 */
	boolean isPrimitive();
	
	/**
	 * Affirms if this type is defined by the user.
	 */
	boolean isUserDefined();
}
