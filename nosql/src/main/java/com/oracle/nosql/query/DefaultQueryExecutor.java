package com.oracle.nosql.query;

import org.json.JSONObject;

import oracle.kv.Key;
import oracle.kv.Value;

import com.oracle.nosql.query.json.JSONResultPacker;
import com.paradox.nosql.query.Index;
import com.paradox.nosql.query.KVQueryContext;
import com.paradox.query.ResultPacker;
import com.paradox.query.impl.AbstractQueryExecutor;
import com.paradox.query.impl.Select;
import com.paradox.schema.UserType;

/**
 * Default execution selects the full extent for the candidate.
 *  
 * @author pinaki poddar
 *
 * @param <T>
 */
public class DefaultQueryExecutor extends AbstractQueryExecutor<Key,Value,JSONObject> {
	private long _timeout;
	public DefaultQueryExecutor(KVQueryContext<Key,Value,JSONObject> ctx) {
		super(ctx);
	}

	@Override
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

	@Override
	protected ResultPacker<JSONObject> newResultPacker(Select select, KVQueryContext<Key, Value, JSONObject> ctx) {
		return new JSONResultPacker();
	}

}
