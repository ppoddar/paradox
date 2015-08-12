package com.oracle.nosql.query;

import java.util.Iterator;

import oracle.kv.Key;
import oracle.kv.Value;

import com.paradox.nosql.query.Index;
import com.paradox.nosql.query.KVQueryContext;
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
public class DefaultQueryExecutor<U> extends AbstractQueryExecutor<Key,Value,U> {
	
	public DefaultQueryExecutor(KVQueryContext<Key,Value,U> ctx) {
		super(ctx);
	}

	@Override
	protected Index<Value> selectIndex(Select select, KVQueryContext<Key, Value, U> ctx) {
		if (ctx.getSchema() == null)
			throw new IllegalStateException("No schema has been set of this conetxt");
		UserType type = ctx.getSchema().getUserType(select.getCandidate().getName());
		if (type == null) 
			throw new RuntimeException(select.getCandidate().getName() + "is not a known type to select");
		
		Key key   = (Key)ctx.getKeyMaker().makeTypeKey(type);
		return new FullScanIndex(key);
	}

}
