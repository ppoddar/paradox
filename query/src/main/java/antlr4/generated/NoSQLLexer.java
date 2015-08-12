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
		LETTER=1, DIGIT=2, UNDERSCORE=3, WILDCARD=4, DOUBLEQUOTE=5, BACKSLASH=6, 
		R=7, F=8, N=9, T=10, B=11, ZERO=12, COLON=13, COMMA=14, DOT=15, LPAREN=16, 
		RPAREN=17, EQUALS=18, EQUALS_IGNORECASE=19, GREATER=20, GREATER_OR_EQUAL=21, 
		LESS=22, LESS_OR_EQUAL=23, LIKE=24, AND=25, AS=26, ASC=27, AVG=28, COUNT=29, 
		DESC=30, EXISTS=31, FROM=32, GROUP_BY=33, IS_NULL=34, IS_NOT_NULL=35, 
		LIMIT=36, MAX=37, MIN=38, NOT=39, OR=40, ORDER_BY=41, SELECT=42, SKIP=43, 
		SUM=44, WHERE=45, WS=46, OPENSTRING=47, STRING_LITERAL=48, CLOSESTRING=49;
	public static final int STRINGMODE = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "STRINGMODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "DIGIT", "UNDERSCORE", "WILDCARD", "DOUBLEQUOTE", "BACKSLASH", 
		"R", "F", "N", "T", "B", "ZERO", "COLON", "COMMA", "DOT", "LPAREN", "RPAREN", 
		"EQUALS", "EQUALS_IGNORECASE", "GREATER", "GREATER_OR_EQUAL", "LESS", 
		"LESS_OR_EQUAL", "LIKE", "AND", "AS", "ASC", "AVG", "COUNT", "DESC", "EXISTS", 
		"FROM", "GROUP_BY", "IS_NULL", "IS_NOT_NULL", "LIMIT", "MAX", "MIN", "NOT", 
		"OR", "ORDER_BY", "SELECT", "SKIP", "SUM", "WHERE", "WS", "OPENSTRING", 
		"STRING_LITERAL", "CLOSESTRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'_'", "'*'", "'\"'", "'\\'", "'r'", "'f'", "'n'", "'t'", 
		"'b'", "'0'", "':'", "','", "'.'", "'('", "')'", "'='", "'~='", "'>'", 
		"'>='", "'<'", "'<='", "'LIKE'", "'AND'", "'AS'", "'ASC'", "'AVG'", "'COUNT'", 
		"'DESC'", "'EXISTS'", "'FROM'", "'GROUP BY'", "'IS NULL'", "'IS NOT NULL'", 
		"'LIMIT'", "'MAX'", "'MIN'", "'NOT'", "'OR'", "'ORDER BY'", "'SELECT'", 
		"'SKIP'", "'SUM'", "'WHERE'", null, null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LETTER", "DIGIT", "UNDERSCORE", "WILDCARD", "DOUBLEQUOTE", "BACKSLASH", 
		"R", "F", "N", "T", "B", "ZERO", "COLON", "COMMA", "DOT", "LPAREN", "RPAREN", 
		"EQUALS", "EQUALS_IGNORECASE", "GREATER", "GREATER_OR_EQUAL", "LESS", 
		"LESS_OR_EQUAL", "LIKE", "AND", "AS", "ASC", "AVG", "COUNT", "DESC", "EXISTS", 
		"FROM", "GROUP_BY", "IS_NULL", "IS_NOT_NULL", "LIMIT", "MAX", "MIN", "NOT", 
		"OR", "ORDER_BY", "SELECT", "SKIP", "SUM", "WHERE", "WS", "OPENSTRING", 
		"STRING_LITERAL", "CLOSESTRING"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u012a\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4"+
		"\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4"+
		" \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4"+
		"+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		")\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		",\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\6/\u0115\n/\r/\16/\u0116\3/\3/\3\60"+
		"\3\60\3\60\3\60\3\60\3\61\7\61\u0121\n\61\f\61\16\61\u0124\13\61\3\62"+
		"\3\62\3\62\3\62\3\62\2\2\63\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26"+
		"\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32"+
		"\64\33\66\348\35:\36<\37> @!B\"D#F$H%J&L\'N(P)R*T+V,X-Z.\\/^\60`\61b\62"+
		"d\63\4\2\3\5\4\2C\\c|\5\2\13\f\17\17\"\"\3\2))\u012a\2\4\3\2\2\2\2\6\3"+
		"\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2"+
		"\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3"+
		"\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3"+
		"\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64"+
		"\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3"+
		"\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2"+
		"\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2"+
		"Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\3b\3\2\2\2\3d\3\2\2\2\4f\3"+
		"\2\2\2\6h\3\2\2\2\bj\3\2\2\2\nl\3\2\2\2\fn\3\2\2\2\16p\3\2\2\2\20r\3\2"+
		"\2\2\22t\3\2\2\2\24v\3\2\2\2\26x\3\2\2\2\30z\3\2\2\2\32|\3\2\2\2\34~\3"+
		"\2\2\2\36\u0080\3\2\2\2 \u0082\3\2\2\2\"\u0084\3\2\2\2$\u0086\3\2\2\2"+
		"&\u0088\3\2\2\2(\u008a\3\2\2\2*\u008d\3\2\2\2,\u008f\3\2\2\2.\u0092\3"+
		"\2\2\2\60\u0094\3\2\2\2\62\u0097\3\2\2\2\64\u009c\3\2\2\2\66\u00a0\3\2"+
		"\2\28\u00a3\3\2\2\2:\u00a7\3\2\2\2<\u00ab\3\2\2\2>\u00b1\3\2\2\2@\u00b6"+
		"\3\2\2\2B\u00bd\3\2\2\2D\u00c2\3\2\2\2F\u00cb\3\2\2\2H\u00d3\3\2\2\2J"+
		"\u00df\3\2\2\2L\u00e5\3\2\2\2N\u00e9\3\2\2\2P\u00ed\3\2\2\2R\u00f1\3\2"+
		"\2\2T\u00f4\3\2\2\2V\u00fd\3\2\2\2X\u0104\3\2\2\2Z\u0109\3\2\2\2\\\u010d"+
		"\3\2\2\2^\u0114\3\2\2\2`\u011a\3\2\2\2b\u0122\3\2\2\2d\u0125\3\2\2\2f"+
		"g\t\2\2\2g\5\3\2\2\2hi\4\62;\2i\7\3\2\2\2jk\7a\2\2k\t\3\2\2\2lm\7,\2\2"+
		"m\13\3\2\2\2no\7$\2\2o\r\3\2\2\2pq\7^\2\2q\17\3\2\2\2rs\7t\2\2s\21\3\2"+
		"\2\2tu\7h\2\2u\23\3\2\2\2vw\7p\2\2w\25\3\2\2\2xy\7v\2\2y\27\3\2\2\2z{"+
		"\7d\2\2{\31\3\2\2\2|}\7\62\2\2}\33\3\2\2\2~\177\7<\2\2\177\35\3\2\2\2"+
		"\u0080\u0081\7.\2\2\u0081\37\3\2\2\2\u0082\u0083\7\60\2\2\u0083!\3\2\2"+
		"\2\u0084\u0085\7*\2\2\u0085#\3\2\2\2\u0086\u0087\7+\2\2\u0087%\3\2\2\2"+
		"\u0088\u0089\7?\2\2\u0089\'\3\2\2\2\u008a\u008b\7\u0080\2\2\u008b\u008c"+
		"\7?\2\2\u008c)\3\2\2\2\u008d\u008e\7@\2\2\u008e+\3\2\2\2\u008f\u0090\7"+
		"@\2\2\u0090\u0091\7?\2\2\u0091-\3\2\2\2\u0092\u0093\7>\2\2\u0093/\3\2"+
		"\2\2\u0094\u0095\7>\2\2\u0095\u0096\7?\2\2\u0096\61\3\2\2\2\u0097\u0098"+
		"\7N\2\2\u0098\u0099\7K\2\2\u0099\u009a\7M\2\2\u009a\u009b\7G\2\2\u009b"+
		"\63\3\2\2\2\u009c\u009d\7C\2\2\u009d\u009e\7P\2\2\u009e\u009f\7F\2\2\u009f"+
		"\65\3\2\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2\7U\2\2\u00a2\67\3\2\2\2\u00a3"+
		"\u00a4\7C\2\2\u00a4\u00a5\7U\2\2\u00a5\u00a6\7E\2\2\u00a69\3\2\2\2\u00a7"+
		"\u00a8\7C\2\2\u00a8\u00a9\7X\2\2\u00a9\u00aa\7I\2\2\u00aa;\3\2\2\2\u00ab"+
		"\u00ac\7E\2\2\u00ac\u00ad\7Q\2\2\u00ad\u00ae\7W\2\2\u00ae\u00af\7P\2\2"+
		"\u00af\u00b0\7V\2\2\u00b0=\3\2\2\2\u00b1\u00b2\7F\2\2\u00b2\u00b3\7G\2"+
		"\2\u00b3\u00b4\7U\2\2\u00b4\u00b5\7E\2\2\u00b5?\3\2\2\2\u00b6\u00b7\7"+
		"G\2\2\u00b7\u00b8\7Z\2\2\u00b8\u00b9\7K\2\2\u00b9\u00ba\7U\2\2\u00ba\u00bb"+
		"\7V\2\2\u00bb\u00bc\7U\2\2\u00bcA\3\2\2\2\u00bd\u00be\7H\2\2\u00be\u00bf"+
		"\7T\2\2\u00bf\u00c0\7Q\2\2\u00c0\u00c1\7O\2\2\u00c1C\3\2\2\2\u00c2\u00c3"+
		"\7I\2\2\u00c3\u00c4\7T\2\2\u00c4\u00c5\7Q\2\2\u00c5\u00c6\7W\2\2\u00c6"+
		"\u00c7\7R\2\2\u00c7\u00c8\7\"\2\2\u00c8\u00c9\7D\2\2\u00c9\u00ca\7[\2"+
		"\2\u00caE\3\2\2\2\u00cb\u00cc\7K\2\2\u00cc\u00cd\7U\2\2\u00cd\u00ce\7"+
		"\"\2\2\u00ce\u00cf\7P\2\2\u00cf\u00d0\7W\2\2\u00d0\u00d1\7N\2\2\u00d1"+
		"\u00d2\7N\2\2\u00d2G\3\2\2\2\u00d3\u00d4\7K\2\2\u00d4\u00d5\7U\2\2\u00d5"+
		"\u00d6\7\"\2\2\u00d6\u00d7\7P\2\2\u00d7\u00d8\7Q\2\2\u00d8\u00d9\7V\2"+
		"\2\u00d9\u00da\7\"\2\2\u00da\u00db\7P\2\2\u00db\u00dc\7W\2\2\u00dc\u00dd"+
		"\7N\2\2\u00dd\u00de\7N\2\2\u00deI\3\2\2\2\u00df\u00e0\7N\2\2\u00e0\u00e1"+
		"\7K\2\2\u00e1\u00e2\7O\2\2\u00e2\u00e3\7K\2\2\u00e3\u00e4\7V\2\2\u00e4"+
		"K\3\2\2\2\u00e5\u00e6\7O\2\2\u00e6\u00e7\7C\2\2\u00e7\u00e8\7Z\2\2\u00e8"+
		"M\3\2\2\2\u00e9\u00ea\7O\2\2\u00ea\u00eb\7K\2\2\u00eb\u00ec\7P\2\2\u00ec"+
		"O\3\2\2\2\u00ed\u00ee\7P\2\2\u00ee\u00ef\7Q\2\2\u00ef\u00f0\7V\2\2\u00f0"+
		"Q\3\2\2\2\u00f1\u00f2\7Q\2\2\u00f2\u00f3\7T\2\2\u00f3S\3\2\2\2\u00f4\u00f5"+
		"\7Q\2\2\u00f5\u00f6\7T\2\2\u00f6\u00f7\7F\2\2\u00f7\u00f8\7G\2\2\u00f8"+
		"\u00f9\7T\2\2\u00f9\u00fa\7\"\2\2\u00fa\u00fb\7D\2\2\u00fb\u00fc\7[\2"+
		"\2\u00fcU\3\2\2\2\u00fd\u00fe\7U\2\2\u00fe\u00ff\7G\2\2\u00ff\u0100\7"+
		"N\2\2\u0100\u0101\7G\2\2\u0101\u0102\7E\2\2\u0102\u0103\7V\2\2\u0103W"+
		"\3\2\2\2\u0104\u0105\7U\2\2\u0105\u0106\7M\2\2\u0106\u0107\7K\2\2\u0107"+
		"\u0108\7R\2\2\u0108Y\3\2\2\2\u0109\u010a\7U\2\2\u010a\u010b\7W\2\2\u010b"+
		"\u010c\7O\2\2\u010c[\3\2\2\2\u010d\u010e\7Y\2\2\u010e\u010f\7J\2\2\u010f"+
		"\u0110\7G\2\2\u0110\u0111\7T\2\2\u0111\u0112\7G\2\2\u0112]\3\2\2\2\u0113"+
		"\u0115\t\3\2\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\b/\2\2\u0119"+
		"_\3\2\2\2\u011a\u011b\7)\2\2\u011b\u011c\3\2\2\2\u011c\u011d\b\60\3\2"+
		"\u011d\u011e\b\60\4\2\u011ea\3\2\2\2\u011f\u0121\n\4\2\2\u0120\u011f\3"+
		"\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"c\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7)\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\b\62\5\2\u0128\u0129\b\62\6\2\u0129e\3\2\2\2\6\2\3\u0116\u0122"+
		"\7\b\2\2\4\3\2\7\3\2\6\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}