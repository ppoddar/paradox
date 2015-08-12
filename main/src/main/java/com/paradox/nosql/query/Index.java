package com.paradox.nosql.query;

import java.util.Iterator;

import oracle.kv.Value;

import com.paradox.query.QueryContext;

public interface Index<V> {
	Iterator<V> fetch(QueryContext ctx);
}
