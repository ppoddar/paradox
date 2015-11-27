package org.paradox.nosql.query;

import oracle.kv.Value;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.paradox.query.kv.ValueNotExistException;
import org.paradox.query.kv.ValueTransformer;

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

	/**
	 * Extracts value for the given path.
	 * 
	 * @return null if path exists but value is null or JSONObjet.NULL
	 * @exception if path does not exist
	 */
	@Override
	public Object extractFieldValue(JSONObject candidate, String path) {
		int dot = path.indexOf('.');
		if (dot == -1) {
			Object value = candidate.opt(path);
			if (!candidate.has(path)) throw new ValueNotExistException(path);
			return value == null || value == JSONObject.NULL ? null : value;
		} else {
			String segment = path.substring(0, dot);
			if (!candidate.has(segment)) throw new ValueNotExistException(segment,path);
			Object next = candidate.opt(segment);
			if (next instanceof JSONObject) {
				return extractFieldValue((JSONObject)next, path.substring(dot+1));
			} else {
				throw new RuntimeException("Can not extract " + path);
			}
		}
	}
}

