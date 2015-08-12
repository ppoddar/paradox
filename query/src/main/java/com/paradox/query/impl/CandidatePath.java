package com.paradox.query.impl;

import com.paradox.query.Expression;
import com.paradox.query.ExpressionVisitor;
import com.paradox.query.QueryContext;
import com.paradox.query.Expression.Candidate;



/**
 * An expression to designate a candidate type.
 * 
 * @param <V> the type 
 */
public class CandidatePath<V> implements Expression.Candidate<V> {
	private final String _typeName;
	
	public CandidatePath(String type) {
		_typeName = type;
	}
	
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Evaluates as the given candidate itself.
	 */
	@Override
	public V evaluate(Object candidate, QueryContext<?,?,?> ctx) {
		return (V)candidate;
	}

	@Override
	public String getName() {
		return _typeName;
	}

}