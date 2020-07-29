package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;

public class SelectOperand extends QOMObject {

    private IdentifiedPath identifiedPath;

    private String alias;

    public SelectOperand(AQLParser.SelectOperandContext ctx, Lookup lookup) {
        identifiedPath = new IdentifiedPath(ctx.identifiedPath(),lookup);
        if (ctx.AS() != null) {
            alias = ctx.IDENTIFIER().getText();
            lookup.addAlias(alias,identifiedPath);
        }
    }

    @Override
    public void validate() {
        identifiedPath.validate();
    }

    public IdentifiedPath getIdentifiedPath() {
        return identifiedPath;
    }

    public String getAlias() {
        return alias;
    }

}
