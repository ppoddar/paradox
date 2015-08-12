package com.paradox.schema.impl;

import com.paradox.schema.Attribute;
import com.paradox.schema.Constraint;
import com.paradox.schema.Type;

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
