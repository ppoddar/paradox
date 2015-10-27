package org.paradox.query;

import java.util.Iterator;

import com.paradox.query.kv.KVQueryContext;

/**
 * Packs query result in a user representation.
 * A packer instance lives for a single {@link KVQueryContext#executeQuery(String) query execution}.
 * 
 * @param <U> type in user representation
 * 
 * @author pinaki poddar
 *
 */
public interface ResultPacker<U> {
	/**
	 * Packs the given selected candidate into a result set.
	 * @param candidate a candidate
	 */
	void pack(U candidate);
	
	/**
	 * Gets the results for the end user.
	 * @return an iterator over the list of results selected by the query 
	 */
	Iterator<U> getResultList();
}
