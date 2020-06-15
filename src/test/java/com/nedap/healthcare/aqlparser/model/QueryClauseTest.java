package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.*;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueryClauseTest {

    @Test
    public void selectClause_fromClause_whereClause_orderByClause() throws AQLValidationException {
        String aql = "SELECT c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude AS bw " +
                "FROM EHR e [ehr_id/value=1234] CONTAINS COMPOSITION c [openEHR-EHR-COMPOSITION.test.v1.0.0] WHERE bw = 42 ORDER BY bw";
        QueryClause queryClause = (QueryClause) QOMParser.parse(aql,"queryClause");

        SelectClause selectClause = queryClause.getSelectClause();
        assertEquals("c",selectClause.getSelection().get(0).getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectClause.getSelection().get(0).getIdentifiedPath().getObjectPath().toString());
        assertEquals("bw",selectClause.getSelection().get(0).getAlias());

        FromClause fromClause = queryClause.getFromClause();
        ContainsExpression containsExpression = fromClause.getContainsExpression();
        assertTrue(containsExpression.getObject() instanceof Operator);
        assertEquals(OperatorType.CONTAINS,((Operator) containsExpression.getObject()).getType());
        assertEquals("e",((ClassExprOperand) containsExpression.getChildren(0).getObject()).getVariableName());
        assertEquals("EHR",((ClassExprOperand) containsExpression.getChildren(0).getObject()).getClassName());
        assertEquals("[/ehr_id/value = 1234]",((ClassExprOperand) containsExpression.getChildren(0).getObject()).getPredicate().toString());
        assertEquals("c",((ClassExprOperand) containsExpression.getChildren(1).getObject()).getVariableName());
        assertEquals("COMPOSITION",((ClassExprOperand) containsExpression.getChildren(1).getObject()).getClassName());
        assertEquals("[openEHR-EHR-COMPOSITION.test.v1.0.0]",((ClassExprOperand) containsExpression.getChildren(1).getObject()).getPredicate().toString());

        WhereClause whereClause = queryClause.getWhereClause();
        IdentifiedExprOperand identifiedExprOperand = (IdentifiedExprOperand) whereClause.getIdentifiedExpression().getObject();
        assertEquals("c",identifiedExprOperand.getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",identifiedExprOperand.getObjectPath());
        assertEquals(OperatorType.EQUAL,identifiedExprOperand.getOperator().getType());
        assertEquals(42,((PrimitiveOperand)identifiedExprOperand.getChildren(1).getObject()).getValue());

        OrderByClause orderByClause = queryClause.getOrderByClause();
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",orderByClause.getOrderByExpression(0).getIdentifiedPath().getObjectPath().toString());
    }
}
