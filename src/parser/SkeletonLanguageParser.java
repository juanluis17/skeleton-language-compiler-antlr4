package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SkeletonLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TK_PRINT=8, TK_PRINTLN=9, 
		TK_READ=10, TK_TIPO_INT=11, TK_TIPO_FLOAT=12, TK_VOID=13, TK_IF=14, TK_ELSE=15, 
		TK_RETURN=16, MUL=17, DIV=18, ADD=19, SUB=20, SIGNO=21, TK_CTE_INT=22, 
		TK_CTE_FLOAT=23, TK_ID=24, WS=25;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "')'", "','", "'('", "'='", "'}'", "';'", "TK_PRINT", 
		"TK_PRINTLN", "TK_READ", "TK_TIPO_INT", "TK_TIPO_FLOAT", "TK_VOID", "TK_IF", 
		"TK_ELSE", "TK_RETURN", "'*'", "'/'", "'+'", "'-'", "SIGNO", "TK_CTE_INT", 
		"TK_CTE_FLOAT", "TK_ID", "WS"
	};
	public static final int
		RULE_start = 0, RULE_attributes = 1, RULE_methods = 2, RULE_tipoRet = 3, 
		RULE_arg = 4, RULE_sent = 5, RULE_sentAsig = 6, RULE_sentSalida = 7, RULE_sentIf = 8, 
		RULE_sentReturn = 9, RULE_localDclVar = 10, RULE_block = 11, RULE_callMethod = 12, 
		RULE_callMethodSent = 13, RULE_exp = 14, RULE_cte = 15, RULE_tipo = 16;
	public static final String[] ruleNames = {
		"start", "attributes", "methods", "tipoRet", "arg", "sent", "sentAsig", 
		"sentSalida", "sentIf", "sentReturn", "localDclVar", "block", "callMethod", 
		"callMethodSent", "exp", "cte", "tipo"
	};

	@Override
	public String getGrammarFileName() { return "SkeletonLanguage.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SkeletonLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<AttributesContext> attributes() {
			return getRuleContexts(AttributesContext.class);
		}
		public List<MethodsContext> methods() {
			return getRuleContexts(MethodsContext.class);
		}
		public AttributesContext attributes(int i) {
			return getRuleContext(AttributesContext.class,i);
		}
		public MethodsContext methods(int i) {
			return getRuleContext(MethodsContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34); attributes();
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40); methods();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TK_TIPO_INT) | (1L << TK_TIPO_FLOAT) | (1L << TK_VOID))) != 0) );
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

	public static class AttributesContext extends ParserRuleContext {
		public TerminalNode TK_ID() { return getToken(SkeletonLanguageParser.TK_ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_attributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); tipo();
			setState(46); match(TK_ID);
			setState(47); match(T__0);
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

	public static class MethodsContext extends ParserRuleContext {
		public TipoRetContext tipoRet() {
			return getRuleContext(TipoRetContext.class,0);
		}
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public TerminalNode TK_ID() { return getToken(SkeletonLanguageParser.TK_ID, 0); }
		public SentContext sent(int i) {
			return getRuleContext(SentContext.class,i);
		}
		public List<SentContext> sent() {
			return getRuleContexts(SentContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public MethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methods; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitMethods(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodsContext methods() throws RecognitionException {
		MethodsContext _localctx = new MethodsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_methods);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); tipoRet();
			setState(50); match(TK_ID);
			setState(51); match(T__3);
			setState(60);
			_la = _input.LA(1);
			if (_la==TK_TIPO_INT || _la==TK_TIPO_FLOAT) {
				{
				setState(52); arg();
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(53); match(T__4);
					setState(54); arg();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(62); match(T__5);
			setState(63); match(T__6);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << TK_PRINT) | (1L << TK_PRINTLN) | (1L << TK_TIPO_INT) | (1L << TK_TIPO_FLOAT) | (1L << TK_IF) | (1L << TK_RETURN) | (1L << TK_ID))) != 0)) {
				{
				{
				setState(64); sent();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70); match(T__1);
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

	public static class TipoRetContext extends ParserRuleContext {
		public TerminalNode TK_VOID() { return getToken(SkeletonLanguageParser.TK_VOID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TipoRetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoRet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitTipoRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoRetContext tipoRet() throws RecognitionException {
		TipoRetContext _localctx = new TipoRetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipoRet);
		try {
			setState(74);
			switch (_input.LA(1)) {
			case TK_VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(72); match(TK_VOID);
				}
				break;
			case TK_TIPO_INT:
			case TK_TIPO_FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); tipo();
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

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode TK_ID() { return getToken(SkeletonLanguageParser.TK_ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); tipo();
			setState(77); match(TK_ID);
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

	public static class SentContext extends ParserRuleContext {
		public LocalDclVarContext localDclVar() {
			return getRuleContext(LocalDclVarContext.class,0);
		}
		public SentIfContext sentIf() {
			return getRuleContext(SentIfContext.class,0);
		}
		public SentSalidaContext sentSalida() {
			return getRuleContext(SentSalidaContext.class,0);
		}
		public CallMethodSentContext callMethodSent() {
			return getRuleContext(CallMethodSentContext.class,0);
		}
		public SentAsigContext sentAsig() {
			return getRuleContext(SentAsigContext.class,0);
		}
		public SentReturnContext sentReturn() {
			return getRuleContext(SentReturnContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitSent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentContext sent() throws RecognitionException {
		SentContext _localctx = new SentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sent);
		try {
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79); block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); sentAsig();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81); sentSalida();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(82); sentIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(83); sentReturn();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(84); localDclVar();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(85); callMethodSent();
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

	public static class SentAsigContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TK_ID() { return getToken(SkeletonLanguageParser.TK_ID, 0); }
		public SentAsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentAsig; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitSentAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentAsigContext sentAsig() throws RecognitionException {
		SentAsigContext _localctx = new SentAsigContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentAsig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(TK_ID);
			setState(89); match(T__2);
			setState(90); exp(0);
			setState(91); match(T__0);
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

	public static class SentSalidaContext extends ParserRuleContext {
		public TerminalNode TK_PRINTLN() { return getToken(SkeletonLanguageParser.TK_PRINTLN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TK_PRINT() { return getToken(SkeletonLanguageParser.TK_PRINT, 0); }
		public SentSalidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentSalida; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitSentSalida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentSalidaContext sentSalida() throws RecognitionException {
		SentSalidaContext _localctx = new SentSalidaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sentSalida);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if ( !(_la==TK_PRINT || _la==TK_PRINTLN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(94); match(T__3);
			setState(95); exp(0);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(96); match(T__4);
				setState(97); exp(0);
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103); match(T__5);
			setState(104); match(T__0);
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

	public static class SentIfContext extends ParserRuleContext {
		public TerminalNode TK_IF() { return getToken(SkeletonLanguageParser.TK_IF, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SentContext sent(int i) {
			return getRuleContext(SentContext.class,i);
		}
		public TerminalNode TK_ELSE() { return getToken(SkeletonLanguageParser.TK_ELSE, 0); }
		public List<SentContext> sent() {
			return getRuleContexts(SentContext.class);
		}
		public SentIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentIf; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitSentIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentIfContext sentIf() throws RecognitionException {
		SentIfContext _localctx = new SentIfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(TK_IF);
			setState(107); match(T__3);
			setState(108); exp(0);
			setState(109); match(T__5);
			setState(110); sent();
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(111); match(TK_ELSE);
				setState(112); sent();
				}
				break;
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

	public static class SentReturnContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TK_RETURN() { return getToken(SkeletonLanguageParser.TK_RETURN, 0); }
		public SentReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentReturn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitSentReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentReturnContext sentReturn() throws RecognitionException {
		SentReturnContext _localctx = new SentReturnContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(TK_RETURN);
			setState(117);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << TK_CTE_INT) | (1L << TK_CTE_FLOAT) | (1L << TK_ID))) != 0)) {
				{
				setState(116); exp(0);
				}
			}

			setState(119); match(T__0);
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

	public static class LocalDclVarContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TK_ID() { return getToken(SkeletonLanguageParser.TK_ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public LocalDclVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDclVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitLocalDclVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDclVarContext localDclVar() throws RecognitionException {
		LocalDclVarContext _localctx = new LocalDclVarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_localDclVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); tipo();
			setState(122); match(TK_ID);
			setState(125);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(123); match(T__2);
				setState(124); exp(0);
				}
			}

			setState(127); match(T__0);
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

	public static class BlockContext extends ParserRuleContext {
		public SentContext sent(int i) {
			return getRuleContext(SentContext.class,i);
		}
		public List<SentContext> sent() {
			return getRuleContexts(SentContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(T__6);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << TK_PRINT) | (1L << TK_PRINTLN) | (1L << TK_TIPO_INT) | (1L << TK_TIPO_FLOAT) | (1L << TK_IF) | (1L << TK_RETURN) | (1L << TK_ID))) != 0)) {
				{
				{
				setState(130); sent();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136); match(T__1);
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

	public static class CallMethodContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode TK_ID() { return getToken(SkeletonLanguageParser.TK_ID, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CallMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callMethod; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitCallMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallMethodContext callMethod() throws RecognitionException {
		CallMethodContext _localctx = new CallMethodContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_callMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(TK_ID);
			setState(139); match(T__3);
			setState(148);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << TK_CTE_INT) | (1L << TK_CTE_FLOAT) | (1L << TK_ID))) != 0)) {
				{
				setState(140); exp(0);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(141); match(T__4);
					setState(142); exp(0);
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(150); match(T__5);
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

	public static class CallMethodSentContext extends ParserRuleContext {
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public CallMethodSentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callMethodSent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitCallMethodSent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallMethodSentContext callMethodSent() throws RecognitionException {
		CallMethodSentContext _localctx = new CallMethodSentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callMethodSent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); callMethod();
			setState(153); match(T__0);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpMulDivContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpMulDivContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitExpMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAddSubContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpAddSubContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitExpAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIDContext extends ExpContext {
		public TerminalNode TK_ID() { return getToken(SkeletonLanguageParser.TK_ID, 0); }
		public ExpIDContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitExpID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpCallMethodContext extends ExpContext {
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public ExpCallMethodContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitExpCallMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpParentContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpParentContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitExpParent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpCteContext extends ExpContext {
		public CteContext cte() {
			return getRuleContext(CteContext.class,0);
		}
		public ExpCteContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitExpCte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new ExpCallMethodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(156); callMethod();
				}
				break;
			case 2:
				{
				_localctx = new ExpParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157); match(T__3);
				setState(158); exp(0);
				setState(159); match(T__5);
				}
				break;
			case 3:
				{
				_localctx = new ExpCteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161); cte();
				}
				break;
			case 4:
				{
				_localctx = new ExpIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162); match(TK_ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpMulDivContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(165);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(166);
						((ExpMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ExpMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(167); exp(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpAddSubContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(168);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(169);
						((ExpAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(170); exp(5);
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CteContext extends ParserRuleContext {
		public CteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cte; }
	 
		public CteContext() { }
		public void copyFrom(CteContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CteFloatContext extends CteContext {
		public TerminalNode TK_CTE_FLOAT() { return getToken(SkeletonLanguageParser.TK_CTE_FLOAT, 0); }
		public CteFloatContext(CteContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitCteFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CteIntContext extends CteContext {
		public TerminalNode TK_CTE_INT() { return getToken(SkeletonLanguageParser.TK_CTE_INT, 0); }
		public CteIntContext(CteContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitCteInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CteContext cte() throws RecognitionException {
		CteContext _localctx = new CteContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cte);
		try {
			setState(178);
			switch (_input.LA(1)) {
			case TK_CTE_INT:
				_localctx = new CteIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176); match(TK_CTE_INT);
				}
				break;
			case TK_CTE_FLOAT:
				_localctx = new CteFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177); match(TK_CTE_FLOAT);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	 
		public TipoContext() { }
		public void copyFrom(TipoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TipoFloatContext extends TipoContext {
		public TerminalNode TK_TIPO_FLOAT() { return getToken(SkeletonLanguageParser.TK_TIPO_FLOAT, 0); }
		public TipoFloatContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitTipoFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoIntContext extends TipoContext {
		public TerminalNode TK_TIPO_INT() { return getToken(SkeletonLanguageParser.TK_TIPO_INT, 0); }
		public TipoIntContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkeletonLanguageVisitor ) return ((SkeletonLanguageVisitor<? extends T>)visitor).visitTipoInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tipo);
		try {
			setState(182);
			switch (_input.LA(1)) {
			case TK_TIPO_INT:
				_localctx = new TipoIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(180); match(TK_TIPO_INT);
				}
				break;
			case TK_TIPO_FLOAT:
				_localctx = new TipoFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(181); match(TK_TIPO_FLOAT);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 5);
		case 1: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00bb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\6\2,\n\2\r\2\16\2-\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\5\4?\n\4\3\4\3\4\3\4\7"+
		"\4D\n\4\f\4\16\4G\13\4\3\4\3\4\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7"+
		"\te\n\t\f\t\16\th\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n"+
		"\n\3\13\3\13\5\13x\n\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0080\n\f\3\f\3"+
		"\f\3\r\3\r\7\r\u0086\n\r\f\r\16\r\u0089\13\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u0092\n\16\f\16\16\16\u0095\13\16\5\16\u0097\n\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a6"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00ae\n\20\f\20\16\20\u00b1\13"+
		"\20\3\21\3\21\5\21\u00b5\n\21\3\22\3\22\5\22\u00b9\n\22\3\22\2\3\36\23"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\5\3\2\n\13\3\2\23\24\3\2"+
		"\25\26\u00c3\2\'\3\2\2\2\4/\3\2\2\2\6\63\3\2\2\2\bL\3\2\2\2\nN\3\2\2\2"+
		"\fX\3\2\2\2\16Z\3\2\2\2\20_\3\2\2\2\22l\3\2\2\2\24u\3\2\2\2\26{\3\2\2"+
		"\2\30\u0083\3\2\2\2\32\u008c\3\2\2\2\34\u009a\3\2\2\2\36\u00a5\3\2\2\2"+
		" \u00b4\3\2\2\2\"\u00b8\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2"+
		"\2\'(\3\2\2\2(+\3\2\2\2)\'\3\2\2\2*,\5\6\4\2+*\3\2\2\2,-\3\2\2\2-+\3\2"+
		"\2\2-.\3\2\2\2.\3\3\2\2\2/\60\5\"\22\2\60\61\7\32\2\2\61\62\7\t\2\2\62"+
		"\5\3\2\2\2\63\64\5\b\5\2\64\65\7\32\2\2\65>\7\6\2\2\66;\5\n\6\2\678\7"+
		"\5\2\28:\5\n\6\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<?\3\2\2\2="+
		";\3\2\2\2>\66\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\4\2\2AE\7\3\2\2BD\5\f\7"+
		"\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\b\2"+
		"\2I\7\3\2\2\2JM\7\17\2\2KM\5\"\22\2LJ\3\2\2\2LK\3\2\2\2M\t\3\2\2\2NO\5"+
		"\"\22\2OP\7\32\2\2P\13\3\2\2\2QY\5\30\r\2RY\5\16\b\2SY\5\20\t\2TY\5\22"+
		"\n\2UY\5\24\13\2VY\5\26\f\2WY\5\34\17\2XQ\3\2\2\2XR\3\2\2\2XS\3\2\2\2"+
		"XT\3\2\2\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\r\3\2\2\2Z[\7\32\2\2[\\\7\7"+
		"\2\2\\]\5\36\20\2]^\7\t\2\2^\17\3\2\2\2_`\t\2\2\2`a\7\6\2\2af\5\36\20"+
		"\2bc\7\5\2\2ce\5\36\20\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2"+
		"\2\2hf\3\2\2\2ij\7\4\2\2jk\7\t\2\2k\21\3\2\2\2lm\7\20\2\2mn\7\6\2\2no"+
		"\5\36\20\2op\7\4\2\2ps\5\f\7\2qr\7\21\2\2rt\5\f\7\2sq\3\2\2\2st\3\2\2"+
		"\2t\23\3\2\2\2uw\7\22\2\2vx\5\36\20\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz"+
		"\7\t\2\2z\25\3\2\2\2{|\5\"\22\2|\177\7\32\2\2}~\7\7\2\2~\u0080\5\36\20"+
		"\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7\t"+
		"\2\2\u0082\27\3\2\2\2\u0083\u0087\7\3\2\2\u0084\u0086\5\f\7\2\u0085\u0084"+
		"\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\b\2\2\u008b\31\3\2\2"+
		"\2\u008c\u008d\7\32\2\2\u008d\u0096\7\6\2\2\u008e\u0093\5\36\20\2\u008f"+
		"\u0090\7\5\2\2\u0090\u0092\5\36\20\2\u0091\u008f\3\2\2\2\u0092\u0095\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u008e\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\7\4\2\2\u0099\33\3\2\2\2\u009a\u009b\5\32\16\2\u009b"+
		"\u009c\7\t\2\2\u009c\35\3\2\2\2\u009d\u009e\b\20\1\2\u009e\u00a6\5\32"+
		"\16\2\u009f\u00a0\7\6\2\2\u00a0\u00a1\5\36\20\2\u00a1\u00a2\7\4\2\2\u00a2"+
		"\u00a6\3\2\2\2\u00a3\u00a6\5 \21\2\u00a4\u00a6\7\32\2\2\u00a5\u009d\3"+
		"\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00af\3\2\2\2\u00a7\u00a8\f\7\2\2\u00a8\u00a9\t\3\2\2\u00a9\u00ae\5\36"+
		"\20\b\u00aa\u00ab\f\6\2\2\u00ab\u00ac\t\4\2\2\u00ac\u00ae\5\36\20\7\u00ad"+
		"\u00a7\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\37\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b5"+
		"\7\30\2\2\u00b3\u00b5\7\31\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2"+
		"\u00b5!\3\2\2\2\u00b6\u00b9\7\r\2\2\u00b7\u00b9\7\16\2\2\u00b8\u00b6\3"+
		"\2\2\2\u00b8\u00b7\3\2\2\2\u00b9#\3\2\2\2\25\'-;>ELXfsw\177\u0087\u0093"+
		"\u0096\u00a5\u00ad\u00af\u00b4\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}