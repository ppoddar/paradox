package com.paradox.query.impl;

import com.paradox.nosql.query.KVQueryContext;
import com.paradox.query.Expression;
import com.paradox.query.ExpressionVisitor;



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
	public V evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
		return (V)candidate;
	}

	@Override
	public String getName() {
		return _typeName;
	}

}