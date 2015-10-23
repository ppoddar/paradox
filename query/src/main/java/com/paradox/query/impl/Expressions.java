package com.paradox.query.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import com.paradox.nosql.query.KVQueryContext;
import com.paradox.query.Expression;
import com.paradox.query.ExpressionVisitor;

/**
 * Defines the concrete query expressions.
 * 
 * @author pinaki poddar
 *
 */
public class Expressions {
	/**
	 * Base abstract expression allows zero or more child expressions.
	 *
	 * @param <V>
	 */
	public static abstract class AbstractExpression<V> implements Expression<V> {
		private List<Expression<?>> _args;
		
		public final Expression<?> getArgument(int idx) {
			return _args.get(idx);
		}
		
		public final int getArgumentCount() {
			return _args == null ? 0 : _args.size();
		}
		
		public void accept(ExpressionVisitor visitor) {
			visitor.visit(this);
			if (_args != null) {
				for (Expression<?> child : _args) {
					child.accept(visitor);
				}
			}
		}
		
		protected final void addArgument(Expression<?> expr) {
			if (_args == null) {
				_args = new ArrayList<Expression<?>>();
			}
			_args.add(expr);
		}
	}
	
	/**
	 * An expression that operates on other expression(s).
	 */
	public static abstract class OperatorExpression<V> extends AbstractExpression<V> 
		implements Expression.Operator<V>{
		
		protected OperatorExpression(Expression<?> expr) {
			addArgument(expr);
		}
		
		protected OperatorExpression(Expression.Path<?> lhs, Expression<?> rhs) {
			addArgument(lhs);
			addArgument(rhs);
		}
	}
	
	
	public static class Equals extends OperatorExpression<Boolean> implements Expression.Equals {
		boolean _ignoreCase;
		
		public Equals(Expression.Path<?> path, Expression.Value<?> value) {
			this(path, value, false);
		}
		
		public Equals(Expression.Path<?> path, Expression.Value<?> value, boolean ignoreCase) {
			super(path, value);
			_ignoreCase = ignoreCase;
		}
		
