package com.nedap.aqlparser.model;

import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.leaf.Leaf;
import com.nedap.aqlparser.util.QOMParserUtil;
import com.nedap.archie.rm.RMObject;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

public class NodeExpression extends QOMObject {

    private QOMObject object;
    private List<NodeExpression> children;

    protected void setObject(QOMObject object) {
        this.object = object;
    }

    protected void setObject(ParseTree parseTree) {
        this.object = QOMParserUtil.parse(parseTree);
    }

    protected void setObject(ParseTree... parseTrees) {
        this.object = QOMParserUtil.parse(parseTrees).get(0);
    }

    protected void addChild(QOMObject object) {
        NodeExpression child = new NodeExpression();
        child.setObject(object);
        addChild(child);
    }

    protected void addChild(ParseTree parseTree) {
        addChild(QOMParserUtil.parse(parseTree));
    }

    protected void addChild(NodeExpression child) {
        if (child == null) return;
        if (this.children == null) this.children = new ArrayList<>();
        children.add(child);
    }

    protected void addChildren(ParseTree... parseTrees) {
        addChildren(QOMParserUtil.parse(parseTrees));
    }

    protected void addChildren(List<QOMObject> children) {
        children.forEach(this::addChild);
    }

    public QOMObject getObject() {
        return object;
    }

    public List<NodeExpression> getChildren() {
        return children;
    }

    public NodeExpression getChildren(int i) {
        return children.get(i);
    }

    public Boolean hasChildren() {
        return (children != null && children.size() >= 1);
    }

    public Boolean isLeaf() {
        return this instanceof Leaf;
    }

    @Override
    public String toString() {
        String result = getObject().toString();
        if (hasChildren()) result = getChildren(0).toString() + " " + result + " " + getChildren(1).toString();
        return result;
    }

    @Override
    public void validate() throws AQLValidationException {
        if (object != null) getObject().validate();
        if (children != null) {
            for (NodeExpression child : children) {
                child.validate();
            }
        }
    }

}
