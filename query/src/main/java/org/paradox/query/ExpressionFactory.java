package org.paradox.query;

/**
 * A factory for query expressions.
 * 
 * @author pinaki poddar
 *
 */
public interface ExpressionFactory {
	/**
	 * Creates a path expression from the given attribute name.
	 */
	Expression.Path<?> newPath(String field);
	
	/**
	 * Creates a candidate expression from the given type name.
	 */
	Expression.Candidate<?> newCandidate(String root);
	
	/**
	 * Creates a predicate expression to evaluate the given path for nullity.
	 */
	Expression.Predicate newIsNull(Expression.Path<?> path);
	
	/**
	 * Creates a predicate expression to negate the given predicate.
	 */
	Expression.Predicate newNot(Expression.Predicate predicate);
	
	/**
	 * Creates a predicate expression as a disjunction of the given pair of predicates.
	 */
	Expression.Predicate newAnd(Expression.Predicate lhs, Expression.Predicate rhs);

	/**
	 * Creates a predicate expression as a conjunction of the given pair of predicates.
	 */
	Expression.Predicate newOr(Expression.Predicate lhs, Expression.Predicate rhs);

	/**
	 * Creates a predicate expression to evaluate if the given path is greater than the given value.
	 */
	Expression.Predicate newGreater(Expression.Path<?> lhs, Expression.Value<Number> rhs);

	/**
	 * Creates a predicate expression to evaluate if the given path is greater or equal to the given value.
	 */
	Expression.Predicate newGreaterOrEqual(Expression.Path<?> lhs, Expression.Value<Number> rhs);

	/**
	 * Creates a predicate expression to evaluate if the given path is less than the given value.
	 */
	Expression.Predicate newLess(Expression.Path<?> lhs, Expression.Value<Number> rhs);

	/**
	 * Creates a predicate expression to evaluate if the given path is less or equal to the given value.
	 */
	Expression.Predicate newLessOrEqual(Expression.Path<?> lhs, Expression.Value<Number> rhs);

	/**
	 * Creates a predicate expression to evaluate if the given path is equal to the given value.
	 */
	Expression.Predicate newEqual(Expression.Path<?> lhs, Expression.Value<?> rhs);
	Expression.Predicate newEqualIgnoreCase(Expression.Path<?> lhs, Expression.Value<?> rhs);

	/**
	 * Creates a predicate expression to evaluate if the given path matches the given value
	 * as a regular expression.
	 */
	Expression.Predicate newLike(Expression.Path<?> lhs, Expression.Value<String> rhs);

	/**
	 * Creates an expression to count the number of instances.
	 */
	Expression<Integer> newCount(Expression.Path<?> path);

	/**
	 * Creates an expression to find the maximum among the candidate instances along the given path.
	 */
	Expression<Number>  newMax(Expression.Path<?> path);

	/**
	 * Creates an expression to find the minimum among the candidate instances along the given path.
	 */
	Expression<Number>  newMin(Expression.Path<?> path);

	/**
	 * Creates an expression to find the average of the candidate instances along the given path.
	 */
	Expression<Number>  newAvg(Expression.Path<?> path);

	/**
	 * Creates an expression to find the sum of the candidate instances along the given path.
	 */
	Expression<Number>  newSum(Expression.Path<?> path);

	/**
	 * Creates an expression to hold a bind parameter of given name.
	 */
	Expression.BindParameter       newBindParameter(String param);

	/**
	 * Creates an expression for a literal constant of particular type.
	 */
	<V> Expression.Value<V> newConstant(V v);	
}
