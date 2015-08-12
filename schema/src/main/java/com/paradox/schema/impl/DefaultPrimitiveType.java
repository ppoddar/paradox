package com.paradox.schema.impl;

import com.paradox.schema.Schema;
import com.paradox.schema.Type;

public final class DefaultPrimitiveType extends AbstractType implements Type {
	private Class<?> _cls;
	protected DefaultPrimitiveType(Schema schema, String name) {
		super(schema, name, AbstractType.FLAG_PRIMITIVE);
	}
}
