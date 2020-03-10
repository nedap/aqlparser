package com.nedap.aqlparser.result;

import java.util.List;

/**
 * ResultRow according to the result structure from the openEhr EHR service definition, i.e. a row object from which
 * cell objects can be obtained, via either an integer index (0-based) or the column name. An object it can be anything
 * from a String, Integer etc, to a DV_CODED_TEXT or other openEHR Data type, to an Observation or Composition,
 * from the main openEHR RM. What the objects are is completely dependent on what the com.nedap.aqlparser.query paths refer to.
 */
public class ResultRow {

    List<Object> items;

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

}
