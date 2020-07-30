package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;

import java.util.ArrayList;
import java.util.List;

public class SelectOperand extends QOMObject {

    private IdentifiedPath identifiedPath;

    private String alias;

    private Lookup lookup;

    public SelectOperand(AQLParser.SelectOperandContext ctx, Lookup lookup) {
        identifiedPath = new IdentifiedPath(ctx.identifiedPath(),lookup);
        this.lookup = lookup;
        if (ctx.AS() != null) {
            alias = ctx.IDENTIFIER().getText();
            lookup.addAlias(alias,identifiedPath);
        }
    }

    @Override
    public List<AQLValidationMessage> validate() {
        List<AQLValidationMessage> messages = new ArrayList<>(identifiedPath.validate());
        IdentifiedPath testPath = lookup.getIdentifiedPath(alias);
        if (testPath != null && !testPath.getVariableName().equals(identifiedPath.getVariableName())) {
            messages.add(new AQLValidationMessage(this.getClass(), "Alias " + alias + " used multiple times"));
        }
        return messages;
    }

    public IdentifiedPath getIdentifiedPath() {
        return identifiedPath;
    }

    public String getAlias() {
        return alias;
    }

}
