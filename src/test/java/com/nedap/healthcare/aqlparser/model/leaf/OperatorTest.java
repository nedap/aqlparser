package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLUnsupportedFeatureException;
import com.nedap.healthcare.aqlparser.model.Lookup;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OperatorTest extends BaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void compareNumber() {
        Operator operator = new Operator(OperatorType.EQUAL);
        assertTrue(operator.compare(2,2));
        assertTrue(operator.compare(2.0,2));
        assertTrue(operator.compare(2.0,2.0));
        assertTrue(operator.compare(2L,2.0));
        assertFalse(operator.compare(2,2.1));

        operator = new Operator(OperatorType.GREATER_THAN);
        assertTrue(operator.compare(2,1));
        assertTrue(operator.compare(2.0,1));
        assertTrue(operator.compare(2.0,1.0));
        assertTrue(operator.compare(2L,1.0));
        assertFalse(operator.compare(2L,3.0));

        operator = new Operator(OperatorType.GREATER_EQUAL_TO);
        assertTrue(operator.compare(2,1));
        assertTrue(operator.compare(2.0,2));
        assertTrue(operator.compare(2.0,2.0));
        assertTrue(operator.compare(2L,1.0));
        assertFalse(operator.compare(2L,3.0));

        operator = new Operator(OperatorType.SMALLER_THAN);
        assertTrue(operator.compare(2,3));
        assertTrue(operator.compare(2.0,3));
        assertTrue(operator.compare(2.0,3.0));
        assertTrue(operator.compare(2L,3.0));
        assertFalse(operator.compare(4L,3.0));

        operator = new Operator(OperatorType.SMALLER_EQUAL_TO);
        assertTrue(operator.compare(2,2));
        assertTrue(operator.compare(2.0,2));
        assertTrue(operator.compare(2.0,2.0));
        assertTrue(operator.compare(2L,3.0));
        assertFalse(operator.compare(4L,3.99));

        operator = new Operator(OperatorType.NOT_EQUAL);
        assertTrue(operator.compare(2,3));
        assertTrue(operator.compare(2.0,44));
        assertTrue(operator.compare(2.0,2.2));
        assertTrue(operator.compare(2L,2.0001));
        assertFalse(operator.compare(4L,4.00));
    }

    @Test
    public void compareString() {
        Operator operator = new Operator(OperatorType.EQUAL);
        assertTrue(operator.compare("someString","someString"));
        assertFalse(operator.compare("someString","someOtherString"));
    }

    @Test
    public void compareDates() {
        Operator operator = new Operator(OperatorType.EQUAL);
        assertTrue(operator.compare(LocalDate.of(1,1,1),LocalDate.of(1,1,1)));
        assertFalse(operator.compare(LocalDate.of(1,1,1),LocalDate.of(2,1,1)));

        //ToDo: Add more tests, also compare different types!
    }

    @Test
    public void illegalArgument() {
        Operator operator = new Operator(OperatorType.AND);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2,2));

        operator = new Operator(OperatorType.OR);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2,2));

        operator = new Operator(OperatorType.CONTAINS);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2,2));

        operator = new Operator(OperatorType.EXISTS);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2,2));

        operator = new Operator(OperatorType.NOT);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2,2));
    }

    @Test
    public void unsupported() {
        Operator operator = new Operator(OperatorType.GREATER_THAN);
        thrown.expect(AQLUnsupportedFeatureException.class);
        thrown.expectMessage(">, >=, <, <= operators not yet supported for comparison of Strings.");
        operator.compare("SomeString","SomeOtherString");

        operator = new Operator(OperatorType.GREATER_EQUAL_TO);
        thrown.expect(AQLUnsupportedFeatureException.class);
        thrown.expectMessage(">, >=, <, <= operators not yet supported for comparison of Strings.");
        operator.compare("SomeString","SomeOtherString");

        operator = new Operator(OperatorType.SMALLER_THAN);
        thrown.expect(AQLUnsupportedFeatureException.class);
        thrown.expectMessage(">, >=, <, <= operators not yet supported for comparison of Strings.");
        operator.compare("SomeString","SomeOtherString");

        operator = new Operator(OperatorType.SMALLER_EQUAL_TO);
        thrown.expect(AQLUnsupportedFeatureException.class);
        thrown.expectMessage(">, >=, <, <= operators not yet supported for comparison of Strings.");
        operator.compare("SomeString","SomeOtherString");
    }

    @Test
    public void nonComparable() {
        Operator operator = new Operator(OperatorType.EQUAL);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected instance of Comparable");
        //Period is not comparable
        operator.compare(Period.ZERO,Period.ZERO);
    }

    @Test
    public void compareApplesWithPears() {
        Operator operator = new Operator(OperatorType.EQUAL);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot compare public final class java.lang.Integer to public final class java.lang.String");
        //Period is not comparable
        operator.compare(22,"twenty-two");
    }


}
