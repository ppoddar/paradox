package com.paradox.query.impl;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.paradox.query.Expression;
import com.paradox.query.ExpressionFactory;
import com.paradox.schema.Schema;

public class TestSelectParse {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOriginalSQLIsRetained() throws Exception {
		Schema schema = null;
		ExpressionFactory factory = new QueryExpressionFactory();
		String sql = "select name from Person";
		Select select = new SelectBuilder(schema, factory).parse(sql);
		Assert.assertEquals(sql, select.getSQL());
	}
	
	@Test
	public void testCandidate() throws Exception {
		Schema schema = null;
		ExpressionFactory factory = new QueryExpressionFactory();
		String sql = "select name from Person";
		Select select = new SelectBuilder(schema, factory).parse(sql);
		String extent = select.getCandidate().getName();
		Assert.assertEquals("Person", extent);
	}
	
	@Test
	public void testSingleProjection() throws Exception {
		Schema schema = null;
		ExpressionFactory factory = new QueryExpressionFactory();
		String sql = "select name from Person";
		Select select = new SelectBuilder(schema, factory).parse(sql);
		Iterator<Expression.Path<?>> terms = select.getFieldTerms();
		
		Assert.assertTrue(terms.hasNext());
		Expression.Path<?> term = terms.next();
		Assert.assertEquals("name", term.getName());
	}
	
	@Test
	public void testIterationOrderIsPreservedForMultipleProjection() throws Exception {
		Schema schema = null;
		ExpressionFactory factory = new QueryExpressionFactory();
		String sql = "select name,email from Person";
		Select select = new SelectBuilder(schema, factory).parse(sql);
		Iterator<Expression.Path<?>> terms = select.getFieldTerms();
		
		Assert.assertTrue(terms.hasNext());
		Expression.Path<?> term1 = terms.next();
		Assert.assertEquals("name", term1.getName());
		Assert.assertTrue(terms.hasNext());
		Expression.Path<?> term2 = terms.next();
		Assert.assertEquals("email", term2.getName());

		Assert.assertFalse(terms.hasNext());
	}

}
