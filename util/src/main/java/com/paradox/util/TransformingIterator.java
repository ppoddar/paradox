package com.paradox.util;

import java.util.Iterator;

import org.paradox.util.Transformer;

/**
 * Applies a {@link Transformer transform} on iterated value
 * of another iterator. 
 * 
 * @author pinaki poddar
 *
 * @param <X> original value type
 * @param <Y> transformed value type
 */
public class TransformingIterator<X, Y> implements Iterator<Y> {
	private final Iterator<X> _base;
	private final Transformer<X, Y> _transformer;

	/**
	 * Supply a base iterator and a transformer.
	 * @param base must not be null.
	 * @param transformer must not be null.
	 */
	public TransformingIterator(Iterator<X> base, Transformer<X, Y> transformer) {
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
