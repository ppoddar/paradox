package com.paradox.query;

import com.paradox.schema.Schema;
/*
 *  A context provides an environment to execute a query.
 */
public interface QueryContext<K,V,U> {

  /**
   * Gets the schema. If a schema is available, then the query is semantically validated
   * against the schema.
   * 
   * @return the schema for semantic validation. Can be null to disable validation.
   */
  Schema getSchema();



  ExpressionFactory getExpressionFactory();
  
  
  QueryExecutor<K, V, U> getExecutor();

}