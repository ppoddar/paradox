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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.paradox.query.Expression;
import org.paradox.query.QueryContext;
import org.paradox.query.ResultPacker;
import org.paradox.util.ChainedIterator;

/**
 * An abstract algorithm packs the result ordering if specified by the select.
 *  
 * @author pinaki poddar
 *
 * @param <T>
 */
public abstract class AbstractResultPacker<T> implements ResultPacker<T> {
	private Select _select;
	private QueryContext<?,?,T> _ctx;
	private Map<Object,Set<T>> selected;
	private OrderingComparator<T> _orderByComparator;
	private static final Object DUMMY_GROUP = new Object();
	
	/**
	 * Sets the context before use.
	 * @param select
	 * @param ctx
	 */
	public void setContext(Select select, QueryContext<?,?,T> ctx) {
		_select = select;
		_ctx = ctx;
		selected = new HashMap<Object,Set<T>>();
		if (_select.hasOrdering()) {
			_orderByComparator = new OrderingComparator<T>(_ctx, _select);
		} 
		if (!_select.hasGrouping()) {
			selected.put(DUMMY_GROUP, _select.hasOrdering() ? new TreeSet<T>(_orderByComparator) : new HashSet<T>());
		}
		
	}
	@Override
	public void pack(T c) {
		Set<T> group = decideGroup(c);
			Iterator<Expression.Path<?>> terms = _select.getProjectionTerms();
			T single = newResult();
			while (terms.hasNext()) {
				Expression.Path<?> term = terms.next();
				if (!(term instanceof Expression.AggregatePath)) continue;
				Object val = term.evaluate(c, _ctx);
				try {
					
					put(single, term.getName(), val);
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}
			group.add(single);
		
	}
	
	@Override
	public Iterator<T> getResultList() {
		if (_select.hasGrouping()) {
			List<Iterator<T>> childIterators = new ArrayList<Iterator<T>>();
			for (Map.Entry<Object, Set<T>> entry : selected.entrySet()) {
				childIterators.add(createIterator(entry.getValue()));
			}
			return new ChainedIterator<T>(childIterators);
		} else {
			return createIterator(selected.get(DUMMY_GROUP));
		}
	}
	
	Iterator<T> createIterator(Set<T> candidateGroup) {
		if (_select.hasAggregateTerms()) {
			return Collections.singletonList(computeAggregate(candidateGroup)).iterator();
		} else {
			return candidateGroup.iterator();
		} 
	}
	
	private Set<T> decideGroup(Object c) {
		Object groupKey = DUMMY_GROUP;
		if (_select.getGroupByTerms().hasNext()) {
			 _select.getGroupByTerms().next().evaluate(c, _ctx);
		}
		Set<T> group = selected.get(groupKey);
		if (group == null) {
			if (_select.getOrderByTerms().hasNext()) {
			   group = new TreeSet<T>(_orderByComparator);
			} else {
				group = new HashSet<T>();
			}
			selected.put(groupKey, group);
		}
		return group;
	}
	
	private T computeAggregate(Set<T> candidateSet) {
		T single = newResult();
		Iterator<Expression.Path<?>> terms = _select.getProjectionTerms();
		while (terms.hasNext()) {
			Expression.Path<?> term = terms.next();
			if (!(term instanceof Expression.AggregatePath)) continue;
			
			Object val = term.evaluate(candidateSet, _ctx);
			try {
				put(single, term.getAlias(), val);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		return single;
	}

	/**
	 * Create a new row to be packed as result.
	 * @return a new empty row to be populated.
	 */
	protected abstract T newResult();
	
	/**
	 * Populates the given row for the given property with the given value. 
	 * @param row a row of result to be populated
	 * @param field a field/property of the row
	 * @param val the value for that row element
	 * @throws Exception in case anything goes wrong
	 */
	protected abstract void put(Object row, String field, Object val) throws Exception;
}
