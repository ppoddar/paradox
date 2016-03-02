package org.paradox.util;

import java.util.LinkedList;

@SuppressWarnings("serial")
class DepthFirstTraversal<T> extends Traversal<T>{

	protected DepthFirstTraversal(Tree<T> tree) {
		super(tree);
	}

	@Override
	protected Traversal<T> traverse() {
		LinkedList<Tree<T>> q = new LinkedList<Tree<T>>();
		q.add(_tree);
		while (!q.isEmpty()) {
			Tree<T> t = q.removeFirst();
			this.add(t);
			for (int i = 0; i < t.getChildCount(); i++) {
				this.addAll(new DepthFirstTraversal<T>(t.getChild(i)).traverse());
			}
		} 
		return this;
	}
}
