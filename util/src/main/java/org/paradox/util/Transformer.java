package org.paradox.util;

public interface Transformer<A,B> {
	B transform(A a);

}
