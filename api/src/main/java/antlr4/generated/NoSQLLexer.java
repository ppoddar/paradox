// Generated from NoSQLLexer.g4 by ANTLR 4.5

package antlr4.generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NoSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		UNDERSCORE=1, WILDCARD=2, DOUBLEQUOTE=3, BACKSLASH=4, COLON=5, COMMA=6, 
		DOT=7, LPAREN=8, RPAREN=9, EQUALS=10, NOT_EQUALS=11, EQUALS_IGNORECASE=12, 
		GREATER=13, GREATER_OR_EQUAL=14, LESS=15, LESS_OR_EQUAL=16, LIKE=17, AND=18, 
		AS=19, ASC=20, AVG=21, COUNT=22, DESC=23, EXISTS=24, FROM=25, BY=26, IS=27, 
		NULL=28, GROUP_BY=29, IS_NULL=30, IS_NOT_NULL=31, LIMIT=32, MAX=33, MIN=34, 
		NOT=35, OR=36, ORDER_BY=37, SELECT=38, SKIP=39, SUM=40, WHERE=41, IDENTIFIER=42, 
		LETTER=43, DIGIT=44, WS=45, OPENSTRING=46, STRING_LITERAL=47, CLOSESTRING=48;
	public static final int STRINGMODE = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "STRINGMODE"
	};

	public static final String[] ruleNames = {
		"UNDERSCORE", "WILDCARD", "DOUBLEQUOTE", "BACKSLASH", "COLON", "COMMA", 
		"DOT", "LPAREN", "RPAREN", "EQUALS", "NOT_EQUALS", "EQUALS_IGNORECASE", 
		"GREATER", "GREATER_OR_EQUAL", "LESS", "LESS_OR_EQUAL", "LIKE", "AND", 
		"AS", "ASC", "AVG", "COUNT", "DESC", "EXISTS", "FROM", "BY", "IS", "NULL", 
		"GROUP_BY", "IS_NULL", "IS_NOT_NULL", "LIMIT", "MAX", "MIN", "NOT", "OR", 
		"ORDER_BY", "SELECT", "SKIP", "SUM", "WHERE", "IDENTIFIER", "LETTER", 
		"DIGIT", "WS", "OPENSTRING", "STRING_LITERAL", "CLOSESTRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'_'", "'*'", "'\"'", "'\\'", "':'", "','", "'.'", "'('", "')'", 
		"'='", "'!='", "'~='", "'>'", "'>='", "'<'", "'<='", "'LIKE'", null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "UNDERSCORE", "WILDCARD", "DOUBLEQUOTE", "BACKSLASH", "COLON", "COMMA", 
		"DOT", "LPAREN", "RPAREN", "EQUALS", "NOT_EQUALS", "EQUALS_IGNORECASE", 
		"GREATER", "GREATER_OR_EQUAL", "LESS", "LESS_OR_EQUAL", "LIKE", "AND", 
		"AS", "ASC", "AVG", "COUNT", "DESC", "EXISTS", "FROM", "BY", "IS", "NULL", 
		"GROUP_BY", "IS_NULL", "IS_NOT_NULL", "LIMIT", "MAX", "MIN", "NOT", "OR", 
		"ORDER_BY", "SELECT", "SKIP", "SUM", "WHERE", "IDENTIFIER", "LETTER", 
		"DIGIT", "WS", "OPENSTRING", "STRING_LITERAL", "CLOSESTRING"
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


	public NoSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NoSQLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\62\u0121\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4"+
		"\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4"+
		" \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4"+
		"+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*"+
		"\3+\3+\3+\7+\u0102\n+\f+\16+\u0105\13+\3,\3,\3-\3-\3.\6.\u010c\n.\r.\16"+
		".\u010d\3.\3.\3/\3/\3/\3/\3/\3\60\7\60\u0118\n\60\f\60\16\60\u011b\13"+
		"\60\3\61\3\61\3\61\3\61\3\61\2\2\62\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n"+
		"\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60"+
		"\31\62\32\64\33\66\348\35:\36<\37> @!B\"D#F$H%J&L\'N(P)R*T+V,X-Z.\\/^"+
		"\60`\61b\62\4\2\3\34\4\2CCcc\4\2PPpp\4\2FFff\4\2UUuu\4\2EEee\4\2XXxx\4"+
		"\2IIii\4\2QQqq\4\2WWww\4\2VVvv\4\2GGgg\4\2ZZzz\4\2KKkk\4\2HHhh\4\2TTt"+
		"t\4\2OOoo\4\2DDdd\4\2[[{{\4\2NNnn\4\2RRrr\4\2MMmm\4\2YYyy\4\2JJjj\4\2"+
		"C\\c|\5\2\13\f\17\17\"\"\3\2))\u0123\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2"+
		"\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24"+
		"\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2"+
		"\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2"+
		"\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3"+
		"\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2"+
		"\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2"+
		"P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3"+
		"\2\2\2\2^\3\2\2\2\3`\3\2\2\2\3b\3\2\2\2\4d\3\2\2\2\6f\3\2\2\2\bh\3\2\2"+
		"\2\nj\3\2\2\2\fl\3\2\2\2\16n\3\2\2\2\20p\3\2\2\2\22r\3\2\2\2\24t\3\2\2"+
		"\2\26v\3\2\2\2\30x\3\2\2\2\32{\3\2\2\2\34~\3\2\2\2\36\u0080\3\2\2\2 \u0083"+
		"\3\2\2\2\"\u0085\3\2\2\2$\u0088\3\2\2\2&\u008d\3\2\2\2(\u0091\3\2\2\2"+
		"*\u0094\3\2\2\2,\u0098\3\2\2\2.\u009c\3\2\2\2\60\u00a2\3\2\2\2\62\u00a7"+
		"\3\2\2\2\64\u00ae\3\2\2\2\66\u00b3\3\2\2\28\u00b6\3\2\2\2:\u00b9\3\2\2"+
		"\2<\u00be\3\2\2\2>\u00c5\3\2\2\2@\u00c8\3\2\2\2B\u00cc\3\2\2\2D\u00d2"+
		"\3\2\2\2F\u00d6\3\2\2\2H\u00da\3\2\2\2J\u00de\3\2\2\2L\u00e1\3\2\2\2N"+
		"\u00e8\3\2\2\2P\u00ef\3\2\2\2R\u00f4\3\2\2\2T\u00f8\3\2\2\2V\u00fe\3\2"+
		"\2\2X\u0106\3\2\2\2Z\u0108\3\2\2\2\\\u010b\3\2\2\2^\u0111\3\2\2\2`\u0119"+
		"\3\2\2\2b\u011c\3\2\2\2de\7a\2\2e\5\3\2\2\2fg\7,\2\2g\7\3\2\2\2hi\7$\2"+
		"\2i\t\3\2\2\2jk\7^\2\2k\13\3\2\2\2lm\7<\2\2m\r\3\2\2\2no\7.\2\2o\17\3"+
		"\2\2\2pq\7\60\2\2q\21\3\2\2\2rs\7*\2\2s\23\3\2\2\2tu\7+\2\2u\25\3\2\2"+
		"\2vw\7?\2\2w\27\3\2\2\2xy\7#\2\2yz\7?\2\2z\31\3\2\2\2{|\7\u0080\2\2|}"+
		"\7?\2\2}\33\3\2\2\2~\177\7@\2\2\177\35\3\2\2\2\u0080\u0081\7@\2\2\u0081"+
		"\u0082\7?\2\2\u0082\37\3\2\2\2\u0083\u0084\7>\2\2\u0084!\3\2\2\2\u0085"+
		"\u0086\7>\2\2\u0086\u0087\7?\2\2\u0087#\3\2\2\2\u0088\u0089\7N\2\2\u0089"+
		"\u008a\7K\2\2\u008a\u008b\7M\2\2\u008b\u008c\7G\2\2\u008c%\3\2\2\2\u008d"+
		"\u008e\t\2\2\2\u008e\u008f\t\3\2\2\u008f\u0090\t\4\2\2\u0090\'\3\2\2\2"+
		"\u0091\u0092\t\2\2\2\u0092\u0093\t\5\2\2\u0093)\3\2\2\2\u0094\u0095\t"+
		"\2\2\2\u0095\u0096\t\5\2\2\u0096\u0097\t\6\2\2\u0097+\3\2\2\2\u0098\u0099"+
		"\t\2\2\2\u0099\u009a\t\7\2\2\u009a\u009b\t\b\2\2\u009b-\3\2\2\2\u009c"+
		"\u009d\t\6\2\2\u009d\u009e\t\t\2\2\u009e\u009f\t\n\2\2\u009f\u00a0\t\3"+
		"\2\2\u00a0\u00a1\t\13\2\2\u00a1/\3\2\2\2\u00a2\u00a3\t\4\2\2\u00a3\u00a4"+
		"\t\f\2\2\u00a4\u00a5\t\5\2\2\u00a5\u00a6\t\6\2\2\u00a6\61\3\2\2\2\u00a7"+
		"\u00a8\t\f\2\2\u00a8\u00a9\t\r\2\2\u00a9\u00aa\t\16\2\2\u00aa\u00ab\t"+
		"\5\2\2\u00ab\u00ac\t\13\2\2\u00ac\u00ad\t\5\2\2\u00ad\63\3\2\2\2\u00ae"+
		"\u00af\t\17\2\2\u00af\u00b0\t\20\2\2\u00b0\u00b1\t\t\2\2\u00b1\u00b2\t"+
		"\21\2\2\u00b2\65\3\2\2\2\u00b3\u00b4\t\22\2\2\u00b4\u00b5\t\23\2\2\u00b5"+
		"\67\3\2\2\2\u00b6\u00b7\t\16\2\2\u00b7\u00b8\t\5\2\2\u00b89\3\2\2\2\u00b9"+
		"\u00ba\t\3\2\2\u00ba\u00bb\t\n\2\2\u00bb\u00bc\t\24\2\2\u00bc\u00bd\t"+
		"\24\2\2\u00bd;\3\2\2\2\u00be\u00bf\t\b\2\2\u00bf\u00c0\t\20\2\2\u00c0"+
		"\u00c1\t\t\2\2\u00c1\u00c2\t\n\2\2\u00c2\u00c3\t\25\2\2\u00c3\u00c4\5"+
		"\66\33\2\u00c4=\3\2\2\2\u00c5\u00c6\58\34\2\u00c6\u00c7\5:\35\2\u00c7"+
		"?\3\2\2\2\u00c8\u00c9\58\34\2\u00c9\u00ca\5H$\2\u00ca\u00cb\5:\35\2\u00cb"+
		"A\3\2\2\2\u00cc\u00cd\t\24\2\2\u00cd\u00ce\t\16\2\2\u00ce\u00cf\t\21\2"+
		"\2\u00cf\u00d0\t\16\2\2\u00d0\u00d1\t\13\2\2\u00d1C\3\2\2\2\u00d2\u00d3"+
		"\t\21\2\2\u00d3\u00d4\t\2\2\2\u00d4\u00d5\t\r\2\2\u00d5E\3\2\2\2\u00d6"+
		"\u00d7\t\21\2\2\u00d7\u00d8\t\16\2\2\u00d8\u00d9\t\3\2\2\u00d9G\3\2\2"+
		"\2\u00da\u00db\t\3\2\2\u00db\u00dc\t\t\2\2\u00dc\u00dd\t\13\2\2\u00dd"+
		"I\3\2\2\2\u00de\u00df\t\t\2\2\u00df\u00e0\t\20\2\2\u00e0K\3\2\2\2\u00e1"+
		"\u00e2\t\t\2\2\u00e2\u00e3\t\20\2\2\u00e3\u00e4\t\4\2\2\u00e4\u00e5\t"+
		"\f\2\2\u00e5\u00e6\t\20\2\2\u00e6\u00e7\5\66\33\2\u00e7M\3\2\2\2\u00e8"+
		"\u00e9\t\5\2\2\u00e9\u00ea\t\f\2\2\u00ea\u00eb\t\24\2\2\u00eb\u00ec\t"+
		"\f\2\2\u00ec\u00ed\t\6\2\2\u00ed\u00ee\t\13\2\2\u00eeO\3\2\2\2\u00ef\u00f0"+
		"\t\5\2\2\u00f0\u00f1\t\26\2\2\u00f1\u00f2\t\16\2\2\u00f2\u00f3\t\25\2"+
		"\2\u00f3Q\3\2\2\2\u00f4\u00f5\t\5\2\2\u00f5\u00f6\t\n\2\2\u00f6\u00f7"+
		"\t\21\2\2\u00f7S\3\2\2\2\u00f8\u00f9\t\27\2\2\u00f9\u00fa\t\30\2\2\u00fa"+
		"\u00fb\t\f\2\2\u00fb\u00fc\t\20\2\2\u00fc\u00fd\t\f\2\2\u00fdU\3\2\2\2"+
		"\u00fe\u0103\5X,\2\u00ff\u0102\5X,\2\u0100\u0102\5Z-\2\u0101\u00ff\3\2"+
		"\2\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104W\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\t\31\2\2"+
		"\u0107Y\3\2\2\2\u0108\u0109\4\62;\2\u0109[\3\2\2\2\u010a\u010c\t\32\2"+
		"\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b.\2\2\u0110]\3\2\2\2\u0111\u0112"+
		"\7)\2\2\u0112\u0113\3\2\2\2\u0113\u0114\b/\3\2\u0114\u0115\b/\4\2\u0115"+
		"_\3\2\2\2\u0116\u0118\n\33\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2"+
		"\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011aa\3\2\2\2\u011b\u0119\3"+
		"\2\2\2\u011c\u011d\7)\2\2\u011d\u011e\3\2\2\2\u011e\u011f\b\61\5\2\u011f"+
		"\u0120\b\61\6\2\u0120c\3\2\2\2\b\2\3\u0101\u0103\u010d\u0119\7\b\2\2\4"+
		"\3\2\7\3\2\6\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}