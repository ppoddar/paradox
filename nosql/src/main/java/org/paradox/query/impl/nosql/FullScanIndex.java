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

import java.util.Iterator;

import org.paradox.query.Index;
import org.paradox.query.QueryContext;
import org.paradox.schema.UserType;
import org.paradox.util.Transformer;
import org.paradox.util.TransforminIterator;

import oracle.kv.Key;
import oracle.kv.Value;

/**
 * A full scan index gets the entire extent of a type.
 * 
 * @author pinaki poddar
 *
 */
public class FullScanIndex implements Index<Value> {
	private final Key _parentKey;
	
	/**
	 * Supply the key whose descendants are the entire extent of a 
	 * {@link UserType user-defined type}.
	 * @param key a key with partial major path as it represents an 
	 * extent of a type. Must not be null.
	 */
	public FullScanIndex(Key key) {
		if (key == null)
			throw new IllegalArgumentException("FullScanIndex must have non-null key");
		_parentKey = key;
	}
	
	@Override
	public Iterator<Value> fetch(QueryContext<?,?,?> ctx) {
		final DefaultQueryContext kvctx = (DefaultQueryContext)ctx;
		Transformer<Key, Value> transformer = new Transformer<Key, Value>(){
			public Value transform(Key k) {
				return kvctx.getStore().get(k).getValue();
			}
		};
		return 
		new TransforminIterator<Key,Value>(kvctx.getExtent(_parentKey), transformer);
	}

}
