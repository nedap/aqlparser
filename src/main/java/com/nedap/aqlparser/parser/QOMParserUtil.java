package com.nedap.aqlparser.parser;

import com.nedap.aqlparser.AQLParser;
import com.nedap.aqlparser.model.ObjectPath;
import com.nedap.aqlparser.model.expression.Leaf;
import com.nedap.aqlparser.model.expression.ValueList;
import com.nedap.aqlparser.model.expression.operand.Operand;
import com.nedap.aqlparser.model.expression.operand.URIOperand;

public class QOMParserUtil {

    public static Leaf parsePredicateOperand(AQLParser.PredicateOperandContext ctx) {
        if (ctx.operand() != null) {
            return new Operand(ctx.operand());
        } else if (ctx.objectPath() != null) {
            return new ObjectPath(ctx.objectPath());
        } else {
            throw new RuntimeException("Must not be reached");
        }
    }

    public static Leaf parseMatchesOperand(AQLParser.MatchesOperandContext ctx) {
        if (ctx.valueListItems() != null) {
            return new ValueList(ctx.valueListItems());
        } else if (ctx.URIVALUE() != null) {
            return new URIOperand(ctx.URIVALUE().getText());
        } else {
            throw new RuntimeException("Must not be reached");
        }
    }
}
