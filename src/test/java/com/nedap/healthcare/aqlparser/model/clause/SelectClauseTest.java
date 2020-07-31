package com.nedap.healthcare.aqlparser.model.clause;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.clause.SelectClause;
import com.nedap.healthcare.aqlparser.parser.QOMParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SelectClauseTest extends BaseTest {

    @Test
    public void selectOperand() throws AQLValidationException {
        //Add variable c -- will throw AQLValidationException otherwise
        QOMParser.parse("COMPOSITION c","classExprOperand", lookup);
        String aql = "SELECT c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        SelectClause selectClause = (SelectClause) QOMParser.parse(aql,"selectClause", lookup);
        assertEquals("c",selectClause.getSelection().get(0).getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectClause.getSelection().get(0).getIdentifiedPath().getObjectPath().toString());
    }

    @Test
    public void selectMultiple() throws AQLValidationException {
        //Add variable c -- will throw AQLValidationException otherwise
        QOMParser.parse("COMPOSITION c","classExprOperand", lookup);
        String aql = "SELECT c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude, c/content[id0.0.100.1]/data[id3]/events[id4]/time/value";
        SelectClause selectClause = (SelectClause) QOMParser.parse(aql,"selectClause", lookup);
        assertEquals("c",selectClause.getSelection().get(0).getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectClause.getSelection().get(0).getIdentifiedPath().getObjectPath().toString());
        assertEquals("c",selectClause.getSelection().get(1).getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/time/value",selectClause.getSelection().get(1).getIdentifiedPath().getObjectPath().toString());
    }

    @Test
    public void topClause_selectOperand() throws AQLValidationException {
        //Add variable c -- will throw AQLValidationException otherwise
        QOMParser.parse("COMPOSITION c","classExprOperand", lookup);
        String aql = "SELECT TOP 10 FORWARD c/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude";
        SelectClause selectClause = (SelectClause) QOMParser.parse(aql,"selectClause", lookup);
        assertEquals("c",selectClause.getSelection().get(0).getIdentifiedPath().getVariableName());
        assertEquals("/content[id0.0.100.1]/data[id3]/events[id4]/data[id2]/items[id5]/value[id27]/magnitude",selectClause.getSelection().get(0).getIdentifiedPath().getObjectPath().toString());
        assertNotNull(selectClause.getTopClause());
    }
}
