package com.nedap.healthcare.aqlparser.parser;

import com.nedap.healthcare.aqlparser.AQLBaseVisitor;
import com.nedap.healthcare.aqlparser.AQLLexer;
import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.QueryClause;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QOMParser extends AQLBaseVisitor<QOMObject> {

    private Lookup lookup;

    public QOMParser(Lookup lookup) {
        this.lookup = lookup;
    }

    public static QueryClause parse(String aql, Lookup lookup) throws AQLValidationException {
        return (QueryClause) parse(aql,"queryClause", lookup);
    }

    public static QOMObject parse(String aql, String startRuleName, Lookup lookup) throws AQLValidationException {
        final CharStream input = CharStreams.fromString(aql);
        final AQLLexer lexer = new AQLLexer(input);
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokenStream);
        ParseTree parseTree;
        try {
            Method method = parser.getClass().getMethod(startRuleName);
            parseTree = (ParseTree) method.invoke(parser);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Could not invoke ParseTree." + startRuleName,e);
        }
        final QOMParser visitor = new QOMParser(lookup);
        QOMObject object = visitor.visit(parseTree);
        if (object == null) throw new RuntimeException("Visitor for " + startRuleName + " not yet implement");
        object.validate();
        return object;
    }

    @Override
    public QOMObject visitChildren(RuleNode node) {
        return QOMParserUtil.parse(lookup, node);
    }

}
