package com.nedap.healthcare.aqlparser.model;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.leaf.Operator;
import com.nedap.healthcare.aqlparser.model.leaf.OperatorType;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class NodeExpression extends QOMObject {

    private QOMObject object;
    private List<NodeExpression> children;

    private Lookup lookup;

    private NodeExpression() {
    }

    public NodeExpression(AQLParser.ContainsExprContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    public NodeExpression(AQLParser.IdentifiedExprContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    public NodeExpression(AQLParser.StandardPredicateExprContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    public NodeExpression(AQLParser.StandardPredicateExprOperandContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    public NodeExpression(AQLParser.NodePredicateExprContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    public NodeExpression(AQLParser.NodePredicateExprOperandContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    public NodeExpression(AQLParser.IdentifiedExprOperandContext ctx, Lookup lookup) {
        this.lookup = lookup;
        initialize(ctx);
    }

    private void initialize(AQLParser.IdentifiedExprOperandContext ctx) {
        setObject(ctx.COMPARABLEOPERATOR(), ctx.MATCHES(),ctx.predicateOperand(0));
        if (ctx.COMPARABLEOPERATOR() != null || ctx.MATCHES() != null) {
            addChildren(ctx.predicateOperand(0),ctx.predicateOperand(1),ctx.matchesOperand());
        }
    }

    private void initialize(AQLParser.ContainsExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.containsExpr(0));
            return;
        }
        setObject(ctx.CONTAINS(),ctx.classExprOperand(), ctx.AND(), ctx.OR());
        addChildren(
                (ctx.CONTAINS() != null) ? ctx.classExprOperand() : null,
                ctx.containsExpr(0),
                ctx.containsExpr(1));
    }

    private void initialize(AQLParser.IdentifiedExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.identifiedExpr(0));
            return;
        }
        setObject(ctx.identifiedExprOperand(), ctx.NOT(), ctx.EXISTS(), ctx.AND(), ctx.OR());
        addChildren(ctx.identifiedExpr(0), ctx.identifiedExpr(1));
    }

    private void initialize(AQLParser.StandardPredicateExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.standardPredicateExpr(0));
            return;
        }
        setObject(ctx.standardPredicateExprOperand(),ctx.NOT(),ctx.AND(),ctx.OR());
        addChildren(ctx.standardPredicateExpr(0),ctx.standardPredicateExpr(1));
    }

    private void initialize(AQLParser.NodePredicateExprContext ctx) {
        if (ctx.OPEN() != null) {
            initialize(ctx.nodePredicateExpr(0));
            return;
        }
        setObject(ctx.AND(),ctx.OR(),ctx.nodePredicateExprOperand());
        addChildren(ctx.nodePredicateExpr(0),ctx.nodePredicateExpr(1));
    }

    private void initialize(AQLParser.NodePredicateExprOperandContext ctx) {
        if (!ctx.predicateOperand().isEmpty()) {
            setObject(QOMParserUtil.parse(lookup, ctx.COMPARABLEOPERATOR(),ctx.MATCHES()).get(0));
            addChildren(QOMParserUtil.parse(lookup, ctx.predicateOperand(0),ctx.predicateOperand(1),ctx.REGEXPATTERN()));
        } else if (ctx.COMMA() != null) {
            setObject(new Operator(OperatorType.AND));
            addChildren(QOMParserUtil.parse(lookup, ctx.NODEID(),
                    ctx.ARCHETYPEID(),
                    ctx.PARAMETER(0),
                    ctx.STRING(),
                    ctx.PARAMETER(1)));
        } else {
            setObject(QOMParserUtil.parse(
                    lookup,
                    ctx.NODEID(),
                    ctx.ARCHETYPEID(),
                    ctx.PARAMETER(0)).get(0));
        }
    }

    private void initialize(AQLParser.StandardPredicateExprOperandContext ctx) {
        setObject(ctx.COMPARABLEOPERATOR());
        addChildren(ctx.objectPath(),ctx.predicateOperand());
    }


    protected void setObject(QOMObject object) {
        this.object = object;
    }

    protected void setObject(ParseTree parseTree) {
        this.object = QOMParserUtil.parse(lookup, parseTree);
    }

    protected void setObject(ParseTree... parseTrees) {
        List<QOMObject> objects = QOMParserUtil.parse(lookup, parseTrees);
        this.object = objects.get(0);
    }

    protected void addChild(QOMObject object) {
        NodeExpression child = new NodeExpression();
        child.setObject(object);
        addChild(child);
    }

    protected void addChild(ParseTree parseTree) {
        addChild(QOMParserUtil.parse(lookup, parseTree));
    }

    protected void addChild(NodeExpression child) {
        if (child == null) return;
        if (this.children == null) this.children = new ArrayList<>();
        children.add(child);
    }

    protected void addChildren(ParseTree... parseTrees) {
        addChildren(QOMParserUtil.parse(lookup, parseTrees));
    }

    protected void addChildren(List<QOMObject> children) {
        for (QOMObject qomObject : children) {
            //Explicitly call correct method, cannot resolve this since NodeExpression is also of type QOMObject
            if (qomObject instanceof NodeExpression) {
                addChild((NodeExpression) qomObject);
            } else {
                addChild(qomObject);
            }
        }
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

    public Boolean isTerminalNode() {
        if (!hasChildren()) {
            if (object instanceof NodeExpression) {
                return ((NodeExpression) object).isTerminalNode();
            } else {
                return true;
            }
        } else {
            return children.stream().noneMatch(NodeExpression::hasChildren);
        }
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

    public Lookup getLookup() {
        return lookup;
    }

    public void setLookup(Lookup lookup) {
        this.lookup = lookup;
    }

}
