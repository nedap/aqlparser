package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.ClassExprOperand;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FromClauseTest extends BaseTest {

    @Test
    public void containsExpr() throws AQLValidationException {
        String aql ="FROM EHR e [ehr_id/value=1234]";
        FromClause fromClause = (FromClause) QOMParser.parse(aql,"fromClause", lookup);
        ContainsExpression containsExpression = fromClause.getContainsExpression();
        assertTrue(containsExpression.getObject() instanceof ClassExprOperand);
    }

}
