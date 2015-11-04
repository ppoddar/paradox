package com.paradox;

import java.util.Iterator;

import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.Value;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.paradox.nosql.query.QueryContextBuilder;
import org.paradox.query.QueryContext;

/**
 * Queries hand-crafted data to validate predicate-based query results.
 *  
 * @author pinaki poddar
 *
 */
public class TestQuery {
	private static KVStore _store;
	private static QueryContext<Key, Value, JSONObject> _ctx;
	private static String _type = "Person";
	private static int _dataSize = 10;
	
	@BeforeClass
	public static void init() throws Exception {
		String storeName = System.getProperty("store", "kvstore");
		String hostPort   = System.getProperty("hostPort", "localhost:5000");
		System.err.println("Connecting to " + storeName + " at " + hostPort);
		KVStoreConfig config = new KVStoreConfig(storeName, hostPort);
		
		_store = KVStoreFactory.getStore(config);
		_ctx = new QueryContextBuilder(_store).build();
		
		if (count(_store, _type) > 0) {
			deleteAll(_store, _type);
		}
		populate(_store, _type, _dataSize);
	}

	@Test
	public void testCountQuery() throws Exception {
		String sql = "select * from Person";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(_dataSize, count(result));
	}
	
	@Test
	public void testExists() throws Exception {
		String sql = "select * from Person p where exists p.address";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(_dataSize/2, count(result));
	}
	
	@Test
	public void testLessThan() throws Exception {
		String sql = "select * from Person p where p.age < 42";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(0, count(result));
	}
	
	@Test
	public void testGreaterThan() throws Exception {
		String sql = "select * from Person p where p.age > 42";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(_dataSize-1, count(result));
	}
	
	@Test
	public void testEquals() throws Exception {
		String sql = "select * from Person p where p.age = 46";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(1, count(result));
	}
	
	@Test
	public void testNotEquals() throws Exception {
		String sql = "select * from Person p where p.age != 46";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(_dataSize-1, count(result));
	}
	
	static int count(Iterator<?> iterator) {
		int n = 0;
		while (iterator.hasNext()) {
			n++;
			iterator.next();
		}
		return n;
	}
	static int count(KVStore store, String type) {
		Key key = Key.createKey(type);
		Iterator<Key> keys = _ctx.getExtent(key);
		return count(keys);
	}
	static int deleteAll(KVStore store, String type) {
		System.err.println("deleteAll records of " + type);
		Key key = Key.createKey(type);
		Iterator<Key> keys = _ctx.getExtent(key);
		int n = 0;
		while (keys.hasNext()) {
			n++; 
			store.delete(keys.next());
		}
		System.err.println("deleted " + n + " records");
		return n;
	}
	
	/**
	 * Populates hand-crafted Person-Address data.
	 * @param store
	 * @param type
	 * @param N
	 */
	static void populate(KVStore store, String type, int N) {
		System.err.println("populate " + N + " records of " + type);
		for (int i = 0; i < N; i++) {
			Key key = Key.createKey(type, ""+i);
			JSONObject person = new JSONObject();
			JSONObject address = new JSONObject();
			person.put("name", type + "-" + i);
			person.put("age", 42+i);
			if (i%2 == 0) person.put("address", address);
			address.put("city", "City-" + i);
			System.err.println("Put " + key);
			store.put(key, Value.createValue(person.toString().getBytes()));
		}
	}

}