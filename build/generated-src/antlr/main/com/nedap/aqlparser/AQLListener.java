// Generated from com/nedap/aqlparser/AQL.g4 by ANTLR 4.8
package com.nedap.aqlparser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AQLParser}.
 */
public interface AQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AQLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(AQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(AQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void enterSelectClause(AQLParser.SelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void exitSelectClause(AQLParser.SelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#topClause}.
	 * @param ctx the parse tree
	 */
	void enterTopClause(AQLParser.TopClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#topClause}.
	 * @param ctx the parse tree
	 */
	void exitTopClause(AQLParser.TopClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#selectExpr}.
	 * @param ctx the parse tree
	 */
	void enterSelectExpr(AQLParser.SelectExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#selectExpr}.
	 * @param ctx the parse tree
	 */
	void exitSelectExpr(AQLParser.SelectExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#selectVar}.
	 * @param ctx the parse tree
	 */
	void enterSelectVar(AQLParser.SelectVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#selectVar}.
	 * @param ctx the parse tree
	 */
	void exitSelectVar(AQLParser.SelectVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(AQLParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(AQLParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(AQLParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(AQLParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(AQLParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(AQLParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#orderByExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrderByExpr(AQLParser.OrderByExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#orderByExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrderByExpr(AQLParser.OrderByExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#identifiedPath}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiedPath(AQLParser.IdentifiedPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#identifiedPath}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiedPath(AQLParser.IdentifiedPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#pathPart}.
	 * @param ctx the parse tree
	 */
	void enterPathPart(AQLParser.PathPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#pathPart}.
	 * @param ctx the parse tree
	 */
	void exitPathPart(AQLParser.PathPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#objectPath}.
	 * @param ctx the parse tree
	 */
	void enterObjectPath(AQLParser.ObjectPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#objectPath}.
	 * @param ctx the parse tree
	 */
	void exitObjectPath(AQLParser.ObjectPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#predicateOperand}.
	 * @param ctx the parse tree
	 */
	void enterPredicateOperand(AQLParser.PredicateOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#predicateOperand}.
	 * @param ctx the parse tree
	 */
	void exitPredicateOperand(AQLParser.PredicateOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(AQLParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(AQLParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#standardPredicate}.
	 * @param ctx the parse tree
	 */
	void enterStandardPredicate(AQLParser.StandardPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#standardPredicate}.
	 * @param ctx the parse tree
	 */
	void exitStandardPredicate(AQLParser.StandardPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#standardPredicateExpr}.
	 * @param ctx the parse tree
	 */
	void enterStandardPredicateExpr(AQLParser.StandardPredicateExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#standardPredicateExpr}.
	 * @param ctx the parse tree
	 */
	void exitStandardPredicateExpr(AQLParser.StandardPredicateExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#archetypePredicate}.
	 * @param ctx the parse tree
	 */
	void enterArchetypePredicate(AQLParser.ArchetypePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#archetypePredicate}.
	 * @param ctx the parse tree
	 */
	void exitArchetypePredicate(AQLParser.ArchetypePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#nodePredicate}.
	 * @param ctx the parse tree
	 */
	void enterNodePredicate(AQLParser.NodePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#nodePredicate}.
	 * @param ctx the parse tree
	 */
	void exitNodePredicate(AQLParser.NodePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#nodePredicateExpr}.
	 * @param ctx the parse tree
	 */
	void enterNodePredicateExpr(AQLParser.NodePredicateExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#nodePredicateExpr}.
	 * @param ctx the parse tree
	 */
	void exitNodePredicateExpr(AQLParser.NodePredicateExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#nodePredicateOperand}.
	 * @param ctx the parse tree
	 */
	void enterNodePredicateOperand(AQLParser.NodePredicateOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#nodePredicateOperand}.
	 * @param ctx the parse tree
	 */
	void exitNodePredicateOperand(AQLParser.NodePredicateOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#identifiedExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiedExpr(AQLParser.IdentifiedExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#identifiedExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiedExpr(AQLParser.IdentifiedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#matchesOperand}.
	 * @param ctx the parse tree
	 */
	void enterMatchesOperand(AQLParser.MatchesOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#matchesOperand}.
	 * @param ctx the parse tree
	 */
	void exitMatchesOperand(AQLParser.MatchesOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#valueListItems}.
	 * @param ctx the parse tree
	 */
	void enterValueListItems(AQLParser.ValueListItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#valueListItems}.
	 * @param ctx the parse tree
	 */
	void exitValueListItems(AQLParser.ValueListItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#contains}.
	 * @param ctx the parse tree
	 */
	void enterContains(AQLParser.ContainsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#contains}.
	 * @param ctx the parse tree
	 */
	void exitContains(AQLParser.ContainsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#containsExpression}.
	 * @param ctx the parse tree
	 */
	void enterContainsExpression(AQLParser.ContainsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#containsExpression}.
	 * @param ctx the parse tree
	 */
	void exitContainsExpression(AQLParser.ContainsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AQLParser#classExpr}.
	 * @param ctx the parse tree
	 */
	void enterClassExpr(AQLParser.ClassExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AQLParser#classExpr}.
	 * @param ctx the parse tree
	 */
	void exitClassExpr(AQLParser.ClassExprContext ctx);
}