/**

      Copyright ©2016. Author Pinaki Poddar. All Rights Reserved. 

	Permission to use, copy, modify, and distribute this software and its documentation 
	for educational, research, and not-for-profit purposes, without fee and without a 
	signed licensing agreement, is hereby granted, provided that the above copyright notice, 
	this paragraph and the following two paragraphs appear in all copies, modifications, 
	and distributions. 


	IN NO EVENT SHALL THE AUTHOR BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, 
	OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE 
	AND ITS DOCUMENTATION, EVEN IF THE AUTHOR HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

	THE AUTHOR SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE AND 
	ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED HEREUNDER IS PROVIDED "AS IS". THE AUTHOR HAS 
	NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

package org.paradox.util;

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
