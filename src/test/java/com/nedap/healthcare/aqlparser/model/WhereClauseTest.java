package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.IdentifiedExprOperand;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WhereClauseTest extends BaseTest {

    @Test
    public void identifiedExpr() throws AQLValidationException {
        String aql = "WHERE c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude >= 42";
        WhereClause whereClause = (WhereClause) QOMParser.parse(aql,"whereClause", lookup);
        IdentifiedExpression identifiedExpression = whereClause.getIdentifiedExpression();
        assertTrue(identifiedExpression.getObject() instanceof IdentifiedExprOperand);
    }
}
