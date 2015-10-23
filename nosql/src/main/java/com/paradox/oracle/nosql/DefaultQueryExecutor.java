package com.paradox.oracle.nosql;

import org.json.JSONObject;

import oracle.kv.Key;
import oracle.kv.Value;

import com.paradox.nosql.query.Index;
import com.paradox.nosql.query.KVQueryContext;
import com.paradox.oracle.nosql.json.JSONResultPacker;
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
		UserType type = null;
		if (ctx.getSchema() != null) {
			type = ctx.getSchema().getUserType(select.getCandidate().getName());
		}
		Key key = null;
		if (type != null) {
			key   = (Key)ctx.getKeyMaker().makeTypeKey(type);
		}
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
		JSONResultPacker packer = new JSONResultPacker();
		packer.setContext(select, ctx);
		return packer;
	}

}
