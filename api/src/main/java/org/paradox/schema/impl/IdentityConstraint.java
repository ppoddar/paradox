package org.paradox.schema.impl;

import java.util.List;

import org.paradox.schema.Attribute;
import org.paradox.schema.Constraint;
import org.paradox.schema.Type;

public class IdentityConstraint extends AbstractConstraint implements Constraint {

	IdentityConstraint(Type type, String name, Attribute attr) {
		super(type, name, attr);
	}
	IdentityConstraint(Type type, String name, List<Attribute> attrs) {
		super(type, name, attrs);
	}

}
