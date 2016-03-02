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
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.paradox.schema.Schema;

/**
 *  A context provides an environment to execute a query
 *  on a key-value store and returns result in user 
 *  representation.
 *  <p>
 *  Query execution on a Key-Value store requires associated artifacts
 *  that the user of this interface must supply:
 * <ul>
 * <li>{@link KeyMaker} to create a partial or complete key. 
 * For key-value store, the composition of key is designed by the application  
 * and hence the {@link KeyMaker} contract can only be satisfied by the application.
 * <li>{@link ValueTransformer} to extract the property from the stored value.    
 * The storage representation is opaque (an array of bytes). The query expressions 
 * based on property value e.g. {@code person.age > 25} can not be evaluated unless 
 * the user representation is known. 
 * <li>{@link Schema} to validate the query semantically. The schema can be optional.
 * If a schema is supplied, then the name tokens in a query are validated against 
 * the schema namespace.  
 *  
 * <li>which is the representation for the output/selected result?
 * </ul>
 * This interface pulls together these concerns.
 * <p>
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
   * Gets the schema. If a schema is available, then the query is semantically validated
   * against the schema.
   * 
   * @return the schema for query validation and efficient query plan. 
   * Can be null to disable validation.
   */
  Schema getSchema();
  
  
  /**
   * Executes the given select query and returns a list of results.
   * @param sql a SQL select query string
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
  int executeUpdate(String sql, Map<String, Object> bindParams) throws Exception;

  /**
   * Executes the given insert/update/delete query and returns the
   * number of key-value pairs affected.
   * @param sql a insert/update/delete query
   * @return number of key-value pairs affected.
   */
  int executeUpdate(String sql) throws Exception;

	
	  /**
	   * Gets the timeout in millisecond unit.
	   */
	  long getQueryTimeout();
	  
	  /**
	   * Sets the query time out.
	   * @param timeout time value
	   * @param unit unit of time value
	   */
	  QueryContext<K,V,U> setQueryTimeout(long timeout, TimeUnit unit);
	  
	  /**
	   * Gets an iterator on the given key extent.
	   * @param k a 
	   * @return If a store organizes its key in a hierarchical namespace 
	   * (as the case for Oracle NoSQL), all keys that are
	   * descendant from the given key.
	   */
	  Iterator<K> getExtent(K k);
	  
		/**
		 * Gets the policy to create identifier key for NoSQL data store.
		 * 
		 * @return a policy that creates key for data store. Never null.
		 */
		KeyMaker<K> getKeyMaker();
		
		/**
		 * Gets the transformer that converts between NoSQL storage representation and
		 * user representation of data values.
		 */
		ValueTransformer<V,U> getValueTransformer();


}
