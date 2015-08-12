package com.paradox.schema.impl;

import java.lang.reflect.Array;

import com.paradox.schema.ContainerType;
import com.paradox.schema.Type;

class AbstractContainerType extends AbstractType implements ContainerType {
	private final Type   _elementType;

	AbstractContainerType(Type e) {
		super(e.getSchema(), e.getSchema().getNamingPolicy().createPluralTypeName(e.getName()), makeFlag(e));
		_elementType = e;
	}
	
	public final Type getElementType() {
		return _elementType;
	}
	
	private static int makeFlag(Type e) {
		int flag = FLAG_PLURAL;
		if (e.isEnumerated()) flag |= FLAG_ENUM;
		if (e.isPrimitive()) flag |= FLAG_PRIMITIVE;
		if (e.isUserDefined()) flag |= FLAG_USER;
		return flag;
	}
	
}
