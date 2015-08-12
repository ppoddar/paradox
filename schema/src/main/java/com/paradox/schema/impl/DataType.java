package com.paradox.schema.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.paradox.schema.Attribute;
import com.paradox.schema.Constraint;
import com.paradox.schema.Schema;
import com.paradox.schema.Type;
import com.paradox.schema.UserType;

class DataType extends AbstractType implements UserType {
	private Set<Constraint> _constraints;
	
	DataType(Schema schema, String name, int flags) {
		super(schema, name, flags);
	}
	
	@Override
	public Attribute getAttribute(String name) {
		return getAttribute(name, false);
	}
	
	public Attribute getAttribute(String name, boolean mustExist) {
		Attribute attr = getChild(name);
		if (attr == null && mustExist) {
			throw new RuntimeException(name + " does not exist in " + this);
		}
		return attr;
	}
	
	
	@Override
	public Collection<Attribute> getAttributes() {
		return getChildren();
	}
	
	@Override
	public Attribute newAttribute(String name, Type type) {
		Attribute attr = new AttributeImpl(this, name, type);
		addChild(attr);
		return attr;
	}
	
	@Override
	public void addConstraint(Constraint c) {
		if (_constraints == null)
			_constraints = new HashSet<Constraint>();
		_constraints.add(c);
	}

	@Override
	public List<Attribute> getIdAttributes() {
		if (_constraints == null) return null;
		for (Constraint c : _constraints) {
			if (c instanceof IdentityConstraint) 
				return c.getAttributes();
		}
		return null;
	}
}
