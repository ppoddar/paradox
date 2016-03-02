/**

      Copyright ©2016. Author Pinaki Poddar. All Rights Reserved. 

	Permission to use, copy, modify, and distribute this software and its documentation 
	for educational, research, and not-for-profit purposes, without fee and without a 
	signed licensing agreement, is hereby granted, provided that the above copyright notice, 
	this paragraph and the following two paragraphs appear in all copies, modifications, 
	and distributions. 


	IN NO EVENT SHALL THE AUTHOR BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, 
	OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE 
	AND ITS DOCUMENTATION, EVEN IF THE AUTHOR HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

	THE AUTHOR SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE AND 
	ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED HEREUNDER IS PROVIDED "AS IS". THE AUTHOR HAS 
	NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

package org.paradox.query;

/**
 * A transformer between data representation used by user application and data storage.
 * <p>
 * This interface provides the transformation protocol for to convert a stored value
 * to a user level representation and vice versa. 
 * <p>
 * The important feature of this interface is to {@link #extractFieldValue(Object, String) extract}
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
