package com.paradox.query.impl;

import java.util.ArrayList;
import java.util.List;

import com.paradox.query.Expression;
import com.paradox.query.ExpressionVisitor;

/**
 * Visits expression tree to collect nodes of specific type.
 * 
 * @author pinaki poddar
 *
 * @param <X> type of expression node to collect
 */
public class ExpressionCollector<X extends Expression> implements ExpressionVisitor {
	private final Class<X> _type;
	private List<X>  _collection = new ArrayList<X>();
	
	/**
	 * Creates a collector that will collect nodes of the given type.
	 * @param type
	 */
	public ExpressionCollector(Class<X> type) {
		_type = type;
	}
	
	@Override
	public void visit(Expression<?> expr) {
		if (_type.isInstance(expr)) {
			_collection.add((X)expr);
		}
	}
	
	/**
	 * Collect all the nodes starting from the given node that are of type
	 * supplied at construction.
	 * 
	 * @param expr the root node to start collecting 
	 * @return
	 */
	public List<X> collect(Expression<?> expr) {
		synchronized (_collection) {
			_collection.clear();
			expr.accept(this);
			return _collection;
		}
	}

}
