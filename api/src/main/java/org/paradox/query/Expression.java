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

package org.paradox.query;

import org.paradox.query.exp.ExpressionVisitor;


/**
 * Generic node of a Query Tree. A query is represented as a tree of Expression nodes.
 * A query projection and order by clause are also lists of {@link Expression.Path Path
 * Expressions}.
 * 
 * <p>
 * An expression {@link #evaluate(Object, QueryContext) evaluates} its argument(s) to produce a value. 
 * The generic type argument of an Expression denotes the type of value produced by evaluation. 
 * <br>
 * The type of candidate is relevant for {@link Expression.Path path-based expression}. 
 * A path expression is {@link Expression#evaluate(Object, QueryContext) evaluated} by extracting 
 * the attribute value  of the the candidate instance. A path expression must know the 
 * representation type of the candidate instance.
 * <br>
 * Many expressions such as logical or comparison operator expressions has no direct bearing 
 * on the candidate type other than the fact that most of these operations use a path expression 
 * as their left-hand side argument. 
 * <p>
 * The generic argument (the generic argument {@code V}) is the type of value returned 
 * when an expression is  evaluated. For example, an {@code AND} expression will evaluate to 
 * a {@code Boolean} type. Because many expression evaluates to a boolean value, a 
 * {@link Expression.Predicate Predicate} is defined as a marker which is equivalent
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
	
	
	/** Affirms if left hand is null. **/
	interface IsNull extends Predicate{}
	
	/**
	 * Affirms if a given attribute exists in a candidate record. 
	 *
	 */
	interface Exists extends Predicate{}
	
	/** Affirms if two expressions evaluate to be equal. **/
	interface Equals extends Predicate{}
	
	/** Affirms if two expressions evaluate to be not equal. **/
	interface NotEquals extends Predicate{}
	
	/** Affirms if left hand expression evaluates to be greater 
	 * than the right hand expression numerically. 
	 **/
	interface Greater extends Predicate{}
	
	/** Affirms if left hand expression evaluates to be greater 
	 * than or equal to the right hand expression numerically. 
	 **/
	interface GreaterOrEqual extends Predicate{}
	
	/** Affirms if left hand expression evaluates to be less 
	 * than the right hand expression numerically. 
	 **/
	interface Less extends Predicate{}
	
	/** Affirms if left hand expression evaluates to be less 
	 * than or equal to the right hand expression numerically. 
	 **/
	interface LessOrEqual extends Predicate{}
	/** Affirms if left hand expression matches  to the right 
	 * hand expression as a regular expression. 
	 **/
	interface Like extends Predicate{}
	
	/**
	 * All non-operator expressions e.g. a field path in the domain model 
	 * or literal or a bind parameter.
	 */
	interface Value<V> extends Expression<V> {}
	
	/**
	 * A bind parameter is a named placeholder for a value.
	 */
	interface BindParameter extends Value<Object> {
		/**
		 * Gets the name of this bind parameter.
		 */
		String getName();
		/** 
		 * Binds the bind parameter to the given value.
		 */
		void setValue(Object value);
	}
	
	/**
	 * Designates a candidate type. A candidate is a special path 
	 * often is root.
	 */
	interface Candidate<V> extends Path<V> {
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
	 * A path expression often appears in the left hand side argument of a comparison operator. 
	 * <br>
	 * For example, in a {@code Equals} expression as in {@code person.address.city = 'San Francisco'}, 
	 * the path expression represents {@code person.address.city} as a chain of three segments.
	 */
	interface Path<V> extends Value<V>, Aliased {
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
		
	}

	
	/**
	 * A path that appears in an {@code ORDER BY} clause.
	 *
	 * @param <V> the value of the path. Must be comparable.
	 */
	interface OrderablePath<V> extends Path<V> {
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
	 * Occurs in right hand term of an expression.
	 */
	interface Constant<V> extends Value<V> {
		V getValue();
	}
	
	/** A literal string value 
	 **/
	interface StringValue extends Constant<String> {}
	
	/** A decimal value 
   **/
	interface DecimalValue extends Constant<Number> {}
	
	/** A integer value often 
	 **/
	interface IntegerValue extends Constant<Integer> {}

	/**
	 * A path evaluated on a collection instead of an instance.
	 * Combines a path with an aggregate {@link Operator operator}
	 */
	interface AggregatePath<V> extends Path<V> {
		
	}
	
	/** Evaluates to the count of selected candidates 
	 **/
	interface Count extends AggregatePath<Integer>{}
	
	/** Evaluates to the sum of evaluated values of its argument 
	 *  path across all selected candidates 
	 **/
	interface Sum extends AggregatePath<Number>{}
	
	/** Evaluates to the minimum of evaluated values of its argument 
	 *  across all selected candidates 
	 **/
	interface Min extends AggregatePath<Number>{}
	
	/** Evaluates to the maximum of evaluated values of its argument 
	 *  across all selected candidates 
	 **/
	interface Max extends AggregatePath<Number>{}
	
	/** Evaluates to the average of evaluated values of its argument 
	 *  across all selected candidates 
	 **/
	interface Avg extends AggregatePath<Number>{}
}
