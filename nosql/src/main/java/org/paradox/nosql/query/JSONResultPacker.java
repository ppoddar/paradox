package org.paradox.nosql.query;

import org.json.JSONObject;
import org.paradox.query.ResultPacker;
import org.paradox.query.impl.AbstractResultPacker;

/**
 * Packs query result in a JSON object.
 * 
 * @author pinaki poddar
 *
 */
public class JSONResultPacker extends AbstractResultPacker<JSONObject> implements ResultPacker<JSONObject> {

	@Override
	protected JSONObject newResult() {
		return new JSONObject();
	}

	@Override
	protected void put(Object obj, String field, Object value) throws Exception {
		JSONObject row = (JSONObject)obj;
		int dot = field.indexOf('.');
		if (dot == -1) {
			row.put(field, value);
		} else {
			String attr = field.substring(0, dot);
			Object reference = row.opt(attr);
			if (reference == null) {
				reference = new JSONObject();
				row.put(attr, reference);
				put((JSONObject)reference, field.substring(dot+1), value);
			} else if (reference instanceof JSONObject) {
				put((JSONObject)reference, field.substring(dot+1), value);
			} else {
				throw new RuntimeException("Can not populate " + field);
			}
			
		}
	}
}
