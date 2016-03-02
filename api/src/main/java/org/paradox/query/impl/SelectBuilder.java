package org.paradox.query.impl;

import java.io.IOException;
import java.util.BitSet;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.paradox.query.Expression;
import org.paradox.query.ExpressionFactory;
import org.paradox.schema.SchemaValidationException;

import antlr4.generated.NoSQLBaseListener;
import antlr4.generated.NoSQLLexer;
import antlr4.generated.NoSQLParser;
import antlr4.generated.NoSQLParser.AggregateTermContext;
import antlr4.generated.NoSQLParser.AliasContext;
import antlr4.generated.NoSQLParser.AndContext;
import antlr4.generated.NoSQLParser.AvgContext;
import antlr4.generated.NoSQLParser.BindParamContext;
import antlr4.generated.NoSQLParser.CountContext;
import antlr4.generated.NoSQLParser.DecimalValueContext;
import antlr4.generated.NoSQLParser.EqualsContext;
import antlr4.generated.NoSQLParser.EqualsIgnoreCaseContext;
import antlr4.generated.NoSQLParser.ExistsContext;
import antlr4.generated.NoSQLParser.FieldNameContext;
import antlr4.generated.NoSQLParser.FieldPathContext;
import antlr4.generated.NoSQLParser.GreaterContext;
import antlr4.generated.NoSQLParser.GreaterOrEqualContext;
import antlr4.generated.NoSQLParser.GroupByClauseContext;
import antlr4.generated.NoSQLParser.IntegerValueContext;
import antlr4.generated.NoSQLParser.IsNotNullContext;
import antlr4.generated.NoSQLParser.IsNullContext;
import antlr4.generated.NoSQLParser.LessContext;
import antlr4.generated.NoSQLParser.LessOrEqualContext;
import antlr4.generated.NoSQLParser.LikeContext;
import antlr4.generated.NoSQLParser.LimitClauseContext;
import antlr4.generated.NoSQLParser.MaxContext;
import antlr4.generated.NoSQLParser.MinContext;
import antlr4.generated.NoSQLParser.NotContext;
import antlr4.generated.NoSQLParser.NotEqualsContext;
import antlr4.generated.NoSQLParser.OrContext;
import antlr4.generated.NoSQLParser.OrderByClauseContext;
import antlr4.generated.NoSQLParser.OrderByTermContext;
import antlr4.generated.NoSQLParser.ProjectionsContext;
import antlr4.generated.NoSQLParser.SelectClauseContext;
import antlr4.generated.NoSQLParser.SelectStatementContext;
import antlr4.generated.NoSQLParser.SkipClauseContext;
import antlr4.generated.NoSQLParser.StringValueContext;
import antlr4.generated.NoSQLParser.SumContext;
import antlr4.generated.NoSQLParser.TypeNameContext;
import antlr4.generated.NoSQLParser.WhereClauseContext;

/**
 * Builds a {@link Select select statement} by parsing a SQL-like string.
 * The grammar for SQL-like string is defined using ANTLR (version 4). 
 * <p>
 * This builder listens as nodes of Abstract Syntax Tree (AST) generated  
 * from an input query string are walked. On each AST node, this builder 
 * creates appropriate types of {@link Expression query expression} and populates
 * a {@link Select select} data structure. 
 * <br>
 * The intermediate {@link Expression expressions} are maintained in an 
 * internal Stack machine. The enterXXX() pushes the expression on to
 * the stack and exitXXX() pops it, with the exception of aliased expressions.
 * 
 * <p>
 * The concrete expressions are created by a {@link ExpressionFactory factory}.
 * 
 * @author pinaki poddar
 *
 */
public class SelectBuilder extends NoSQLBaseListener implements ANTLRErrorListener {
	private final Stack<Expression<?>> _stack;
	private final ExpressionFactory _factory;
	private Select _select;
	
	// a state to determine how field paths on the stack are to be treated
	private static enum ParseClause {PROJECTION, WHERE, ORDER_BY, GROUP_BY};
	private ParseClause _parseCtx = ParseClause.PROJECTION;
	private static final boolean _debug = Boolean.getBoolean("debug");
	/**
	 * Supply a factory for Query Expressions.
	 * @param factory creates concrete expressions. must not be null.
	 */
	public SelectBuilder(ExpressionFactory factory) {
		_stack = new Stack<Expression<?>>();
		_factory = factory;
	}
	