		@Override
		public Boolean evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Object lhs = getArgument(0).evaluate(candidate, ctx);
			Object rhs = getArgument(1).evaluate(candidate, ctx);
			return _ignoreCase ? lhs.toString().equalsIgnoreCase(rhs.toString()) : lhs.equals(rhs);
		}
	}
	
	public static class IsNull extends OperatorExpression<Boolean> implements Expression.IsNull {
		public IsNull(Expression.Path<?> path) {
			super(path);
		}
		@Override
		public Boolean evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Object lhs = getArgument(0).evaluate(candidate, ctx);
			return lhs == null;
		}
	}
	
	public static class Not extends OperatorExpression<Boolean> implements Expression.Not {
		
		public Not(Predicate predicate) {
			super(predicate);
		}
		@Override
		public Boolean evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Boolean lhs = ((Predicate)getArgument(0)).evaluate(candidate, ctx);
			return lhs == null ? false : !lhs.booleanValue();
		}
	}
	
	public static abstract class BinaryNumericExpression extends OperatorExpression<Boolean> {
		public BinaryNumericExpression(Expression.Path<?> path, Expression.Value<Number> value) {
			super(path, value);
		}
		@Override
		public final Boolean evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Number lhs = (Number)getArgument(0).evaluate(candidate, ctx);
			Number rhs = (Number)getArgument(1).evaluate(candidate, ctx);
			return compare(lhs,rhs);
		}
		
		abstract Boolean compare(Number lhs, Number rhs);
		
	}
	public static class Greater extends BinaryNumericExpression implements Expression.Greater {
		public Greater(Expression.Path<?> path, Expression.Value<Number> value) {
			super(path, value);
		}
		@Override
		public Boolean compare(Number lhs, Number rhs) {
			return lhs.doubleValue() > rhs.doubleValue();
		}
	}
	public static class GreaterOrEqual extends BinaryNumericExpression implements Expression.GreaterOrEqual {
		public GreaterOrEqual(Expression.Path<?> path, Expression.Value<Number> value) {
			super(path, value);
		}
		@Override
		public Boolean compare(Number lhs, Number rhs) {
			return lhs.doubleValue() >= rhs.doubleValue();
		}
	}
	public static class Less extends BinaryNumericExpression implements Expression.Less {
		public Less(Expression.Path<?> path, Expression.Value<Number> value) {
			super(path, value);
		}
		@Override
		public Boolean compare(Number lhs, Number rhs) {
			return lhs.doubleValue() < rhs.doubleValue();
		}
	}
	public static class LessOrEqual extends BinaryNumericExpression implements Expression.LessOrEqual {
		public LessOrEqual(Expression.Path<?> path, Expression.Value<Number> value) {
			super(path, value);
		}
		@Override
		public Boolean compare(Number lhs, Number rhs) {
			return lhs.doubleValue() <= rhs.doubleValue();
		}
	}
	public static class Like extends OperatorExpression<Boolean> implements Expression.Like {
		public Like(Expression.Path<?> path, Expression.Value<String> value) {
			super(path, value);
		}
		@Override
		public Boolean evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			String lhs = (String)getArgument(0).evaluate(candidate, ctx);
			String rhs = (String)getArgument(1).evaluate(candidate, ctx);
			return Pattern.matches(rhs, lhs);
		}
	}

	public static abstract class ConstantExpression<V> extends AbstractExpression<V> {
		final V _value;
		ConstantExpression(V v) {
			_value = v;
		}
		public final V getValue() {
			return _value;
		}
		
		@Override
		public V evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			return _value;
		}

	}
	
	public static class IntegerValue extends ConstantExpression<Integer> implements Expression.IntegerValue {
		public IntegerValue(Integer v) {
			super(v);
		}
	}
	public static class DecimalValue extends ConstantExpression<Number>  implements Expression.DecimalValue {
		public DecimalValue(Number d) {
			super(d);
		}
	}
	
	public static class StringValue extends ConstantExpression<String> implements Expression.StringValue {
		public StringValue(String s) {
			super(s);
		}
	}
	
	/**
	 * Aggregate expression evaluates on a collection of candidates
	 * instead of individual candidate.
	 * They are called once per execution with a collection as candidate.
	 *
	 * @param <V>
	 */
	public static abstract class AggregateExpression<V> extends OperatorExpression<V> implements Expression.Aggregate<V> {
		private final String _operator;
		private String       _alias;
		
		AggregateExpression(String operator, Expression.Path<?> path) {
			super(path);
			_operator = operator;
		}
		
		@Override
		public AggregateExpression<V> setAlias(String alias) {
			_alias = alias;
			return this;
		}
		
		@Override
		public String getAlias() {
			if (isAliased()) return _alias;
			return _operator + '_' + getArgument(0).toString().replace('.', '_');
		}
		
		@Override
		public boolean isAliased() {
			return _alias != null;
		}
		
		protected Collection<?> assertCollection(Object candidate) {
			if (candidate instanceof Collection) return Collection.class.cast(candidate);
			throw new IllegalArgumentException(this + " must have a collection as candidate for evaluation");
		}
	}
	
	public static class Count extends AggregateExpression<Integer> implements Expression.Count {
		public Count(Expression.Path<?> path) {
			super("count", path);
		}
		
		@Override
		public Integer evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			return assertCollection(candidate).size();
		}
		
	}
	
	public static class Sum extends AggregateExpression<Number>  implements Expression.Sum {
		public Sum(Expression.Path<?> path) {
			super("sum", path);
		}
		@Override
		public Number evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Collection<?> coll = assertCollection(candidate);
			double sum = 0.0;
			for (Object obj : coll) {
				sum += ((Number)getArgument(0).evaluate(obj, ctx)).doubleValue();
			}
			return sum;
		}
	}
	
	public static class Avg extends Sum implements Expression.Avg {
		public Avg(Expression.Path<?> path) {
			super(path);
		}
		@Override
		public Number evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Collection<?> coll = assertCollection(candidate);
			if (coll.isEmpty()) return 0.0;
			double sum = 0.0;
			for (Object obj : coll) {
				sum += ((Number)getArgument(0).evaluate(obj, ctx)).doubleValue();
			}
			return sum/coll.size();
		}
	}
	
	public static class Min extends AggregateExpression<Number> implements Expression.Min{
		public Min(Expression.Path<?> path) {
			super("min", path);
		}
		@Override
		public Number evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Collection<?> coll = assertCollection(candidate);
			if (coll.isEmpty()) return 0.0;
			double min = Double.MAX_VALUE;
			for (Object obj : coll) {
				min = Math.min(min, ((Number)getArgument(0).evaluate(obj, ctx)).doubleValue());
			}
			return min;
		}
		
	}
	public static class Max extends AggregateExpression<Number> implements Expression.Max{
		
		public Max(Expression.Path<?> path) {
			super("max", path);
		}
		@Override
		public Number evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Collection<?> coll = assertCollection(candidate);
			if (coll.isEmpty()) return 0.0;
			double max = Double.MIN_VALUE;
			for (Object obj : coll) {
				max = Math.max(max, ((Number)getArgument(0).evaluate(obj, ctx)).doubleValue());
			}
			return max;
		}
	}
	

	/**
	 * A bind parameter in a query works differently than other expressions.
	 * A parameter expression is evaluated to a value that is set 
	 * @author pipoddar
	 *
	 * @param <V>
	 */
	public static class BindParameter extends AbstractExpression<Object> implements Expression.BindParameter {
		private final String _paramKey;
		private Object _paramValue;
		private boolean _bound;
		
		public BindParameter(String param) {
			if (param.charAt(0) != ':')
				throw new IllegalArgumentException("Invalid bind parameter [" + param + "]. " 
						+ "Must begin with colon (':') character");
			_paramKey = param.substring(1);
		}
		@Override
		public String getName() {
			return _paramKey;
		}
		
		@Override
		public void setValue(Object value) {
			_paramValue = value;
			_bound    = true;
		}
		
		@Override
		public Object evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			if (!_bound) throw new RuntimeException("Bind parameter [" + _paramKey + "] is not bound");
			return _paramValue;
		}
	}
	
	public static class Or extends AbstractExpression<Boolean> implements Expression.Or {
		public Or(Predicate lhs, Predicate rhs) {
			addArgument(lhs);
			addArgument(rhs);
		}
		
		@Override
		public Boolean evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Boolean lhs = ((Predicate)getArgument(0)).evaluate(candidate, ctx);
			if (lhs) return true;
			return ((Predicate)getArgument(1)).evaluate(candidate, ctx);
		}
	}
	
	public static class And extends AbstractExpression<Boolean> implements Expression.And {
		public And(Predicate lhs, Predicate rhs) {
			addArgument(lhs);
			addArgument(rhs);
		}
		
		@Override
		public Boolean evaluate(Object candidate, KVQueryContext<?,?,?> ctx) {
			Boolean lhs = ((Predicate)getArgument(0)).evaluate(candidate, ctx);
			if (!lhs) return false;
			return ((Predicate)getArgument(1)).evaluate(candidate, ctx);
		}
	}

}
