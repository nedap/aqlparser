package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.exception.AQLValidationException;
import com.nedap.aqlparser.model.Lookup;
import com.nedap.aqlparser.model.QOMObject;

public class SelectOperand extends QOMObject implements Leaf {

    private IdentifiedPath identifiedPath;

    private String alias;

    public SelectOperand(AQLParser.SelectOperandContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.SelectOperandContext ctx) {
        identifiedPath = new IdentifiedPath(ctx.identifiedPath());
        if (ctx.AS() != null) {
            alias = ctx.IDENTIFIER().getText();
            Lookup.addAlias(alias,identifiedPath);
        }
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

}
