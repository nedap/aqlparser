package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.QOMObject;

public class SelectOperand extends QOMObject implements Leaf {

    private IdentifiedPath identifiedPath;

    private String alias;

    private ClassExprOperand classExprOperand;

    public SelectOperand(AQLParser.SelectOperandContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.SelectOperandContext ctx) {
        identifiedPath = new IdentifiedPath(ctx.identifiedPath());
        if (ctx.AS() != null) alias = ctx.IDENTIFIER().getText();
    }

    @Override
    public void validate() throws AQLValidationException {
        identifiedPath.validate();
    }

    public IdentifiedPath getIdentifiedPath() {
        return identifiedPath;
    }

    public String getAlias() {
        return alias;
    }

    public ClassExprOperand getClassExprOperand() {
        return classExprOperand;
    }

    public void setClassExprOperand(ClassExprOperand classExprOperand) {
        this.classExprOperand = classExprOperand;
    }

}
