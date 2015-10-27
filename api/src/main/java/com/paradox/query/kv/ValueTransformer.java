package com.paradox.query.kv;

/**
 * A transformer between data representation used by the Oracle NoSQL and user application.
 * <p>
 * This interface provides the transformation protocol for to convert a storage {@link Value}
 * to a user level representation. 
 * <p>
 * Oracle NoSQL uses {@link Value} interface for storage representation in its Key-Value store. 
 * {@code oracle.kv.Value} interface provides two-way conversion between itself and byte array. 
 * A user application however may prefer a more transparent data representation than byte array.
 * <p>
 * The other important feature of this interface is to {@link #extractFieldValue(Object, String) extract}
 * the value of a property.
 * 
 * 
 * @author pinaki poddar
 *
 */
public interface ValueTransformer<V,U> {
	/**
	 * Convert the given instance to the storage representation used by data store. 
	 */
	V encode(U instance);
	
	/**
	 * Convert from the given storage representation to a representation which can be easier 
	 * to extract the value of a property. 
	 * @see #extractFieldValue(Object, String)
	 * @return a representation preferred for value extraction. 
	 */
	U decode(V v);
	
	/**
	 * Extract the value from the given candidate for the given path.
	 * @param candidate the candidate that has been obtained by {@link #decode(Value) decoding} the storage 
	 * representation. 
	 * @param path a dot separated path e.g. {@code bestFriend.address.city} 
	 * @return value of the given property
	 */
	Object extractFieldValue(U candidate, String path);
	
}
