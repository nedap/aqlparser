package com.nedap.aqlparser.model;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.ClassExprOperand;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FromClauseTest {

    @Test
    public void containsExpr() throws AQLValidationException {
        String aql ="FROM EHR e [ehr_id/value=1234]";
        FromClause fromClause = (FromClause) QOMParser.parse(aql,"fromClause");
        ContainsExpression containsExpression = fromClause.getContainsExpression();
        assertTrue(containsExpression.getObject() instanceof ClassExprOperand);
    }

}
