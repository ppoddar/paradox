package org.paradox.query.impl;

import org.paradox.query.Expression;
import org.paradox.query.kv.KVQueryContext;



/**
 * An expression to designate a candidate type.
 * 
 * @param <V> the type 
 */
public class CandidatePath<V> extends AbstractPath<V> implements Expression.Candidate<V> {	
	public CandidatePath(String type) {
		super(type);
	}

	/**
	 * Evaluates as the given candidate itself.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
		return (V)candidate;
	}

}