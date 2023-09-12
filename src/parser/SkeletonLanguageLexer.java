package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SkeletonLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TK_PRINT=8, TK_PRINTLN=9, 
		TK_READ=10, TK_TIPO_INT=11, TK_TIPO_FLOAT=12, TK_VOID=13, TK_IF=14, TK_ELSE=15, 
		TK_RETURN=16, MUL=17, DIV=18, ADD=19, SUB=20, SIGNO=21, TK_CTE_INT=22, 
		TK_CTE_FLOAT=23, TK_ID=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "TK_PRINT", "TK_PRINTLN", 
		"TK_READ", "TK_TIPO_INT", "TK_TIPO_FLOAT", "TK_VOID", "TK_IF", "TK_ELSE", 
		"TK_RETURN", "MUL", "DIV", "ADD", "SUB", "SIGNO", "TK_CTE_INT", "TK_CTE_FLOAT", 
		"TK_ID", "LETRA", "DIGITO", "WS"
	};


	public SkeletonLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SkeletonLanguage.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 26: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00d7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tR\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nb\n\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13l\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\ft\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0080\n\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008a\n\16\3\17\3\17\3\17"+
		"\3\17\5\17\u0090\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u009a"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00a8\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\5\26\u00b4"+
		"\n\26\3\27\5\27\u00b7\n\27\3\27\6\27\u00ba\n\27\r\27\16\27\u00bb\3\30"+
		"\3\30\3\30\6\30\u00c1\n\30\r\30\16\30\u00c2\3\31\3\31\5\31\u00c7\n\31"+
		"\3\31\3\31\3\31\7\31\u00cc\n\31\f\31\16\31\u00cf\13\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\2\65\2\67\33\3\2\4\4\2C\\c|\5\2\13\f\17\17\"\"\u00e5\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\t?\3\2\2\2\13A\3\2\2\2"+
		"\rC\3\2\2\2\17E\3\2\2\2\21Q\3\2\2\2\23a\3\2\2\2\25k\3\2\2\2\27s\3\2\2"+
		"\2\31\177\3\2\2\2\33\u0089\3\2\2\2\35\u008f\3\2\2\2\37\u0099\3\2\2\2!"+
		"\u00a7\3\2\2\2#\u00a9\3\2\2\2%\u00ab\3\2\2\2\'\u00ad\3\2\2\2)\u00af\3"+
		"\2\2\2+\u00b3\3\2\2\2-\u00b6\3\2\2\2/\u00bd\3\2\2\2\61\u00c6\3\2\2\2\63"+
		"\u00d0\3\2\2\2\65\u00d2\3\2\2\2\67\u00d4\3\2\2\29:\7}\2\2:\4\3\2\2\2;"+
		"<\7+\2\2<\6\3\2\2\2=>\7.\2\2>\b\3\2\2\2?@\7*\2\2@\n\3\2\2\2AB\7?\2\2B"+
		"\f\3\2\2\2CD\7\177\2\2D\16\3\2\2\2EF\7=\2\2F\20\3\2\2\2GH\7R\2\2HI\7T"+
		"\2\2IJ\7K\2\2JK\7P\2\2KR\7V\2\2LM\7r\2\2MN\7t\2\2NO\7k\2\2OP\7p\2\2PR"+
		"\7v\2\2QG\3\2\2\2QL\3\2\2\2R\22\3\2\2\2ST\7R\2\2TU\7T\2\2UV\7K\2\2VW\7"+
		"P\2\2WX\7V\2\2XY\7N\2\2Yb\7P\2\2Z[\7r\2\2[\\\7t\2\2\\]\7k\2\2]^\7p\2\2"+
		"^_\7v\2\2_`\7n\2\2`b\7p\2\2aS\3\2\2\2aZ\3\2\2\2b\24\3\2\2\2cd\7T\2\2d"+
		"e\7G\2\2ef\7C\2\2fl\7F\2\2gh\7t\2\2hi\7g\2\2ij\7c\2\2jl\7f\2\2kc\3\2\2"+
		"\2kg\3\2\2\2l\26\3\2\2\2mn\7K\2\2no\7P\2\2ot\7V\2\2pq\7k\2\2qr\7p\2\2"+
		"rt\7v\2\2sm\3\2\2\2sp\3\2\2\2t\30\3\2\2\2uv\7H\2\2vw\7N\2\2wx\7Q\2\2x"+
		"y\7C\2\2y\u0080\7V\2\2z{\7h\2\2{|\7n\2\2|}\7q\2\2}~\7c\2\2~\u0080\7v\2"+
		"\2\177u\3\2\2\2\177z\3\2\2\2\u0080\32\3\2\2\2\u0081\u0082\7x\2\2\u0082"+
		"\u0083\7q\2\2\u0083\u0084\7k\2\2\u0084\u008a\7f\2\2\u0085\u0086\7X\2\2"+
		"\u0086\u0087\7Q\2\2\u0087\u0088\7K\2\2\u0088\u008a\7F\2\2\u0089\u0081"+
		"\3\2\2\2\u0089\u0085\3\2\2\2\u008a\34\3\2\2\2\u008b\u008c\7K\2\2\u008c"+
		"\u0090\7H\2\2\u008d\u008e\7k\2\2\u008e\u0090\7h\2\2\u008f\u008b\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\u0090\36\3\2\2\2\u0091\u0092\7G\2\2\u0092\u0093"+
		"\7N\2\2\u0093\u0094\7U\2\2\u0094\u009a\7G\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7n\2\2\u0097\u0098\7u\2\2\u0098\u009a\7g\2\2\u0099\u0091\3\2\2"+
		"\2\u0099\u0095\3\2\2\2\u009a \3\2\2\2\u009b\u009c\7T\2\2\u009c\u009d\7"+
		"G\2\2\u009d\u009e\7V\2\2\u009e\u009f\7W\2\2\u009f\u00a0\7T\2\2\u00a0\u00a8"+
		"\7P\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7v\2\2\u00a4"+
		"\u00a5\7w\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a8\7p\2\2\u00a7\u009b\3\2\2"+
		"\2\u00a7\u00a1\3\2\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7,\2\2\u00aa$\3\2\2"+
		"\2\u00ab\u00ac\7\61\2\2\u00ac&\3\2\2\2\u00ad\u00ae\7-\2\2\u00ae(\3\2\2"+
		"\2\u00af\u00b0\7/\2\2\u00b0*\3\2\2\2\u00b1\u00b4\5\'\24\2\u00b2\u00b4"+
		"\5)\25\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4,\3\2\2\2\u00b5"+
		"\u00b7\5+\26\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00ba\5\65\33\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc.\3\2\2\2\u00bd\u00be\5-\27\2"+
		"\u00be\u00c0\7\60\2\2\u00bf\u00c1\5\65\33\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\60\3\2\2"+
		"\2\u00c4\u00c7\7a\2\2\u00c5\u00c7\5\63\32\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00cd\3\2\2\2\u00c8\u00cc\7a\2\2\u00c9\u00cc\5\63"+
		"\32\2\u00ca\u00cc\5\65\33\2\u00cb\u00c8\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\62\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\t\2\2\2\u00d1\64"+
		"\3\2\2\2\u00d2\u00d3\4\62;\2\u00d3\66\3\2\2\2\u00d4\u00d5\t\3\2\2\u00d5"+
		"\u00d6\b\34\2\2\u00d68\3\2\2\2\23\2Qaks\177\u0089\u008f\u0099\u00a7\u00b3"+
		"\u00b6\u00bb\u00c2\u00c6\u00cb\u00cd\3\3\34\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}