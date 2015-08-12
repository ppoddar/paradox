package com.oracle.nosql.query;

import oracle.kv.Consistency;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

import com.paradox.nosql.query.KVQueryContext;
import com.paradox.nosql.query.KeyMaker;
import com.paradox.nosql.query.ValueTransformer;
import com.paradox.query.ExpressionFactory;
import com.paradox.query.QueryExecutor;
import com.paradox.query.ResultPacker;
import com.paradox.query.impl.QueryExpressionFactory;
import com.paradox.schema.Schema;

/**
 * The execution environment and engine to execute a query.
 * <br>
 * A context is configured with all its related artifacts by
 * {@link QueryContextBuilder builder} at construction.
 * For the user, a context is immutable. 
 * 
 * @author pinaki poddar
 */
public final class DefaultQueryContext<U> implements KVQueryContext<Key,Value,U> {
	private Schema            		_schema;
	private KeyMaker<Key> 			_keyMaker;
	private ValueTransformer<Value,U>  	_valueTransformer;
	private Class<? extends ResultPacker<U>>  _resultPacker;
	private KVStore                 _store;
	private Consistency             _consistency;
	private ExpressionFactory       _factory;
	private final QueryExecutor<Key, Value, U> _executor;
	
	
	DefaultQueryContext() {
		_executor = new DefaultQueryExecutor<U>(this);
	}
	
	public KVStore getStore() {
		return _store;
	}
	
	@Override
	public Schema getSchema() {
		return _schema;
	}
	
	@Override
	public ValueTransformer<Value,U> getValueTransformer() {
		return _valueTransformer;
	}
	
	@Override
	public KeyMaker<Key> getKeyMaker() {
		return _keyMaker;
	}
	
//	@Override
	public Class<? extends ResultPacker<U>> getResultPacker() {
		return _resultPacker;
	}

    public Consistency getConsistency() {
    	return _consistency;
    }
	
	void setConsistency(Consistency consistency) {
		_consistency = consistency;
	}
	
	void setKeyMaker(KeyMaker<Key> keyMaker) {
		_keyMaker = keyMaker;
	}
	
	void setSchema(Schema schema) {
		_schema = schema;
	}
	
	void setStore(KVStore store) {
		if (store == null) 
			throw new IllegalArgumentException("Can not create context with null datastore handle");
		_store = store;
	}
	
	void setValueTransformer(ValueTransformer<Value,U> transformer) {
		_valueTransformer = transformer;
	}
	
	void setResultPacker(Class<? extends ResultPacker<U>> packer) {
		_resultPacker = packer;
	}

	@Override
	public ExpressionFactory getExpressionFactory() {
		if (_factory == null) {
			_factory = new QueryExpressionFactory();
		}
		return _factory;
	}
	
	public void setQueryTimeout(long timeout) {
		_executor.setQueryTimeout(timeout);
	}

	@Override
	public QueryExecutor<Key,Value,U> getExecutor() {
		return _executor;
	}
}
