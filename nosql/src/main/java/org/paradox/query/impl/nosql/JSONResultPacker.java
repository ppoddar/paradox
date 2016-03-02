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

import oracle.kv.Key;
import oracle.kv.Value;

import org.json.JSONObject;
import org.paradox.query.QueryContext;
import org.paradox.query.ResultPacker;
import org.paradox.query.impl.AbstractResultPacker;
import org.paradox.query.impl.Select;

/**
 * Packs query result in a JSON object.
 * 
 * @author pinaki poddar
 *
 */
public class JSONResultPacker extends AbstractResultPacker<JSONObject> implements ResultPacker<JSONObject> {

	public JSONResultPacker(Select select, QueryContext<Key, Value, JSONObject> ctx) {
		setContext(select, ctx);
	}
	
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
