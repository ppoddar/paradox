package org.paradox.command;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oracle.kv.Direction;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.Value;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.paradox.nosql.query.DefaultQueryContext;
import org.paradox.schema.Attribute;
import org.paradox.schema.UserType;

<<<<<<< HEAD:cli/src/main/java/org/paradox/command/DataLoader.java
import com.paradox.query.kv.KeyMaker;
import com.paradox.query.kv.ValueTransformer;
=======
import com.paradox.nosql.query.KeyMaker;
import com.paradox.nosql.query.ValueTransformer;
import com.paradox.oracle.nosql.DefaultQueryContext;
import com.paradox.schema.Attribute;
import com.paradox.schema.UserType;
>>>>>>> ae9bf706ecaa26c0cf77a79a3b34b2fd988c26bc:nosql/src/main/java/com/oracle/paradox/DataLoader.java

/**
 * Loads data from a file to a NoSQL data store.
 * <p>
 * The file reader ignores empty line or any line starting with {@code '#'} character as first non-whitespace character.
 * <br>
 * Each other line is parsed as a JSON object.  
 *  
 * @author pinaki poddar
 *
 */
public class DataLoader {

	/**
	 * Loads the data read from the given file to the given data store.
	 * @param ctx a Oracle NoSQL Key-Value store.
	 * @param type type name
	 * @param reader each line contains a JSON format data. 
	 */
	public static int loadData(DefaultQueryContext ctx, String type, BufferedReader reader) throws Exception {
		UserType personType = ctx.getSchema().getUserType(type);
		List<Attribute> identifiers = personType.getIdAttributes();
		KeyMaker<Key> keyMaker = ctx.getKeyMaker();
		ValueTransformer<Value,JSONObject> valueTransformer = ctx.getValueTransformer();
		KVStore store = ctx.getStore();
		Map<String, Object> pkValues = new HashMap<String, Object>();
		String line = null;
		int count = 0;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.startsWith("#")) continue;
			if (line.length() == 0) continue;
			JSONObject person = new JSONObject(new JSONTokener(line));
			for (Attribute id : identifiers) {
				pkValues.put(id.getName(), person.get(id.getName()));
			}
			Key key = keyMaker.makeInstanceKey(personType, pkValues);
			Value value = valueTransformer.encode(person);
		
			store.put(key, value);
			count++;
		}
		reader.close();
		return count;
	}
	
	/**
	 * Deletes all key-value pairs of the given datastore.
	 */
	public static int deleteAll(DefaultQueryContext ctx) {
		KVStore store = ctx.getStore();
		Iterator<KeyValueVersion> allPairs = store.storeIterator(Direction.UNORDERED, 0);
		int count = 0;
		while (allPairs.hasNext()) {
			store.delete(allPairs.next().getKey());
			count++;
		}
		return count;
	}
}
