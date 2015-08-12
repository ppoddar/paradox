package com.oracle.nosql.query;

import oracle.kv.Consistency;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

import org.json.JSONObject;

import com.paradox.nosql.query.KVQueryContext;
import com.paradox.nosql.query.KeyMaker;
import com.paradox.nosql.query.ValueTransformer;
import com.paradox.schema.Schema;

/**
 * Builder for {@link KVQueryContext}.
 * <br>
 * Uses a {@link DefaultKeyMaker default key} policy. 
 * 
 * @author pinaki poddar
 *
 */
public class QueryContextBuilder {
	private KeyMaker<Key> _keyMaker = new DefaultKeyMaker();
	private ValueTransformer<Value,JSONObject> _valueTransformer;
	private final Schema _schema;
	private Consistency _consistency = Consistency.NONE_REQUIRED;
	private long _timeout;
	private final KVStore _store;
	
	public QueryContextBuilder(KVStore store, Schema schema) {
		_store  = store;
		if (_store == null) throw new IllegalStateException("Must set NoSQL Store connection");
		_schema = schema;
	}
	
	public DefaultQueryContext build() {
		if (_keyMaker == null) throw new IllegalStateException("Must set Key Distribution Policy");
		if (_valueTransformer == null) throw new IllegalStateException("Must set Value Transformation Policy");
		
		DefaultQueryContext ctx = new DefaultQueryContext();
		
  		ctx.setKeyMaker(_keyMaker);
  		ctx.setValueTransformer(_valueTransformer);
  		ctx.setSchema(_schema);
  		ctx.setConsistency(_consistency);
  		ctx.setQueryTimeout(_timeout);
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
