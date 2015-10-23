package com.oracle.nosql.query;

import org.json.JSONObject;

import oracle.kv.Consistency;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

import com.oracle.nosql.query.json.JSONValueTransformer;
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
public final class DefaultQueryContext implements KVQueryContext<Key,Value,JSONObject> {
	private KeyMaker<Key> _keyMaker;
	private ValueTransformer<Value,JSONObject> _valueTransformer;
	private Schema _schema;
	private KVStore _store;
	private Consistency _consistency = Consistency.NONE_REQUIRED;
	private Class<? extends ResultPacker<JSONObject>>  _resultPacker;
	private final QueryExecutor<Key, Value, JSONObject> _executor;
	
	
	DefaultQueryContext() {
		_executor = new DefaultQueryExecutor(this);
		
		_keyMaker = new DefaultKeyMaker();
		_valueTransformer = new JSONValueTransformer();
	}
	
	
	public Class<? extends ResultPacker<JSONObject>> getResultPacker() {
		return _resultPacker;
	}

	public void setQueryTimeout(long timeout) {
		_executor.setQueryTimeout(timeout);
	}

	@Override
	public QueryExecutor<Key,Value,JSONObject> getExecutor() {
		return _executor;
	}
	
	public KVStore getStore() {
		return _store;
	}
	@Override
	public Schema getSchema() {
		return _schema;
	}
	
	@Override
	public ValueTransformer<Value,JSONObject> getValueTransformer() {
		return _valueTransformer;
	}
	
	@Override
	public KeyMaker<Key> getKeyMaker() {
		return _keyMaker;
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
	
	void setValueTransformer(ValueTransformer<Value,JSONObject> transformer) {
		_valueTransformer = transformer;
	}
	
	@Override
	public ExpressionFactory getExpressionFactory() {
		return new QueryExpressionFactory();
	}
}
