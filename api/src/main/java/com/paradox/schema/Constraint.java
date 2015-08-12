package com.paradox.schema;

import java.util.List;

/**
 * A constraint on one or more {@link Attribute}s.
 * For example, whether an attribute is an primary key.
 * 
 * @author pinaki poddar
 *
 */
public interface Constraint extends SchemaElement<Attribute> {
	List<Attribute> getAttributes();
}
