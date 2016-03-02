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

package org.paradox.query.impl;

import java.util.LinkedList;

import org.paradox.query.Expression;
import org.paradox.query.exp.ExpressionVisitor;
import org.paradox.query.kv.ValueTransformer;

public abstract class AbstractPath<V> implements Expression.Path<V> {
	private final LinkedList<String> _fields = new LinkedList<String>();
	private String _alias;
	/**
	 * Separates the segments of a path.
	 */
	public static final char PATH_SEPARATOR = '.';
	

	public AbstractPath(String f) {
		_fields.add(f);
	}
	/**
	 * Gets the name of this field.
	 * 
	 * @see #getName()
	 */
	public final String getField() {
		return _fields.getLast();
	}
	
	/**
	 * Gets the full name of this path.
	 * The naming is important because {@link ValueTransformer#extractFieldValue(Object, String) value transformer} would
	 * use this path name to extract the value from a candidate instance.
	 */
	@Override
	public final String getName() {
		StringBuilder path = new StringBuilder(_fields.getFirst());
		for (int i = 1; i < _fields.size(); i++) {
			path.append(PATH_SEPARATOR).append(_fields.get(i));
		}
		return path.toString();
	}
	

	public String toString() {
		return getName();
	}
	
	@Override
	public final void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
	@Override
	public final Expression.Path<?> newPath(String next) {
		_fields.add(next);
		return this;
	}


	@Override
	public final boolean isAliased() {
		return _alias != null;
	}
	
	@Override
	public final String getAlias() {
		return _alias;
	}
	
	@Override
	public final void setAlias(String alias) {
		_alias = alias;
	}
}
