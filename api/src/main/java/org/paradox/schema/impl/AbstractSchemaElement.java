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

package org.paradox.schema.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.paradox.schema.SchemaElement;

/**
 * An abstract implementation of a generic {@link SchemaElement schema element}. 
 * 
 * 
 * @author pinaki poddar
 *
 * @param <T> type of its children
 */
abstract class AbstractSchemaElement<T extends SchemaElement<?>> implements SchemaElement<T>, Iterable<T> {
	private final String   _name;
	private final SchemaElement<?> _scope;
	private Map<String, T> _children;
	
	protected AbstractSchemaElement(SchemaElement<?> scope, String name) {
		_name  = name;
		_scope = scope;
	}
	
	@Override
	public final String getName() {
		return _name;
	}
	
	@Override
	public final SchemaElement<?> getScope() {
		return _scope;
	}
	
	@Override
	public final T getChild(String name) {
		return _children == null ? null : _children.get(name);
	}
	
	@Override
	public final boolean hasChild(String name) {
		return _children == null ? false : _children.containsKey(name);
	}
	
	@Override
	public final Iterator<T> iterator() {
		if (_children == null) return Collections.emptyIterator();
		return _children.values().iterator();
	}
	
	protected final Collection<T> getChildren() {
		if (_children == null) return Collections.emptySet();
		return _children.values();
	}
	
	/**
	 * Adds the given child.
	 * 
	 * @param child must be non-null, must have a non-null name, its defining scope must be the same as this receiver
	 * and no child of the same name must not exist in this receiver.
	 */
	protected final void addChild(T child) {
		if (child == null) 
			throw new IllegalArgumentException(this + " can not add null child");
		if (child.getName() == null) 
			throw new IllegalArgumentException(this + " can not add child with null name");
		if (child.getScope() != this) 
			throw new IllegalArgumentException(this + " can not add child " + child + " from a different scope " + child.getScope());
		if (_children != null && _children.containsKey(child.getName()))
			throw new IllegalStateException(this + " can not add child " + child + " because a child named " + child.getName() + " already exists");
		
		if (_children == null) {
			_children = new TreeMap<String, T>();
		}
		_children.put(child.getName(), child);
	}
}
