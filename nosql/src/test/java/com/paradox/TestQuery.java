/**

      Copyright ©2016. Author Pinaki Poddar. All Rights Reserved. 

	Permission to use, copy, modify, and distribute this software and its documentation 
	for educational, research, and not-for-profit purposes, without fee and without a 
	signed licensing agreement, is hereby granted, provided that the above copyright notice, 
	this paragraph and the following two paragraphs appear in all copies, modifications, 
	and distributions. 


	IN NO EVENT SHALL THE AUTHOR BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, 
	OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE 
	AND ITS DOCUMENTATION, EVEN IF THE AUTHOR HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

	THE AUTHOR SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE AND 
	ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED HEREUNDER IS PROVIDED "AS IS". THE AUTHOR HAS 
	NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

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
import org.paradox.query.QueryContext;
import org.paradox.query.impl.nosql.QueryContextBuilder;

/**
 * Queries hand-crafted data to validate predicate-based query results.
 * The test only run if a NoSQl database has started before this test.
 * Otherwise, all test are effectively ignore.
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
		KVStoreConfig config = new KVStoreConfig(storeName, hostPort);
		
		try {
			_store = KVStoreFactory.getStore(config);
		} catch (Exception ex) {
			System.err.println("***ERROR: Opening store " + config);
			System.err.println("***WARNING: All tests will be skkiped");
			return;
		}
		_ctx = new QueryContextBuilder(_store).build();
		
		deleteAll(_store, _type);
		populate(_store, _type, _dataSize);
	}

	@Test
	public void testCount() throws Exception {
		if (_store == null) return;
		String sql = "select * from Person";
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(_dataSize, count(result));
	}
	
	@Test
	public void testExists() throws Exception {
		assertQueryResultByResultCount("select * from Person where exists address", _dataSize/2);
	}
	
	@Test
	public void testLessThan() throws Exception {
		assertQueryResultByResultCount("select * from Person where age < 42", 0);
	}
	
	@Test
	public void testLessThanEqual() throws Exception {
		assertQueryResultByResultCount("select * from Person where age <= 42", 1);
	}
	
	@Test
	public void testGreaterThan() throws Exception {
		assertQueryResultByResultCount("select * from Person where age > 42", _dataSize-1);
	}
	@Test
	public void testGreaterThanEqual() throws Exception {
		assertQueryResultByResultCount("select * from Person where age >= 42", _dataSize);
	}
	
	@Test
	public void testEquals() throws Exception {
		assertQueryResultByResultCount("select * from Person where age = 46", 1);
	}
	
	@Test
	public void testNotEquals() throws Exception {
		assertQueryResultByResultCount("select * from Person where age != 46", _dataSize-1);
	}
	
	@Test
	public void testEqualsIgnoreCase() throws Exception {
		assertQueryResultByResultCount("select * from Person where name ~= 'person-4'", 1);
	}	
	
	@Test
	public void testLike() throws Exception {
		assertQueryResultByResultCount("select * from Person where name LIKE 'Person-[1-5]'", 5);
	}
	
	@Test
	public void testIsNull() throws Exception {
		assertQueryResultByResultCount("select * from Person where ISNULL gender", 2);
	}
	@Test
	public void testIsNotNull() throws Exception {
		assertQueryResultByResultCount("select * from Person where NOT(ISNULL gender)", _dataSize - 2);
	}
	@Test
	public void testAnd() throws Exception {
		assertQueryResultByResultCount("select * from Person where age = 44 and gender='MALE'", 1);
	}
	
	@Test
	public void testJSONNull() {
		JSONObject json = new JSONObject();
		json.put("a", (Object)null);
		json.put("b", JSONObject.NULL);
		Assert.assertFalse(json.has("a"));
		Assert.assertTrue(json.has("b"));
		Assert.assertNull(json.opt("a"));
		Assert.assertSame(JSONObject.NULL, json.opt("b"));
	}
	
	void assertQueryResultByResultCount(String sql, int expectedResultCount) throws Exception {
		if (_store == null) return;
		Iterator<JSONObject> result = _ctx.executeQuery(sql);
		Assert.assertEquals(expectedResultCount, count(result));
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
		int n = count(keys);
		return n;
	}
	static int deleteAll(KVStore store, String type) {
		Key key = Key.createKey(type);
		Iterator<Key> keys = _ctx.getExtent(key);
		int n = 0;
		while (keys.hasNext()) {
			n++; 
			store.delete(keys.next());
		}
		return n;
	}
	
	/**
	 * Populates hand-crafted Person-Address data.
	 * @param store
	 * @param type
	 * @param N
	 */
	static void populate(KVStore store, String type, int N) {
		for (int i = 0; i < N; i++) {
			Key key = Key.createKey(type, ""+i);
			JSONObject person = new JSONObject();
			JSONObject address = new JSONObject();
			person.put("name", type + "-" + i);
			person.put("age", 42+i);
			person.put("gender", i % 2 == 0 ? "MALE" : "FEMALE");
			if (i == 0 || i == N-1) person.put("gender", JSONObject.NULL);
			
			if (i%2 == 0) person.put("address", address);
			address.put("city", "City-" + i);
			if (i == 0 || i == N-1) address.put("city", JSONObject.NULL);
			
			store.put(key, Value.createValue(person.toString().getBytes()));
		}
	}

}
