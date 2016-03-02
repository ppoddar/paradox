package org.paradox.schema.impl;

import org.paradox.schema.Attribute;
import org.paradox.schema.Constraint;
import org.paradox.schema.Type;

class AttributeImpl extends AbstractSchemaElement<Constraint> implements Attribute {
	private final Type   _type;

	AttributeImpl(Type owner, String name, Type type) {
		super(owner, name);
		_type  = type;
	}
	
	public Type getType() {
		return _type;
	}
	
	public Type getOwner() {
		return (Type)getScope();
	}
}
