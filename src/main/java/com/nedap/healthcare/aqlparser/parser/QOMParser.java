package com.nedap.healthcare.aqlparser.parser;

import com.nedap.archie.rmobjectvalidator.RMObjectValidationMessage;
import com.nedap.healthcare.aqlparser.AQLLexer;
import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLValidationException;
import com.nedap.healthcare.aqlparser.model.AQLValidationMessage;
import com.nedap.healthcare.aqlparser.model.Lookup;
import com.nedap.healthcare.aqlparser.model.QOMObject;
import com.nedap.healthcare.aqlparser.model.clause.QueryClause;
import com.nedap.healthcare.aqlparser.util.QOMParserUtil;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;

public class QOMParser {

    public static QueryClause parse(String aql, Lookup lookup) {
        return (QueryClause) parse(aql,"queryClause", lookup);
    }

    public static QOMObject parse(String aql, String startRuleName, Lookup lookup) throws AQLValidationException {
        final CharStream input = CharStreams.fromString(aql);
        final AQLLexer lexer = new AQLLexer(input);
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(QOMErrorListener.getInstance());
        ParseTree parseTree;
        try {
            Method method = parser.getClass().getMethod(startRuleName);
            parseTree = (ParseTree) method.invoke(parser);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new IllegalArgumentException("Could not invoke ParseTree." + startRuleName,e);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof AQLValidationException) {
                throw (AQLValidationException) e.getCause();
            }
            throw new AQLValidationException("Invoking " + startRuleName + " failed", e);
        }
        QOMObject object = QOMParserUtil.parse(lookup, parseTree);
        object.validate();
        if (object.hasErrors()) {
            String message = object.getValidationMessages().
                    stream().
                    map(AQLValidationMessage::getMessage).
                    collect(Collectors.joining("; "));
            throw new AQLValidationException(message);
        }
        return object;
    }

}
