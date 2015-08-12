package com.paradox.query.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.paradox.nosql.query.Index;
import com.paradox.nosql.query.KVQueryContext;
import com.paradox.nosql.query.ValueTransformer;
import com.paradox.query.Expression;
import com.paradox.query.QueryExecutor;
import com.paradox.query.ResultPacker;
import com.paradox.util.NVPair;

/**
 * Defines the basic functions of query execution. The concrete implementations must supply these functions.
 * <p>
 * The basic discipline of query execution is
 * <ol>
 * <li> Parse the query string to build a {@link Select} statement in terms of {@link Expression expression nodes}.
 * <li> Bind query parameters, if any
 * <li> Analyze the query predicate (i.e. a {@code where} clause in a {@code select} statement) to 
 * {@link #selectIndex(Select, KVQueryContext) determine} the appropriate index. 
 * <li> Retrieve the candidate extent as an {@link KVStore#storeIterator(oracle.kv.Direction, int, oracle.kv.Key, 
 * oracle.kv.KeyRange, oracle.kv.Depth, oracle.kv.Consistency, long, java.util.concurrent.TimeUnit, 
 * oracle.kv.StoreIteratorConfig) iterator over stored key-value} pairs from the chosen index 
 * <li> For each key-value pair, {@link ValueTransformer#decode(oracle.kv.Value) transform} the stored representation
 * to a candidate record in user representation 
 * <li> Evaluate each candidate on the query predicate. Collect the candidate if it passes evaluation.
 * <li> {@link ResultPacker#pack(Projections, Object) Pack} the collected candidates into a result, 
 * optionally sorting them. 
 * </ol>
 * <p>
 * The concrete implementations must provide the details on 
 * <ol type="a">
 * 	<li> how to choose an <em>appropriate</em> index 
 *  <li> how to project the results
 * </ol>
 * <b>Predicate Evaluation</b>: To evaluate a candidate, the field/attribute values are required e.g. to evaluate
 * a comparison expression such as {@code person.age > 25}, it is required to extract the {@code age} attribute value 
 * from each {@code Person} candidate record.<br>
 * In Oracle NoSQL Key-Value store, a {@code Person} record is stored as an array of bytes. This execution process
 * is <em>agnostic</em> to the encoding scheme that converted the user representation of a {@code Person} record into 
 * the storage representation of a byte array.<br>
 * During evaluation of each expression, the extraction of attribute value(s) from the candidate record is delegated
 * to the {@link ValueTransformer#extractFieldValue(Object, String) Value Transformer} interface. The user of this facility must
 * provide the {@link ValueTransformer Transformer} via the {@link KVQueryContext#getValueTransformer() execution context}
 * 
 * 
 * @author pinaki poddar
 */
public abstract class AbstractQueryExecutor<K,V,U> implements QueryExecutor<K,V,U> {
	private final KVQueryContext<K,V,U> _ctx;
	
	public AbstractQueryExecutor(KVQueryContext<K,V,U> ctx) {
		if (ctx == null) throw new NullPointerException("Can not create executor with null context");
		_ctx = ctx;
	}
	
	public final KVQueryContext<K,V,U> getContext() {
		return _ctx;
	}
	
	public Iterator<U> executeQuery(String query,Object... bindPairs)  throws Exception {
		return executeQuery(query, new NVPair(bindPairs));
	}
	@Override
	public Iterator<U> executeQuery(String query, Map<String, Object> bindParams) throws Exception {
		ValueTransformer<V,U> valueTransformer = _ctx.getValueTransformer();
		Select select = new SelectBuilder(_ctx.getSchema(), _ctx.getExpressionFactory()).parse(query);
		ResultPacker<U> packer = newResultPacker(select, _ctx);
		bindParams(select, bindParams);
		Index<V> index = selectIndex(select, _ctx);
		Iterator<V> candidates = index.fetch(_ctx);
		while (candidates.hasNext()) {
			V kvv = candidates.next();
			U candidate = valueTransformer.decode(kvv);
			Expression.Predicate where = select.getPredicate();
			if (where == null || where.evaluate(candidate, _ctx)) {
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
  public Iterator<U> executeQuery(String sql) throws Exception {
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
	protected abstract Index<V> selectIndex(Select select, KVQueryContext<K,V,U> ctx); 
	protected abstract ResultPacker<U> newResultPacker(Select select, KVQueryContext<K,V,U> ctx); 
}
