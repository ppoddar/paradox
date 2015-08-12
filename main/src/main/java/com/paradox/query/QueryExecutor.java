package com.paradox.query;

import java.util.Iterator;
import java.util.Map;

import com.paradox.nosql.query.KVQueryContext;

/**
 * Executes a SQL query in a given {@link KVQueryContext execution environment}. 
 * <br>
 * The query grammar is a limited version  SQL grammar. 
 * The grammar is described <a href="../../../../../NoSQL.g4.html"> here</a>. 
 *  
 * @author pinaki poddar
 *
 */
public interface QueryExecutor<K,V,U> {

//  ResultPacker<U> getResultPacker(Class<U> userType);
  
  /**
   * Executes the given select query and returns a list of results.
   * @param sql a SQL select query
   * @return a list of selected result. Can be empty, but never null.
   */
  Iterator<U> executeQuery(String sql) throws Exception;

  /**
   * Executes the given select query and returns a list of results.
   * @param sql a SQL select query
   * @param bindParams values for bind parameters used in the query
   * indexed by the bind parameter name
   * @return a list of selected result. Can be empty, but never null.
   */
  Iterator<U> executeQuery(String sql, Map<String, Object> bindParams) throws Exception;

  /**
   * Executes the given select query and returns a list of results.
   * @param sql a SQL select query
   * @param bindPairs values for bind parameters used in the query.
   * Must have even numbered elements. The element at even index is the
   * bind parameter name and corresponding (next) element at odd index
   * is the value.
   * @return a list of selected result. Can be empty, but never null.
   */
  Iterator<U> executeQuery(String sql, Object... bindPairs) throws Exception;

  /**
   * Executes the given insert/update/delete query and returns the
   * number of key-value pairs affected.
   * @param sql a insert/update/delete query
   * @param bindParams values for bind parameters used in the query
   * indexed by the bind parameter name
   * @return number of key-value pairs affected.
   */
  int execute(String sql, Map<String, Object> bindParams) throws Exception;

  /**
   * Executes the given insert/update/delete query and returns the
   * number of key-value pairs affected.
   * @param sql a insert/update/delete query
   * @return number of key-value pairs affected.
   */
  int execute(String sql) throws Exception;

	
	/**
	 * The execution context of this receiver.
	 */
	QueryContext getContext();
	
}
