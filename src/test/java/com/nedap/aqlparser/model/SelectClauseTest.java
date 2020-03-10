package com.nedap.aqlparser.model;

import com.nedap.aqlparser.parser.QOMParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class SelectClauseTest {

    @Test
    public void select_alias(){
        String aql = "SELECT c/name/value AS name";

        SelectClause selectClause = (SelectClause) QOMParser.parse(aql,"selectClause");

        assertEquals(1,selectClause.getSelection().size());
        assertEquals("c",selectClause.getSelection().get(0).getVariableName());
        assertEquals("name/value",selectClause.getSelection().get(0).getPath());
        assertEquals("name",selectClause.getSelection().get(0).getAlias());
    }

    @Test
    public void select_top_alias(){
        String aql = "SELECT TOP 42 FORWARD c/name/value AS name";

        SelectClause selectClause = (SelectClause) QOMParser.parse(aql,"selectClause");

        assertEquals(Direction.FORWARD,selectClause.getTop().getDirection());
        assertEquals(new Integer(42),selectClause.getTop().getNTop());

        assertEquals(1,selectClause.getSelection().size());
        assertEquals("c",selectClause.getSelection().get(0).getVariableName());
        assertEquals("name/value",selectClause.getSelection().get(0).getPath());
        assertEquals("name",selectClause.getSelection().get(0).getAlias());
    }

    @Test
    public void select_multiple_alias(){
        String aql = "SELECT c/name/value AS name, c/context/start_time AS date_time, c/composer/name AS composer";

        SelectClause selectClause = (SelectClause) QOMParser.parse(aql,"selectClause");

        assertEquals(3,selectClause.getSelection().size());

        assertEquals("c",selectClause.getSelection().get(0).getVariableName());
        assertEquals("name/value",selectClause.getSelection().get(0).getPath());
        assertEquals("name",selectClause.getSelection().get(0).getAlias());

        assertEquals("c",selectClause.getSelection().get(1).getVariableName());
        assertEquals("context/start_time",selectClause.getSelection().get(1).getPath());
        assertEquals("date_time",selectClause.getSelection().get(1).getAlias());

        assertEquals("c",selectClause.getSelection().get(2).getVariableName());
        assertEquals("composer/name",selectClause.getSelection().get(2).getPath());
        assertEquals("composer",selectClause.getSelection().get(2).getAlias());
    }

}
