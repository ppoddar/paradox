package com.paradox.query.impl;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;
import org.paradox.query.Expression;
import org.paradox.query.ExpressionFactory;
import org.paradox.query.impl.QueryExpressionFactory;
import org.paradox.query.impl.Select;
import org.paradox.query.impl.SelectBuilder;

public class TestSelectParse {

	@Test
	public void testOriginalSQLIsRetained() throws Exception {
		String sql = "select name from Person";
		Select select = parseSelect(sql);
		Assert.assertEquals(sql, select.getSQL());
	}
	
	@Test
	public void testKeywordsAreCaseInsensitive() throws Exception {
		String sql = "selEct name FroM Person";
		Select select = parseSelect(sql);
		Assert.assertEquals(sql, select.getSQL());
	}
	
	@Test
	public void testCandidate() throws Exception {
		String sql = "select name from Person";
		Select select = parseSelect(sql);
		String extent = select.getCandidate().getName();
		Assert.assertEquals("Person", extent);
	}
	@Test
	public void testCandidateAlias() throws Exception {
		String sql = "select name from Person p";
		Select select = parseSelect(sql);
		Expression.Candidate<?> candidate = select.getCandidate();
		Assert.assertEquals("Person", candidate.getName());
		Assert.assertEquals("p", candidate.getAlias());
	}
	
	@Test
	public void testSingleProjection() throws Exception {
		String sql = "select name from Person";
		Select select = parseSelect(sql);
		Iterator<Expression.Path<?>> terms = select.getProjectionTerms();
		
		Assert.assertTrue(terms.hasNext());
		Expression.Path<?> term = terms.next();
		Assert.assertEquals("name", term.getName());
	}
	
	@Test
	public void testIterationOrderIsPreservedForMultipleProjection() throws Exception {
		String sql = "select name,email from Person";
		Select select = parseSelect(sql);
		Iterator<Expression.Path<?>> terms = select.getProjectionTerms();
		
		Assert.assertTrue(terms.hasNext());
		Expression.Path<?> term1 = terms.next();
		Assert.assertEquals("name", term1.getName());
		Assert.assertTrue(terms.hasNext());
		Expression.Path<?> term2 = terms.next();
		Assert.assertEquals("email", term2.getName());

		Assert.assertFalse(terms.hasNext());
	}

	@Test
	public void testMultiSegmentProjection() throws Exception {
		String sql = "select user.email from Person";
		Select select = parseSelect(sql);
		Iterator<Expression.Path<?>> terms = select.getProjectionTerms();
		Assert.assertTrue(terms.hasNext());
		Expression.Path<?> term = terms.next();
		Assert.assertFalse(terms.hasNext());
		Assert.assertEquals("user.email", term.getName());
	}
	@Test
	public void testPredicate() throws Exception {
		String sql = "select email from Person where ab=1"; // requires at least two character field name
		Select select = parseSelect(sql);
		Expression.Predicate predicate = select.getPredicate();
		Assert.assertNotNull(predicate);
		Expression<?> lhs = predicate.getArgument(0);
		Expression<?> rhs = predicate.getArgument(1);
		Assert.assertNotNull(lhs);
		Assert.assertNotNull(rhs);
		Assert.assertTrue(predicate instanceof Expression.Equals);
		Assert.assertTrue(lhs instanceof Expression.Path);
		Assert.assertTrue(rhs instanceof Expression.Constant);
	}
	
	public void testPredicate2() throws Exception {
		String sql = "select * from Person where age < 42";
		Select select = parseSelect(sql);
		Expression.Predicate predicate = select.getPredicate();
		Assert.assertNotNull(predicate);
		Expression<?> lhs = predicate.getArgument(0);
		Expression<?> rhs = predicate.getArgument(1);
		Assert.assertNotNull(lhs);
		Assert.assertNotNull(rhs);
		Assert.assertTrue(predicate instanceof Expression.Less);
		Assert.assertTrue(lhs instanceof Expression.Path);
		Assert.assertTrue(rhs instanceof Expression.Constant);
	}

	Select parseSelect(String sql) throws Exception {
		ExpressionFactory factory = new QueryExpressionFactory();
		Select select = new SelectBuilder(factory).parse(sql);
		return select;
	}
}
