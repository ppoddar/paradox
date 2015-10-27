package org.paradox.query.impl;

import org.paradox.query.Expression;
import org.paradox.query.exp.ExpressionVisitor;

import com.paradox.query.kv.KVQueryContext;



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
	@SuppressWarnings("unchecked")
	@Override
	public V evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
		return (V)candidate;
	}

	@Override
	public String getName() {
		return _typeName;
	}

}