package org.paradox.query;

import java.util.Iterator;

import org.paradox.query.QueryContext;

/**
 * A stored index.
 * 
 * @author pinaki poddar
 *
 * @param <V>
 */
public interface Index<V> {
	/**
	 * Fetches the values.
	 * 
	 * @param ctx the execution context
	 * @return an iterator
	 */
	Iterator<V> fetch(QueryContext<?,?,?> ctx);
}
