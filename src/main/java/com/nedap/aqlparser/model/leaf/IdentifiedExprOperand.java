package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.NodeExpression;
import com.nedap.archie.query.RMPathQuery;
import com.nedap.archie.rm.RMObject;
import com.nedap.archie.rminfo.ArchieRMInfoLookup;

/**
 * An identified expression specifies matching criteria in the WHERE clause and comes in two forms. The first form is
 * an expression formed by a unary operator, such as NOT or EXISTS, described earlier. The second is a binary operator
 * expression, formed as follows:
 *
 * 1) left operand: an identified path;
 * 2) operator: a comparison operator;
 * 3) right operand: one of:
 *      - a value criterion, normally of a primitive type, such as String, Integer, Boolean, Double, or Float;
 *        if a String value, single or double quotation marks are required; OR
 *      - a replaceable parameter (identified with the '$' symbol); OR
 *      - an identified path.
 */
public class IdentifiedExprOperand extends NodeExpression implements Leaf {

    public IdentifiedExprOperand(AQLParser.IdentifiedExprOperandContext ctx){
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedExprOperandContext ctx) {
        setObject(ctx.COMPARABLEOPERATOR(),ctx.MATCHES());
        addChildren(ctx.predicateOperand(0),ctx.predicateOperand(1),ctx.matchesOperand());
    }

    @Override
    public void validate() throws AQLValidationException {
        if (!(getChildren(0).getObject() instanceof ObjectPath)) {
            throw new AQLValidationException("ObjectPath required in IdentifiedExprOperand");
        }
    }

    private String getObjectPath() {
        return getChildren(0).getObject().toString();
    }

    @Override
    public Boolean evaluate(RMObject rmObject) {
        Object o1 = new RMPathQuery(getObjectPath()).find(ArchieRMInfoLookup.getInstance(),rmObject);
        if (getChildren(1).getObject() instanceof PredicateOperand) {
            PredicateOperand operand = (PredicateOperand) getChildren(1).getObject();
            Object o2;
            if (operand.getOperand() instanceof ObjectPath) {
                o2 = new RMPathQuery(operand.toString()).find(ArchieRMInfoLookup.getInstance(),rmObject);
            } else if (operand.getOperand() instanceof PrimitiveOperand) {
                o2 = ((PrimitiveOperand) operand.getOperand()).getValue();
            } else {
                throw new RuntimeException("Must not be reached");
            }
            return ((Operator) getObject()).compare(o1,o2);
        } else if (getChildren(1).getObject() instanceof ValueList) {
            return ((ValueList) getChildren(1).getObject()).getItems().
                    stream().
                    map(PrimitiveOperand::getValue).
                    anyMatch(o2 -> ((Operator) getObject()).compare(o1,o2));
        } else if (getChildren(1).getObject() instanceof URIValue) {
            throw new RuntimeException("Comparison to URI not yet supported");
        } else {
            throw new RuntimeException("Must not be reached");
        }
    }

}
