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
		COLON=7, COMMA=8, DOT=9, LPAREN=10, RPAREN=11, EQUALS=12, EQUALS_IGNORECASE=13, 
		GREATER=14, GREATER_OR_EQUAL=15, LESS=16, LESS_OR_EQUAL=17, LIKE=18, AND=19, 
		AS=20, ASC=21, AVG=22, COUNT=23, DESC=24, EXISTS=25, FROM=26, GROUP_BY=27, 
		IS_NULL=28, IS_NOT_NULL=29, LIMIT=30, MAX=31, MIN=32, NOT=33, OR=34, ORDER_BY=35, 
		SELECT=36, SKIP=37, SUM=38, WHERE=39, WS=40, OPENSTRING=41, STRING_LITERAL=42, 
		CLOSESTRING=43;
	public static final int
		RULE_selectStatement = 0, RULE_selectClause = 1, RULE_whereClause = 2, 
		RULE_orderByClause = 3, RULE_groupByClause = 4, RULE_limitClause = 5, 
		RULE_skipClause = 6, RULE_projections = 7, RULE_typeName = 8, RULE_rootPath = 9, 
		RULE_fieldName = 10, RULE_fieldPath = 11, RULE_aggregateTerm = 12, RULE_alias = 13, 
		RULE_predicate = 14, RULE_predicateTerm = 15, RULE_unaryPredicate = 16, 
		RULE_binaryPredicate = 17, RULE_and = 18, RULE_or = 19, RULE_equals = 20, 
		RULE_equalsIgnoreCase = 21, RULE_greater = 22, RULE_greaterOrEqual = 23, 
		RULE_less = 24, RULE_lessOrEqual = 25, RULE_like = 26, RULE_not = 27, 
		RULE_isNull = 28, RULE_isNotNull = 29, RULE_exists = 30, RULE_sum = 31, 
		RULE_min = 32, RULE_max = 33, RULE_count = 34, RULE_avg = 35, RULE_value = 36, 
		RULE_stringValue = 37, RULE_numericValue = 38, RULE_integerValue = 39, 
		RULE_decimalValue = 40, RULE_bindParam = 41, RULE_paramKey = 42, RULE_orderByTerm = 43, 
		RULE_asc = 44, RULE_desc = 45;
	public static final String[] ruleNames = {
		"selectStatement", "selectClause", "whereClause", "orderByClause", "groupByClause", 
		"limitClause", "skipClause", "projections", "typeName", "rootPath", "fieldName", 
		"fieldPath", "aggregateTerm", "alias", "predicate", "predicateTerm", "unaryPredicate", 
		"binaryPredicate", "and", "or", "equals", "equalsIgnoreCase", "greater", 
		"greaterOrEqual", "less", "lessOrEqual", "like", "not", "isNull", "isNotNull", 
		"exists", "sum", "min", "max", "count", "avg", "value", "stringValue", 
		"numericValue", "integerValue", "decimalValue", "bindParam", "paramKey", 
		"orderByTerm", "asc", "desc"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'_'", "'*'", "'\"'", "'\\'", "':'", "','", "'.'", "'('", 
		"')'", "'='", "'~='", "'>'", "'>='", "'<'", "'<='", "'LIKE'", null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LETTER", "DIGIT", "UNDERSCORE", "WILDCARD", "DOUBLEQUOTE", "BACKSLASH", 
		"COLON", "COMMA", "DOT", "LPAREN", "RPAREN", "EQUALS", "EQUALS_IGNORECASE", 
		"GREATER", "GREATER_OR_EQUAL", "LESS", "LESS_OR_EQUAL", "LIKE", "AND", 
		"AS", "ASC", "AVG", "COUNT", "DESC", "EXISTS", "FROM", "GROUP_BY", "IS_NULL", 
		"IS_NOT_NULL", "LIMIT", "MAX", "MIN", "NOT", "OR", "ORDER_BY", "SELECT", 
		"SKIP", "SUM", "WHERE", "WS", "OPENSTRING", "STRING_LITERAL", "CLOSESTRING"
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
			setState(92);
			selectClause();
			setState(94);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(93);
				whereClause();
				}
			}

			setState(97);
			_la = _input.LA(1);
			if (_la==ORDER_BY) {
				{
				setState(96);
				orderByClause();
				}
			}

			setState(100);
			_la = _input.LA(1);
			if (_la==GROUP_BY) {
				{
				setState(99);
				groupByClause();
				}
			}

			setState(103);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(102);
				limitClause();
				}
			}

			setState(106);
			_la = _input.LA(1);
			if (_la==SKIP) {
				{
				setState(105);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(SELECT);
			setState(109);
			projections();
			setState(110);
			match(FROM);
			setState(111);
			typeName();
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
			setState(113);
			match(WHERE);
			setState(114);
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
			setState(116);
			match(ORDER_BY);
			setState(117);
			orderByTerm();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(118);
				match(COMMA);
				setState(119);
				orderByTerm();
				}
				}
				setState(124);
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
			setState(125);
			match(GROUP_BY);
			setState(126);
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
			setState(128);
			match(LIMIT);
			setState(129);
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
			setState(131);
			match(SKIP);
			setState(132);
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
			setState(151);
			switch (_input.LA(1)) {
			case WILDCARD:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				rootPath();
				}
				break;
			case LETTER:
			case UNDERSCORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				fieldPath();
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(136);
					match(COMMA);
					setState(137);
					fieldPath();
					}
					}
					setState(142);
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
				setState(143);
				aggregateTerm();
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(144);
					match(COMMA);
					setState(145);
					aggregateTerm();
					}
					}
					setState(150);
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
		public List<TerminalNode> LETTER() { return getTokens(NoSQLParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(NoSQLParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(NoSQLParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(NoSQLParser.DIGIT, i);
		}
		public List<TerminalNode> UNDERSCORE() { return getTokens(NoSQLParser.UNDERSCORE); }
		public TerminalNode UNDERSCORE(int i) {
			return getToken(NoSQLParser.UNDERSCORE, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(LETTER);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << DIGIT) | (1L << UNDERSCORE))) != 0)) {
				{
				{
				setState(154);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << DIGIT) | (1L << UNDERSCORE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(159);
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
			setState(160);
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
		public List<TerminalNode> LETTER() { return getTokens(NoSQLParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(NoSQLParser.LETTER, i);
		}
		public List<TerminalNode> UNDERSCORE() { return getTokens(NoSQLParser.UNDERSCORE); }
		public TerminalNode UNDERSCORE(int i) {
			return getToken(NoSQLParser.UNDERSCORE, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(NoSQLParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(NoSQLParser.DIGIT, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==LETTER || _la==UNDERSCORE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << DIGIT) | (1L << UNDERSCORE))) != 0)) {
				{
				{
				setState(163);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << DIGIT) | (1L << UNDERSCORE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(168);
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
			setState(169);
			fieldName();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(170);
				match(DOT);
				setState(171);
				fieldName();
				}
				}
				setState(176);
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
			setState(182);
			switch (_input.LA(1)) {
			case SUM:
				{
				setState(177);
				sum();
				}
				break;
			case MIN:
				{
				setState(178);
				min();
				}
				break;
			case MAX:
				{
				setState(179);
				max();
				}
				break;
			case AVG:
				{
				setState(180);
				avg();
				}
				break;
			case COUNT:
				{
				setState(181);
				count();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(186);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(184);
				match(AS);
				setState(185);
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
			setState(188);
			match(LETTER);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER || _la==DIGIT) {
				{
				{
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==LETTER || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(194);
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
			setState(195);
			predicateTerm();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(198);
				switch (_input.LA(1)) {
				case AND:
					{
					setState(196);
					and();
					}
					break;
				case OR:
					{
					setState(197);
					or();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(204);
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
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				unaryPredicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
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
			setState(212);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				not();
				}
				break;
			case LETTER:
			case UNDERSCORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				isNull();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
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
			setState(221);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				equals();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				equalsIgnoreCase();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				greater();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				greaterOrEqual();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(218);
				less();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(219);
				lessOrEqual();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(220);
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
			setState(223);
			match(AND);
			setState(224);
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
			setState(226);
			match(OR);
			setState(227);
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
			setState(229);
			fieldPath();
			setState(230);
			match(EQUALS);
			setState(233);
			switch (_input.LA(1)) {
			case DIGIT:
			case OPENSTRING:
				{
				setState(231);
				value();
				}
				break;
			case COLON:
				{
				setState(232);
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
		enterRule(_localctx, 42, RULE_equalsIgnoreCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			fieldPath();
			setState(236);
			match(EQUALS_IGNORECASE);
			setState(239);
			switch (_input.LA(1)) {
			case DIGIT:
			case OPENSTRING:
				{
				setState(237);
				value();
				}
				break;
			case COLON:
				{
				setState(238);
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
		enterRule(_localctx, 44, RULE_greater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			fieldPath();
			setState(242);
			match(GREATER);
			setState(245);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(243);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(244);
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
		enterRule(_localctx, 46, RULE_greaterOrEqual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			fieldPath();
			setState(248);
			match(GREATER_OR_EQUAL);
			setState(251);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(249);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(250);
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
		enterRule(_localctx, 48, RULE_less);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			fieldPath();
			setState(254);
			match(LESS);
			setState(257);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(255);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(256);
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
		enterRule(_localctx, 50, RULE_lessOrEqual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			fieldPath();
			setState(260);
			match(LESS_OR_EQUAL);
			setState(263);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(261);
				numericValue();
				}
				break;
			case COLON:
				{
				setState(262);
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
		enterRule(_localctx, 52, RULE_like);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			fieldPath();
			setState(266);
			match(LIKE);
			setState(269);
			switch (_input.LA(1)) {
			case OPENSTRING:
				{
				setState(267);
				stringValue();
				}
				break;
			case COLON:
				{
				setState(268);
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
		enterRule(_localctx, 54, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(NOT);
			setState(272);
			match(LPAREN);
			setState(273);
			predicateTerm();
			setState(274);
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
		enterRule(_localctx, 56, RULE_isNull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			fieldPath();
			setState(277);
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
		enterRule(_localctx, 58, RULE_isNotNull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			fieldPath();
			setState(280);
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
		enterRule(_localctx, 60, RULE_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(EXISTS);
			setState(283);
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
		enterRule(_localctx, 62, RULE_sum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(SUM);
			setState(286);
			match(LPAREN);
			setState(287);
			fieldPath();
			setState(288);
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
		enterRule(_localctx, 64, RULE_min);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(MIN);
			setState(291);
			match(LPAREN);
			setState(292);
			fieldPath();
			setState(293);
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
		enterRule(_localctx, 66, RULE_max);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(MAX);
			setState(296);
			match(LPAREN);
			setState(297);
			fieldPath();
			setState(298);
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
		enterRule(_localctx, 68, RULE_count);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(COUNT);
			setState(301);
			match(LPAREN);
			setState(302);
			fieldPath();
			setState(303);
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
		enterRule(_localctx, 70, RULE_avg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(AVG);
			setState(306);
			match(LPAREN);
			setState(307);
			fieldPath();
			setState(308);
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
		enterRule(_localctx, 72, RULE_value);
		try {
			setState(312);
			switch (_input.LA(1)) {
			case OPENSTRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				stringValue();
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
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
		enterRule(_localctx, 74, RULE_stringValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(OPENSTRING);
			setState(315);
			match(STRING_LITERAL);
			setState(316);
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
		enterRule(_localctx, 76, RULE_numericValue);
		try {
			setState(320);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				integerValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
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
		enterRule(_localctx, 78, RULE_integerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(322);
				match(DIGIT);
				}
				}
				setState(325); 
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
		enterRule(_localctx, 80, RULE_decimalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			integerValue();
			setState(328);
			match(DOT);
			{
			setState(329);
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
		enterRule(_localctx, 82, RULE_bindParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(COLON);
			setState(332);
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
		enterRule(_localctx, 84, RULE_paramKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(LETTER);
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER || _la==DIGIT) {
				{
				{
				setState(335);
				_la = _input.LA(1);
				if ( !(_la==LETTER || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(340);
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
		enterRule(_localctx, 86, RULE_orderByTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			fieldPath();
			setState(344);
			switch (_input.LA(1)) {
			case ASC:
				{
				setState(342);
				asc();
				}
				break;
			case DESC:
				{
				setState(343);
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
		enterRule(_localctx, 88, RULE_asc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
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
		enterRule(_localctx, 90, RULE_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u0161\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\5\2a\n\2\3\2\5\2d\n\2\3\2\5\2g\n\2\3\2"+
		"\5\2j\n\2\3\2\5\2m\n\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\7\5{\n\5\f\5\16\5~\13\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\7\t\u008d\n\t\f\t\16\t\u0090\13\t\3\t\3\t\3\t\7\t\u0095\n\t\f\t"+
		"\16\t\u0098\13\t\5\t\u009a\n\t\3\n\3\n\7\n\u009e\n\n\f\n\16\n\u00a1\13"+
		"\n\3\13\3\13\3\f\3\f\7\f\u00a7\n\f\f\f\16\f\u00aa\13\f\3\r\3\r\3\r\7\r"+
		"\u00af\n\r\f\r\16\r\u00b2\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u00b9\n\16"+
		"\3\16\3\16\5\16\u00bd\n\16\3\17\3\17\7\17\u00c1\n\17\f\17\16\17\u00c4"+
		"\13\17\3\20\3\20\3\20\5\20\u00c9\n\20\7\20\u00cb\n\20\f\20\16\20\u00ce"+
		"\13\20\3\21\3\21\5\21\u00d2\n\21\3\22\3\22\3\22\5\22\u00d7\n\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e0\n\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\5\26\u00ec\n\26\3\27\3\27\3\27\3\27\5\27\u00f2"+
		"\n\27\3\30\3\30\3\30\3\30\5\30\u00f8\n\30\3\31\3\31\3\31\3\31\5\31\u00fe"+
		"\n\31\3\32\3\32\3\32\3\32\5\32\u0104\n\32\3\33\3\33\3\33\3\33\5\33\u010a"+
		"\n\33\3\34\3\34\3\34\3\34\5\34\u0110\n\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\5&\u013b\n&\3\'\3"+
		"\'\3\'\3\'\3(\3(\5(\u0143\n(\3)\6)\u0146\n)\r)\16)\u0147\3*\3*\3*\3*\3"+
		"+\3+\3+\3,\3,\7,\u0153\n,\f,\16,\u0156\13,\3-\3-\3-\5-\u015b\n-\3.\3."+
		"\3/\3/\3/\2\2\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\\2\5\3\2\3\5\4\2\3\3\5\5\3\2\3\4\u015d\2^\3"+
		"\2\2\2\4n\3\2\2\2\6s\3\2\2\2\bv\3\2\2\2\n\177\3\2\2\2\f\u0082\3\2\2\2"+
		"\16\u0085\3\2\2\2\20\u0099\3\2\2\2\22\u009b\3\2\2\2\24\u00a2\3\2\2\2\26"+
		"\u00a4\3\2\2\2\30\u00ab\3\2\2\2\32\u00b8\3\2\2\2\34\u00be\3\2\2\2\36\u00c5"+
		"\3\2\2\2 \u00d1\3\2\2\2\"\u00d6\3\2\2\2$\u00df\3\2\2\2&\u00e1\3\2\2\2"+
		"(\u00e4\3\2\2\2*\u00e7\3\2\2\2,\u00ed\3\2\2\2.\u00f3\3\2\2\2\60\u00f9"+
		"\3\2\2\2\62\u00ff\3\2\2\2\64\u0105\3\2\2\2\66\u010b\3\2\2\28\u0111\3\2"+
		"\2\2:\u0116\3\2\2\2<\u0119\3\2\2\2>\u011c\3\2\2\2@\u011f\3\2\2\2B\u0124"+
		"\3\2\2\2D\u0129\3\2\2\2F\u012e\3\2\2\2H\u0133\3\2\2\2J\u013a\3\2\2\2L"+
		"\u013c\3\2\2\2N\u0142\3\2\2\2P\u0145\3\2\2\2R\u0149\3\2\2\2T\u014d\3\2"+
		"\2\2V\u0150\3\2\2\2X\u0157\3\2\2\2Z\u015c\3\2\2\2\\\u015e\3\2\2\2^`\5"+
		"\4\3\2_a\5\6\4\2`_\3\2\2\2`a\3\2\2\2ac\3\2\2\2bd\5\b\5\2cb\3\2\2\2cd\3"+
		"\2\2\2df\3\2\2\2eg\5\n\6\2fe\3\2\2\2fg\3\2\2\2gi\3\2\2\2hj\5\f\7\2ih\3"+
		"\2\2\2ij\3\2\2\2jl\3\2\2\2km\5\16\b\2lk\3\2\2\2lm\3\2\2\2m\3\3\2\2\2n"+
		"o\7&\2\2op\5\20\t\2pq\7\34\2\2qr\5\22\n\2r\5\3\2\2\2st\7)\2\2tu\5\36\20"+
		"\2u\7\3\2\2\2vw\7%\2\2w|\5X-\2xy\7\n\2\2y{\5X-\2zx\3\2\2\2{~\3\2\2\2|"+
		"z\3\2\2\2|}\3\2\2\2}\t\3\2\2\2~|\3\2\2\2\177\u0080\7\35\2\2\u0080\u0081"+
		"\5\30\r\2\u0081\13\3\2\2\2\u0082\u0083\7 \2\2\u0083\u0084\5P)\2\u0084"+
		"\r\3\2\2\2\u0085\u0086\7\'\2\2\u0086\u0087\5P)\2\u0087\17\3\2\2\2\u0088"+
		"\u009a\5\24\13\2\u0089\u008e\5\30\r\2\u008a\u008b\7\n\2\2\u008b\u008d"+
		"\5\30\r\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u009a\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0096"+
		"\5\32\16\2\u0092\u0093\7\n\2\2\u0093\u0095\5\32\16\2\u0094\u0092\3\2\2"+
		"\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009a"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u0088\3\2\2\2\u0099\u0089\3\2\2\2\u0099"+
		"\u0091\3\2\2\2\u009a\21\3\2\2\2\u009b\u009f\7\3\2\2\u009c\u009e\t\2\2"+
		"\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\23\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\6\2\2\u00a3"+
		"\25\3\2\2\2\u00a4\u00a8\t\3\2\2\u00a5\u00a7\t\2\2\2\u00a6\u00a5\3\2\2"+
		"\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\27"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00b0\5\26\f\2\u00ac\u00ad\7\13\2\2"+
		"\u00ad\u00af\5\26\f\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\31\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b9\5@!\2\u00b4\u00b9\5B\"\2\u00b5\u00b9\5D#\2\u00b6\u00b9\5H%\2\u00b7"+
		"\u00b9\5F$\2\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b5\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00bb"+
		"\7\26\2\2\u00bb\u00bd\5\34\17\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2"+
		"\2\u00bd\33\3\2\2\2\u00be\u00c2\7\3\2\2\u00bf\u00c1\t\4\2\2\u00c0\u00bf"+
		"\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\35\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00cc\5 \21\2\u00c6\u00c9\5&\24"+
		"\2\u00c7\u00c9\5(\25\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cb"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\37\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\5\"\22"+
		"\2\u00d0\u00d2\5$\23\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2!"+
		"\3\2\2\2\u00d3\u00d7\58\35\2\u00d4\u00d7\5:\36\2\u00d5\u00d7\5> \2\u00d6"+
		"\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7#\3\2\2\2"+
		"\u00d8\u00e0\5*\26\2\u00d9\u00e0\5,\27\2\u00da\u00e0\5.\30\2\u00db\u00e0"+
		"\5\60\31\2\u00dc\u00e0\5\62\32\2\u00dd\u00e0\5\64\33\2\u00de\u00e0\5\66"+
		"\34\2\u00df\u00d8\3\2\2\2\u00df\u00d9\3\2\2\2\u00df\u00da\3\2\2\2\u00df"+
		"\u00db\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2"+
		"\2\2\u00e0%\3\2\2\2\u00e1\u00e2\7\25\2\2\u00e2\u00e3\5 \21\2\u00e3\'\3"+
		"\2\2\2\u00e4\u00e5\7$\2\2\u00e5\u00e6\5 \21\2\u00e6)\3\2\2\2\u00e7\u00e8"+
		"\5\30\r\2\u00e8\u00eb\7\16\2\2\u00e9\u00ec\5J&\2\u00ea\u00ec\5T+\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec+\3\2\2\2\u00ed\u00ee\5\30\r\2"+
		"\u00ee\u00f1\7\17\2\2\u00ef\u00f2\5J&\2\u00f0\u00f2\5T+\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2-\3\2\2\2\u00f3\u00f4\5\30\r\2\u00f4"+
		"\u00f7\7\20\2\2\u00f5\u00f8\5N(\2\u00f6\u00f8\5T+\2\u00f7\u00f5\3\2\2"+
		"\2\u00f7\u00f6\3\2\2\2\u00f8/\3\2\2\2\u00f9\u00fa\5\30\r\2\u00fa\u00fd"+
		"\7\21\2\2\u00fb\u00fe\5N(\2\u00fc\u00fe\5T+\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fe\61\3\2\2\2\u00ff\u0100\5\30\r\2\u0100\u0103\7\22"+
		"\2\2\u0101\u0104\5N(\2\u0102\u0104\5T+\2\u0103\u0101\3\2\2\2\u0103\u0102"+
		"\3\2\2\2\u0104\63\3\2\2\2\u0105\u0106\5\30\r\2\u0106\u0109\7\23\2\2\u0107"+
		"\u010a\5N(\2\u0108\u010a\5T+\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2"+
		"\u010a\65\3\2\2\2\u010b\u010c\5\30\r\2\u010c\u010f\7\24\2\2\u010d\u0110"+
		"\5L\'\2\u010e\u0110\5T+\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110"+
		"\67\3\2\2\2\u0111\u0112\7#\2\2\u0112\u0113\7\f\2\2\u0113\u0114\5 \21\2"+
		"\u0114\u0115\7\r\2\2\u01159\3\2\2\2\u0116\u0117\5\30\r\2\u0117\u0118\7"+
		"\36\2\2\u0118;\3\2\2\2\u0119\u011a\5\30\r\2\u011a\u011b\7\37\2\2\u011b"+
		"=\3\2\2\2\u011c\u011d\7\33\2\2\u011d\u011e\5\30\r\2\u011e?\3\2\2\2\u011f"+
		"\u0120\7(\2\2\u0120\u0121\7\f\2\2\u0121\u0122\5\30\r\2\u0122\u0123\7\r"+
		"\2\2\u0123A\3\2\2\2\u0124\u0125\7\"\2\2\u0125\u0126\7\f\2\2\u0126\u0127"+
		"\5\30\r\2\u0127\u0128\7\r\2\2\u0128C\3\2\2\2\u0129\u012a\7!\2\2\u012a"+
		"\u012b\7\f\2\2\u012b\u012c\5\30\r\2\u012c\u012d\7\r\2\2\u012dE\3\2\2\2"+
		"\u012e\u012f\7\31\2\2\u012f\u0130\7\f\2\2\u0130\u0131\5\30\r\2\u0131\u0132"+
		"\7\r\2\2\u0132G\3\2\2\2\u0133\u0134\7\30\2\2\u0134\u0135\7\f\2\2\u0135"+
		"\u0136\5\30\r\2\u0136\u0137\7\r\2\2\u0137I\3\2\2\2\u0138\u013b\5L\'\2"+
		"\u0139\u013b\5N(\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013bK\3\2"+
		"\2\2\u013c\u013d\7+\2\2\u013d\u013e\7,\2\2\u013e\u013f\7-\2\2\u013fM\3"+
		"\2\2\2\u0140\u0143\5P)\2\u0141\u0143\5R*\2\u0142\u0140\3\2\2\2\u0142\u0141"+
		"\3\2\2\2\u0143O\3\2\2\2\u0144\u0146\7\4\2\2\u0145\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148Q\3\2\2\2"+
		"\u0149\u014a\5P)\2\u014a\u014b\7\13\2\2\u014b\u014c\5P)\2\u014cS\3\2\2"+
		"\2\u014d\u014e\7\t\2\2\u014e\u014f\5V,\2\u014fU\3\2\2\2\u0150\u0154\7"+
		"\3\2\2\u0151\u0153\t\4\2\2\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155W\3\2\2\2\u0156\u0154\3\2\2\2"+
		"\u0157\u015a\5\30\r\2\u0158\u015b\5Z.\2\u0159\u015b\5\\/\2\u015a\u0158"+
		"\3\2\2\2\u015a\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015bY\3\2\2\2\u015c"+
		"\u015d\7\27\2\2\u015d[\3\2\2\2\u015e\u015f\7\32\2\2\u015f]\3\2\2\2\"`"+
		"cfil|\u008e\u0096\u0099\u009f\u00a8\u00b0\u00b8\u00bc\u00c2\u00c8\u00cc"+
		"\u00d1\u00d6\u00df\u00eb\u00f1\u00f7\u00fd\u0103\u0109\u010f\u013a\u0142"+
		"\u0147\u0154\u015a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}