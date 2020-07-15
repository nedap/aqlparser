package com.nedap.healthcare.aqlparser.model.predicate;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.OperatorType;
import com.nedap.healthcare.aqlparser.model.leaf.PrimitiveOperand;
import com.nedap.healthcare.aqlparser.model.leaf.StandardPredicateExprOperand;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardPredicateTest extends BaseTest {

    @Test
    public void standardPredicate() throws AQLValidationException {
        String aql = "[ehr_id/value = 42]";
        StandardPredicate standardPredicate = (StandardPredicate) QOMParser.parse(aql,"standardPredicate", lookup);
        StandardPredicateExpression standardPredicateExpression = (StandardPredicateExpression) standardPredicate.getPredicateExpression();
        StandardPredicateExprOperand standardPredicateExprOperand = (StandardPredicateExprOperand) standardPredicateExpression.getObject();
        assertEquals("/ehr_id/value",standardPredicateExprOperand.getObjectPath().toString());
        assertEquals(OperatorType.EQUAL,standardPredicateExprOperand.getOperator().getType());
        assertEquals(42,((PrimitiveOperand) standardPredicateExprOperand.getChildren(1).getObject()).getValue());
    }

}
