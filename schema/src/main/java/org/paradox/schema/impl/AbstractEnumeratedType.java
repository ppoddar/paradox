package org.paradox.schema.impl;

import java.util.List;

import org.paradox.schema.EnumeratedType;
import org.paradox.schema.Schema;

class AbstractEnumeratedType extends AbstractType implements EnumeratedType {

	AbstractEnumeratedType(Schema schema, String name) {
		super(schema, name, FLAG_ENUM);
	}

	@Override
	public List<String> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
