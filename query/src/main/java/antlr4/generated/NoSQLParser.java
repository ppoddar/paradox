// Generated from NoSQL.g4 by ANTLR 4.5

	package antlr4.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NoSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LETTER=1, DIGIT=2, UNDERSCORE=3, WILDCARD=4, DOUBLEQUOTE=5, BACKSLASH=6, 
		COLON=7, COMMA=8, DOT=9, LPAREN=10, RPAREN=11, EQUALS=12, NOT_EQUALS=13, 
		EQUALS_IGNORECASE=14, GREATER=15, GREATER_OR_EQUAL=16, LESS=17, LESS_OR_EQUAL=18, 
		LIKE=19, AND=20, AS=21, ASC=22, AVG=23, COUNT=24, DESC=25, EXISTS=26, 
		FROM=27, GROUP_BY=28, IS_NULL=29, IS_NOT_NULL=30, LIMIT=31, MAX=32, MIN=33, 
		NOT=34, OR=35, ORDER_BY=36, SELECT=37, SKIP=38, SUM=39, WHERE=40, IDENTIFIER=41, 
		WS=42, OPENSTRING=43, STRING_LITERAL=44, CLOSESTRING=45;
	public static final int
		RULE_selectStatement = 0, RULE_selectClause = 1, RULE_whereClause = 2, 
		RULE_orderByClause = 3, RULE_groupByClause = 4, RULE_limitClause = 5, 
		RULE_skipClause = 6, RULE_projections = 7, RULE_typeName = 8, RULE_rootPath = 9, 
		RULE_fieldName = 10, RULE_fieldPath = 11, RULE_aggregateTerm = 12, RULE_alias = 13, 
		RULE_predicate = 14, RULE_predicateTerm = 15, RULE_unaryPredicate = 16, 
		RULE_binaryPredicate = 17, RULE_and = 18, RULE_or = 19, RULE_equals = 20, 
		RULE_notequals = 21, RULE_equalsIgnoreCase = 22, RULE_greater = 23, RULE_greaterOrEqual = 24, 
		RULE_less = 25, RULE_lessOrEqual = 26, RULE_like = 27, RULE_not = 28, 
		RULE_isNull = 29, RULE_isNotNull = 30, RULE_exists = 31, RULE_sum = 32, 
		RULE_min = 33, RULE_max = 34, RULE_count = 35, RULE_avg = 36, RULE_value = 37, 
		RULE_stringValue = 38, RULE_numericValue = 39, RULE_integerValue = 40, 
		RULE_decimalValue = 41, RULE_bindParam = 42, RULE_paramKey = 43, RULE_orderByTerm = 44, 
		RULE_asc = 45, RULE_desc = 46;
	public static final String[] ruleNames = {
		"selectStatement", "selectClause", "whereClause", "orderByClause", "groupByClause", 
		"limitClause", "skipClause", "projections", "typeName", "rootPath", "fieldName", 
		"fieldPath", "aggregateTerm", "alias", "predicate", "predicateTerm", "unaryPredicate", 
		"binaryPredicate", "and", "or", "equals", "notequals", "equalsIgnoreCase", 
		"greater", "greaterOrEqual", "less", "lessOrEqual", "like", "not", "isNull", 
		"isNotNull", "exists", "sum", "min", "max", "count", "avg", "value", "stringValue", 
		"numericValue", "integerValue", "decimalValue", "bindParam", "paramKey", 
		"orderByTerm", "asc", "desc"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'_'", "'*'", "'\"'", "'\\'", "':'", "','", "'.'", "'('", 
		"')'", "'='", "'!='", "'~='", "'>'", "'>='", "'<'", "'<='", "'LIKE'", 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LETTER", "DIGIT", "UNDERSCORE", "WILDCARD", "DOUBLEQUOTE", "BACKSLASH", 
		"COLON", "COMMA", "DOT", "LPAREN", "RPAREN", "EQUALS", "NOT_EQUALS", "EQUALS_IGNORECASE", 
		"GREATER", "GREATER_OR_EQUAL", "LESS", "LESS_OR_EQUAL", "LIKE", "AND", 
		"AS", "ASC", "AVG", "COUNT", "DESC", "EXISTS", "FROM", "GROUP_BY", "IS_NULL", 
		"IS_NOT_NULL", "LIMIT", "MAX", "MIN", "NOT", "OR", "ORDER_BY", "SELECT", 
		"SKIP", "SUM", "WHERE", "IDENTIFIER", "WS", "OPENSTRING", "STRING_LITERAL", 
		"CLOSESTRING"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NoSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NoSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SelectStatementContext extends ParserRuleContext {
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public SkipClauseContext skipClause() {
			return getRuleContext(SkipClauseContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			selectClause();
			setState(96);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(95);
				whereClause();
				}
			}

			setState(99);
			_la = _input.LA(1);
			if (_la==ORDER_BY) {
				{
				setState(98);
				orderByClause();
				}
			}

			setState(102);
			_la = _input.LA(1);
			if (_la==GROUP_BY) {
				{
				setState(101);
				groupByClause();
				}
			}

			setState(105);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(104);
				limitClause();
				}
			}

			setState(108);
			_la = _input.LA(1);
			if (_la==SKIP) {
				{
				setState(107);
				skipClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectClauseContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(NoSQLParser.SELECT, 0); }
		public ProjectionsContext projections() {
			return getRuleContext(ProjectionsContext.class,0);
		}
		public TerminalNode FROM() { return getToken(NoSQLParser.FROM, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public SelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitSelectClause(this);
		}
	}

	public final SelectClauseContext selectClause() throws RecognitionException {
		SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(SELECT);
			setState(111);
			projections();
			setState(112);
			match(FROM);
			setState(113);
			typeName();
			setState(115);
			_la = _input.LA(1);
			if (_la==LETTER) {
				{
				setState(114);
				alias();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(NoSQLParser.WHERE, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(WHERE);
			setState(118);
			predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderByClauseContext extends ParserRuleContext {
		public TerminalNode ORDER_BY() { return getToken(NoSQLParser.ORDER_BY, 0); }
		public List<OrderByTermContext> orderByTerm() {
			return getRuleContexts(OrderByTermContext.class);
		}
		public OrderByTermContext orderByTerm(int i) {
			return getRuleContext(OrderByTermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(NoSQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NoSQLParser.COMMA, i);
		}
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitOrderByClause(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_orderByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(ORDER_BY);
			setState(121);
			orderByTerm();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(122);
				match(COMMA);
				setState(123);
				orderByTerm();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByClauseContext extends ParserRuleContext {
		public TerminalNode GROUP_BY() { return getToken(NoSQLParser.GROUP_BY, 0); }
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitGroupByClause(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_groupByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(GROUP_BY);
			setState(130);
			fieldPath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitClauseContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(NoSQLParser.LIMIT, 0); }
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(LIMIT);
			setState(133);
			integerValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipClauseContext extends ParserRuleContext {
		public TerminalNode SKIP() { return getToken(NoSQLParser.SKIP, 0); }
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public SkipClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterSkipClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitSkipClause(this);
		}
	}

	public final SkipClauseContext skipClause() throws RecognitionException {
		SkipClauseContext _localctx = new SkipClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_skipClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(SKIP);
			setState(136);
			integerValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProjectionsContext extends ParserRuleContext {
		public RootPathContext rootPath() {
			return getRuleContext(RootPathContext.class,0);
		}
		public List<FieldPathContext> fieldPath() {
			return getRuleContexts(FieldPathContext.class);
		}
		public FieldPathContext fieldPath(int i) {
			return getRuleContext(FieldPathContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(NoSQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NoSQLParser.COMMA, i);
		}
		public List<AggregateTermContext> aggregateTerm() {
			return getRuleContexts(AggregateTermContext.class);
		}
		public AggregateTermContext aggregateTerm(int i) {
			return getRuleContext(AggregateTermContext.class,i);
		}
		public ProjectionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projections; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterProjections(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitProjections(this);
		}
	}

	public final ProjectionsContext projections() throws RecognitionException {
		ProjectionsContext _localctx = new ProjectionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_projections);
		int _la;
		try {
			setState(155);
			switch (_input.LA(1)) {
			case WILDCARD:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				rootPath();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				fieldPath();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(140);
					match(COMMA);
					setState(141);
					fieldPath();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				aggregateTerm();
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(148);
					match(COMMA);
					setState(149);
					aggregateTerm();
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NoSQLParser.IDENTIFIER, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RootPathContext extends ParserRuleContext {
		public TerminalNode WILDCARD() { return getToken(NoSQLParser.WILDCARD, 0); }
		public RootPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterRootPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitRootPath(this);
		}
	}

	public final RootPathContext rootPath() throws RecognitionException {
		RootPathContext _localctx = new RootPathContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rootPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(WILDCARD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NoSQLParser.IDENTIFIER, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldPathContext extends ParserRuleContext {
		public List<FieldNameContext> fieldName() {
			return getRuleContexts(FieldNameContext.class);
		}
		public FieldNameContext fieldName(int i) {
			return getRuleContext(FieldNameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(NoSQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(NoSQLParser.DOT, i);
		}
		public FieldPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterFieldPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitFieldPath(this);
		}
	}

	public final FieldPathContext fieldPath() throws RecognitionException {
		FieldPathContext _localctx = new FieldPathContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			fieldName();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(164);
				match(DOT);
				setState(165);
				fieldName();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateTermContext extends ParserRuleContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public MinContext min() {
			return getRuleContext(MinContext.class,0);
		}
		public MaxContext max() {
			return getRuleContext(MaxContext.class,0);
		}
		public AvgContext avg() {
			return getRuleContext(AvgContext.class,0);
		}
		public CountContext count() {
			return getRuleContext(CountContext.class,0);
		}
		public TerminalNode AS() { return getToken(NoSQLParser.AS, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public AggregateTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterAggregateTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitAggregateTerm(this);
		}
	}

	public final AggregateTermContext aggregateTerm() throws RecognitionException {
		AggregateTermContext _localctx = new AggregateTermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_aggregateTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			switch (_input.LA(1)) {
			case SUM:
				{
				setState(171);
				sum();
				}
				break;
			case MIN:
				{
				setState(172);
				min();
				}
				break;
			case MAX:
				{
				setState(173);
				max();
				}
				break;
			case AVG:
				{
				setState(174);
				avg();
				}
				break;
			case COUNT:
				{
				setState(175);
				count();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(180);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(178);
				match(AS);
				setState(179);
				alias();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(NoSQLParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(NoSQLParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(NoSQLParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(NoSQLParser.DIGIT, i);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(LETTER);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER || _la==DIGIT) {
				{
				{
				setState(183);
				_la = _input.LA(1);
				if ( !(_la==LETTER || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PredicateTermContext predicateTerm() {
			return getRuleContext(PredicateTermContext.class,0);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			predicateTerm();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(192);
				switch (_input.LA(1)) {
				case AND:
					{
					setState(190);
					and();
					}
					break;
				case OR:
					{
					setState(191);
					or();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateTermContext extends ParserRuleContext {
		public UnaryPredicateContext unaryPredicate() {
			return getRuleContext(UnaryPredicateContext.class,0);
		}
		public BinaryPredicateContext binaryPredicate() {
			return getRuleContext(BinaryPredicateContext.class,0);
		}
		public PredicateTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterPredicateTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitPredicateTerm(this);
		}
	}

	public final PredicateTermContext predicateTerm() throws RecognitionException {
		PredicateTermContext _localctx = new PredicateTermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_predicateTerm);
		try {
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				unaryPredicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				binaryPredicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryPredicateContext extends ParserRuleContext {
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public IsNullContext isNull() {
			return getRuleContext(IsNullContext.class,0);
		}
		public ExistsContext exists() {
			return getRuleContext(ExistsContext.class,0);
		}
		public UnaryPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterUnaryPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitUnaryPredicate(this);
		}
	}

	public final UnaryPredicateContext unaryPredicate() throws RecognitionException {
		UnaryPredicateContext _localctx = new UnaryPredicateContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unaryPredicate);
		try {
			setState(206);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				not();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				isNull();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				exists();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryPredicateContext extends ParserRuleContext {
		public EqualsContext equals() {
			return getRuleContext(EqualsContext.class,0);
		}
		public NotequalsContext notequals() {
			return getRuleContext(NotequalsContext.class,0);
		}
		public EqualsIgnoreCaseContext equalsIgnoreCase() {
			return getRuleContext(EqualsIgnoreCaseContext.class,0);
		}
		public GreaterContext greater() {
			return getRuleContext(GreaterContext.class,0);
		}
		public GreaterOrEqualContext greaterOrEqual() {
			return getRuleContext(GreaterOrEqualContext.class,0);
		}
		public LessContext less() {
			return getRuleContext(LessContext.class,0);
		}
		public LessOrEqualContext lessOrEqual() {
			return getRuleContext(LessOrEqualContext.class,0);
		}
		public LikeContext like() {
			return getRuleContext(LikeContext.class,0);
		}
		public BinaryPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterBinaryPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitBinaryPredicate(this);
		}
	}

	public final BinaryPredicateContext binaryPredicate() throws RecognitionException {
		BinaryPredicateContext _localctx = new BinaryPredicateContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_binaryPredicate);
		try {
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				equals();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				notequals();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				equalsIgnoreCase();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				greater();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				greaterOrEqual();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				less();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(214);
				lessOrEqual();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(215);
				like();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(NoSQLParser.AND, 0); }
		public PredicateTermContext predicateTerm() {
			return getRuleContext(PredicateTermContext.class,0);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitAnd(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(AND);
			setState(219);
			predicateTerm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(NoSQLParser.OR, 0); }
		public PredicateTermContext predicateTerm() {
			return getRuleContext(PredicateTermContext.class,0);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(OR);
			setState(222);
			predicateTerm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualsContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(NoSQLParser.EQUALS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public EqualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitEquals(this);
		}
	}

	public final EqualsContext equals() throws RecognitionException {
		EqualsContext _localctx = new EqualsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_equals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			fieldPath();
			setState(225);
			match(EQUALS);
			setState(228);
			switch (_input.LA(1)) {
			case DIGIT:
			case OPENSTRING:
				{
				setState(226);
				value();
				}
				break;
			case COLON:
				{
				setState(227);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotequalsContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode NOT_EQUALS() { return getToken(NoSQLParser.NOT_EQUALS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public NotequalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notequals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterNotequals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitNotequals(this);
		}
	}

	public final NotequalsContext notequals() throws RecognitionException {
		NotequalsContext _localctx = new NotequalsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_notequals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			fieldPath();
			setState(231);
			match(NOT_EQUALS);
			setState(234);
			switch (_input.LA(1)) {
			case DIGIT:
			case OPENSTRING:
				{
				setState(232);
				value();
				}
				break;
			case COLON:
				{
				setState(233);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualsIgnoreCaseContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode EQUALS_IGNORECASE() { return getToken(NoSQLParser.EQUALS_IGNORECASE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public EqualsIgnoreCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalsIgnoreCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterEqualsIgnoreCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitEqualsIgnoreCase(this);
		}
	}

	public final EqualsIgnoreCaseContext equalsIgnoreCase() throws RecognitionException {
		EqualsIgnoreCaseContext _localctx = new EqualsIgnoreCaseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_equalsIgnoreCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			fieldPath();
			setState(237);
			match(EQUALS_IGNORECASE);
			setState(240);
			switch (_input.LA(1)) {
			case DIGIT:
			case OPENSTRING:
				{
				setState(238);
				value();
				}
				break;
			case COLON:
				{
				setState(239);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GreaterContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(NoSQLParser.GREATER, 0); }
		public NumericValueContext numericValue() {
			return getRuleContext(NumericValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public GreaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greater; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterGreater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitGreater(this);
		}
	}

	public final GreaterContext greater() throws RecognitionException {
		GreaterContext _localctx = new GreaterContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_greater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			fieldPath();
			setState(243);
			match(GREATER);
			setState(246);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(244);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(245);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GreaterOrEqualContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode GREATER_OR_EQUAL() { return getToken(NoSQLParser.GREATER_OR_EQUAL, 0); }
		public NumericValueContext numericValue() {
			return getRuleContext(NumericValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public GreaterOrEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterOrEqual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterGreaterOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitGreaterOrEqual(this);
		}
	}

	public final GreaterOrEqualContext greaterOrEqual() throws RecognitionException {
		GreaterOrEqualContext _localctx = new GreaterOrEqualContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_greaterOrEqual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			fieldPath();
			setState(249);
			match(GREATER_OR_EQUAL);
			setState(252);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(250);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(251);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LessContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode LESS() { return getToken(NoSQLParser.LESS, 0); }
		public NumericValueContext numericValue() {
			return getRuleContext(NumericValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public LessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_less; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterLess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitLess(this);
		}
	}

	public final LessContext less() throws RecognitionException {
		LessContext _localctx = new LessContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_less);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			fieldPath();
			setState(255);
			match(LESS);
			setState(258);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(256);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(257);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LessOrEqualContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode LESS_OR_EQUAL() { return getToken(NoSQLParser.LESS_OR_EQUAL, 0); }
		public NumericValueContext numericValue() {
			return getRuleContext(NumericValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public LessOrEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessOrEqual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterLessOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitLessOrEqual(this);
		}
	}

	public final LessOrEqualContext lessOrEqual() throws RecognitionException {
		LessOrEqualContext _localctx = new LessOrEqualContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_lessOrEqual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			fieldPath();
			setState(261);
			match(LESS_OR_EQUAL);
			setState(264);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(262);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(263);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LikeContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(NoSQLParser.LIKE, 0); }
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public BindParamContext bindParam() {
			return getRuleContext(BindParamContext.class,0);
		}
		public LikeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_like; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitLike(this);
		}
	}

	public final LikeContext like() throws RecognitionException {
		LikeContext _localctx = new LikeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_like);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			fieldPath();
			setState(267);
			match(LIKE);
			setState(270);
			switch (_input.LA(1)) {
			case OPENSTRING:
				{
				setState(268);
				stringValue();
				}
				break;
			case COLON:
				{
				setState(269);
				bindParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(NoSQLParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(NoSQLParser.LPAREN, 0); }
		public PredicateTermContext predicateTerm() {
			return getRuleContext(PredicateTermContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NoSQLParser.RPAREN, 0); }
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitNot(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(NOT);
			setState(273);
			match(LPAREN);
			setState(274);
			predicateTerm();
			setState(275);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IsNullContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode IS_NULL() { return getToken(NoSQLParser.IS_NULL, 0); }
		public IsNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isNull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterIsNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitIsNull(this);
		}
	}

	public final IsNullContext isNull() throws RecognitionException {
		IsNullContext _localctx = new IsNullContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_isNull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			fieldPath();
			setState(278);
			match(IS_NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IsNotNullContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode IS_NOT_NULL() { return getToken(NoSQLParser.IS_NOT_NULL, 0); }
		public IsNotNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isNotNull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterIsNotNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitIsNotNull(this);
		}
	}

	public final IsNotNullContext isNotNull() throws RecognitionException {
		IsNotNullContext _localctx = new IsNotNullContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_isNotNull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			fieldPath();
			setState(281);
			match(IS_NOT_NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExistsContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(NoSQLParser.EXISTS, 0); }
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public ExistsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitExists(this);
		}
	}

	public final ExistsContext exists() throws RecognitionException {
		ExistsContext _localctx = new ExistsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(EXISTS);
			setState(284);
			fieldPath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumContext extends ParserRuleContext {
		public TerminalNode SUM() { return getToken(NoSQLParser.SUM, 0); }
		public TerminalNode LPAREN() { return getToken(NoSQLParser.LPAREN, 0); }
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NoSQLParser.RPAREN, 0); }
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitSum(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_sum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(SUM);
			setState(287);
			match(LPAREN);
			setState(288);
			fieldPath();
			setState(289);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinContext extends ParserRuleContext {
		public TerminalNode MIN() { return getToken(NoSQLParser.MIN, 0); }
		public TerminalNode LPAREN() { return getToken(NoSQLParser.LPAREN, 0); }
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NoSQLParser.RPAREN, 0); }
		public MinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitMin(this);
		}
	}

	public final MinContext min() throws RecognitionException {
		MinContext _localctx = new MinContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_min);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(MIN);
			setState(292);
			match(LPAREN);
			setState(293);
			fieldPath();
			setState(294);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaxContext extends ParserRuleContext {
		public TerminalNode MAX() { return getToken(NoSQLParser.MAX, 0); }
		public TerminalNode LPAREN() { return getToken(NoSQLParser.LPAREN, 0); }
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NoSQLParser.RPAREN, 0); }
		public MaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitMax(this);
		}
	}

	public final MaxContext max() throws RecognitionException {
		MaxContext _localctx = new MaxContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_max);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(MAX);
			setState(297);
			match(LPAREN);
			setState(298);
			fieldPath();
			setState(299);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CountContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(NoSQLParser.COUNT, 0); }
		public TerminalNode LPAREN() { return getToken(NoSQLParser.LPAREN, 0); }
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NoSQLParser.RPAREN, 0); }
		public CountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_count; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitCount(this);
		}
	}

	public final CountContext count() throws RecognitionException {
		CountContext _localctx = new CountContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_count);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(COUNT);
			setState(302);
			match(LPAREN);
			setState(303);
			fieldPath();
			setState(304);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AvgContext extends ParserRuleContext {
		public TerminalNode AVG() { return getToken(NoSQLParser.AVG, 0); }
		public TerminalNode LPAREN() { return getToken(NoSQLParser.LPAREN, 0); }
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NoSQLParser.RPAREN, 0); }
		public AvgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterAvg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitAvg(this);
		}
	}

	public final AvgContext avg() throws RecognitionException {
		AvgContext _localctx = new AvgContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_avg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(AVG);
			setState(307);
			match(LPAREN);
			setState(308);
			fieldPath();
			setState(309);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public NumericValueContext numericValue() {
			return getRuleContext(NumericValueContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_value);
		try {
			setState(313);
			switch (_input.LA(1)) {
			case OPENSTRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				stringValue();
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				numericValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringValueContext extends ParserRuleContext {
		public TerminalNode OPENSTRING() { return getToken(NoSQLParser.OPENSTRING, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(NoSQLParser.STRING_LITERAL, 0); }
		public TerminalNode CLOSESTRING() { return getToken(NoSQLParser.CLOSESTRING, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitStringValue(this);
		}
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_stringValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(OPENSTRING);
			setState(316);
			match(STRING_LITERAL);
			setState(317);
			match(CLOSESTRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericValueContext extends ParserRuleContext {
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public DecimalValueContext decimalValue() {
			return getRuleContext(DecimalValueContext.class,0);
		}
		public NumericValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterNumericValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitNumericValue(this);
		}
	}

	public final NumericValueContext numericValue() throws RecognitionException {
		NumericValueContext _localctx = new NumericValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_numericValue);
		try {
			setState(321);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				integerValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				decimalValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerValueContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(NoSQLParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(NoSQLParser.DIGIT, i);
		}
		public IntegerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterIntegerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitIntegerValue(this);
		}
	}

	public final IntegerValueContext integerValue() throws RecognitionException {
		IntegerValueContext _localctx = new IntegerValueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_integerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(323);
				match(DIGIT);
				}
				}
				setState(326); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecimalValueContext extends ParserRuleContext {
		public List<IntegerValueContext> integerValue() {
			return getRuleContexts(IntegerValueContext.class);
		}
		public IntegerValueContext integerValue(int i) {
			return getRuleContext(IntegerValueContext.class,i);
		}
		public TerminalNode DOT() { return getToken(NoSQLParser.DOT, 0); }
		public DecimalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterDecimalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitDecimalValue(this);
		}
	}

	public final DecimalValueContext decimalValue() throws RecognitionException {
		DecimalValueContext _localctx = new DecimalValueContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_decimalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			integerValue();
			setState(329);
			match(DOT);
			{
			setState(330);
			integerValue();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindParamContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(NoSQLParser.COLON, 0); }
		public ParamKeyContext paramKey() {
			return getRuleContext(ParamKeyContext.class,0);
		}
		public BindParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterBindParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitBindParam(this);
		}
	}

	public final BindParamContext bindParam() throws RecognitionException {
		BindParamContext _localctx = new BindParamContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_bindParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(COLON);
			setState(333);
			paramKey();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamKeyContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(NoSQLParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(NoSQLParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(NoSQLParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(NoSQLParser.DIGIT, i);
		}
		public ParamKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterParamKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitParamKey(this);
		}
	}

	public final ParamKeyContext paramKey() throws RecognitionException {
		ParamKeyContext _localctx = new ParamKeyContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_paramKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(LETTER);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER || _la==DIGIT) {
				{
				{
				setState(336);
				_la = _input.LA(1);
				if ( !(_la==LETTER || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderByTermContext extends ParserRuleContext {
		public FieldPathContext fieldPath() {
			return getRuleContext(FieldPathContext.class,0);
		}
		public AscContext asc() {
			return getRuleContext(AscContext.class,0);
		}
		public DescContext desc() {
			return getRuleContext(DescContext.class,0);
		}
		public OrderByTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterOrderByTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitOrderByTerm(this);
		}
	}

	public final OrderByTermContext orderByTerm() throws RecognitionException {
		OrderByTermContext _localctx = new OrderByTermContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_orderByTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			fieldPath();
			setState(345);
			switch (_input.LA(1)) {
			case ASC:
				{
				setState(343);
				asc();
				}
				break;
			case DESC:
				{
				setState(344);
				desc();
				}
				break;
			case EOF:
			case COMMA:
			case GROUP_BY:
			case LIMIT:
			case SKIP:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AscContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(NoSQLParser.ASC, 0); }
		public AscContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterAsc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitAsc(this);
		}
	}

	public final AscContext asc() throws RecognitionException {
		AscContext _localctx = new AscContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_asc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(ASC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescContext extends ParserRuleContext {
		public TerminalNode DESC() { return getToken(NoSQLParser.DESC, 0); }
		public DescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).enterDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NoSQLListener ) ((NoSQLListener)listener).exitDesc(this);
		}
	}

	public final DescContext desc() throws RecognitionException {
		DescContext _localctx = new DescContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(DESC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u0162\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\5\2c\n\2\3\2\5\2f\n\2\3\2\5\2"+
		"i\n\2\3\2\5\2l\n\2\3\2\5\2o\n\2\3\3\3\3\3\3\3\3\3\3\5\3v\n\3\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\7\5\177\n\5\f\5\16\5\u0082\13\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u0091\n\t\f\t\16\t\u0094\13\t\3\t"+
		"\3\t\3\t\7\t\u0099\n\t\f\t\16\t\u009c\13\t\5\t\u009e\n\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\7\r\u00a9\n\r\f\r\16\r\u00ac\13\r\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00b3\n\16\3\16\3\16\5\16\u00b7\n\16\3\17\3\17\7"+
		"\17\u00bb\n\17\f\17\16\17\u00be\13\17\3\20\3\20\3\20\5\20\u00c3\n\20\7"+
		"\20\u00c5\n\20\f\20\16\20\u00c8\13\20\3\21\3\21\5\21\u00cc\n\21\3\22\3"+
		"\22\3\22\5\22\u00d1\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00db\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00e7"+
		"\n\26\3\27\3\27\3\27\3\27\5\27\u00ed\n\27\3\30\3\30\3\30\3\30\5\30\u00f3"+
		"\n\30\3\31\3\31\3\31\3\31\5\31\u00f9\n\31\3\32\3\32\3\32\3\32\5\32\u00ff"+
		"\n\32\3\33\3\33\3\33\3\33\5\33\u0105\n\33\3\34\3\34\3\34\3\34\5\34\u010b"+
		"\n\34\3\35\3\35\3\35\3\35\5\35\u0111\n\35\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\5\'\u013c\n\'\3(\3(\3"+
		"(\3(\3)\3)\5)\u0144\n)\3*\6*\u0147\n*\r*\16*\u0148\3+\3+\3+\3+\3,\3,\3"+
		",\3-\3-\7-\u0154\n-\f-\16-\u0157\13-\3.\3.\3.\5.\u015c\n.\3/\3/\3\60\3"+
		"\60\3\60\2\2\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^\2\3\3\2\3\4\u015e\2`\3\2\2\2\4p\3\2\2\2\6"+
		"w\3\2\2\2\bz\3\2\2\2\n\u0083\3\2\2\2\f\u0086\3\2\2\2\16\u0089\3\2\2\2"+
		"\20\u009d\3\2\2\2\22\u009f\3\2\2\2\24\u00a1\3\2\2\2\26\u00a3\3\2\2\2\30"+
		"\u00a5\3\2\2\2\32\u00b2\3\2\2\2\34\u00b8\3\2\2\2\36\u00bf\3\2\2\2 \u00cb"+
		"\3\2\2\2\"\u00d0\3\2\2\2$\u00da\3\2\2\2&\u00dc\3\2\2\2(\u00df\3\2\2\2"+
		"*\u00e2\3\2\2\2,\u00e8\3\2\2\2.\u00ee\3\2\2\2\60\u00f4\3\2\2\2\62\u00fa"+
		"\3\2\2\2\64\u0100\3\2\2\2\66\u0106\3\2\2\28\u010c\3\2\2\2:\u0112\3\2\2"+
		"\2<\u0117\3\2\2\2>\u011a\3\2\2\2@\u011d\3\2\2\2B\u0120\3\2\2\2D\u0125"+
		"\3\2\2\2F\u012a\3\2\2\2H\u012f\3\2\2\2J\u0134\3\2\2\2L\u013b\3\2\2\2N"+
		"\u013d\3\2\2\2P\u0143\3\2\2\2R\u0146\3\2\2\2T\u014a\3\2\2\2V\u014e\3\2"+
		"\2\2X\u0151\3\2\2\2Z\u0158\3\2\2\2\\\u015d\3\2\2\2^\u015f\3\2\2\2`b\5"+
		"\4\3\2ac\5\6\4\2ba\3\2\2\2bc\3\2\2\2ce\3\2\2\2df\5\b\5\2ed\3\2\2\2ef\3"+
		"\2\2\2fh\3\2\2\2gi\5\n\6\2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jl\5\f\7\2kj\3"+
		"\2\2\2kl\3\2\2\2ln\3\2\2\2mo\5\16\b\2nm\3\2\2\2no\3\2\2\2o\3\3\2\2\2p"+
		"q\7\'\2\2qr\5\20\t\2rs\7\35\2\2su\5\22\n\2tv\5\34\17\2ut\3\2\2\2uv\3\2"+
		"\2\2v\5\3\2\2\2wx\7*\2\2xy\5\36\20\2y\7\3\2\2\2z{\7&\2\2{\u0080\5Z.\2"+
		"|}\7\n\2\2}\177\5Z.\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\t\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\36\2"+
		"\2\u0084\u0085\5\30\r\2\u0085\13\3\2\2\2\u0086\u0087\7!\2\2\u0087\u0088"+
		"\5R*\2\u0088\r\3\2\2\2\u0089\u008a\7(\2\2\u008a\u008b\5R*\2\u008b\17\3"+
		"\2\2\2\u008c\u009e\5\24\13\2\u008d\u0092\5\30\r\2\u008e\u008f\7\n\2\2"+
		"\u008f\u0091\5\30\r\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u009e\3\2\2\2\u0094\u0092\3\2\2\2\u0095"+
		"\u009a\5\32\16\2\u0096\u0097\7\n\2\2\u0097\u0099\5\32\16\2\u0098\u0096"+
		"\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u008c\3\2\2\2\u009d\u008d\3\2"+
		"\2\2\u009d\u0095\3\2\2\2\u009e\21\3\2\2\2\u009f\u00a0\7+\2\2\u00a0\23"+
		"\3\2\2\2\u00a1\u00a2\7\6\2\2\u00a2\25\3\2\2\2\u00a3\u00a4\7+\2\2\u00a4"+
		"\27\3\2\2\2\u00a5\u00aa\5\26\f\2\u00a6\u00a7\7\13\2\2\u00a7\u00a9\5\26"+
		"\f\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\31\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b3\5B\"\2"+
		"\u00ae\u00b3\5D#\2\u00af\u00b3\5F$\2\u00b0\u00b3\5J&\2\u00b1\u00b3\5H"+
		"%\2\u00b2\u00ad\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b5\7\27"+
		"\2\2\u00b5\u00b7\5\34\17\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\33\3\2\2\2\u00b8\u00bc\7\3\2\2\u00b9\u00bb\t\2\2\2\u00ba\u00b9\3\2\2"+
		"\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\35"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c6\5 \21\2\u00c0\u00c3\5&\24\2\u00c1"+
		"\u00c3\5(\25\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c5\3\2"+
		"\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\37\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\5\"\22"+
		"\2\u00ca\u00cc\5$\23\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc!"+
		"\3\2\2\2\u00cd\u00d1\5:\36\2\u00ce\u00d1\5<\37\2\u00cf\u00d1\5@!\2\u00d0"+
		"\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1#\3\2\2\2"+
		"\u00d2\u00db\5*\26\2\u00d3\u00db\5,\27\2\u00d4\u00db\5.\30\2\u00d5\u00db"+
		"\5\60\31\2\u00d6\u00db\5\62\32\2\u00d7\u00db\5\64\33\2\u00d8\u00db\5\66"+
		"\34\2\u00d9\u00db\58\35\2\u00da\u00d2\3\2\2\2\u00da\u00d3\3\2\2\2\u00da"+
		"\u00d4\3\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db%\3\2\2\2\u00dc\u00dd"+
		"\7\26\2\2\u00dd\u00de\5 \21\2\u00de\'\3\2\2\2\u00df\u00e0\7%\2\2\u00e0"+
		"\u00e1\5 \21\2\u00e1)\3\2\2\2\u00e2\u00e3\5\30\r\2\u00e3\u00e6\7\16\2"+
		"\2\u00e4\u00e7\5L\'\2\u00e5\u00e7\5V,\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5"+
		"\3\2\2\2\u00e7+\3\2\2\2\u00e8\u00e9\5\30\r\2\u00e9\u00ec\7\17\2\2\u00ea"+
		"\u00ed\5L\'\2\u00eb\u00ed\5V,\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2"+
		"\2\u00ed-\3\2\2\2\u00ee\u00ef\5\30\r\2\u00ef\u00f2\7\20\2\2\u00f0\u00f3"+
		"\5L\'\2\u00f1\u00f3\5V,\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"/\3\2\2\2\u00f4\u00f5\5\30\r\2\u00f5\u00f8\7\21\2\2\u00f6\u00f9\5P)\2"+
		"\u00f7\u00f9\5V,\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\61\3"+
		"\2\2\2\u00fa\u00fb\5\30\r\2\u00fb\u00fe\7\22\2\2\u00fc\u00ff\5P)\2\u00fd"+
		"\u00ff\5V,\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\63\3\2\2\2"+
		"\u0100\u0101\5\30\r\2\u0101\u0104\7\23\2\2\u0102\u0105\5P)\2\u0103\u0105"+
		"\5V,\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\65\3\2\2\2\u0106"+
		"\u0107\5\30\r\2\u0107\u010a\7\24\2\2\u0108\u010b\5P)\2\u0109\u010b\5V"+
		",\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\67\3\2\2\2\u010c\u010d"+
		"\5\30\r\2\u010d\u0110\7\25\2\2\u010e\u0111\5N(\2\u010f\u0111\5V,\2\u0110"+
		"\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u01119\3\2\2\2\u0112\u0113\7$\2\2\u0113"+
		"\u0114\7\f\2\2\u0114\u0115\5 \21\2\u0115\u0116\7\r\2\2\u0116;\3\2\2\2"+
		"\u0117\u0118\5\30\r\2\u0118\u0119\7\37\2\2\u0119=\3\2\2\2\u011a\u011b"+
		"\5\30\r\2\u011b\u011c\7 \2\2\u011c?\3\2\2\2\u011d\u011e\7\34\2\2\u011e"+
		"\u011f\5\30\r\2\u011fA\3\2\2\2\u0120\u0121\7)\2\2\u0121\u0122\7\f\2\2"+
		"\u0122\u0123\5\30\r\2\u0123\u0124\7\r\2\2\u0124C\3\2\2\2\u0125\u0126\7"+
		"#\2\2\u0126\u0127\7\f\2\2\u0127\u0128\5\30\r\2\u0128\u0129\7\r\2\2\u0129"+
		"E\3\2\2\2\u012a\u012b\7\"\2\2\u012b\u012c\7\f\2\2\u012c\u012d\5\30\r\2"+
		"\u012d\u012e\7\r\2\2\u012eG\3\2\2\2\u012f\u0130\7\32\2\2\u0130\u0131\7"+
		"\f\2\2\u0131\u0132\5\30\r\2\u0132\u0133\7\r\2\2\u0133I\3\2\2\2\u0134\u0135"+
		"\7\31\2\2\u0135\u0136\7\f\2\2\u0136\u0137\5\30\r\2\u0137\u0138\7\r\2\2"+
		"\u0138K\3\2\2\2\u0139\u013c\5N(\2\u013a\u013c\5P)\2\u013b\u0139\3\2\2"+
		"\2\u013b\u013a\3\2\2\2\u013cM\3\2\2\2\u013d\u013e\7-\2\2\u013e\u013f\7"+
		".\2\2\u013f\u0140\7/\2\2\u0140O\3\2\2\2\u0141\u0144\5R*\2\u0142\u0144"+
		"\5T+\2\u0143\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144Q\3\2\2\2\u0145\u0147"+
		"\7\4\2\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149S\3\2\2\2\u014a\u014b\5R*\2\u014b\u014c\7\13\2\2\u014c"+
		"\u014d\5R*\2\u014dU\3\2\2\2\u014e\u014f\7\t\2\2\u014f\u0150\5X-\2\u0150"+
		"W\3\2\2\2\u0151\u0155\7\3\2\2\u0152\u0154\t\2\2\2\u0153\u0152\3\2\2\2"+
		"\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156Y\3"+
		"\2\2\2\u0157\u0155\3\2\2\2\u0158\u015b\5\30\r\2\u0159\u015c\5\\/\2\u015a"+
		"\u015c\5^\60\2\u015b\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c[\3\2\2\2\u015d\u015e\7\30\2\2\u015e]\3\2\2\2\u015f\u0160\7"+
		"\33\2\2\u0160_\3\2\2\2\"behknu\u0080\u0092\u009a\u009d\u00aa\u00b2\u00b6"+
		"\u00bc\u00c2\u00c6\u00cb\u00d0\u00da\u00e6\u00ec\u00f2\u00f8\u00fe\u0104"+
		"\u010a\u0110\u013b\u0143\u0148\u0155\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}