package com.paradox.schema.impl;

import com.paradox.schema.Attribute;
import com.paradox.schema.Schema;
import com.paradox.schema.Type;

abstract class AbstractType extends AbstractSchemaElement<Attribute> implements Type {
	static final byte FLAG_PRIMITIVE = 0x1  << 1;
	static final byte FLAG_USER      = 0x1  << 2;
	static final byte FLAG_ENUM      = 0x1  << 3;
	static final byte FLAG_PLURAL    = 0x1  << 4;

	private final int    _flags;

	protected AbstractType(Schema schema, String name, int flags) {
		super(schema, name);
		if (schema == null) throw new IllegalArgumentException("Null schema");
		_flags  = flags;
	}
	
	@Override
	public final Schema getSchema() {
		return (Schema)getScope();
	}
	
	@Override
	public final boolean isPrimitive() {
		return isSet(FLAG_PRIMITIVE);
	}
	@Override
	public final boolean isPlural() {
		return isSet(FLAG_PLURAL);
	}
	@Override
	public final boolean isEnumerated() {
		return isSet(FLAG_ENUM);
	}
	@Override
	public final boolean isUserDefined() {
		return isSet(FLAG_USER);
	}
	
	
	
	protected boolean isSet(byte flag) {
		return (_flags & flag) != 0;
	}
	
}
