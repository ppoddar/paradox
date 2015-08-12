package com.paradox.query.impl;

import java.util.Comparator;
import java.util.Iterator;

import com.paradox.nosql.query.KVQueryContext;
import com.paradox.query.Expression;

/**
 * A comparator to order query results.
 * 
 * @author pinaki poddar
 *
 * @param <T> the type of result rows to be compared
 */
public class OrderingComparator<T> implements Comparator<T> {
	private final KVQueryContext<?,?,?> _ctx;
	private final Select _select;
	
	public OrderingComparator(KVQueryContext<?,?,?> ctx, Select select) {
		_ctx = ctx;
		_select = select;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		Iterator<Expression.Path<?>> terms = _select.getOrderByTerms();
		int result = 0;
		while (terms.hasNext()) {
			Expression.Path<?> term = terms.next();
			Object v1 = term.evaluate(o1, _ctx);
			Object v2 = term.evaluate(o2, _ctx);
			if (v1 instanceof Comparable && v2 instanceof Comparable) {
				result = ((Comparable)v1).compareTo(v2);
				if (result != 0) break;
			}
		}
		return result;
	}

}
