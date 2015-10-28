package org.paradox.nosql.query;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.paradox.query.Expression;
import org.paradox.query.ExpressionFactory;
import org.paradox.query.Index;
import org.paradox.query.ResultPacker;
import org.paradox.query.impl.ExpressionCollector;
import org.paradox.query.impl.QueryExpressionFactory;
import org.paradox.query.impl.Select;
import org.paradox.query.impl.SelectBuilder;
import org.paradox.query.kv.KVQueryContext;
import org.paradox.query.kv.KeyMaker;
import org.paradox.query.kv.ValueTransformer;
import org.paradox.schema.Schema;
import org.paradox.schema.UserType;
import org.paradox.util.NVPair;

import oracle.kv.Consistency;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.Value;

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
	private Schema            		_schema;
	private KeyMaker<Key> 			_keyMaker;
	private ValueTransformer<Value,JSONObject>  	_valueTransformer;
	private Class<? extends ResultPacker<JSONObject>>  _resultPacker;
	private KVStore                 _store;
	private Consistency             _consistency;
	private ExpressionFactory       _factory;
	private long _timeout;
	
	
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
	
//	@Override
	public Class<? extends ResultPacker<JSONObject>> getResultPacker() {
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
	
	void setValueTransformer(ValueTransformer<Value,JSONObject> transformer) {
		_valueTransformer = transformer;
	}
	
	
	public ExpressionFactory getExpressionFactory() {
		if (_factory == null) {
			_factory = new QueryExpressionFactory();
		}
		return _factory;
	}
	
	public Iterator<JSONObject> executeQuery(String query,Object... bindPairs)  throws Exception {
		return executeQuery(query, new NVPair(bindPairs));
	}
	@Override
	public Iterator<JSONObject> executeQuery(String query, Map<String, Object> bindParams) throws Exception {
		Select select = new SelectBuilder(getSchema(), getExpressionFactory()).parse(query);
		ResultPacker<JSONObject> packer = newResultPacker(select, this);
		bindParams(select, bindParams);
		Index<Value> index = selectIndex(select, this);
		Iterator<Value> candidates = index.fetch(this);
		while (candidates.hasNext()) {
			Value kvv = candidates.next();
			JSONObject candidate = _valueTransformer.decode(kvv);
			Expression.Predicate where = select.getPredicate();
			if (where == null || where.evaluate(candidate, this)) {
				packer.pack(candidate);
			}
		}
		return packer.getResultList();
	}
	
	@Override
	public int execute(String query, Map<String, Object> bindParams) {
		throw new UnsupportedOperationException();
	}
  @Override
  public Iterator<JSONObject> executeQuery(String sql) throws Exception {
    return executeQuery(sql, (Object[])null);
  }

  @Override
  public int execute(String sql) throws Exception {
    return execute(sql, null);
  }

	
	protected void bindParams(Select select, Map<String,Object> params) {
		if (select.getPredicate() == null) return;
		ExpressionCollector<Expression.BindParameter> collector = 
				new ExpressionCollector<Expression.BindParameter>(Expression.BindParameter.class);
		List<Expression.BindParameter> bindParams = collector.collect(select.getPredicate());
		for (Expression.BindParameter param : bindParams) {
			param.setValue(getBindParameterValue(param, params));
		}
		
	}
	
	Object getBindParameterValue(Expression.BindParameter param, Map<String,Object> params) {
		if (params == null) 
			throw new IllegalArgumentException("Parameter [" + param.getName() + "] is not supplied");
		if (!params.containsKey(param.getName())) 
			throw new IllegalArgumentException("Parameter [" + param.getName() + "] is not supplied. "
					+ "Supplied parameters are " + params.keySet());
		return params.get(param.getName());
		
	}
	
	/**
	 * Chooses a suitable index for the given select statement.
	 * This index would be used retrieve the extent.
	 * @param select the select statement 
	 * @param ctx the query execution environment
	 * @return an Index to retrieve the candidate extent
	 */
	
	protected Index<Value> selectIndex(Select select, KVQueryContext<Key, Value, JSONObject> ctx) {
		if (ctx.getSchema() == null)
			throw new IllegalStateException("No schema has been set of this conetxt");
		UserType type = ctx.getSchema().getUserType(select.getCandidate().getName());
		if (type == null) 
			throw new RuntimeException(select.getCandidate().getName() + "is not a known type to select");
		
		Key key   = (Key)ctx.getKeyMaker().makeTypeKey(type);
		return new FullScanIndex(key);
	}

	@Override
	public long getQueryTimeout() {
		return _timeout;
	}

	@Override
	public void setQueryTimeout(long timeout) {
		_timeout = timeout;		
	}

	
	protected ResultPacker<JSONObject> newResultPacker(Select select, KVQueryContext<Key, Value, JSONObject> ctx) {
		return new JSONResultPacker();
	}


}
