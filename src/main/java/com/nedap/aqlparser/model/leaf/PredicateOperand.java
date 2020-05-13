package com.nedap.aqlparser.model.leaf;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.QOMObject;
import com.nedap.aqlparser.util.QOMParserUtil;
import com.nedap.archie.query.RMObjectWithPath;
import com.nedap.archie.query.RMPathQuery;
import com.nedap.archie.rm.RMObject;
import com.nedap.archie.rminfo.ArchieRMInfoLookup;

public class PredicateOperand extends QOMObject implements Leaf {

    private QOMObject operand;

    public PredicateOperand(AQLParser.PredicateOperandContext ctx) {
        initialize(ctx);
    }

    private void initialize(AQLParser.PredicateOperandContext ctx) {
        operand = QOMParserUtil.parse(ctx.objectPath(),ctx.primitiveOperand(),ctx.PARAMETER()).get(0);
    }

    @Override
    public String toString() {
        return operand.toString();
    }

    public QOMObject getOperand() {
        return operand;
    }

}
