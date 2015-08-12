package com.paradox.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChainedIterator<E> implements Iterator<E>{
	private final Iterator<Iterator<E>> _childIterator;
	//private List<Iterator<E>> _children;
	private Iterator<E> _current;
	public ChainedIterator(Collection<Iterator<E>> iterators) {
		if (iterators == null) throw new IllegalArgumentException("Can not create iterator with null children");
		_childIterator = iterators.iterator();
		_current = _childIterator.hasNext() ? _childIterator.next() : null;
	}
	

	@Override
	public boolean hasNext() {
		if (_current == null) return false;
		if (_current.hasNext()) return true;
		_current = _childIterator.hasNext() ? _childIterator.next() : null;
		return hasNext();
	}

	@Override
	public E next() {
		if (_current == null || !_current.hasNext())
			throw new NoSuchElementException();
		return _current.next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
