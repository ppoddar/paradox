package com.paradox.schema.impl;

import java.util.List;

import com.paradox.schema.EnumeratedType;
import com.paradox.schema.Schema;

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
