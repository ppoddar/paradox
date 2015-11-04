package org.paradox.nosql.query;

import java.util.Iterator;

import org.paradox.query.Index;
import org.paradox.query.QueryContext;
import org.paradox.schema.UserType;
import org.paradox.util.Transformer;
import org.paradox.util.TransforminIterator;

import oracle.kv.Key;
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
	 * Supply the key whose descendants are the entire extent of a 
	 * {@link UserType user-defined type}.
	 * @param key a key with partial major path as it represents an 
	 * extent of a type. Must not be null.
	 */
	public FullScanIndex(Key key) {
		if (key == null)
			throw new IllegalArgumentException("FullScanIndex must have non-null key");
		_parentKey = key;
	}
	
	@Override
	public Iterator<Value> fetch(QueryContext<?,?,?> ctx) {
		final DefaultQueryContext kvctx = (DefaultQueryContext)ctx;
		Transformer<Key, Value> transformer = new Transformer<Key, Value>(){
			public Value transform(Key k) {
				return kvctx.getStore().get(k).getValue();
			}
		};
		return 
		new TransforminIterator<Key,Value>(kvctx.getExtent(_parentKey), transformer);
	}

}
