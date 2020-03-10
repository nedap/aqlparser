package com.nedap.aqlparser.result;

/**
 * ResultColumnDef according to the result structure from the openEhr EHR service definition. A ResultColumnDef has
 * the definition of the result set as a logical set of columns, mapped to archetyped data structures via paths
 */
public class ResultColumnDef {

    // an archetype or RM path
    String path;
    // name of the column in this result set
    String name;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
