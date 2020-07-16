package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.NodeExpression;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardPredicateExprOperandTest extends BaseTest {

    @Test
    public void standardPredicateExprOperand() throws AQLValidationException {
        String aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude > 40";
        NodeExpression standardPredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"standardPredicateExprOperand", lookup);
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",standardPredicateExprOperand.getChildren(0).getObject().toString());
        assertEquals(OperatorType.GREATER_THAN,((Operator) standardPredicateExprOperand.getObject()).getType());
        assertEquals(40,((PrimitiveOperand) standardPredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void comparableOperators() throws AQLValidationException {
        String aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude > 40";
        NodeExpression standardPredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"standardPredicateExprOperand", lookup);
        assertEquals(OperatorType.GREATER_THAN,((Operator) standardPredicateExprOperand.getObject()).getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude >= 40";
        standardPredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"standardPredicateExprOperand", lookup);
        assertEquals(OperatorType.GREATER_EQUAL_TO,((Operator) standardPredicateExprOperand.getObject()).getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude < 40";
        standardPredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"standardPredicateExprOperand", lookup);
        assertEquals(OperatorType.SMALLER_THAN,((Operator) standardPredicateExprOperand.getObject()).getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude <= 40";
        standardPredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"standardPredicateExprOperand", lookup);
        assertEquals(OperatorType.SMALLER_EQUAL_TO,((Operator) standardPredicateExprOperand.getObject()).getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 40";
        standardPredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"standardPredicateExprOperand", lookup);
        assertEquals(OperatorType.EQUAL,((Operator) standardPredicateExprOperand.getObject()).getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude != 40";
        standardPredicateExprOperand = (NodeExpression) QOMParser.parse(aql,"standardPredicateExprOperand", lookup);
        assertEquals(OperatorType.NOT_EQUAL,((Operator) standardPredicateExprOperand.getObject()).getType());
    }
}
