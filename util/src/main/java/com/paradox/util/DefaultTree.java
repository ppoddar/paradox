package com.paradox.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultTree<T> implements Tree<T> {
	private List<Tree<T>> _children;
	private Tree<T> _parent;
	private final T _data;

	/**
	 * Creates root of a tree with the given data
	 * 
	 * @param data
	 *            must not be null.
	 */
	public DefaultTree(T data) {
		this(null, data);
	}

	/**
	 * Creates tree node of the given parent and with the given data
	 * 
	 * @param parent
	 *            can be null only for root node.
	 * @param data
	 *            must not be null.
	 */
	protected DefaultTree(Tree<T> parent, T data) {
		if (data == null)
			throw new IllegalArgumentException(
					"Tree node can not be constructed with null");
		this._parent = parent;
		_data = data;
	}

	@Override
	public final boolean isRoot() {
		return _parent == null;
	}

	@Override
	public final boolean isLeaf() {
		return _children == null;
	}

	@Override
	public final Tree<T> getRoot() {
		return isRoot() ? this : _parent.getRoot();
	}

	@Override
	public int getDepth() {
		return isRoot() ? 0 : _parent.getDepth() + 1;
	}

	@Override
	public int getHeight() {
		if (isLeaf())
			return 0;
		int height = 0;
		for (Tree<T> c : _children) {
			height = Math.max(height, c.getHeight());
		}
		return height + 1;
	}

	@Override
	public final Tree<T> getParent() {
		return _parent;
	}

	@Override
	public void setParent(Tree<T> parent) {
		if (parent == null)
			throw new IllegalArgumentException("Parent can not be null");
		if (getParent() != null) {
			if (getParent() != this) {
				throw new IllegalStateException(this
						+ " has a different parent " + getParent());
			} else {
				return;
			}
		} else {
			_parent = parent;
		}
	}

	@Override
	public final Tree<T> getChild(int i) {
		if (isLeaf())
			throw new IllegalStateException("Can not get " + i
					+ "-th child for leaf node " + this);
		return _children.get(i);
	}

	@Override
	public Tree<T> search(List<T> path) {
		if (path == null || path.isEmpty())
			return null;
		if (match(path.get(0)))
			return this;
		for (Tree<T> child : _children) {
			Tree<T> result = child.search(path.subList(1, path.size()));
			if (result != null)
				return result;
		}
		return null;
	}

	public Tree<T> find(T t) {
		if (match(t))
			return this;
		if (isLeaf())
			return null;
		for (Tree<T> child : _children) {
			Tree<T> r = child.find(t);
			if (r != null)
				return r;
		}
		return null;
	}

	@Override
	public int indexOf(Tree<T> child) {
		return _children == null ? -1 : _children.indexOf(child);
	}

	@Override
	public T get() {
		return _data;
	}

	protected boolean match(T t) {
		return _data != null && _data.equals(t);
	}

	@Override
	public void addChild(Tree<T> child) {
		if (child == null)
			throw new IllegalArgumentException("Can not add null child");
		child.setParent(this);
		if (_children == null)
			_children = new ArrayList<Tree<T>>();
		_children.add(child);
	}

	@Override
	public int getChildCount() {
		return isLeaf() ? 0 : _children.size();
	}

	@Override
	public String toString() {
		return _data != null ? _data.toString() : "null";
	}

	public Iterator<Tree<T>> iterator() {
		return iterator(DEPTH_FIRST);
	}

	@Override
	public Tree<T> getByPath(int... indices) {
		List<Integer> path = new ArrayList<Integer>();
		for (int i = 0; indices != null && i < indices.length; i++) {
			path.add(indices[i]);
		}
		return getByPath(path);
	}

	@Override
	public Tree<T> getByPath(List<Integer> indices) {
		if (indices.isEmpty())
			return this;
		return getChild(indices.get(0)).getByPath(indices.subList(1, indices.size()));
	}

	@Override
	public Iterator<Tree<T>> iterator(int mode) {
		switch (mode) {
		case BREADTH_FIRST:
			return new BreadthFirstTraversal<T>(this).traverse().iterator();
		case DEPTH_FIRST:
			return new DepthFirstTraversal<T>(this).traverse().iterator();
		default:
			throw new IllegalArgumentException("Invalid traversal mode, only BREADTH_FIRST or DEPTH_FIRST allowed");
		}
	}
}
