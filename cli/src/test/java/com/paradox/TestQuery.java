package com.paradox;

import java.util.Iterator;

import oracle.kv.Depth;
import oracle.kv.Direction;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.Value;

import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.paradox.nosql.query.DefaultQueryContext;
import org.paradox.nosql.query.QueryContextBuilder;
import org.paradox.query.QueryContext;

public class TestQuery {
	private static KVStore _store;
	private static QueryContext<Key, Value, JSONObject> _ctx;
	private static String _type = "Person";
	private static int _dataSize = 10;
	
	@BeforeClass
	public static void init() throws Exception {
		KVStoreConfig config = new KVStoreConfig("kvstore", "localhost:5000");
		_store = KVStoreFactory.getStore(config);
		
		_ctx = new QueryContextBuilder(_store).build();
		
		if (count(_store, _type) <= 0) {
			populate(_store, _type, _dataSize);
		} else {
			deleteAll(_store, _type);
		}
		
	}

	@Test
	public void testQuery() throws Exception {
		String sql = "select * from Person";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		int n = 0;
		while (result.hasNext()) {
			n++;
			System.err.println(result.next());
		}
		System.err.println(""+ n + " results");
	}

	static int count(KVStore store, String type) {
		Key key = Key.createKey(type);
		Iterator<Key> keys = 
		_store.multiGetKeysIterator(Direction.UNORDERED, 0, key, null, Depth.PARENT_AND_DESCENDANTS);
		int n = 0;
		while (keys.hasNext()) {
			n++; keys.next();
		}
		return n;
	}
	static int deleteAll(KVStore store, String type) {
		Key key = Key.createKey(type);
		Iterator<Key> keys = 
		_store.multiGetKeysIterator(Direction.UNORDERED, 0, key, null, Depth.PARENT_AND_DESCENDANTS);
		int n = 0;
		while (keys.hasNext()) {
			n++; 
			store.delete(keys.next());
		}
		return n;
	}
	
	static void populate(KVStore store, String type, int N) {
		for (int i = 0; i < N; i++) {
		Key key = Key.createKey(type);
		JSONObject person = new JSONObject();
		JSONObject address = new JSONObject();
		person.put("name", type + "-" + i);
		person.put("age", 42+i);
		if (i%2 == 0) person.put("address", address);
		address.put("city", "City-" + i);
		store.put(key, Value.createValue(person.toString().getBytes()));
		
	}

}
