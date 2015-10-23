package com.paradox.util;

/**
 * Transform a value of one type to another.
 * 
 * @author pinaki poddar
 *
 * @param <A> original type
 * @param <B> transformed type
 */
public interface Transformer<A,B> {
	B transform(A a);
}
