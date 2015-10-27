package org.paradox.schema.impl;

import java.util.Iterator;

import org.paradox.schema.Attribute;
import org.paradox.schema.Type;

public interface AttributePath {
	Type getType();
	int length();
	Iterator<Attribute> segments();
	AttributePath subpath();
	Attribute getAttribute();
}
