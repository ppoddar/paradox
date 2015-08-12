package com.paradox.schema.impl;

import java.util.Collection;
import java.util.List;

import com.paradox.schema.Attribute;
import com.paradox.schema.Constraint;
import com.paradox.schema.Type;

public abstract class AbstractConstraint extends AbstractSchemaElement<Attribute> implements Constraint {

	protected AbstractConstraint(Type type, String name, Attribute attr) {
		super(type, name);
		addChild(attr);
	}
	protected AbstractConstraint(Type type, String name, Collection<Attribute> attrs) {
		super(type, name);
		for (Attribute a :attrs)
			addChild(a);
	}
	
	@Override
	public final List<Attribute> getAttributes() {
		return (List<Attribute>) super.getChildren();
	}
}
