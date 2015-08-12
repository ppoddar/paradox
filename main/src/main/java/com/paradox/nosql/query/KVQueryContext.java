package com.paradox.nosql.query;

import com.paradox.query.QueryContext;
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
public interface KVQueryContext<K,V,U> extends QueryContext {
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
}
