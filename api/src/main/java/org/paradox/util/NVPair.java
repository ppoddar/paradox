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

package org.paradox.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NVPair implements Map<String, Object>{
	private final Map<String, Object> _delegate = new HashMap<String, Object>();
	
	/**
	 * Creates a map from given name-value pairs.
	 * 
	 * @param nvPairs name-value pairs must have even numbered elements. 
	 * The element at even index is the 'name' and corresponding (next) element at odd index
	 * is the value.
	 */
	public NVPair(Object...nvPairs) {
		if (nvPairs == null || nvPairs.length == 0) return;
		if (nvPairs.length%2 != 0) throw new IllegalArgumentException("Invalid number (" + nvPairs.length + ") " +
				"of name-value parameters. Name-value pairs must be specified in pair");
		for (int i = 0; i < nvPairs.length; i++) {
			_delegate.put(nvPairs[i].toString(), nvPairs[++i]);
		}
	}
	
	@Override
	public int size() {
		return _delegate.size();
	}

	@Override
	public boolean isEmpty() {
		return _delegate.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return _delegate.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _delegate.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		return _delegate.get(key);
	}

	@Override
	public Object put(String key, Object value) {
		return _delegate.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return _delegate.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		_delegate.putAll(m);
	}

	@Override
	public void clear() {
		_delegate.clear();
	}

	@Override
	public Set<String> keySet() {
		return _delegate.keySet();
	}

	@Override
	public Collection<Object> values() {
		return _delegate.values();
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return _delegate.entrySet();
	}

}
