package org.paradox.query.impl;

import org.paradox.query.kv.KVQueryContext;
import org.paradox.query.kv.ValueTransformer;

/**
 * Implements a path expression.
 * <p>
 * A path expression is distinct from most other expressions because a path expression
 * must evaluate itself to a value against a candidate instance, and hence must know the representation of the 
 * candidate object. In contrast, an {@code AND} expression which performs a disjunction of two boolean values need not 
 * assume anything about candidate instances.
 * <br>
 * This implementation delegates evaluation to {@link ValueTransformer#extractFieldValue(Object, String) Value Transformer} 
 * interface which is made available via {@link KVQueryContext#getValueTransformer() execution context}. 
 * 
 * @author pinaki poddar
 *
 * @param <V> the type of value held in this path
 */
public class FieldPath<V> extends AbstractPath<V> {
	/**
	 * Creates a path with a single field.
	 * @param f a field name. must be non-null, non-empty, without a {@linkplain #PATH_SEPARATOR separator} character.
	 */
	public FieldPath(String f) {
		super(f);
		if (f == null) throw new IllegalArgumentException("Can not construct path with null field name");
		if (f.isEmpty()) throw new IllegalArgumentException("Can not construct path with empty field name");
		if (f.indexOf(PATH_SEPARATOR) != -1) throw new IllegalArgumentException("Can not construct path with field [" +
		     f + "] because it contains a '" + PATH_SEPARATOR + "' which is a meta-character to separate path segments");
		if (!Character.isJavaIdentifierStart(f.charAt(0)))
			throw new IllegalArgumentException("Can not construct path with field [" +
				     f + "] because it begins a '" + f.charAt(0) + "' which is not allowed");
		for (int i = 1; i < f.length(); i++) {
			if (!Character.isJavaIdentifierPart(f.charAt(i))) {
				throw new IllegalArgumentException("Can not construct path with field [" +
					     f + "] because it contains a '" + f.charAt(i) + "' character which is not allowed");
			}
		}
	}
	
	
	/**
	 * Evaluates this expression by delegation to {@link ValueTransformer#extractFieldValue(Object, String) 
	 * value transformer}.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public V evaluate(Object candidate, KVQueryContext ctx) {
		return (V)ctx.getValueTransformer().extractFieldValue(candidate, getName());
	}
}