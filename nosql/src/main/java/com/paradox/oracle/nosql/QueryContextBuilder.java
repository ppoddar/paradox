package com.paradox.oracle.nosql;

import oracle.kv.Consistency;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

import org.json.JSONObject;
import org.paradox.query.ExpressionFactory;
import org.paradox.query.impl.QueryExpressionFactory;
import org.paradox.query.kv.KeyMaker;
import org.paradox.query.kv.ValueTransformer;
import org.paradox.schema.Schema;

/**
 * Builder for {@link KVQueryContext}.
 * <br>
 * Uses a {@link DefaultKeyMaker default key} policy. 
 * 
 * @author pinaki poddar
 *
 */
public class QueryContextBuilder {
	private DefaultKeyMaker _keyMaker;
	private ValueTransformer<Value,JSONObject> _valueTransformer;
	private final Schema _schema;
	private Consistency _consistency = Consistency.NONE_REQUIRED;
	private long _timeout;
	private KVStore _store;
	
	public QueryContextBuilder(KVStore store) {
		this(store, null);
	}
	
	public QueryContextBuilder(KVStore store, Schema schema) {
		if (store == null) 
			throw new IllegalArgumentException("Can not create context with null store");
		_store  = store;
		_schema = schema;
	}
	
	public DefaultQueryContext build() {
		DefaultQueryContext ctx = new DefaultQueryContext();
		
  		if (_keyMaker != null) ctx.setKeyMaker(_keyMaker);
  		if (_valueTransformer != null) ctx.setValueTransformer(_valueTransformer);
  		if (_schema != null) ctx.setSchema(_schema);
  		
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
