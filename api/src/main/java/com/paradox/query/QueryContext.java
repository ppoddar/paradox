package com.paradox.query;

import java.util.Iterator;
import java.util.Map;

import org.paradox.schema.Schema;

/**
 *  A context provides an environment to execute a query.
 *  
 */
public interface QueryContext<K,V,U> {

  /**
   * Gets the schema. If a schema is available, then the query is semantically validated
   * against the schema.
   * 
   * @return the schema for semantic validation. Can be null to disable validation.
   */
  Schema getSchema();
  
  
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
	   * Gets the timeout in millisecond unit.
	   */
	  long getQueryTimeout();
	  void setQueryTimeout(long timeout);

}