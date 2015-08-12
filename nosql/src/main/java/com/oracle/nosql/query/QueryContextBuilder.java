package com.oracle.nosql.query;

import oracle.kv.Consistency;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

import com.paradox.nosql.query.KeyMaker;
import com.paradox.nosql.query.ValueTransformer;
import com.paradox.query.QueryContext;
import com.paradox.query.ResultPacker;
import com.paradox.schema.Schema;

/**
 * Builder for {@link QueryContext}.
 * <br>
 * Uses a {@link DefaultKeyMaker default key} policy. 
 * 
 * @author pinaki poddar
 *
 */
public class QueryContextBuilder<T> {
	private KeyMaker<Key> _keyMaker = new DefaultKeyMaker();
	private ValueTransformer<Value,T> _valueTransformer;
	private Class<? extends ResultPacker<T>>  _resultPacker;
	private final Schema _schema;
	private Consistency _consistency = Consistency.NONE_REQUIRED;
	private long _timeout;
	private final KVStore _store;
	
	public QueryContextBuilder(KVStore store, Schema schema) {
		_store  = store;
		if (_store == null) throw new IllegalStateException("Must set NoSQL Store connection");
		_schema = schema;
	}
	
	public DefaultQueryContext<T> build() {
		if (_keyMaker == null) throw new IllegalStateException("Must set Key Distribution Policy");
		if (_valueTransformer == null) throw new IllegalStateException("Must set Value Transformation Policy");
		if (_resultPacker == null) throw new IllegalStateException("Must set Result Packing Policy");
		
		DefaultQueryContext<T> ctx = new DefaultQueryContext<T>();
		
  		ctx.setKeyMaker(_keyMaker);
  		ctx.setValueTransformer(_valueTransformer);
  		ctx.setResultPacker(_resultPacker);
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
	public QueryContextBuilder<T> withKeyMaker(DefaultKeyMaker keyMaker) {
		_keyMaker = keyMaker;
		return this;
	}
	
	/**
	 * Sets the transformer that converts between Oracle NoSQL storage representation and
	 * user representation of data values.
	 */
	public QueryContextBuilder<T> withValueTransformer(ValueTransformer<Value,T> transformer) {
		_valueTransformer = transformer;
		return this;
	}
	
	/**
	 * Sets the result packer that presents the 
	 * user representation of data values.
	 */
	public QueryContextBuilder<T> withResultPacker(Class<? extends ResultPacker<T>> packer) {
		_resultPacker = packer;
		return this;
	}
	
	/**
	 * Sets the level of read consistency required for query result.
	 */
	public QueryContextBuilder<T> withConsistency(Consistency consistency) {
		_consistency = consistency;
		return this;
	}
	
	/**
	 * Sets the timeout in millisecond unit.
	 */
	public QueryContextBuilder<T> withQueryTimeout(long timeout) {
		_timeout = timeout;
		return this;
	}
	
}
