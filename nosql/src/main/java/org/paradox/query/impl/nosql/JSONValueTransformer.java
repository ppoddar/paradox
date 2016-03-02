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

package org.paradox.query.impl.nosql;

import oracle.kv.Value;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.paradox.query.ValueNotExistException;
import org.paradox.query.ValueTransformer;

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

