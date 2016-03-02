package org.paradox.schema;

import java.util.Collection;
import java.util.List;

/**
 * A user-defined type.
 * <p>
 * A user-defined type has zero or more {@link Attribute attributes}. The user-defined type is designed on the
 * assumption that instances would be persisted. Hence, a user-defined type also designates a list of its attributes
 * that participate to form a primary key. The order of these attributes is significant from generating a compound key.
 * 
 * @see KeyMaker
 * 
 * @author pinaki poddar
 *
 */
public interface UserType extends Type {
	/**
	 * Gets the attribute of given name, or null if absent.
	 * @param attrName name of an attribute
	 */
	Attribute getAttribute(String attrName);
	
	/**
	 * Gets the attributes without any specific order
	 */
	Collection<Attribute> getAttributes();
	
	
	/**
	 * Gets the attributes whose values form the identifier of an instance of this type.
	 * The order of attribute can be important for hierarchical key.
	 * @see KeyMaker
	 * @return empty list if this receiver has no identifier attributes.
	 */
	List<Attribute> getIdAttributes();
	
	
	void addConstraint(Constraint constraint);
	
	Attribute newAttribute(String name, Type type);
	
}
