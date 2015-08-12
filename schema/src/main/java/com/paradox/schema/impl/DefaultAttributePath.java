package com.paradox.schema.impl;

import java.util.Iterator;
import java.util.LinkedList;

import com.paradox.schema.Attribute;
import com.paradox.schema.Type;

class DefaultAttributePath implements AttributePath {
	private final LinkedList<Attribute> _segments = new LinkedList<Attribute>();
	
	DefaultAttributePath(Attribute attr) {
		append(attr);
	}
	
	@Override
	public Type getType() {
		return _segments.getLast().getType();
	}

	@Override
	public int length() {
		return _segments.size();
	}

	@Override
	public Iterator<Attribute> segments() {
		return _segments.iterator();
	}
	
	void append(Attribute attr) {
		_segments.add(attr);
	}
	
	@Override
	public AttributePath subpath() {
		DefaultAttributePath next = new DefaultAttributePath(_segments.get(1));
		for (int i = 2; i < length(); i++) {
			next.append(_segments.get(i));
		}
		return next;
	}
	
	@Override
	public Attribute getAttribute() {
		return _segments.getLast();
	}

}
