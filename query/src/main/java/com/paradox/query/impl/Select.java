package com.paradox.query.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.paradox.query.Expression;

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
	private boolean                   _hasCandidate;
	private List<Expression.Path<?>>  _paths;
	private Expression.Path<?>        _groupByTerm;
	private List<Expression.Aggregate<?>> _aggregates;
	private List<Expression.Path<?>>      _orderByTerms;
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
	
	void setRoot(Expression.Candidate<?> root) {
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
	
	public boolean hasLimit() {
		return _limit != null;
	}
	
	void setSkip(Integer skip) {
		_skip = skip;
	}
	public int getSkip() {
		return _skip;
	}
	
	public boolean hasSkip() {
		return _skip != null;
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
	
	
	/**
	 * Sets that this project will be using the candidate type only.
	 * Field path or aggregate can not be added.
	 * 
	 */
	public void setCandidateTerm() {
		if (_paths != null || _aggregates != null) {
			throw new IllegalStateException("Can not set candidate as either field path or aggregate is already used");
		}
		_hasCandidate = true;
	}
	
	void addFieldTerm(Expression.Path<?> term) {
		if (_hasCandidate || _aggregates != null) {
			throw new IllegalStateException("Can not add field path " + term + " as either candidate or aggregate is already used");
		}
		if (_paths == null) {
			_paths = new ArrayList<Expression.Path<?>>();
		}
		_paths.add(term);
	}
	
	void addAggregateTerm(Expression.Aggregate<?> aggregate) {
		if (_hasCandidate || _paths != null) {
			throw new IllegalStateException("Can not add aggregate " + aggregate + " as either candidate or field path is already used");
		}
		if (_aggregates == null) {
			_aggregates = new ArrayList<Expression.Aggregate<?>>();
		}
		_aggregates.add(aggregate);
	}
	
	void addGroupByTerm(Expression.Path<?> term) {
		_groupByTerm = term;
	}
	
	/**
	 * Gets the aggregate expressions.
	 * @return empty iterator if this projection does not have any aggregate term
	 */
	public Iterator<Expression.Path<?>> getFieldTerms() {
		if (_paths == null) return Collections.emptyIterator();
		return  _paths.iterator();
	}
	
	/**
	 * Gets the path expressions.
	 * @return empty iterator if this projection does not any have path expression
	 */
	public Iterator<Expression.Aggregate<?>> getAggregateTerms() {
		if (_aggregates == null) return Collections.emptyIterator();
		return  _aggregates.iterator();
	}
	
	public Expression.Path<?> getGroupByTerm() {
		return _groupByTerm;
	}
	
	/**
	 * Affirms if the projection is using aggregates.
	 */
	public boolean hasAggregates() {
		return _aggregates != null;
	}
	
	/**
	 * Affirms if the projection is using field paths.
	 */
	public boolean hasPaths() {
		return _paths != null;
	}
	
	/**
	 * Affirms if the projection is using candidate term i.e. {@code select * from .....}.
	 */
	public boolean hasCandidateTerm() {
		return _hasCandidate;
	}
	
	public boolean hasOrdering() {
		return _orderByTerms != null;
	}
	
	public boolean hasGrouping() {
		return _groupByTerm != null;
	}
}
