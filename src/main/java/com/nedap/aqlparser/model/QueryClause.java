package com.nedap.aqlparser.model;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.ClassExprOperand;
import com.nedap.aqlparser.model.leaf.Operator;
import com.nedap.aqlparser.model.leaf.OperatorType;
import com.nedap.aqlparser.model.leaf.SelectOperand;

public class QueryClause extends QOMObject{

    private SelectClause selectClause;
    private FromClause fromClause;
    private WhereClause whereClause;

    public QueryClause(AQLParser.QueryContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.QueryContext ctx) {
        selectClause = new SelectClause(ctx.selectClause());
        fromClause = new FromClause(ctx.fromClause());
        if (ctx.whereClause() != null) {
            whereClause = new WhereClause(ctx.whereClause());
        }
        setClassExpressions(fromClause.getContainsExpression());
    }

    private void setClassExpressions(ContainsExpression containsExpression) {
        if (!containsExpression.hasChildren()) {
            ClassExprOperand classExprOperand = (ClassExprOperand) containsExpression.getObject();
            selectClause.getSelectOperand(classExprOperand.getVariableName()).setClassExprOperand(classExprOperand);
        } else {
            OperatorType type = ((Operator) containsExpression.getObject()).getType();
            if (type == OperatorType.CONTAINS) {
                setClassExpressions((ContainsExpression) containsExpression.getChildren(0));
            } else {
                setClassExpressions((ContainsExpression) containsExpression.getChildren(0).getObject());
            }
            setClassExpressions((ContainsExpression) containsExpression.getChildren(1).getObject());
        }
    }

    public SelectClause getSelectClause() {
        return selectClause;
    }

    public FromClause getFromClause() {
        return fromClause;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    @Override
    public void validate() throws AQLValidationException {
        selectClause.validate();
        fromClause.validate();
        if (whereClause != null) {
            whereClause.validate();
        }
    }
}
