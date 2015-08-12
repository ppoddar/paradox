package com.paradox.util;

import java.util.LinkedList;

@SuppressWarnings("serial")
public class BreadthFirstTraversal<T> extends Traversal<T>{

	protected BreadthFirstTraversal(Tree<T> tree) {
		super(tree);
	}

	@Override
	protected Traversal<T> traverse() {
		LinkedList<Tree<T>> q = new LinkedList<Tree<T>>();
		q.add(_tree);
		while (!q.isEmpty()) {
			Tree<T> t = q.removeFirst();
			add(t);
			for (int i = 0; i < t.getChildCount(); i++) {
				q.add(t.getChild(i));
			}
		}
		return this;
	}

}
