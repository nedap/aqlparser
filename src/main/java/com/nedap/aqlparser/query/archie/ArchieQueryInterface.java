package com.nedap.aqlparser.query.archie;

import com.nedap.aqlparser.query.QueryInterface;
import com.nedap.archie.rm.RMObject;

import java.util.List;

public interface ArchieQueryInterface extends QueryInterface {

    List<RMObject> getRmObjects();

    void setRmObjects(List<RMObject> rmObjects);

}
