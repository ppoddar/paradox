package com.paradox.query;

import java.util.Iterator;
import java.util.Map;

import com.paradox.nosql.query.KeyMaker;
import com.paradox.nosql.query.ValueTransformer;
import com.paradox.schema.Schema;

/**
 * A context provides an environment to execute a query.
 * <br>
 * A query execution on a Key-Value store requires few associated artifacts
 * that the user of this interface must supply:
 * <ul>
 * <li>{@link KeyMaker} to create a partial or complete {@link Key}. 
 * For key-value store, the composition of key is designed by the application  
 * and hence the {@link KeyMaker} contract can only be satisfied by the application.
 * <li>{@link ValueTransformer} to extract the property from the value.    
 * The storage representation is opaque (an array of bytes). The query expressions 
 * based on property value e.g. {@code person.age > 25} can not be evaluated unless 
 * the user representation is known. 
 * <li>{@link Schema} to validate the query semantically. The schema can be optional.
 * If a schema is supplied, then the name tokens in a query are validated against 
 * the schema namespace.  
 * {@link Consistency} read consistency. It is defaulted to {@link Consistency#NONE_REQUIRED}.
 * <li>and last, but not the least, {@link KVStore Store} reference.  
 * <li>which is the representation for the output/selected result?
 * </ul>
 * This interface pulls together these concerns.
 * <p>
 * <b>Bind Parameter</b>: If a query using bind parameters (it is recommended), then the     
 * 
 * <K> type of key used by the data store
 * <V> type of representation for values used by the data store
 * <U> type of representation for values used by the user application
 * 
 * @author pinaki poddar
 *
 */
public interface QueryContext<K,V,U> {
	/**
	 * Gets the schema, if any. If a schema is available, then the query is semantically validated
	 * against the schema.
	 * 
	 * @return the schema for semantic validation. Can be null to disable validation.
	 */
	Schema getSchema();
	
	
	/**
	 * Gets the policy to create {@link Key key} for Oracle NoSQL data store.
	 * 
	 * @return a policy that creates key for data store. Never null.
	 */
	KeyMaker<K> getKeyMaker();
	
	/**
	 * Gets the transformer that converts between Oracle NoSQL storage representation and
	 * user representation of data values.
	 */
	ValueTransformer<V,U> getValueTransformer();
	
	Class<? extends ResultPacker<U>> getResultPacker();
	
	/**
	 * Gets the timeout in millisecond unit.
	 */
	long getQueryTimeout();
	
	
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
	
	
	ExpressionFactory getExpressionFactory();
}
