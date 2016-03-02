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

import java.util.Comparator;
import java.util.Iterator;

import org.paradox.query.Expression;
import org.paradox.query.QueryContext;

/**
 * A comparator to order query results.
 * 
 * @author pinaki poddar
 *
 * @param <T> the type of result rows to be compared
 */
public class OrderingComparator<T> implements Comparator<T> {
	private final QueryContext<?,?,?> _ctx;
	private final Select _select;
	
	public OrderingComparator(QueryContext<?,?,?> ctx, Select select) {
		_ctx = ctx;
		_select = select;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compare(Object o1, Object o2) {
		Iterator<Expression.Path<?>> terms = _select.getOrderByTerms();
		int result = 0;
		while (terms.hasNext()) {
			Expression.Path<?> term = terms.next();
			Object v1 = term.evaluate(o1, _ctx);
			Object v2 = term.evaluate(o2, _ctx);
			if (v1 instanceof Comparable && v2 instanceof Comparable) {
				result = ((Comparable)v1).compareTo(v2);
				if (result != 0) break;
			}
		}
		return result;
	}

}
