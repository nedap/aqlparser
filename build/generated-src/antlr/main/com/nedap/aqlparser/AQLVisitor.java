// Generated from com/nedap/aqlparser/AQL.g4 by ANTLR 4.8
package com.nedap.aqlparser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AQLParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(AQLParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#selectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectClause(AQLParser.SelectClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#topClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopClause(AQLParser.TopClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#selectExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectExpr(AQLParser.SelectExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#selectVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectVar(AQLParser.SelectVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(AQLParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(AQLParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(AQLParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#orderByExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByExpr(AQLParser.OrderByExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#identifiedPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifiedPath(AQLParser.IdentifiedPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#pathPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathPart(AQLParser.PathPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#objectPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPath(AQLParser.ObjectPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#predicateOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateOperand(AQLParser.PredicateOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(AQLParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#standardPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardPredicate(AQLParser.StandardPredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#standardPredicateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardPredicateExpr(AQLParser.StandardPredicateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#archetypePredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchetypePredicate(AQLParser.ArchetypePredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#nodePredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodePredicate(AQLParser.NodePredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#nodePredicateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodePredicateExpr(AQLParser.NodePredicateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#nodePredicateOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodePredicateOperand(AQLParser.NodePredicateOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#identifiedExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifiedExpr(AQLParser.IdentifiedExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#matchesOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchesOperand(AQLParser.MatchesOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#valueListItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueListItems(AQLParser.ValueListItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#contains}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContains(AQLParser.ContainsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#containsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsExpression(AQLParser.ContainsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AQLParser#classExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExpr(AQLParser.ClassExprContext ctx);
}