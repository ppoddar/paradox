package org.paradox.query.impl;

import org.paradox.query.Expression;
import org.paradox.query.ExpressionFactory;
import org.paradox.query.Expression.Candidate;
import org.paradox.query.Expression.Path;
import org.paradox.query.Expression.Predicate;
import org.paradox.query.Expression.Value;
import org.paradox.query.exp.Expressions;


/**
 * Abstract factory for query expressions generates concrete implementation for a subset of  query expressions that 
 * can be evaluated independent of the candidate type. 
 * <br>
 * The path expressions, on the other hand, require concrete candidate type to be evaluated, 
 * This factory is agnostic about the representation type of value data of the candidates and hence does not 
 * generate the path expressions. A concrete derivation must provide the abstract methods.
 * 
 * 
 * @author pinaki poddar
 *
 */
public class QueryExpressionFactory implements ExpressionFactory {


	@Override
	public Expression.Predicate newIsNull(Expression.Path< ?> path) {
		return new Expressions.IsNull(path);
	}

	@Override
	public Expression.Predicate  newNot(Expression.Predicate predicate) {
		return new Expressions.Not(predicate);
	}

	@Override
	public Expression.Predicate newAnd(Expression.Predicate lhs, Expression.Predicate rhs) {
		return new Expressions.And(lhs, rhs);
	}

	@Override
	public Predicate newOr(Predicate lhs, Predicate rhs) {
		return new Expressions.Or(lhs, rhs);
	}

	@Override
	public Predicate newGreater(Path<?>  path, Value<Number> value) {
		return new Expressions.Greater(path, value);
	}

	@Override
	public Predicate newGreaterOrEqual(Path<?>  lhs, Value<Number> rhs) {
		return new Expressions.GreaterOrEqual(lhs, rhs);
	}

	@Override
	public Predicate newLess(Path<?>  lhs, Value<Number> rhs) {
		return new Expressions.Less(lhs, rhs);
	}

	@Override
	public Predicate newLessOrEqual(Path<?>  lhs, Value<Number> rhs) {
		return new Expressions.LessOrEqual(lhs, rhs);
	}

	@Override
	public Predicate newEqual(Path<?>  lhs, Value<?> rhs) {
		return new Expressions.Equals(lhs, rhs);
	}
	
	@Override
	public Predicate newEqualIgnoreCase(Path<?>  lhs, Value<?> rhs) {
		return new Expressions.Equals(lhs, rhs, true);
	}

	@Override
	public Predicate newLike(Path<?>  lhs, Value<String> rhs) {
		return new Expressions.Like(lhs, rhs);
	}

	@Override
	public Expression.Count newCount(Path<?>  path) {
		return new Expressions.Count(path);
	}

	@Override
	public Expression.Max newMax(Path<?>  path) {
		return new Expressions.Max(path);
	}

	@Override
	public Expression.Min newMin(Path<?>  path) {
		return new Expressions.Min(path);
	}

	@Override
	public Expression.Avg newAvg(Path<?>  path) {
		return new Expressions.Avg(path);
	}

	@Override
	public Expression.Sum newSum(Path<?>  path) {
		return new Expressions.Sum(path);
	}

	@Override
	public Expression.BindParameter newBindParameter(String param) {
		return new Expressions.BindParameter(param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> Expression.Value<V> newConstant(V v) {
		if (v instanceof String) {
			return (Expression.Value<V>)new Expressions.StringValue((String)v);
		} else if (v instanceof Integer) {
			return (Expression.Value<V>)new Expressions.IntegerValue((Integer)v);
		} else if (v instanceof Number) {
			return (Expression.Value<V>)new Expressions.DecimalValue(((Number)v));
		} else {
			throw new IllegalArgumentException("No constant expression for " + v);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Path<?> newPath(String field) {
		return new FieldPath(field);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Candidate<?> newCandidate(String root) {
		return new CandidatePath(root);
	}
}
