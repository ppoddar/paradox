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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.paradox.query.KeyMaker;
import org.paradox.schema.Attribute;
import org.paradox.schema.Schema;
import org.paradox.schema.UserType;

import oracle.kv.Key;

/**
 * This default implementation generates a {@link Key key} for Oracle NoSQL key-value store assuming that the user 
 * has described the values via a {@link Schema}.
 * 
 * @author pinaki poddar
 *
 */
public class DefaultKeyMaker implements KeyMaker<Key> {

	/**
	 * Builds a key with the {@link UserType#getIdAttributes() identifier attributes} of the given user-defined type.
	 * The major path of the key is formed by the values of each identifier attribute in the same order as they
	 * have been declared in the schema.
	 * <p>
	 * This implementation creates the key as {@code name/id0/id1/id2} where {@code name} is name of the given 
	 * user-defined type and {@code id<n>} is the value of the attribute at the n-th index of the 
	 * {@link UserType#getIdAttributes() identifier attributes list}. 
	 * 
	 * 
	 * @param type a user-defined type
	 * @param pkValues values of {@link UserType#getIdAttributes() identifier attributes} indexed by attribute name. 
	 * Not all identifier attribute may be present.
	 * 
	 * 
	 * @throws IllegalArgumentException if the given user-defined type is null or is 
	 * not {@link UserType#isIdentifiable() identifiable}
	 */
	@Override
	public Key makeInstanceKey(UserType type, Map<String,?> pkValues) {
		if (type == null) throw new IllegalArgumentException("Can not generate key for null User type");
//		if (!type.isIdentifiable()) throw new IllegalArgumentException("Can not generate key for non-identifiable type [" 
//				+ type.getName() + "]");
		
		List<Attribute> idAttrs = type.getIdAttributes();
		List<String> majorPath = new ArrayList<String>();
		majorPath.add(type.getName());
		if (pkValues == null)
			return Key.createKey(majorPath);
		
		for (Attribute id : idAttrs) {
			if (pkValues.containsKey(id.getName())) {
				majorPath.add(pkValues.get(id.getName()).toString());
			} else {
				break;
			}
		}
		return Key.createKey(majorPath);
	}

	@Override
	public Key makeTypeKey(UserType type) {
		return makeInstanceKey(type, null);
	}

	@Override
	public boolean isTypeKeyComplete(UserType type) {
		return false;
	}

	@Override
	public Key makeTypeKey(String typeName) {
		return Key.createKey(typeName);
	}

}
