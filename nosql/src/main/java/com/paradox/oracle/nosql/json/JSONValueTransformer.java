package com.paradox.oracle.nosql.json;

import oracle.kv.Value;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.paradox.nosql.query.ValueTransformer;

/**
 * Converts between {@link JSONObject} and Oracle NoSQL {@link Value}.
 *  
 * @author pinaki poddar
 *
 */
public class JSONValueTransformer implements ValueTransformer<Value,JSONObject> {

	@Override
	public Value encode(JSONObject json) {
		if (json == null)
			return null;
		return Value.createValue(json.toString().getBytes());
	}

	@Override
	public JSONObject decode(Value v) {
		if (v == null) 
			return null;
		try {
			return new JSONObject(new JSONTokener(new String(v.getValue())));
		} catch (JSONException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Object extractFieldValue(JSONObject candidate, String path) {
		JSONObject json = (JSONObject)candidate;
		int dot = path.indexOf('.');
		if (dot == -1) {
			return json.opt(path);
		} else {
			Object next = json.opt(path.substring(0, dot));
			if (next instanceof JSONObject) {
				return extractFieldValue((JSONObject)next, path.substring(dot+1));
			} else {
				throw new RuntimeException("Can not extract " + path);
			}
		}
	}
}

