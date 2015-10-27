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
		COLON=7, COMMA=8, DOT=9, LPAREN=10, RPAREN=11, EQUALS=12, EQUALS_IGNORECASE=13, 
		GREATER=14, GREATER_OR_EQUAL=15, LESS=16, LESS_OR_EQUAL=17, LIKE=18, AND=19, 
		AS=20, ASC=21, AVG=22, COUNT=23, DESC=24, EXISTS=25, FROM=26, GROUP_BY=27, 
		IS_NULL=28, IS_NOT_NULL=29, LIMIT=30, MAX=31, MIN=32, NOT=33, OR=34, ORDER_BY=35, 
		SELECT=36, SKIP=37, SUM=38, WHERE=39, WS=40, OPENSTRING=41, STRING_LITERAL=42, 
		CLOSESTRING=43;
	public static final int STRINGMODE = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "STRINGMODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "DIGIT", "UNDERSCORE", "WILDCARD", "DOUBLEQUOTE", "BACKSLASH", 
		"COLON", "COMMA", "DOT", "LPAREN", "RPAREN", "EQUALS", "EQUALS_IGNORECASE", 
		"GREATER", "GREATER_OR_EQUAL", "LESS", "LESS_OR_EQUAL", "LIKE", "AND", 
		"AS", "ASC", "AVG", "COUNT", "DESC", "EXISTS", "FROM", "GROUP_BY", "IS_NULL", 
		"IS_NOT_NULL", "LIMIT", "MAX", "MIN", "NOT", "OR", "ORDER_BY", "SELECT", 
		"SKIP", "SUM", "WHERE", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
		"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
		"Y", "Z", "WS", "OPENSTRING", "STRING_LITERAL", "CLOSESTRING"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u0175\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&"+
		"\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@"+
		"\3@\3A\3A\3B\3B\3C\6C\u0160\nC\rC\16C\u0161\3C\3C\3D\3D\3D\3D\3D\3E\7"+
		"E\u016c\nE\fE\16E\u016f\13E\3F\3F\3F\3F\3F\2\2G\4\3\6\4\b\5\n\6\f\7\16"+
		"\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26"+
		",\27.\30\60\31\62\32\64\33\66\348\35:\36<\37> @!B\"D#F$H%J&L\'N(P)R\2"+
		"T\2V\2X\2Z\2\\\2^\2`\2b\2d\2f\2h\2j\2l\2n\2p\2r\2t\2v\2x\2z\2|\2~\2\u0080"+
		"\2\u0082\2\u0084\2\u0086*\u0088+\u008a,\u008c-\4\2\3\37\4\2C\\c|\4\2C"+
		"Ccc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4"+
		"\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTt"+
		"t\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\5"+
		"\2\13\f\17\17\"\"\3\2))\u015b\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n"+
		"\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2"+
		"\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2"+
		" \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3"+
		"\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2"+
		"\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D"+
		"\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2"+
		"\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2\2\3\u008a\3\2\2\2\3\u008c\3\2\2\2\4"+
		"\u008e\3\2\2\2\6\u0090\3\2\2\2\b\u0092\3\2\2\2\n\u0094\3\2\2\2\f\u0096"+
		"\3\2\2\2\16\u0098\3\2\2\2\20\u009a\3\2\2\2\22\u009c\3\2\2\2\24\u009e\3"+
		"\2\2\2\26\u00a0\3\2\2\2\30\u00a2\3\2\2\2\32\u00a4\3\2\2\2\34\u00a6\3\2"+
		"\2\2\36\u00a9\3\2\2\2 \u00ab\3\2\2\2\"\u00ae\3\2\2\2$\u00b0\3\2\2\2&\u00b3"+
		"\3\2\2\2(\u00b8\3\2\2\2*\u00bc\3\2\2\2,\u00bf\3\2\2\2.\u00c3\3\2\2\2\60"+
		"\u00c7\3\2\2\2\62\u00cd\3\2\2\2\64\u00d2\3\2\2\2\66\u00d9\3\2\2\28\u00de"+
		"\3\2\2\2:\u00e6\3\2\2\2<\u00ed\3\2\2\2>\u00f7\3\2\2\2@\u00fd\3\2\2\2B"+
		"\u0101\3\2\2\2D\u0105\3\2\2\2F\u0109\3\2\2\2H\u010c\3\2\2\2J\u0114\3\2"+
		"\2\2L\u011b\3\2\2\2N\u0120\3\2\2\2P\u0124\3\2\2\2R\u012a\3\2\2\2T\u012c"+
		"\3\2\2\2V\u012e\3\2\2\2X\u0130\3\2\2\2Z\u0132\3\2\2\2\\\u0134\3\2\2\2"+
		"^\u0136\3\2\2\2`\u0138\3\2\2\2b\u013a\3\2\2\2d\u013c\3\2\2\2f\u013e\3"+
		"\2\2\2h\u0140\3\2\2\2j\u0142\3\2\2\2l\u0144\3\2\2\2n\u0146\3\2\2\2p\u0148"+
		"\3\2\2\2r\u014a\3\2\2\2t\u014c\3\2\2\2v\u014e\3\2\2\2x\u0150\3\2\2\2z"+
		"\u0152\3\2\2\2|\u0154\3\2\2\2~\u0156\3\2\2\2\u0080\u0158\3\2\2\2\u0082"+
		"\u015a\3\2\2\2\u0084\u015c\3\2\2\2\u0086\u015f\3\2\2\2\u0088\u0165\3\2"+
		"\2\2\u008a\u016d\3\2\2\2\u008c\u0170\3\2\2\2\u008e\u008f\t\2\2\2\u008f"+
		"\5\3\2\2\2\u0090\u0091\4\62;\2\u0091\7\3\2\2\2\u0092\u0093\7a\2\2\u0093"+
		"\t\3\2\2\2\u0094\u0095\7,\2\2\u0095\13\3\2\2\2\u0096\u0097\7$\2\2\u0097"+
		"\r\3\2\2\2\u0098\u0099\7^\2\2\u0099\17\3\2\2\2\u009a\u009b\7<\2\2\u009b"+
		"\21\3\2\2\2\u009c\u009d\7.\2\2\u009d\23\3\2\2\2\u009e\u009f\7\60\2\2\u009f"+
		"\25\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\7+\2\2\u00a3"+
		"\31\3\2\2\2\u00a4\u00a5\7?\2\2\u00a5\33\3\2\2\2\u00a6\u00a7\7\u0080\2"+
		"\2\u00a7\u00a8\7?\2\2\u00a8\35\3\2\2\2\u00a9\u00aa\7@\2\2\u00aa\37\3\2"+
		"\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ad\7?\2\2\u00ad!\3\2\2\2\u00ae\u00af"+
		"\7>\2\2\u00af#\3\2\2\2\u00b0\u00b1\7>\2\2\u00b1\u00b2\7?\2\2\u00b2%\3"+
		"\2\2\2\u00b3\u00b4\7N\2\2\u00b4\u00b5\7K\2\2\u00b5\u00b6\7M\2\2\u00b6"+
		"\u00b7\7G\2\2\u00b7\'\3\2\2\2\u00b8\u00b9\5R)\2\u00b9\u00ba\5l\66\2\u00ba"+
		"\u00bb\5X,\2\u00bb)\3\2\2\2\u00bc\u00bd\5R)\2\u00bd\u00be\5v;\2\u00be"+
		"+\3\2\2\2\u00bf\u00c0\5R)\2\u00c0\u00c1\5v;\2\u00c1\u00c2\5V+\2\u00c2"+
		"-\3\2\2\2\u00c3\u00c4\5R)\2\u00c4\u00c5\5|>\2\u00c5\u00c6\5^/\2\u00c6"+
		"/\3\2\2\2\u00c7\u00c8\5V+\2\u00c8\u00c9\5n\67\2\u00c9\u00ca\5z=\2\u00ca"+
		"\u00cb\5l\66\2\u00cb\u00cc\5x<\2\u00cc\61\3\2\2\2\u00cd\u00ce\5X,\2\u00ce"+
		"\u00cf\5Z-\2\u00cf\u00d0\5v;\2\u00d0\u00d1\5V+\2\u00d1\63\3\2\2\2\u00d2"+
		"\u00d3\5Z-\2\u00d3\u00d4\5\u0080@\2\u00d4\u00d5\5b\61\2\u00d5\u00d6\5"+
		"v;\2\u00d6\u00d7\5x<\2\u00d7\u00d8\5v;\2\u00d8\65\3\2\2\2\u00d9\u00da"+
		"\5\\.\2\u00da\u00db\5t:\2\u00db\u00dc\5n\67\2\u00dc\u00dd\5j\65\2\u00dd"+
		"\67\3\2\2\2\u00de\u00df\5^/\2\u00df\u00e0\5t:\2\u00e0\u00e1\5n\67\2\u00e1"+
		"\u00e2\5z=\2\u00e2\u00e3\5p8\2\u00e3\u00e4\5T*\2\u00e4\u00e5\5\u0082A"+
		"\2\u00e59\3\2\2\2\u00e6\u00e7\5b\61\2\u00e7\u00e8\5v;\2\u00e8\u00e9\5"+
		"l\66\2\u00e9\u00ea\5z=\2\u00ea\u00eb\5h\64\2\u00eb\u00ec\5h\64\2\u00ec"+
		";\3\2\2\2\u00ed\u00ee\5b\61\2\u00ee\u00ef\5v;\2\u00ef\u00f0\5l\66\2\u00f0"+
		"\u00f1\5n\67\2\u00f1\u00f2\5x<\2\u00f2\u00f3\5l\66\2\u00f3\u00f4\5z=\2"+
		"\u00f4\u00f5\5h\64\2\u00f5\u00f6\5h\64\2\u00f6=\3\2\2\2\u00f7\u00f8\5"+
		"h\64\2\u00f8\u00f9\5b\61\2\u00f9\u00fa\5j\65\2\u00fa\u00fb\5b\61\2\u00fb"+
		"\u00fc\5x<\2\u00fc?\3\2\2\2\u00fd\u00fe\5j\65\2\u00fe\u00ff\5R)\2\u00ff"+
		"\u0100\5\u0080@\2\u0100A\3\2\2\2\u0101\u0102\5j\65\2\u0102\u0103\5b\61"+
		"\2\u0103\u0104\5l\66\2\u0104C\3\2\2\2\u0105\u0106\5l\66\2\u0106\u0107"+
		"\5n\67\2\u0107\u0108\5x<\2\u0108E\3\2\2\2\u0109\u010a\5n\67\2\u010a\u010b"+
		"\5t:\2\u010bG\3\2\2\2\u010c\u010d\5n\67\2\u010d\u010e\5t:\2\u010e\u010f"+
		"\5X,\2\u010f\u0110\5Z-\2\u0110\u0111\5t:\2\u0111\u0112\5T*\2\u0112\u0113"+
		"\5\u0082A\2\u0113I\3\2\2\2\u0114\u0115\5v;\2\u0115\u0116\5Z-\2\u0116\u0117"+
		"\5h\64\2\u0117\u0118\5Z-\2\u0118\u0119\5V+\2\u0119\u011a\5x<\2\u011aK"+
		"\3\2\2\2\u011b\u011c\5v;\2\u011c\u011d\5f\63\2\u011d\u011e\5b\61\2\u011e"+
		"\u011f\5p8\2\u011fM\3\2\2\2\u0120\u0121\5v;\2\u0121\u0122\5z=\2\u0122"+
		"\u0123\5j\65\2\u0123O\3\2\2\2\u0124\u0125\5~?\2\u0125\u0126\5`\60\2\u0126"+
		"\u0127\5Z-\2\u0127\u0128\5t:\2\u0128\u0129\5Z-\2\u0129Q\3\2\2\2\u012a"+
		"\u012b\t\3\2\2\u012bS\3\2\2\2\u012c\u012d\t\4\2\2\u012dU\3\2\2\2\u012e"+
		"\u012f\t\5\2\2\u012fW\3\2\2\2\u0130\u0131\t\6\2\2\u0131Y\3\2\2\2\u0132"+
		"\u0133\t\7\2\2\u0133[\3\2\2\2\u0134\u0135\t\b\2\2\u0135]\3\2\2\2\u0136"+
		"\u0137\t\t\2\2\u0137_\3\2\2\2\u0138\u0139\t\n\2\2\u0139a\3\2\2\2\u013a"+
		"\u013b\t\13\2\2\u013bc\3\2\2\2\u013c\u013d\t\f\2\2\u013de\3\2\2\2\u013e"+
		"\u013f\t\r\2\2\u013fg\3\2\2\2\u0140\u0141\t\16\2\2\u0141i\3\2\2\2\u0142"+
		"\u0143\t\17\2\2\u0143k\3\2\2\2\u0144\u0145\t\20\2\2\u0145m\3\2\2\2\u0146"+
		"\u0147\t\21\2\2\u0147o\3\2\2\2\u0148\u0149\t\22\2\2\u0149q\3\2\2\2\u014a"+
		"\u014b\t\23\2\2\u014bs\3\2\2\2\u014c\u014d\t\24\2\2\u014du\3\2\2\2\u014e"+
		"\u014f\t\25\2\2\u014fw\3\2\2\2\u0150\u0151\t\26\2\2\u0151y\3\2\2\2\u0152"+
		"\u0153\t\27\2\2\u0153{\3\2\2\2\u0154\u0155\t\30\2\2\u0155}\3\2\2\2\u0156"+
		"\u0157\t\31\2\2\u0157\177\3\2\2\2\u0158\u0159\t\32\2\2\u0159\u0081\3\2"+
		"\2\2\u015a\u015b\t\33\2\2\u015b\u0083\3\2\2\2\u015c\u015d\t\34\2\2\u015d"+
		"\u0085\3\2\2\2\u015e\u0160\t\35\2\2\u015f\u015e\3\2\2\2\u0160\u0161\3"+
		"\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0164\bC\2\2\u0164\u0087\3\2\2\2\u0165\u0166\7)\2\2\u0166\u0167\3\2\2"+
		"\2\u0167\u0168\bD\3\2\u0168\u0169\bD\4\2\u0169\u0089\3\2\2\2\u016a\u016c"+
		"\n\36\2\2\u016b\u016a\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2"+
		"\u016d\u016e\3\2\2\2\u016e\u008b\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0171"+
		"\7)\2\2\u0171\u0172\3\2\2\2\u0172\u0173\bF\5\2\u0173\u0174\bF\6\2\u0174"+
		"\u008d\3\2\2\2\6\2\3\u0161\u016d\7\b\2\2\4\3\2\7\3\2\6\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}