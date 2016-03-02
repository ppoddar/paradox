package org.paradox.query.exp;

import org.paradox.query.Expression;

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
