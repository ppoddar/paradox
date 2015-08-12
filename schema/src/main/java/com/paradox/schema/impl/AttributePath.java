package com.paradox.schema.impl;

import java.util.Iterator;

import com.paradox.schema.Attribute;
import com.paradox.schema.Type;

public interface AttributePath {
	Type getType();
	int length();
	Iterator<Attribute> segments();
	AttributePath subpath();
	Attribute getAttribute();
}
