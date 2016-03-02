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

package org.paradox.query.impl.nosql;

import oracle.kv.Consistency;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.paradox.query.KeyMaker;
import org.paradox.query.ValueTransformer;
import org.paradox.schema.Schema;

/**
 * Builder for {@link QueryContext}.
 * <br>
 * Uses a {@link DefaultKeyMaker default key} policy. 
 * 
 * @author pinaki poddar
 *
 */
public class QueryContextBuilder {
	private KeyMaker<Key> _keyMaker = new DefaultKeyMaker();
	private ValueTransformer<Value,JSONObject> _valueTransformer = new JSONValueTransformer();
	private final Schema _schema;
	private Consistency _consistency = Consistency.NONE_REQUIRED;
	private long _timeout;
	private final KVStore _store;
	
	public QueryContextBuilder(KVStore store) {
		this(store, null);
	}
	
	public QueryContextBuilder(KVStore store, Schema schema) {
		_store  = store;
		if (_store == null) throw new IllegalStateException("Must set NoSQL Store connection");
		_schema = schema;
	}
	
	public DefaultQueryContext build() {
		DefaultQueryContext ctx = new DefaultQueryContext();
		
  		ctx.setKeyMaker(_keyMaker);
  		ctx.setValueTransformer(_valueTransformer);
  		ctx.setSchema(_schema);
  		ctx.setConsistency(_consistency);
  		ctx.setQueryTimeout(_timeout, TimeUnit.MILLISECONDS);
  		ctx.setStore(_store);
  		
  		return ctx;
	}
	
	/**
	 * Sets the policy to create {@link Key key} for Oracle NoSQL data store.
	 * 
	 * @return the same builder
	 */
	public QueryContextBuilder withKeyMaker(DefaultKeyMaker keyMaker) {
		_keyMaker = keyMaker;
		return this;
	}
	
	/**
	 * Sets the transformer that converts between Oracle NoSQL storage representation and
	 * user representation of data values.
	 */
	public QueryContextBuilder withValueTransformer(ValueTransformer<Value,JSONObject> transformer) {
		_valueTransformer = transformer;
		return this;
	}
	
	
	/**
	 * Sets the level of read consistency required for query result.
	 */
	public QueryContextBuilder withConsistency(Consistency consistency) {
		_consistency = consistency;
		return this;
	}
	
	/**
	 * Sets the timeout in millisecond unit.
	 */
	public QueryContextBuilder withQueryTimeout(long timeout) {
		_timeout = timeout;
		return this;
	}
	
}
