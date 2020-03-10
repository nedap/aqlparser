// Generated from com/nedap/aqlparser/AQL.g4 by ANTLR 4.8
package com.nedap.aqlparser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, WS=3, COMMENT=4, SELECT=5, TOP=6, FORWARD=7, BACKWARD=8, 
		AS=9, CONTAINS=10, WHERE=11, ORDERBY=12, TIMEWINDOW=13, FROM=14, DESC=15, 
		DESCENDING=16, ASC=17, ASCENDING=18, EHR=19, AND=20, OR=21, XOR=22, NOT=23, 
		MATCHES=24, EXISTS=25, VERSION=26, VERSIONED_OBJECT=27, LATEST_VERSION=28, 
		ALL_VERSIONS=29, BOOLEAN=30, NODEID=31, IDENTIFIER=32, INTEGER=33, FLOAT=34, 
		DATE=35, PARAMETER=36, UNIQUEID=37, ARCHETYPEID=38, COMPARABLEOPERATOR=39, 
		URIVALUE=40, REGEXPATTERN=41, STRING=42, QUOTE=43, SLASH=44, COMMA=45, 
		OPENBRACKET=46, CLOSEBRACKET=47, OPEN=48, CLOSE=49;
	public static final int
		RULE_query = 0, RULE_selectClause = 1, RULE_topClause = 2, RULE_selectExpr = 3, 
		RULE_selectVar = 4, RULE_fromClause = 5, RULE_whereClause = 6, RULE_orderByClause = 7, 
		RULE_orderByExpr = 8, RULE_identifiedPath = 9, RULE_pathPart = 10, RULE_objectPath = 11, 
		RULE_predicateOperand = 12, RULE_operand = 13, RULE_standardPredicate = 14, 
		RULE_standardPredicateExpr = 15, RULE_archetypePredicate = 16, RULE_nodePredicate = 17, 
		RULE_nodePredicateExpr = 18, RULE_nodePredicateOperand = 19, RULE_identifiedExpr = 20, 
		RULE_matchesOperand = 21, RULE_valueListItems = 22, RULE_contains = 23, 
		RULE_containsExpression = 24, RULE_classExpr = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "selectClause", "topClause", "selectExpr", "selectVar", "fromClause", 
			"whereClause", "orderByClause", "orderByExpr", "identifiedPath", "pathPart", 
			"objectPath", "predicateOperand", "operand", "standardPredicate", "standardPredicateExpr", 
			"archetypePredicate", "nodePredicate", "nodePredicateExpr", "nodePredicateOperand", 
			"identifiedExpr", "matchesOperand", "valueListItems", "contains", "containsExpression", 
			"classExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "'''", "'/'", "','", "'['", 
			"']'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "WS", "COMMENT", "SELECT", "TOP", "FORWARD", "BACKWARD", 
			"AS", "CONTAINS", "WHERE", "ORDERBY", "TIMEWINDOW", "FROM", "DESC", "DESCENDING", 
			"ASC", "ASCENDING", "EHR", "AND", "OR", "XOR", "NOT", "MATCHES", "EXISTS", 
			"VERSION", "VERSIONED_OBJECT", "LATEST_VERSION", "ALL_VERSIONS", "BOOLEAN", 
			"NODEID", "IDENTIFIER", "INTEGER", "FLOAT", "DATE", "PARAMETER", "UNIQUEID", 
			"ARCHETYPEID", "COMPARABLEOPERATOR", "URIVALUE", "REGEXPATTERN", "STRING", 
			"QUOTE", "SLASH", "COMMA", "OPENBRACKET", "CLOSEBRACKET", "OPEN", "CLOSE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "AQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AQLParser.EOF, 0); }
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			selectClause();
			setState(53);
			fromClause();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(54);
				whereClause();
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDERBY) {
				{
				setState(57);
				orderByClause();
				}
			}

			setState(60);
			match(EOF);
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
		public TerminalNode SELECT() { return getToken(AQLParser.SELECT, 0); }
		public SelectExprContext selectExpr() {
			return getRuleContext(SelectExprContext.class,0);
		}
		public TopClauseContext topClause() {
			return getRuleContext(TopClauseContext.class,0);
		}
		public SelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSelectClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitSelectClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectClauseContext selectClause() throws RecognitionException {
		SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(SELECT);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TOP) {
				{
				setState(63);
				topClause();
				}
			}

			setState(66);
			selectExpr();
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

	public static class TopClauseContext extends ParserRuleContext {
		public Token direction;
		public TerminalNode TOP() { return getToken(AQLParser.TOP, 0); }
		public TerminalNode INTEGER() { return getToken(AQLParser.INTEGER, 0); }
		public TerminalNode FORWARD() { return getToken(AQLParser.FORWARD, 0); }
		public TerminalNode BACKWARD() { return getToken(AQLParser.BACKWARD, 0); }
		public TopClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterTopClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitTopClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitTopClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopClauseContext topClause() throws RecognitionException {
		TopClauseContext _localctx = new TopClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_topClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(TOP);
			setState(69);
			match(INTEGER);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FORWARD || _la==BACKWARD) {
				{
				setState(70);
				((TopClauseContext)_localctx).direction = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FORWARD || _la==BACKWARD) ) {
					((TopClauseContext)_localctx).direction = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class SelectExprContext extends ParserRuleContext {
		public List<SelectVarContext> selectVar() {
			return getRuleContexts(SelectVarContext.class);
		}
		public SelectVarContext selectVar(int i) {
			return getRuleContext(SelectVarContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AQLParser.COMMA, i);
		}
		public SelectExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSelectExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSelectExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitSelectExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectExprContext selectExpr() throws RecognitionException {
		SelectExprContext _localctx = new SelectExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			selectVar();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(74);
				match(COMMA);
				setState(75);
				selectVar();
				}
				}
				setState(80);
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

	public static class SelectVarContext extends ParserRuleContext {
		public IdentifiedPathContext identifiedPath() {
			return getRuleContext(IdentifiedPathContext.class,0);
		}
		public TerminalNode AS() { return getToken(AQLParser.AS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public SelectVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSelectVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSelectVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitSelectVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectVarContext selectVar() throws RecognitionException {
		SelectVarContext _localctx = new SelectVarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_selectVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			identifiedPath();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(82);
				match(AS);
				setState(83);
				match(IDENTIFIER);
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

	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(AQLParser.FROM, 0); }
		public ContainsExpressionContext containsExpression() {
			return getRuleContext(ContainsExpressionContext.class,0);
		}
		public ContainsContext contains() {
			return getRuleContext(ContainsContext.class,0);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitFromClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fromClause);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(FROM);
				setState(87);
				containsExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(FROM);
				setState(89);
				contains();
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

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(AQLParser.WHERE, 0); }
		public IdentifiedExprContext identifiedExpr() {
			return getRuleContext(IdentifiedExprContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(WHERE);
			setState(93);
			identifiedExpr(0);
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
		public TerminalNode ORDERBY() { return getToken(AQLParser.ORDERBY, 0); }
		public List<OrderByExprContext> orderByExpr() {
			return getRuleContexts(OrderByExprContext.class);
		}
		public OrderByExprContext orderByExpr(int i) {
			return getRuleContext(OrderByExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AQLParser.COMMA, i);
		}
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitOrderByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitOrderByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_orderByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ORDERBY);
			setState(96);
			orderByExpr();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(97);
				match(COMMA);
				setState(98);
				orderByExpr();
				}
				}
				setState(103);
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

	public static class OrderByExprContext extends ParserRuleContext {
		public Token order;
		public IdentifiedPathContext identifiedPath() {
			return getRuleContext(IdentifiedPathContext.class,0);
		}
		public TerminalNode ASC() { return getToken(AQLParser.ASC, 0); }
		public TerminalNode ASCENDING() { return getToken(AQLParser.ASCENDING, 0); }
		public TerminalNode DESC() { return getToken(AQLParser.DESC, 0); }
		public TerminalNode DESCENDING() { return getToken(AQLParser.DESCENDING, 0); }
		public OrderByExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterOrderByExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitOrderByExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitOrderByExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByExprContext orderByExpr() throws RecognitionException {
		OrderByExprContext _localctx = new OrderByExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_orderByExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			identifiedPath();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DESC) | (1L << DESCENDING) | (1L << ASC) | (1L << ASCENDING))) != 0)) {
				{
				setState(105);
				((OrderByExprContext)_localctx).order = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DESC) | (1L << DESCENDING) | (1L << ASC) | (1L << ASCENDING))) != 0)) ) {
					((OrderByExprContext)_localctx).order = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class IdentifiedPathContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public NodePredicateContext nodePredicate() {
			return getRuleContext(NodePredicateContext.class,0);
		}
		public List<TerminalNode> SLASH() { return getTokens(AQLParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(AQLParser.SLASH, i);
		}
		public List<PathPartContext> pathPart() {
			return getRuleContexts(PathPartContext.class);
		}
		public PathPartContext pathPart(int i) {
			return getRuleContext(PathPartContext.class,i);
		}
		public IdentifiedPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiedPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterIdentifiedPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitIdentifiedPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitIdentifiedPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifiedPathContext identifiedPath() throws RecognitionException {
		IdentifiedPathContext _localctx = new IdentifiedPathContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_identifiedPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(IDENTIFIER);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPENBRACKET) {
				{
				setState(109);
				nodePredicate();
				}
			}

			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SLASH) {
				{
				{
				setState(112);
				match(SLASH);
				setState(113);
				pathPart();
				}
				}
				setState(118);
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

	public static class PathPartContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public NodePredicateContext nodePredicate() {
			return getRuleContext(NodePredicateContext.class,0);
		}
		public PathPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPathPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPathPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitPathPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPartContext pathPart() throws RecognitionException {
		PathPartContext _localctx = new PathPartContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pathPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(IDENTIFIER);
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(120);
				nodePredicate();
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

	public static class ObjectPathContext extends ParserRuleContext {
		public List<PathPartContext> pathPart() {
			return getRuleContexts(PathPartContext.class);
		}
		public PathPartContext pathPart(int i) {
			return getRuleContext(PathPartContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(AQLParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(AQLParser.SLASH, i);
		}
		public ObjectPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterObjectPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitObjectPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitObjectPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectPathContext objectPath() throws RecognitionException {
		ObjectPathContext _localctx = new ObjectPathContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_objectPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			pathPart();
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124);
					match(SLASH);
					setState(125);
					pathPart();
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class PredicateOperandContext extends ParserRuleContext {
		public ObjectPathContext objectPath() {
			return getRuleContext(ObjectPathContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public PredicateOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPredicateOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPredicateOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitPredicateOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateOperandContext predicateOperand() throws RecognitionException {
		PredicateOperandContext _localctx = new PredicateOperandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_predicateOperand);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				objectPath();
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case DATE:
			case PARAMETER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				operand();
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

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(AQLParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(AQLParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(AQLParser.FLOAT, 0); }
		public TerminalNode DATE() { return getToken(AQLParser.DATE, 0); }
		public TerminalNode PARAMETER() { return getToken(AQLParser.PARAMETER, 0); }
		public TerminalNode BOOLEAN() { return getToken(AQLParser.BOOLEAN, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << DATE) | (1L << PARAMETER) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class StandardPredicateContext extends ParserRuleContext {
		public TerminalNode OPENBRACKET() { return getToken(AQLParser.OPENBRACKET, 0); }
		public StandardPredicateExprContext standardPredicateExpr() {
			return getRuleContext(StandardPredicateExprContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(AQLParser.CLOSEBRACKET, 0); }
		public StandardPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standardPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterStandardPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitStandardPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitStandardPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandardPredicateContext standardPredicate() throws RecognitionException {
		StandardPredicateContext _localctx = new StandardPredicateContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_standardPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(OPENBRACKET);
			setState(138);
			standardPredicateExpr(0);
			setState(139);
			match(CLOSEBRACKET);
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

	public static class StandardPredicateExprContext extends ParserRuleContext {
		public List<PredicateOperandContext> predicateOperand() {
			return getRuleContexts(PredicateOperandContext.class);
		}
		public PredicateOperandContext predicateOperand(int i) {
			return getRuleContext(PredicateOperandContext.class,i);
		}
		public TerminalNode COMPARABLEOPERATOR() { return getToken(AQLParser.COMPARABLEOPERATOR, 0); }
		public TerminalNode NOT() { return getToken(AQLParser.NOT, 0); }
		public List<StandardPredicateExprContext> standardPredicateExpr() {
			return getRuleContexts(StandardPredicateExprContext.class);
		}
		public StandardPredicateExprContext standardPredicateExpr(int i) {
			return getRuleContext(StandardPredicateExprContext.class,i);
		}
		public TerminalNode OPEN() { return getToken(AQLParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(AQLParser.CLOSE, 0); }
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public TerminalNode XOR() { return getToken(AQLParser.XOR, 0); }
		public TerminalNode OR() { return getToken(AQLParser.OR, 0); }
		public StandardPredicateExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standardPredicateExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterStandardPredicateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitStandardPredicateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitStandardPredicateExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandardPredicateExprContext standardPredicateExpr() throws RecognitionException {
		return standardPredicateExpr(0);
	}

	private StandardPredicateExprContext standardPredicateExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StandardPredicateExprContext _localctx = new StandardPredicateExprContext(_ctx, _parentState);
		StandardPredicateExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_standardPredicateExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case IDENTIFIER:
			case INTEGER:
			case FLOAT:
			case DATE:
			case PARAMETER:
			case STRING:
				{
				setState(142);
				predicateOperand();
				setState(143);
				match(COMPARABLEOPERATOR);
				setState(144);
				predicateOperand();
				}
				break;
			case NOT:
				{
				setState(146);
				match(NOT);
				setState(147);
				standardPredicateExpr(5);
				}
				break;
			case OPEN:
				{
				setState(148);
				match(OPEN);
				setState(149);
				standardPredicateExpr(0);
				setState(150);
				match(CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(163);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new StandardPredicateExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_standardPredicateExpr);
						setState(154);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(155);
						match(AND);
						setState(156);
						standardPredicateExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new StandardPredicateExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_standardPredicateExpr);
						setState(157);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(158);
						match(XOR);
						setState(159);
						standardPredicateExpr(4);
						}
						break;
					case 3:
						{
						_localctx = new StandardPredicateExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_standardPredicateExpr);
						setState(160);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(161);
						match(OR);
						setState(162);
						standardPredicateExpr(3);
						}
						break;
					}
					} 
				}
				setState(167);
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

	public static class ArchetypePredicateContext extends ParserRuleContext {
		public TerminalNode OPENBRACKET() { return getToken(AQLParser.OPENBRACKET, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(AQLParser.CLOSEBRACKET, 0); }
		public TerminalNode ARCHETYPEID() { return getToken(AQLParser.ARCHETYPEID, 0); }
		public TerminalNode PARAMETER() { return getToken(AQLParser.PARAMETER, 0); }
		public TerminalNode REGEXPATTERN() { return getToken(AQLParser.REGEXPATTERN, 0); }
		public ArchetypePredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_archetypePredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterArchetypePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitArchetypePredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitArchetypePredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArchetypePredicateContext archetypePredicate() throws RecognitionException {
		ArchetypePredicateContext _localctx = new ArchetypePredicateContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_archetypePredicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(OPENBRACKET);
			setState(169);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PARAMETER) | (1L << ARCHETYPEID) | (1L << REGEXPATTERN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(170);
			match(CLOSEBRACKET);
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

	public static class NodePredicateContext extends ParserRuleContext {
		public TerminalNode OPENBRACKET() { return getToken(AQLParser.OPENBRACKET, 0); }
		public NodePredicateExprContext nodePredicateExpr() {
			return getRuleContext(NodePredicateExprContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(AQLParser.CLOSEBRACKET, 0); }
		public NodePredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodePredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterNodePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitNodePredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitNodePredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodePredicateContext nodePredicate() throws RecognitionException {
		NodePredicateContext _localctx = new NodePredicateContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_nodePredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(OPENBRACKET);
			setState(173);
			nodePredicateExpr(0);
			setState(174);
			match(CLOSEBRACKET);
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

	public static class NodePredicateExprContext extends ParserRuleContext {
		public NodePredicateOperandContext nodePredicateOperand() {
			return getRuleContext(NodePredicateOperandContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(AQLParser.OPEN, 0); }
		public List<NodePredicateExprContext> nodePredicateExpr() {
			return getRuleContexts(NodePredicateExprContext.class);
		}
		public NodePredicateExprContext nodePredicateExpr(int i) {
			return getRuleContext(NodePredicateExprContext.class,i);
		}
		public TerminalNode CLOSE() { return getToken(AQLParser.CLOSE, 0); }
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public TerminalNode XOR() { return getToken(AQLParser.XOR, 0); }
		public TerminalNode OR() { return getToken(AQLParser.OR, 0); }
		public NodePredicateExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodePredicateExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterNodePredicateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitNodePredicateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitNodePredicateExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodePredicateExprContext nodePredicateExpr() throws RecognitionException {
		return nodePredicateExpr(0);
	}

	private NodePredicateExprContext nodePredicateExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NodePredicateExprContext _localctx = new NodePredicateExprContext(_ctx, _parentState);
		NodePredicateExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_nodePredicateExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case NODEID:
			case IDENTIFIER:
			case INTEGER:
			case FLOAT:
			case DATE:
			case PARAMETER:
			case ARCHETYPEID:
			case STRING:
				{
				setState(177);
				nodePredicateOperand();
				}
				break;
			case OPEN:
				{
				setState(178);
				match(OPEN);
				setState(179);
				nodePredicateExpr(0);
				setState(180);
				match(CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(193);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new NodePredicateExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nodePredicateExpr);
						setState(184);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(185);
						match(AND);
						setState(186);
						nodePredicateExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new NodePredicateExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nodePredicateExpr);
						setState(187);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(188);
						match(XOR);
						setState(189);
						nodePredicateExpr(4);
						}
						break;
					case 3:
						{
						_localctx = new NodePredicateExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nodePredicateExpr);
						setState(190);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(191);
						match(OR);
						setState(192);
						nodePredicateExpr(3);
						}
						break;
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class NodePredicateOperandContext extends ParserRuleContext {
		public TerminalNode NODEID() { return getToken(AQLParser.NODEID, 0); }
		public TerminalNode COMMA() { return getToken(AQLParser.COMMA, 0); }
		public TerminalNode STRING() { return getToken(AQLParser.STRING, 0); }
		public List<TerminalNode> PARAMETER() { return getTokens(AQLParser.PARAMETER); }
		public TerminalNode PARAMETER(int i) {
			return getToken(AQLParser.PARAMETER, i);
		}
		public TerminalNode ARCHETYPEID() { return getToken(AQLParser.ARCHETYPEID, 0); }
		public List<PredicateOperandContext> predicateOperand() {
			return getRuleContexts(PredicateOperandContext.class);
		}
		public PredicateOperandContext predicateOperand(int i) {
			return getRuleContext(PredicateOperandContext.class,i);
		}
		public TerminalNode COMPARABLEOPERATOR() { return getToken(AQLParser.COMPARABLEOPERATOR, 0); }
		public TerminalNode MATCHES() { return getToken(AQLParser.MATCHES, 0); }
		public TerminalNode REGEXPATTERN() { return getToken(AQLParser.REGEXPATTERN, 0); }
		public NodePredicateOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodePredicateOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterNodePredicateOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitNodePredicateOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitNodePredicateOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodePredicateOperandContext nodePredicateOperand() throws RecognitionException {
		NodePredicateOperandContext _localctx = new NodePredicateOperandContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_nodePredicateOperand);
		int _la;
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(NODEID);
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(199);
					match(COMMA);
					setState(200);
					_la = _input.LA(1);
					if ( !(_la==PARAMETER || _la==STRING) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(ARCHETYPEID);
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(204);
					match(COMMA);
					setState(205);
					_la = _input.LA(1);
					if ( !(_la==PARAMETER || _la==STRING) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				match(PARAMETER);
				setState(211);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(209);
					match(COMMA);
					setState(210);
					_la = _input.LA(1);
					if ( !(_la==PARAMETER || _la==STRING) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(213);
				predicateOperand();
				setState(218);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMPARABLEOPERATOR:
					{
					{
					setState(214);
					match(COMPARABLEOPERATOR);
					setState(215);
					predicateOperand();
					}
					}
					break;
				case MATCHES:
					{
					{
					setState(216);
					match(MATCHES);
					setState(217);
					match(REGEXPATTERN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class IdentifiedExprContext extends ParserRuleContext {
		public List<PredicateOperandContext> predicateOperand() {
			return getRuleContexts(PredicateOperandContext.class);
		}
		public PredicateOperandContext predicateOperand(int i) {
			return getRuleContext(PredicateOperandContext.class,i);
		}
		public TerminalNode COMPARABLEOPERATOR() { return getToken(AQLParser.COMPARABLEOPERATOR, 0); }
		public TerminalNode MATCHES() { return getToken(AQLParser.MATCHES, 0); }
		public MatchesOperandContext matchesOperand() {
			return getRuleContext(MatchesOperandContext.class,0);
		}
		public TerminalNode NOT() { return getToken(AQLParser.NOT, 0); }
		public List<IdentifiedExprContext> identifiedExpr() {
			return getRuleContexts(IdentifiedExprContext.class);
		}
		public IdentifiedExprContext identifiedExpr(int i) {
			return getRuleContext(IdentifiedExprContext.class,i);
		}
		public TerminalNode EXISTS() { return getToken(AQLParser.EXISTS, 0); }
		public TerminalNode OPEN() { return getToken(AQLParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(AQLParser.CLOSE, 0); }
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public TerminalNode XOR() { return getToken(AQLParser.XOR, 0); }
		public TerminalNode OR() { return getToken(AQLParser.OR, 0); }
		public IdentifiedExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiedExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterIdentifiedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitIdentifiedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitIdentifiedExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifiedExprContext identifiedExpr() throws RecognitionException {
		return identifiedExpr(0);
	}

	private IdentifiedExprContext identifiedExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentifiedExprContext _localctx = new IdentifiedExprContext(_ctx, _parentState);
		IdentifiedExprContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_identifiedExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case IDENTIFIER:
			case INTEGER:
			case FLOAT:
			case DATE:
			case PARAMETER:
			case STRING:
				{
				setState(223);
				predicateOperand();
				setState(231);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					{
					setState(224);
					match(COMPARABLEOPERATOR);
					setState(225);
					predicateOperand();
					}
					}
					break;
				case 2:
					{
					{
					setState(226);
					match(MATCHES);
					setState(227);
					match(T__0);
					setState(228);
					matchesOperand();
					setState(229);
					match(T__1);
					}
					}
					break;
				}
				}
				break;
			case NOT:
				{
				setState(233);
				match(NOT);
				setState(234);
				identifiedExpr(6);
				}
				break;
			case EXISTS:
				{
				setState(235);
				match(EXISTS);
				setState(236);
				identifiedExpr(5);
				}
				break;
			case OPEN:
				{
				setState(237);
				match(OPEN);
				setState(238);
				identifiedExpr(0);
				setState(239);
				match(CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(252);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new IdentifiedExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_identifiedExpr);
						setState(243);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(244);
						match(AND);
						setState(245);
						identifiedExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new IdentifiedExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_identifiedExpr);
						setState(246);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(247);
						match(XOR);
						setState(248);
						identifiedExpr(4);
						}
						break;
					case 3:
						{
						_localctx = new IdentifiedExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_identifiedExpr);
						setState(249);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(250);
						match(OR);
						setState(251);
						identifiedExpr(3);
						}
						break;
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class MatchesOperandContext extends ParserRuleContext {
		public ValueListItemsContext valueListItems() {
			return getRuleContext(ValueListItemsContext.class,0);
		}
		public TerminalNode URIVALUE() { return getToken(AQLParser.URIVALUE, 0); }
		public MatchesOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchesOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterMatchesOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitMatchesOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitMatchesOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchesOperandContext matchesOperand() throws RecognitionException {
		MatchesOperandContext _localctx = new MatchesOperandContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_matchesOperand);
		try {
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case DATE:
			case PARAMETER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				valueListItems();
				}
				break;
			case URIVALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				match(URIVALUE);
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

	public static class ValueListItemsContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AQLParser.COMMA, i);
		}
		public ValueListItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueListItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterValueListItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitValueListItems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitValueListItems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueListItemsContext valueListItems() throws RecognitionException {
		ValueListItemsContext _localctx = new ValueListItemsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_valueListItems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			operand();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(262);
				match(COMMA);
				setState(263);
				operand();
				}
				}
				setState(268);
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

	public static class ContainsContext extends ParserRuleContext {
		public ClassExprContext classExpr() {
			return getRuleContext(ClassExprContext.class,0);
		}
		public TerminalNode CONTAINS() { return getToken(AQLParser.CONTAINS, 0); }
		public ContainsExpressionContext containsExpression() {
			return getRuleContext(ContainsExpressionContext.class,0);
		}
		public ContainsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contains; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterContains(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitContains(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitContains(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContainsContext contains() throws RecognitionException {
		ContainsContext _localctx = new ContainsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_contains);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			classExpr();
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(270);
				match(CONTAINS);
				setState(271);
				containsExpression(0);
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

	public static class ContainsExpressionContext extends ParserRuleContext {
		public ClassExprContext classExpr() {
			return getRuleContext(ClassExprContext.class,0);
		}
		public ContainsContext contains() {
			return getRuleContext(ContainsContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(AQLParser.OPEN, 0); }
		public List<ContainsExpressionContext> containsExpression() {
			return getRuleContexts(ContainsExpressionContext.class);
		}
		public ContainsExpressionContext containsExpression(int i) {
			return getRuleContext(ContainsExpressionContext.class,i);
		}
		public TerminalNode CLOSE() { return getToken(AQLParser.CLOSE, 0); }
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public TerminalNode XOR() { return getToken(AQLParser.XOR, 0); }
		public TerminalNode OR() { return getToken(AQLParser.OR, 0); }
		public ContainsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_containsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterContainsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitContainsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitContainsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContainsExpressionContext containsExpression() throws RecognitionException {
		return containsExpression(0);
	}

	private ContainsExpressionContext containsExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ContainsExpressionContext _localctx = new ContainsExpressionContext(_ctx, _parentState);
		ContainsExpressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_containsExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(275);
				classExpr();
				}
				break;
			case 2:
				{
				setState(276);
				contains();
				}
				break;
			case 3:
				{
				setState(277);
				match(OPEN);
				setState(278);
				containsExpression(0);
				setState(279);
				match(CLOSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(292);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ContainsExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_containsExpression);
						setState(283);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(284);
						match(AND);
						setState(285);
						containsExpression(7);
						}
						break;
					case 2:
						{
						_localctx = new ContainsExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_containsExpression);
						setState(286);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(287);
						match(XOR);
						setState(288);
						containsExpression(6);
						}
						break;
					case 3:
						{
						_localctx = new ContainsExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_containsExpression);
						setState(289);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(290);
						match(OR);
						setState(291);
						containsExpression(5);
						}
						break;
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	public static class ClassExprContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(AQLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(AQLParser.IDENTIFIER, i);
		}
		public ArchetypePredicateContext archetypePredicate() {
			return getRuleContext(ArchetypePredicateContext.class,0);
		}
		public StandardPredicateContext standardPredicate() {
			return getRuleContext(StandardPredicateContext.class,0);
		}
		public ClassExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterClassExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitClassExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitClassExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassExprContext classExpr() throws RecognitionException {
		ClassExprContext _localctx = new ClassExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_classExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(IDENTIFIER);
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(298);
				match(IDENTIFIER);
				}
				break;
			}
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(301);
				archetypePredicate();
				}
				break;
			case 2:
				{
				setState(302);
				standardPredicate();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return standardPredicateExpr_sempred((StandardPredicateExprContext)_localctx, predIndex);
		case 18:
			return nodePredicateExpr_sempred((NodePredicateExprContext)_localctx, predIndex);
		case 20:
			return identifiedExpr_sempred((IdentifiedExprContext)_localctx, predIndex);
		case 24:
			return containsExpression_sempred((ContainsExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean standardPredicateExpr_sempred(StandardPredicateExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean nodePredicateExpr_sempred(NodePredicateExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean identifiedExpr_sempred(IdentifiedExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean containsExpression_sempred(ContainsExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0134\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\5\2:\n\2\3\2\5\2=\n\2\3\2\3\2\3\3\3\3"+
		"\5\3C\n\3\3\3\3\3\3\4\3\4\3\4\5\4J\n\4\3\5\3\5\3\5\7\5O\n\5\f\5\16\5R"+
		"\13\5\3\6\3\6\3\6\5\6W\n\6\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\7\tf\n\t\f\t\16\ti\13\t\3\n\3\n\5\nm\n\n\3\13\3\13\5\13q\n"+
		"\13\3\13\3\13\7\13u\n\13\f\13\16\13x\13\13\3\f\3\f\5\f|\n\f\3\r\3\r\3"+
		"\r\7\r\u0081\n\r\f\r\16\r\u0084\13\r\3\16\3\16\5\16\u0088\n\16\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u009b\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u00a6\n\21\f\21\16\21\u00a9\13\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b9\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00c4\n\24\f\24\16\24\u00c7\13\24"+
		"\3\25\3\25\3\25\5\25\u00cc\n\25\3\25\3\25\3\25\5\25\u00d1\n\25\3\25\3"+
		"\25\3\25\5\25\u00d6\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u00dd\n\25\5\25"+
		"\u00df\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00ea\n"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00f4\n\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00ff\n\26\f\26\16\26\u0102\13"+
		"\26\3\27\3\27\5\27\u0106\n\27\3\30\3\30\3\30\7\30\u010b\n\30\f\30\16\30"+
		"\u010e\13\30\3\31\3\31\3\31\5\31\u0113\n\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\5\32\u011c\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u0127\n\32\f\32\16\32\u012a\13\32\3\33\3\33\5\33\u012e\n\33\3\33"+
		"\3\33\5\33\u0132\n\33\3\33\2\6 &*\62\34\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\2\7\3\2\t\n\3\2\21\24\5\2  #&,,\5\2&&((++"+
		"\4\2&&,,\2\u014a\2\66\3\2\2\2\4@\3\2\2\2\6F\3\2\2\2\bK\3\2\2\2\nS\3\2"+
		"\2\2\f\\\3\2\2\2\16^\3\2\2\2\20a\3\2\2\2\22j\3\2\2\2\24n\3\2\2\2\26y\3"+
		"\2\2\2\30}\3\2\2\2\32\u0087\3\2\2\2\34\u0089\3\2\2\2\36\u008b\3\2\2\2"+
		" \u009a\3\2\2\2\"\u00aa\3\2\2\2$\u00ae\3\2\2\2&\u00b8\3\2\2\2(\u00de\3"+
		"\2\2\2*\u00f3\3\2\2\2,\u0105\3\2\2\2.\u0107\3\2\2\2\60\u010f\3\2\2\2\62"+
		"\u011b\3\2\2\2\64\u012b\3\2\2\2\66\67\5\4\3\2\679\5\f\7\28:\5\16\b\29"+
		"8\3\2\2\29:\3\2\2\2:<\3\2\2\2;=\5\20\t\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2"+
		">?\7\2\2\3?\3\3\2\2\2@B\7\7\2\2AC\5\6\4\2BA\3\2\2\2BC\3\2\2\2CD\3\2\2"+
		"\2DE\5\b\5\2E\5\3\2\2\2FG\7\b\2\2GI\7#\2\2HJ\t\2\2\2IH\3\2\2\2IJ\3\2\2"+
		"\2J\7\3\2\2\2KP\5\n\6\2LM\7/\2\2MO\5\n\6\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2"+
		"\2PQ\3\2\2\2Q\t\3\2\2\2RP\3\2\2\2SV\5\24\13\2TU\7\13\2\2UW\7\"\2\2VT\3"+
		"\2\2\2VW\3\2\2\2W\13\3\2\2\2XY\7\20\2\2Y]\5\62\32\2Z[\7\20\2\2[]\5\60"+
		"\31\2\\X\3\2\2\2\\Z\3\2\2\2]\r\3\2\2\2^_\7\r\2\2_`\5*\26\2`\17\3\2\2\2"+
		"ab\7\16\2\2bg\5\22\n\2cd\7/\2\2df\5\22\n\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2"+
		"\2gh\3\2\2\2h\21\3\2\2\2ig\3\2\2\2jl\5\24\13\2km\t\3\2\2lk\3\2\2\2lm\3"+
		"\2\2\2m\23\3\2\2\2np\7\"\2\2oq\5$\23\2po\3\2\2\2pq\3\2\2\2qv\3\2\2\2r"+
		"s\7.\2\2su\5\26\f\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\25\3\2\2"+
		"\2xv\3\2\2\2y{\7\"\2\2z|\5$\23\2{z\3\2\2\2{|\3\2\2\2|\27\3\2\2\2}\u0082"+
		"\5\26\f\2~\177\7.\2\2\177\u0081\5\26\f\2\u0080~\3\2\2\2\u0081\u0084\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\31\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0088\5\30\r\2\u0086\u0088\5\34\17\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0086\3\2\2\2\u0088\33\3\2\2\2\u0089\u008a\t\4\2\2\u008a"+
		"\35\3\2\2\2\u008b\u008c\7\60\2\2\u008c\u008d\5 \21\2\u008d\u008e\7\61"+
		"\2\2\u008e\37\3\2\2\2\u008f\u0090\b\21\1\2\u0090\u0091\5\32\16\2\u0091"+
		"\u0092\7)\2\2\u0092\u0093\5\32\16\2\u0093\u009b\3\2\2\2\u0094\u0095\7"+
		"\31\2\2\u0095\u009b\5 \21\7\u0096\u0097\7\62\2\2\u0097\u0098\5 \21\2\u0098"+
		"\u0099\7\63\2\2\u0099\u009b\3\2\2\2\u009a\u008f\3\2\2\2\u009a\u0094\3"+
		"\2\2\2\u009a\u0096\3\2\2\2\u009b\u00a7\3\2\2\2\u009c\u009d\f\6\2\2\u009d"+
		"\u009e\7\26\2\2\u009e\u00a6\5 \21\7\u009f\u00a0\f\5\2\2\u00a0\u00a1\7"+
		"\30\2\2\u00a1\u00a6\5 \21\6\u00a2\u00a3\f\4\2\2\u00a3\u00a4\7\27\2\2\u00a4"+
		"\u00a6\5 \21\5\u00a5\u009c\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a2\3\2"+
		"\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"!\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7\60\2\2\u00ab\u00ac\t\5\2\2"+
		"\u00ac\u00ad\7\61\2\2\u00ad#\3\2\2\2\u00ae\u00af\7\60\2\2\u00af\u00b0"+
		"\5&\24\2\u00b0\u00b1\7\61\2\2\u00b1%\3\2\2\2\u00b2\u00b3\b\24\1\2\u00b3"+
		"\u00b9\5(\25\2\u00b4\u00b5\7\62\2\2\u00b5\u00b6\5&\24\2\u00b6\u00b7\7"+
		"\63\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b2\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b9"+
		"\u00c5\3\2\2\2\u00ba\u00bb\f\6\2\2\u00bb\u00bc\7\26\2\2\u00bc\u00c4\5"+
		"&\24\7\u00bd\u00be\f\5\2\2\u00be\u00bf\7\30\2\2\u00bf\u00c4\5&\24\6\u00c0"+
		"\u00c1\f\4\2\2\u00c1\u00c2\7\27\2\2\u00c2\u00c4\5&\24\5\u00c3\u00ba\3"+
		"\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\'\3\2\2\2\u00c7\u00c5\3\2\2\2"+
		"\u00c8\u00cb\7!\2\2\u00c9\u00ca\7/\2\2\u00ca\u00cc\t\6\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00df\3\2\2\2\u00cd\u00d0\7(\2\2\u00ce"+
		"\u00cf\7/\2\2\u00cf\u00d1\t\6\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00df\3\2\2\2\u00d2\u00d5\7&\2\2\u00d3\u00d4\7/\2\2\u00d4\u00d6"+
		"\t\6\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00df\3\2\2\2\u00d7"+
		"\u00dc\5\32\16\2\u00d8\u00d9\7)\2\2\u00d9\u00dd\5\32\16\2\u00da\u00db"+
		"\7\32\2\2\u00db\u00dd\7+\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00df\3\2\2\2\u00de\u00c8\3\2\2\2\u00de\u00cd\3\2\2\2\u00de\u00d2\3\2"+
		"\2\2\u00de\u00d7\3\2\2\2\u00df)\3\2\2\2\u00e0\u00e1\b\26\1\2\u00e1\u00e9"+
		"\5\32\16\2\u00e2\u00e3\7)\2\2\u00e3\u00ea\5\32\16\2\u00e4\u00e5\7\32\2"+
		"\2\u00e5\u00e6\7\3\2\2\u00e6\u00e7\5,\27\2\u00e7\u00e8\7\4\2\2\u00e8\u00ea"+
		"\3\2\2\2\u00e9\u00e2\3\2\2\2\u00e9\u00e4\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00f4\3\2\2\2\u00eb\u00ec\7\31\2\2\u00ec\u00f4\5*\26\b\u00ed\u00ee\7"+
		"\33\2\2\u00ee\u00f4\5*\26\7\u00ef\u00f0\7\62\2\2\u00f0\u00f1\5*\26\2\u00f1"+
		"\u00f2\7\63\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00e0\3\2\2\2\u00f3\u00eb\3"+
		"\2\2\2\u00f3\u00ed\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4\u0100\3\2\2\2\u00f5"+
		"\u00f6\f\6\2\2\u00f6\u00f7\7\26\2\2\u00f7\u00ff\5*\26\7\u00f8\u00f9\f"+
		"\5\2\2\u00f9\u00fa\7\30\2\2\u00fa\u00ff\5*\26\6\u00fb\u00fc\f\4\2\2\u00fc"+
		"\u00fd\7\27\2\2\u00fd\u00ff\5*\26\5\u00fe\u00f5\3\2\2\2\u00fe\u00f8\3"+
		"\2\2\2\u00fe\u00fb\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101+\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0106\5.\30\2"+
		"\u0104\u0106\7*\2\2\u0105\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106-\3\2"+
		"\2\2\u0107\u010c\5\34\17\2\u0108\u0109\7/\2\2\u0109\u010b\5\34\17\2\u010a"+
		"\u0108\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d/\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0112\5\64\33\2\u0110\u0111"+
		"\7\f\2\2\u0111\u0113\5\62\32\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2"+
		"\u0113\61\3\2\2\2\u0114\u0115\b\32\1\2\u0115\u011c\5\64\33\2\u0116\u011c"+
		"\5\60\31\2\u0117\u0118\7\62\2\2\u0118\u0119\5\62\32\2\u0119\u011a\7\63"+
		"\2\2\u011a\u011c\3\2\2\2\u011b\u0114\3\2\2\2\u011b\u0116\3\2\2\2\u011b"+
		"\u0117\3\2\2\2\u011c\u0128\3\2\2\2\u011d\u011e\f\b\2\2\u011e\u011f\7\26"+
		"\2\2\u011f\u0127\5\62\32\t\u0120\u0121\f\7\2\2\u0121\u0122\7\30\2\2\u0122"+
		"\u0127\5\62\32\b\u0123\u0124\f\6\2\2\u0124\u0125\7\27\2\2\u0125\u0127"+
		"\5\62\32\7\u0126\u011d\3\2\2\2\u0126\u0120\3\2\2\2\u0126\u0123\3\2\2\2"+
		"\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\63"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012d\7\"\2\2\u012c\u012e\7\"\2\2\u012d"+
		"\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u0132\5\""+
		"\22\2\u0130\u0132\5\36\20\2\u0131\u012f\3\2\2\2\u0131\u0130\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\65\3\2\2\2\'9<BIPV\\glpv{\u0082\u0087\u009a\u00a5"+
		"\u00a7\u00b8\u00c3\u00c5\u00cb\u00d0\u00d5\u00dc\u00de\u00e9\u00f3\u00fe"+
		"\u0100\u0105\u010c\u0112\u011b\u0126\u0128\u012d\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}