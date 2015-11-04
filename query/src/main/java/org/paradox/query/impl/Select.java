package org.paradox.query.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.paradox.query.Expression;

/**
 * A concrete structure that holds different components of a select query as {@link Expression expression nodes} e.g.
 * the {@link Projections projected terms}, conditional {@link #getPredicate() predicates},
 * {@link #orderBys() ordering terms} etc.
 * <br>
 * Commonly constructed by {@link SelectBuilder#compile() select builder}.
 * 
 * @author pinaki poddar
 *
 */
public class Select {
	private final String              _sql;
	private Expression.Candidate<?>   _root;
	private Expression.Predicate      _where;
	private List<Expression.Path<?>>  _projections;
	private List<Expression.Path<?>>  _groupByTerms;
	private List<Expression.Path<?>>  _orderByTerms;
	private Integer             _limit;
	private Integer             _skip;
	
	
	/**
	 * Creates a select which will be validated against the given schema. 
	 * 
	 * @param sql a select statement
	 * @param schema a schema for semantic validation. Can be null to disable validation.
	 */
	Select(String sql) {
		_sql = sql;
	}
		
	/**
	 * Gets the sql statement.
	 */
	public String getSQL() {
		return _sql;
	}
	
	void setCandidate(Expression.Candidate<?> root) {
		_root = root;
	}
	
	public Expression.Candidate<?> getCandidate() {
		return _root;
	}
	
	void setPredicate(Expression.Predicate where) {
		_where = where;
	}
	
	public Expression.Predicate getPredicate() {
		return _where;
	}
	
	void setLimit(Integer limit) {
		_limit = limit;
	}
	public int getLimit() {
		return _limit;
	}
	
	void setSkip(Integer skip) {
		_skip = skip;
	}
	public int getSkip() {
		return _skip;
	}
	
	void addOrderByTerm(Expression.Path<?> path) {
		if (_orderByTerms == null) {
			_orderByTerms = new ArrayList<Expression.Path<?>>();
		}
		_orderByTerms.add(path);
	}

	public Iterator<Expression.Path<?>> getOrderByTerms() {
		if (_orderByTerms == null) return Collections.emptyIterator();
		return  _orderByTerms.iterator();
	}
	public Iterator<Expression.Path<?>> getGroupByTerms() {
		if (_orderByTerms == null) return Collections.emptyIterator();
		return  _groupByTerms.iterator();
	}
	
	
	void addProjectionTerm(Expression.Path<?> term) {
		if (_projections == null) {
			_projections = new ArrayList<Expression.Path<?>>();
		}
		_projections.add(term);
	}
	
	
	void addGroupByTerm(Expression.Path<?> term) {
		if (_groupByTerms == null) {
			_groupByTerms = new ArrayList<Expression.Path<?>>();
		}
		_groupByTerms.add(term);
	}
	
	/**
	 * Gets the aggregate expressions.
	 * @return empty iterator if this projection does not have any aggregate term
	 */
	public Iterator<Expression.Path<?>> getProjectionTerms() {
		if (_projections == null) return Collections.emptyIterator();
		return  _projections.iterator();
	}
	
	
	public boolean hasOrdering() {
		return _orderByTerms != null && !_orderByTerms.isEmpty();
	}
	public boolean hasGrouping() {
		return _groupByTerms != null && !_groupByTerms.isEmpty();
	}
	public boolean hasAggregateTerms() {
		if (_projections == null) return false;
		for (Expression.Path<?> path : _projections) {
			if (path instanceof Expression.AggregatePath)
				return true;
		}
		return false;
	}
}
