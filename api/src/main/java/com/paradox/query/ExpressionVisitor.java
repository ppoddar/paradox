package com.paradox.query;

/**
 * Visitor for expression tree.
 * 
 * @author pinaki poddar
 * 
 */

public interface ExpressionVisitor {
	/**
	 * Visit the given expression node.
	 * @param expr a non-null expression node
	 */
	void visit(Expression<?> expr);
}
