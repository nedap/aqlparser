package com.nedap.aqlparser.model.predicate;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.OperatorType;
import com.nedap.aqlparser.model.leaf.PrimitiveOperand;
import com.nedap.aqlparser.model.leaf.StandardPredicateExprOperand;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardPredicateTest {

    @Test
    public void standardPredicate() throws AQLValidationException {
        String aql = "[ehr_id/value = 42]";
        StandardPredicate standardPredicate = (StandardPredicate) QOMParser.parse(aql,"standardPredicate");
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) standardPredicate.getPredicateExpression();
        StandardPredicateExprOperand standardPredicateExprOperand = (StandardPredicateExprOperand) standardPredicateExpression.getObject();
        assertEquals("/ehr_id/value",standardPredicateExprOperand.getObjectPath().toString());
        assertEquals(OperatorType.EQUAL,standardPredicateExprOperand.getOperator().getType());
        assertEquals(42,((PrimitiveOperand) standardPredicateExprOperand.getChildren(1).getObject()).getValue());
    }

}
