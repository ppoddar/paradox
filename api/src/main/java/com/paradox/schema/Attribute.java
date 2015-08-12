package com.paradox.schema;

/**
 * An attribute (or property, or field) of a {@linkplain UserType user-defined type}.
 * <p>
 * An attribute is <em>of</em> a type. The attribute type determines what value can be held
 * in this attribute. 
 * <br>
 * An attribute belongs to an owning type and is name is unique within the owning type.
 * <br>
 * @author pinaki poddar
 *
 */
public interface Attribute extends SchemaElement<Constraint> {
	/**
	 * Gets the name of this attribute.
	 * The name of an attribute is unique among the attributes of its owning type.
	 * 
	 * @see NamingPolicy#isValidAttributeName(String)
	 */
	String getName();
	
	/**
	 * Gets the owner who owns this attribute.
	 * @return the owning type. Never null.
	 */
	Type getOwner();
	
	
	/**
	 * Gets the type of this attribute. This type determines what values can be held in this attribute for a data
	 * record.
	 * @return the type of data held in this attribute. Never null.
	 */
	Type getType();
	
}
