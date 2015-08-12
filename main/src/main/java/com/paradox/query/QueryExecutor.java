package com.paradox.query;

import java.util.Iterator;
import java.util.Map;

import com.paradox.query.QueryContext;

/**
 * Executes a SQL query in a given {@link QueryContext execution environment}. 
 * <br>
 * The query grammar is a limited version  SQL grammar. 
 * The grammar is described <a href="../../../../../NoSQL.g4.html"> here</a>. 
 *  
 * @author pinaki poddar
 *
 */
public interface QueryExecutor<K,V,U> {
	/**
	 * Executes a query to return a list of results.
	 * 
	 * @param query a SQL string. 
	 * @param bindParams TODO
	 * @return a list of query result. Can be empty, but never null.
	 */
	Iterator<U> executeQuery(String query, Map<String, Object> bindParams) throws Exception;
	int execute(String query, Map<String, Object> params) throws Exception;
	
	/**
	 * The execution context of this receiver.
	 */
	QueryContext<K,V,U> getContext();
	
}
