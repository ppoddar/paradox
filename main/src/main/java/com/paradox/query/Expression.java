package com.paradox.query;




/**
 * Generic interface for each node of a Query. Everything about a query a represented in terms of expression nodes.
 * A query predicate is a tree of expressions. A query projection and order by clause are lists of expressions.
 * 
 * <p>The nested interfaces indicate the roles a node play in query evaluation or projection.
 * <p>
 * An expression evaluates its argument(s) to produce a value. The generic argument of expression denotes the type of 
 * value as a result of evaluation. 
 * <br>
 * The type of candidate is relevant for the {@link Expression.Path path-based expression}. 
 * A path expression is {@link Expression#evaluate(Object, QueryContext) evaluated} by extracting the attribute value 
 * of the the candidate instance. A path expression must know the representation type of the candidate instance.
 * <br>
 * Many expressions such as logical or comparison operator expressions has no direct bearing on the candidate type
 * other than the fact that most of these operations use a path expression as their left-hand side argument. So for
 * uniformity across all expressions, the {@link Expression#evaluate(Object, QueryContext) evaluation} method  
 * signature is generically typed and by implication the {@link Expression} interface itself. 
 * <p>
 * The other generic argument (the generic argument {@code V}) is the type of value returned when an expression is 
 * evaluated. For example, an {@code AND} expression will evaluate to a {@code Boolean} type. Because many expression
 * evaluates to a boolean value, a {@link Expression.Predicate Predicate} is defined as a marker which is equivalent
 * to {@code Expression<?,Boolean>}. 
 * 
 * 
 * @author pinaki poddar
 *
 * @param  type of candidate instance for evaluating this expression
 * @param <V> type of result produced by evaluating this expression
 */
public interface Expression<V> {
	void accept(ExpressionVisitor visitor);
	
	/**
	 * Evaluates this receiver for the given candidate.
	 */

	V evaluate(Object candidate, QueryContext<?,?,?> ctx);
	
	/**
	 * Expressions that operate on other expressions as arguments.
	 */
	interface Operator<V> extends Expression<V> {
		/**
		 * Gets the operand at the given index.
		 */
		Expression<?> getArgument(int idx);
	}
	
	/**
	 * A marker interface for operator that evaluates to a Boolean value.
	 * For example, conjunction or greater than operation.
	 */
	interface Predicate extends Operator<Boolean>{}
	
	/** Disjunction of two predicates **/
	interface And extends Predicate{}
	
	/** Conjunction of two predicates. **/
	interface Or extends Predicate{}
	
	/** Negation of two predicates. **/
	interface Not extends Predicate{}
	
	
	/** Affirms if the path is null. **/
	interface IsNull extends Predicate{}
	
	/** Affirms if two expressions evaluate to be equal. **/
	interface Equals extends Predicate{}
	
	/** Affirms if left hand expression evaluates to be greater than the right hand expression numerically. **/
	interface Greater extends Predicate{}
	/** Affirms if left hand expression evaluates to be greater than or equal to the right hand expression numerically. **/
	interface GreaterOrEqual extends Predicate{}
	/** Affirms if left hand expression evaluates to be less than the right hand expression numerically. **/
	interface Less extends Predicate{}
	/** Affirms if left hand expression evaluates to be less than or equal to the right hand expression numerically. **/
	interface LessOrEqual extends Predicate{}
	/** Affirms if left hand expression matches  to the right hand expression as a regular expression. **/
	interface Like extends Predicate{}
	
	/**
	 * All non-operator expressions e.g. a field path in the domain model or literal or a bind parameter.
	 */
	interface Value<V> extends Expression<V> {}
	
	/**
	 * A bind parameter in predicate.
	 */
	interface BindParameter<V> extends Value<V> {
		/**
		 * Gets the name of this bind parameter.
		 */
		String getName();
		/** 
		 * Binds the bind parameter to the given value.
		 */
		void setValue(V value);
	}
	
	/**
	 * Designates a candidate type.
	 */
	interface Candidate<V> extends Value<V> {
		/**
		 * Gets the name of this candidate type.
		 */
		String getName();
	}
	
	/**
	 * Designates a path through the domain model. 
	 * A path can be a series of path segments, each segment denoting an attribute. 
	 * A path can spawn a new path by appending a segment.
	 * The type of value a path represents is the type of its last segment.
	 * <p> 
	 * A path expression often appears in the left hand side argument of a comparison operator. <br>
	 * For example, in a {@code Equals} expression as in {@code person.address.city = 'San Francisco'}, 
	 * the path expression represents {@code person.address.city} as a chain of three segments.
	 */
	interface Path<V> extends Value<V> {
		/**
		 * Gets the name of this path segment
		 */
		String getName();
		
		/**
		 * Creates a new path by augmenting the given segment to this path.
		 * @param segment
		 * @return a new path
		 */
		Path<?> newPath(String segment);

		/**
		 * Sets this path values to be sorted in descending order when the path appears
		 * in an {@code ORDER BY} clause.
		 * @return this path itself
		 */
		Path<V> setDescendingOrder();
		
		/**
		 * Affirms if this path values will be sorted in descending order when the path appears
		 * in an {@code ORDER BY} clause.
		 */
		boolean isDescendingOrder();
	}
	
	/**
	 * Literal constants as a query expression.
	 */
	interface Constant<V> extends Value<V> {
		V getValue();
	}
	
	/** A literal string value often used in the right hand side of an operator **/
	interface StringValue extends Constant<String> {}
	
	/** A decimal value often used in the right hand side of an operator **/
	interface DecimalValue extends Constant<Number> {}
	
	/** A integer value often used in the right hand side of an operator **/
	interface IntegerValue extends Constant<Integer> {}

	/**
	 * A operator that evaluates on an aggregation instead of an instance.
	 */
	interface Aggregate<V> extends Operator<V> {
		
		/**
		 * Gets the alias of this aggregate expression.
		 * If an alias is not set explicitly return a concatenation of the operation and argument path name
		 */
		String getAlias();
		
		/**
		 * Sets alias to this path.
		 * @param alias can be null. A null alias denotes the path to be non-aliased.
		 * @return this path itself
		 */
		Aggregate<V> setAlias(String alias);
		
		/**
		 * Affirms if this expression has been aliased.
		 */
		boolean isAliased();
	}
	
	/** Evaluates to the count of selected candidates **/
	interface Count extends Aggregate<Integer>{}
	
	/** Evaluates to the sum of evaluated values of its argument path across all selected candidates **/
	interface Sum extends Aggregate<Number>{}
	
	/** Evaluates to the minimum of evaluated values of its argument path  across all selected candidates **/
	interface Min extends Aggregate<Number>{}
	
	/** Evaluates to the maximum of evaluated values of its argument path  across all selected candidates **/
	interface Max extends Aggregate<Number>{}
	
	/** Evaluates to the average of evaluated values of its argument path  across all selected candidates **/
	interface Avg extends Aggregate<Number>{}
}
