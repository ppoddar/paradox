package org.paradox.util;

import java.util.Iterator;

public class TransforminIterator<X, Y> implements Iterator<Y> {
	private final Iterator<X> _base;
	private final Transformer<X, Y> _transformer;

	public TransforminIterator(Iterator<X> base, Transformer<X, Y> transformer) {
		_base = base;
		_transformer = transformer;
	}

	@Override
	public boolean hasNext() {
		return _base.hasNext();
	}

	@Override
	public Y next() {
		return _transformer.transform(_base.next());
	}

	@Override
	public void remove() {
		_base.remove();
	}

}
