package com.nedap.healthcare.aqlparser.parser;

import com.nedap.archie.antlr.errors.ANTLRParserErrors;
import com.nedap.healthcare.aqlparser.AQLLexer;
import com.nedap.healthcare.aqlparser.AQLParser;
import com.nedap.healthcare.aqlparser.exception.AQLParsingException;
import com.nedap.healthcare.aqlparser.exception.AQLRuntimeException;
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
import java.util.List;
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

        final ANTLRParserErrors errors = new ANTLRParserErrors();
        final QOMErrorListener errorListener = new QOMErrorListener(errors);

        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

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
        final QOMObject object = QOMParserUtil.parse(lookup, parseTree);

        if (errorListener.getErrors().hasErrors()) {
            throw new AQLParsingException("Could not parse QOM: \n" + errorListener.getErrors().toString());
        }

        final List<AQLValidationMessage> validationMessages= object.validate();
        if (!validationMessages.isEmpty()) {
            String message = validationMessages.
                    stream().
                    map(AQLValidationMessage::toString).
                    collect(Collectors.joining("; "));
            throw new AQLValidationException(message);
        }
        return object;
    }

}
