package org.paradox.util;

import java.util.LinkedList;

@SuppressWarnings("serial")
abstract class Traversal<T> extends LinkedList<Tree<T>> {
	protected final Tree<T> _tree;
	
	protected Traversal(Tree<T> tree) {
		_tree = tree;
	}
	
	protected abstract Traversal<T> traverse();
	
	@Override
	public boolean add(Tree<T> t) {
		System.err.println(this + ".add " + t);
		return super.add(t);
		
	}
	public String toString() {
		return getClass().getSimpleName() + ':' + _tree;
	}
}
