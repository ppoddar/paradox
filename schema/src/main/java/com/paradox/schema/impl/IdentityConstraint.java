package com.paradox.schema.impl;

import java.util.List;

import com.paradox.schema.Attribute;
import com.paradox.schema.Constraint;
import com.paradox.schema.Type;

public class IdentityConstraint extends AbstractConstraint implements Constraint {

	IdentityConstraint(Type type, String name, Attribute attr) {
		super(type, name, attr);
	}
	IdentityConstraint(Type type, String name, List<Attribute> attrs) {
		super(type, name, attrs);
	}

}
