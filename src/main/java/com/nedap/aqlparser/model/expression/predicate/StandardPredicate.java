package com.nedap.aqlparser.model.expression.predicate;


import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.Operator;
import com.nedap.aqlparser.model.expression.OperatorType;
import com.nedap.aqlparser.parser.QOMParserUtil;

public class StandardPredicate extends Predicate {

    public StandardPredicate(AQLParser.StandardPredicateContext ctx) {
        this(ctx.standardPredicateExpr());
    }

    public StandardPredicate(AQLParser.StandardPredicateExprContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.StandardPredicateExprContext ctx) {
        if (ctx.AND() != null || ctx.OR() != null) {
            this.expression = new Operator();
            ((Operator) expression).setLeftOperand(new StandardPredicate(ctx.standardPredicateExpr(0)));
            ((Operator) expression).setRightOperand(new StandardPredicate(ctx.standardPredicateExpr(1)));
            ((Operator) expression).setType((ctx.AND() != null) ? OperatorType.AND : OperatorType.OR);
        } else if (ctx.OPEN() != null) {
            initialize(ctx.standardPredicateExpr(0));
        } else if (ctx.predicateOperand(0) != null) {
            this.expression = new Operator();
            ((Operator) expression).setLeftOperand(QOMParserUtil.parsePredicateOperand(ctx.predicateOperand(0)));
            ((Operator) expression).setRightOperand(QOMParserUtil.parsePredicateOperand(ctx.predicateOperand(1)));
            ((Operator) expression).setType(OperatorType.get(ctx.COMPARABLEOPERATOR().toString()));
        }
    }

}
