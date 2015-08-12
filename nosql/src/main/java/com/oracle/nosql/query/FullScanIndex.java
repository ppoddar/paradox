package com.oracle.nosql.query;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.paradox.nosql.query.Index;
import com.paradox.query.QueryContext;
import com.paradox.schema.UserType;
import com.paradox.util.Transformer;
import com.paradox.util.TransforminIterator;

import oracle.kv.Depth;
import oracle.kv.Direction;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.Value;

/**
 * A full scan index gets the entire extent of a type.
 * 
 * @author pinaki poddar
 *
 */
public class FullScanIndex implements Index<Value> {
	private final Key _parentKey;
	
	/**
	 * Supply the key whose descendants are the entire extent of a {@link UserType user-defined type}.
	 * @param key a key with partial major path as it represents an extent of a type
	 */
	public FullScanIndex(Key key) {
		_parentKey = key;
	}
	
	@Override
	public Iterator<Value> fetch(QueryContext<?,Value,?> ctx) {
		Transformer<KeyValueVersion, Value> transformer = new Transformer<KeyValueVersion, Value>(){
			public Value transform(KeyValueVersion kvv) {
				return kvv.getValue();
			}
		};
		
		
		DefaultQueryContext<?> kvctx = (DefaultQueryContext<?>)ctx;
		
		// Note: storeIterator is used instead of multiGetIterator
		// as the parent key has partial major path
		Iterator<KeyValueVersion> base = kvctx.getStore().storeIterator(
				Direction.UNORDERED, // currently only supports unordered fetch
				0,                   // the store will decide
				_parentKey, 
				null, // key range
				Depth.DESCENDANTS_ONLY,
				kvctx.getConsistency(),
				ctx.getQueryTimeout(),
				TimeUnit.MILLISECONDS);
		return new TransforminIterator<KeyValueVersion, Value>(base, transformer);
	}

}
