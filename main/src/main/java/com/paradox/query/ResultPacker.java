package com.paradox.query;

import java.util.Iterator;

import com.paradox.query.QueryContext;

/**
 * Packs query result in a user representation.
 * A packer instance lives for a single {@link QueryContext#executeQuery(String) query execution}.
 * 
 * @author pinaki poddar
 *
 */
public interface ResultPacker<T> {
	/**
	 * Packs the given selected candidate into a result set.
	 * @param candidate a candidate
	 */
	void pack(T candidate);
	
	/**
	 * Gets the results for the end user.
	 * @return an iterator over the list of results selected by the query 
	 */
	Iterator<T> getResultList();
}
