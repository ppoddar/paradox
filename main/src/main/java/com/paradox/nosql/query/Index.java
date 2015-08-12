package com.paradox.nosql.query;

import java.util.Iterator;

import com.paradox.query.QueryContext;

public interface Index<V> {
	Iterator<V> fetch(QueryContext<?,V,?> ctx);
}
