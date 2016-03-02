package org.paradox.util;

import java.util.Iterator;
/**
 * An empty iterator. 
 */
public final class EmptyIterator<E> implements Iterator<E>{

	@Override
	public boolean hasNext() {return false;}

	@Override
	public E next() {return null;}

	@Override
	public void remove() {}

}
