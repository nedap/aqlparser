package com.nedap.aqlparser.result;

import java.util.List;

/**
 * ResultSet according to the result structure from the openEhr EHR service definition. A ResultSet has a name, a
 * count of rows, its definition (list of columnDefs), and the row data.
 *
 * Data in a ResultSet can be accessed in the following ways:
 * <pre>
 * ResultSet results;
 *
 * results.Rows[0].Items[0]                 // first row, first cell
 * results.Rows[5].Items[13]                // 6th row, 14th cell
 * //ToDo: Not supported yet
 * results.Rows[0].Items["name/value"]      // first row, 'name/value' column
 * </pre>
 *
 */
public class ResultSet {

    String name;
    int totalResults;
    List<ResultColumnDef> columns;
    List<ResultRow> rows;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ResultColumnDef> getColumns() {
        return columns;
    }

    public void setColumns(List<ResultColumnDef> columns) {
        this.columns = columns;
    }

    public List<ResultRow> getRows() {
        return rows;
    }

    public void setRows(List<ResultRow> rows) {
        this.rows = rows;
    }

}
