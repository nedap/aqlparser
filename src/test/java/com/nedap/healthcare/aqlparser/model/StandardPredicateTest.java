package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.model.Predicate;
import com.nedap.healthcare.aqlparser.model.leaf.Operator;
import com.nedap.healthcare.aqlparser.model.leaf.OperatorType;
import com.nedap.healthcare.aqlparser.model.leaf.PrimitiveOperand;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardPredicateTest extends BaseTest {

    @Test
    public void standardPredicate() throws AQLValidationException {
        String aql = "[ehr_id/value = 42]";
        Predicate standardPredicate = (Predicate) QOMParser.parse(aql,"standardPredicate", lookup);
        NodeExpression standardPredicateExpression = (NodeExpression) standardPredicate.getPredicateExpression();
        NodeExpression standardPredicateExprOperand = (NodeExpression) standardPredicateExpression.getObject();
        assertEquals("/ehr_id/value",standardPredicateExprOperand.getChildren(0).getObject().toString());
        assertEquals(OperatorType.EQUAL,((Operator) standardPredicateExprOperand.getObject()).getType());
        assertEquals(42,((PrimitiveOperand) standardPredicateExprOperand.getChildren(1).getObject()).getValue());
    }

}
