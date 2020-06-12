package com.nedap.aqlparser.model;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TopClauseTest {

    @Test
    public void integer() throws AQLValidationException {
        String aql = "TOP 10";
        TopClause topClause = (TopClause) QOMParser.parse(aql,"topClause");
        assertEquals(Integer.valueOf(10),topClause.getLimit());
        assertEquals(TopDirection.FORWARD,topClause.getDirection());
    }

    @Test
    public void integer_forward() throws AQLValidationException {
        String aql = "TOP 10 FORWARD";
        TopClause topClause = (TopClause) QOMParser.parse(aql,"topClause");
        assertEquals(Integer.valueOf(10),topClause.getLimit());
        assertEquals(TopDirection.FORWARD,topClause.getDirection());
    }

    @Test
    public void integer_backward() throws AQLValidationException {
        String aql = "TOP 10 BACKWARD";
        TopClause topClause = (TopClause) QOMParser.parse(aql,"topClause");
        assertEquals(Integer.valueOf(10),topClause.getLimit());
        assertEquals(TopDirection.BACKWARD,topClause.getDirection());
    }

}
