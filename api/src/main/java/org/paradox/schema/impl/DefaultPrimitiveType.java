package org.paradox.schema.impl;

import org.paradox.schema.Schema;
import org.paradox.schema.Type;

public final class DefaultPrimitiveType extends AbstractType implements Type {
	protected DefaultPrimitiveType(Schema schema, String name) {
		super(schema, name, AbstractType.FLAG_PRIMITIVE);
	}
}
