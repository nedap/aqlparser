package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardPredicateExprOperandTest {

    @Test
    public void standardPredicateExprOperand() throws AQLValidationException {
        String aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude > 40";
        StandardPredicateExprOperand standardPredicateExprOperand = (StandardPredicateExprOperand) QOMParser.parse(aql,"standardPredicateExprOperand");
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",standardPredicateExprOperand.getObjectPath().toString());
        assertEquals(OperatorType.GREATER_THAN,standardPredicateExprOperand.getOperator().getType());
        assertEquals(40,((PrimitiveOperand) standardPredicateExprOperand.getChildren(1).getObject()).getValue());
    }

    @Test
    public void comparableOperators() throws AQLValidationException {
        String aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude > 40";
        StandardPredicateExprOperand standardPredicateExprOperand = (StandardPredicateExprOperand) QOMParser.parse(aql,"standardPredicateExprOperand");
        assertEquals(OperatorType.GREATER_THAN,standardPredicateExprOperand.getOperator().getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude >= 40";
        standardPredicateExprOperand = (StandardPredicateExprOperand) QOMParser.parse(aql,"standardPredicateExprOperand");
        assertEquals(OperatorType.GREATER_EQUAL_TO,standardPredicateExprOperand.getOperator().getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude < 40";
        standardPredicateExprOperand = (StandardPredicateExprOperand) QOMParser.parse(aql,"standardPredicateExprOperand");
        assertEquals(OperatorType.SMALLER_THAN,standardPredicateExprOperand.getOperator().getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude <= 40";
        standardPredicateExprOperand = (StandardPredicateExprOperand) QOMParser.parse(aql,"standardPredicateExprOperand");
        assertEquals(OperatorType.SMALLER_EQUAL_TO,standardPredicateExprOperand.getOperator().getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude = 40";
        standardPredicateExprOperand = (StandardPredicateExprOperand) QOMParser.parse(aql,"standardPredicateExprOperand");
        assertEquals(OperatorType.EQUAL,standardPredicateExprOperand.getOperator().getType());

        aql = "content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude != 40";
        standardPredicateExprOperand = (StandardPredicateExprOperand) QOMParser.parse(aql,"standardPredicateExprOperand");
        assertEquals(OperatorType.NOT_EQUAL,standardPredicateExprOperand.getOperator().getType());
    }
}
