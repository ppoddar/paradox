package com.paradox.nosql.query;

import java.util.Map;

import com.paradox.schema.Schema;
import com.paradox.schema.UserType;

/**
 * Generates storage key for a key-value data store.
 * 
 * @author pinaki poddar
 *
 */
public interface KeyMaker<K> {
	/**
	 * Gets a key for the given type and given instance.
	 * 
	 * @param type a user type defined in a {@link Schema}.
	 * @param pkValues the values for {@link UserType#getIdAttributes() identifier attributes} indexed by the
	 * attribute name. Each identifier attribute may not be present in the given map.
	 * @return a complete or partial key
	 */
	K makeInstanceKey(UserType type, Map<String,?> pkValues);
	
	
	/**
	 * Gets a key for the given type.
	 * This key will be used to query an extent as the candidate set for query evaluation.
	 * @param type a user-defined type
	 * @return a partial key for the given type which will be able to retrieve the entire extent for the given type.
	 */
	K makeTypeKey(UserType type);
	
	/**
	 * Affirms if the key for the given user-defined type is a complete major path.
	 * This is likely to return {@code false} except cases where all records of a
	 * user-defined type are stored in the same storage node. 
	 * @param type a user-defined type.
	 * @return true if the key for the given type is a complete major path.
	 * @see #makeTypeKey(UserType)
	 */
	boolean isTypeKeyComplete(UserType type);
}
