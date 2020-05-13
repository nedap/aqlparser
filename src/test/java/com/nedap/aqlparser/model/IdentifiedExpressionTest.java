package com.nedap.aqlparser.model;

import com.nedap.aqlparser.model.leaf.IdentifiedExprOperand;
import com.nedap.aqlparser.model.leaf.Operator;
import com.nedap.aqlparser.model.leaf.OperatorType;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdentifiedExpressionTest {

    @Test
    public void operand_comparable_operand() {
        String aql = "o/data[at0001]/events[at0006]/data[at0003]/items[at0004]/value/value >= 140";
        IdentifiedExpression identifiedExpression = (IdentifiedExpression) QOMParser.parse(aql,"identifiedExpr");
        assertEquals(OperatorType.GREATER_EQUAL_TO,((Operator) ((IdentifiedExprOperand) identifiedExpression.getObject()).getObject()).getType());
        assertEquals("o/data[at0001]/events[at0006]/data[at0003]/items[at0004]/value/value", ((IdentifiedExprOperand) identifiedExpression.getObject()).getChildren(0).toString());
        assertEquals("140",((IdentifiedExprOperand) identifiedExpression.getObject()).getChildren(1).toString());
    }

}
