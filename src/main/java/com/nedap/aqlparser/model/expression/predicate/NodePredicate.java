package com.nedap.aqlparser.model.expression.predicate;
import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.expression.Leaf;
import com.nedap.aqlparser.model.expression.OperatorType;
import com.nedap.aqlparser.model.expression.operand.NodeIdOperand;
import com.nedap.aqlparser.model.expression.operand.Operand;
import com.nedap.aqlparser.model.expression.operand.OperandType;
import com.nedap.aqlparser.parser.QOMParserUtil;

public class NodePredicate extends Predicate {

    public NodePredicate(AQLParser.NodePredicateContext ctx) {
        if (ctx.nodePredicateExpr().nodePredicateOperand() != null) {
            initialize(ctx.nodePredicateExpr().nodePredicateOperand());
        } else {
            throw new RuntimeException("NYI");
        }
    }

    @Override
    public String toString(){
        String result = leftOperand.toString();
        if (rightOperand != null) {
            result += ' ';
            result += type.getType();
            result += ' ';
            result += rightOperand.toString();
        }
        if (leftOperand instanceof Leaf) {
            result = '[' + result + ']';
        }
        return result;
    }

    private void initialize(AQLParser.NodePredicateOperandContext ctx) {

        if (ctx.NODEID() != null) {
            setLeftOperand(new NodeIdOperand(ctx.NODEID().getText()));
        } else if (ctx.PARAMETER().size() == 1 && ctx.COMMA() == null ||
                ctx.PARAMETER().size() == 2 && ctx.COMMA() != null) {
            setLeftOperand(new Operand(OperandType.PARAMETER,ctx.PARAMETER(0).getText()));
        } else if (ctx.predicateOperand() != null) {
            setLeftOperand(QOMParserUtil.parsePredicateOperand(ctx.predicateOperand(0)));
            if (ctx.COMPARABLEOPERATOR() != null) {
                setRightOperand(QOMParserUtil.parsePredicateOperand(ctx.predicateOperand(1)));
                setType(OperatorType.get(ctx.COMPARABLEOPERATOR().getText()));
            } else {
                throw new RuntimeException("NYI");
            }
        } else {
            throw new RuntimeException("NYI");
        }

        if (ctx.COMMA() != null) {
            if (ctx.STRING() != null) {
                setRightOperand(new Operand(OperandType.STRING,ctx.STRING().getText()));
            } else if (ctx.PARAMETER().get(ctx.PARAMETER().size() - 1) != null) {
                setRightOperand(new Operand(OperandType.PARAMETER,ctx.PARAMETER().get(ctx.PARAMETER().size() - 1).getText()));
            } else {
                throw new RuntimeException("Expected STRING or PARAMETER after COMMA in node predicate");
            }
            setType(OperatorType.AND);
        }

    }

}
