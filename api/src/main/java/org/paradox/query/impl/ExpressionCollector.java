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

import java.util.ArrayList;
import java.util.List;

import org.paradox.query.Expression;
import org.paradox.query.exp.ExpressionVisitor;

/**
 * Visits expression tree to collect nodes of specific type.
 * 
 * @author pinaki poddar
 *
 * @param <X> type of expression node to collect
 */
public class ExpressionCollector<X extends Expression<?>> implements ExpressionVisitor {
	private final Class<X> _type;
	private List<X>  _collection = new ArrayList<X>();
	
	/**
	 * Creates a collector that will collect nodes of the given type.
	 * @param type
	 */
	public ExpressionCollector(Class<X> type) {
		_type = type;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void visit(Expression<?> expr) {
		if (_type.isInstance(expr)) {
			_collection.add((X)expr);
		}
	}
	
	/**
	 * Collect all the nodes starting from the given node that are of type
	 * supplied at construction.
	 * 
	 * @param expr the root node to start collecting 
	 * @return
	 */
	public List<X> collect(Expression<?> expr) {
		synchronized (_collection) {
			_collection.clear();
			expr.accept(this);
			return _collection;
		}
	}

}
