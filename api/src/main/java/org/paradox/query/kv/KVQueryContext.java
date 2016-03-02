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

package org.paradox.query.kv;

import org.paradox.query.QueryContext;

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
public interface KVQueryContext<K,V,U> extends QueryContext<K,V,U> {
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
