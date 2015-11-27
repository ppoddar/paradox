package org.paradox.query.kv;


/**
 * A transformer between data representation used by user application and storage.
 * <p>
 * This interface provides the transformation protocol for to convert a storage {@link Value}
 * to a user level representation and vice versa. 
 * <p>
 * Oracle NoSQL uses {@link Value} interface for storage representation in its Key-Value store. 
 * {@code oracle.kv.Value} interface provides two-way conversion between itself and byte array. 
 * A user application however may prefer a more transparent data representation than byte array.
 * <p>
 * The other important feature of this interface is to {@link #extractFieldValue(Object, String) extract}
 * the value of a property.
 * 
 * <V> storage data type 
 * <U> user data type
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
	 * @param candidate the candidate that has been {@link #decode(Object) decoded} 
	 * from storage representation. 
	 * @param path a dot separated path e.g. {@code bestFriend.address.city} 
	 * @return value of the property specified by the given path. 
	 * @throws ValueNotExistException if candidate does not contain the given path.
	 * This is distinct from situation where the property exists with a null value.
	 */
	Object extractFieldValue(U candidate, String path) throws ValueNotExistException;
}