	/**
	 * Compiles the given SQL-like query string into a Select data structure. 
	 * If a schema is available 
	 * 
	 * @return a select populated with parsed expressions
	 * @throws IOException if the given sql string can not be read
	 * SchemaValidationException the name tokens are not semantically valid, for example  
	 */
	public Select parse(String sql) throws IOException, SchemaValidationException {
		synchronized (_stack) {
			_select = new Select(sql);
			ANTLRInputStream in = new ANTLRInputStream(sql);
			 NoSQLLexer lexer = new NoSQLLexer(in);;
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			NoSQLParser parser = new NoSQLParser(tokens);
			ParseTree ast = parser.selectStatement(); // parse the statement
			new ParseTreeWalker().walk(this, ast);
		}
		return _select;
	}
	
	public void enterFieldName(FieldNameContext ctx) {
		String fieldSegment = ctx.getText();
		push(currentStack(Expression.Path.class) ? 
				pop(Expression.Path.class).newPath(fieldSegment)  : _factory.newPath(fieldSegment));
	}

	public void exitFieldPath(FieldPathContext ctx) {
		Expression.Path<?> path = pop(Expression.Path.class);
		switch (_parseCtx) {
		case PROJECTION:
			_select.addProjectionTerm(path);
			break;
		case GROUP_BY :
			_select.addGroupByTerm(path); 
			break;
		case ORDER_BY:
			_select.addOrderByTerm(path);
			break;
		case WHERE:
			push(path);
			break;
		}
	}
	
	public void enterProjections(ProjectionsContext ctx) {
		_parseCtx = ParseClause.PROJECTION;
	}
	public void exitProjections(ProjectionsContext ctx) {
	}
	public void enterWhereClause(WhereClauseContext ctx) {
		assertEmptyStack();
		_parseCtx = ParseClause.WHERE;
	}
	public void exitWhereClause(WhereClauseContext ctx) {
		_select.setPredicate(pop(Expression.Predicate.class));
	}
	@Override 
	public void enterEveryRule(ParserRuleContext ctx) {
		if (!_debug) return;
		for (int i = 0; i < ctx.depth(); i++) System.err.print("-");
		System.err.println("enter  " + ctx.getClass().getSimpleName());
		super.enterEveryRule(ctx);
	}
	@Override 
	public void exitEveryRule(ParserRuleContext ctx) {
		if (!_debug) return;
		for (int i = 0; i < ctx.depth(); i++) System.err.print("-");
		System.err.println("exit   " + ctx.getClass().getSimpleName());
		super.exitEveryRule(ctx);
	}

	
	public void exitIsNotNull(IsNotNullContext ctx) {
		Expression.Path<?> path = pop(Expression.Path.class);
		push(_factory.newNot(_factory.newIsNull(path)));
	}
	
	public void exitIsNull(IsNullContext ctx) {
		Expression.Path<?> path = pop(Expression.Path.class);
		push(_factory.newIsNull(path));
	}

	
	@SuppressWarnings("unchecked")
	public void exitGreater(GreaterContext ctx) {
		Expression.Value<Number> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newGreater(lhs, rhs));
	}

	
	@SuppressWarnings("unchecked")
	public void exitLess(LessContext ctx) {
		Expression.Value<Number> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newLess(lhs, rhs));
	}

	public void exitIntegerValue(IntegerValueContext ctx) {
		push(_factory.newConstant(Integer.parseInt(ctx.getText())));
		
	}
	
	public void exitMin(MinContext ctx) {
		push(_factory.newMin(pop(Expression.Path.class)));
	}
	
	public void enterOrderByTerm(OrderByTermContext ctx) {
		//_select.addOrderByTerm(pop(Expression.Path.class));
		_parseCtx = ParseClause.ORDER_BY;
	}

	
	public void exitSkipClause(SkipClauseContext ctx) {
		_select.setSkip((Integer)pop(Expression.Constant.class).getValue());
	}

	
	public void exitCount(CountContext ctx) {
		push(_factory.newCount(pop(Expression.Path.class)));
	}
	public void exitSum(SumContext ctx) {
		push(_factory.newSum(pop(Expression.Path.class)));
	}
	public void exitAvg(AvgContext ctx) {
		push(_factory.newAvg(pop(Expression.Path.class)));
	}
	public void exitMax(MaxContext ctx) {
		push(_factory.newMax(pop(Expression.Path.class)));
	}
	
	public void exitAlias(AliasContext ctx) {
		pop(Expression.Path.class).setAlias(ctx.getText());
	}

	
	
	public void exitStringValue(StringValueContext ctx) {
		push(_factory.newConstant(ctx.getText()));
	}
	
	public void exitEquals(EqualsContext ctx) {
		Expression.Value<?> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newEqual(lhs, rhs));
	}
	
	@Override
	public void exitNotEquals(NotEqualsContext ctx) {
		Expression.Value<?> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newNotEqual(lhs, rhs));
	}

	public void exitEqualsIgnoreCase(EqualsIgnoreCaseContext ctx) {
		Expression.Value<?> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newEqualIgnoreCase(lhs, rhs));
	}
	public void exitOr(OrContext ctx) {
		Expression.Predicate rhs = pop(Expression.Predicate.class);
		Expression.Predicate lhs = pop(Expression.Predicate.class);
		push(_factory.newOr(lhs, rhs));
	}
	
	public void exitOrderByClause(OrderByClauseContext ctx) {
		assertEmptyStack();
	}
	
	public void exitBindParam(BindParamContext ctx) {
		push(_factory.newBindParameter(ctx.getText()));
		
	}

	@SuppressWarnings("unchecked")
	public void exitLike(LikeContext ctx) {
		Expression.Value<String> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newLike(lhs, rhs));
	}

	public void exitDecimalValue(DecimalValueContext ctx) {
		push(_factory.newConstant(Double.parseDouble(ctx.getText())));
	}

	public void exitAnd(AndContext ctx) {
		Expression.Predicate rhs = pop(Expression.Predicate.class);
		Expression.Predicate lhs = pop(Expression.Predicate.class);
		push(_factory.newAnd(lhs, rhs));
	}

	public void exitNot(NotContext ctx) {
		push(_factory.newNot(pop(Expression.Predicate.class)));
	}
	public void enterTypeName(TypeNameContext ctx) {
		Expression.Candidate<?> candidate = _factory.newCandidate(ctx.getText());
		_select.setCandidate(candidate);
		push(candidate);
	}
	/**
	 * The candidate is now available and select is set accordingly.
	 * 
	 * @see Select#setRoot(org.paradox.query.Expression.Candidate)
	 */
	
	public void exitTypeName(TypeNameContext ctx) {
//		Expression.Candidate<?> candidate = _factory.newCandidate(ctx.getText());
//		_select.setRoot(candidate);
//		// now projection paths can be validated
//		if (_select.hasPaths()) {
//			Iterator<Expression.Path<?>> paths = _select.getFieldTerms();
//			while (paths.hasNext()) {
//				validatePath(paths.next());
//			}
//		} else if (_select.hasAggregates()) {
//			Iterator<Expression.Aggregate<?>> aggregates = _select.getAggregateTerms();
//			while (aggregates.hasNext()) {
//				Expression.Path< ?> path = (Expression.Path< ?>)aggregates.next().getArgument(0);
//				validatePath(path);
//			}
//		}
	}
	public void exitSelectClause(SelectClauseContext ctx) { 
		//assertEmptyStack();
		_stack.clear();
	}

	
	public void exitSelectStatement(SelectStatementContext ctx) {
		assertEmptyStack();
	}
	
	@SuppressWarnings("unchecked")
	public void exitLessOrEqual(LessOrEqualContext ctx) {
		Expression.Value<Number> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newLessOrEqual(lhs, rhs));
	}

	public void exitExists(ExistsContext ctx) {
		push(_factory.newExists(pop(Expression.Path.class)));
	}

	public void exitAggregateTerm(AggregateTermContext ctx) {
		pop(Expression.Path.class);
	}

	@SuppressWarnings("unchecked")
	public void exitGreaterOrEqual(GreaterOrEqualContext ctx) {
		Expression.Value<Number> rhs   = pop(Expression.Value.class);
		Expression.Path<?> lhs    = pop(Expression.Path.class);
		push(_factory.newGreaterOrEqual(lhs, rhs));
	}
	
	public void enterGroupByClause(GroupByClauseContext ctx) {
		_parseCtx = ParseClause.GROUP_BY;
	}
	
	public void exitLimitClause(LimitClauseContext ctx) {
		_select.setLimit((Integer)pop(Expression.Constant.class).getValue());	
	}
	
	 
	public void exitDesc(NoSQLParser.DescContext ctx) { 
		peek(Expression.OrderablePath.class).setDescendingOrder();
	}
	
	

	
	public void visitErrorNode(ErrorNode error) {
		Token token = error.getSymbol();

		int n = token.getStartIndex();
		int l = token.getText().length();
		String sql = _select.getSQL();
		String message = "Syntax error in SQL [" + sql + "]";
		if (n != -1) {
		  message = "Encountered [" + token.getText() + "] at position " +  n + " in SQL [" 
		          + sql.substring(0,n) + "^" + token.getText() + "^ " + sql.substring(n+l) + "]";
		}
		
		throw new RuntimeException(message);
	}


	
	/** -----------------------------------------------------------------------
	 *      Stack Management
	 *  
	 *  Basic stack operations with sanity check for expected stack state and
	 *  type of its top element 
	 *  -----------------------------------------------------------------------    	
	 */
	/**
	 * Push the given element to the stack
	 * @param expr non-null expression
	 */
	void push(Expression<?> expr) {
		if (expr == null) 
			throw new IllegalArgumentException("Can not push null expression");
		_stack.push(expr);
	}

	/** 
	 * Peeks for an element of the given type.
	 * @param cls expected type of the top element on the stack
	 * @return the top element after casting. 
	 * If the top element is not of expected type or there is no element at all, returns null 
	 * 
	 */
	<X extends Expression<?>> X peek(Class<X> cls) {
		if (_stack.isEmpty()) 
			return null;
		if (cls.isInstance(_stack.peek())) {
			return cls.cast(_stack.peek());
		} else {
			return null;
		}
	}
	
	/** 
	 * Pops an element of the given type.
	 * @param cls expected type of the top element on the stack
	 * @return the top element after casting 
	 * @exception IllegalStateException if the stack is empty
	 * or the top element is not assignable to the given expected type
	 * 
	 */
	<X extends Expression<?>> X pop(Class<X> cls) {
		if (_stack.isEmpty()) 
			throw new IllegalStateException("Expecting an element of " + cls + " but the stack is empty");
		if (cls.isInstance(_stack.peek())) {
			return cls.cast(_stack.pop());
		} else {
			String message = _stack.peek() + " is not instance of " + cls;
			printStack("failed at pop " + cls.getName());
			throw new IllegalStateException(message);
		}
	}
	
	boolean currentStack(Class<?> cls) {
		return !_stack.isEmpty() && cls.isInstance(_stack.peek());
	}
	
	/**
	 * Asserts that the stack is empty.
	 */
	void assertEmptyStack() {
		if (!_stack.isEmpty()) {
			int size = _stack.size();
			printStack("failed assertEmptyStack()");
			throw new IllegalStateException("Stack should have been empty but has " + size + " elements");
		}
	}
	
	void printStack(String header) {
		System.err.println(header);
		while (!_stack.isEmpty()) {
			System.err.println(_stack.pop());
		}
	}
	
	String toString(Object obj) {
		return obj == null ? "null" : obj.toString() + '(' + obj.getClass() + ')';
	}
	
	/**
	 * Validates the given type only if schema has been set.
	 */
//	void validateType(Expression.Candidate<?> candidate) {
//		if (_schema == null) return;
//		_schema.validateType(candidate.getName());
//	}
	
	/**
	 * Validates the given path only if schema has been set and the select candidate is available i.e. {@code FROM}
	 * clause has been parsed.
	 */
//	void validatePath(Expression.Path<?> path) {
//		if (_schema == null) return;
//		if (_select.getCandidate() == null) return;
//		_schema.validatePath(_select.getCandidate().getName(), path.toString());
//	}

	
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		
		throw e;
		
	}

	
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex,
			int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
		// TODO Auto-generated method stub
		
	}

	
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa,
			int startIndex, int stopIndex, BitSet conflictingAlts,
			ATNConfigSet configs) {
		// TODO Auto-generated method stub
		
	}

	
	public void reportContextSensitivity(Parser recognizer, DFA dfa,
			int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
		// TODO Auto-generated method stub
		
	}
}
