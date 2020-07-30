package com.nedap.healthcare.aqlparser.model.leaf;

import com.nedap.healthcare.aqlparser.BaseTest;
import com.nedap.healthcare.aqlparser.exception.AQLUnsupportedFeatureException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.*;

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
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        Operator operator = new Operator(OperatorType.EQUAL);
        assertTrue(operator.compare(offsetDateTime,offsetDateTime));
        assertTrue(operator.compare(offsetDateTime,offsetDateTime.toZonedDateTime()));
        assertTrue(operator.compare(offsetDateTime.toZonedDateTime(),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.toLocalDate(),offsetDateTime.toLocalDate()));
        assertTrue(operator.compare(offsetDateTime.toLocalDateTime(),offsetDateTime.toLocalDateTime()));
        assertTrue(operator.compare(offsetDateTime.toLocalTime(),offsetDateTime.toLocalTime()));
        assertFalse(operator.compare(offsetDateTime.plusHours(1),offsetDateTime));

        operator = new Operator(OperatorType.GREATER_THAN);
        assertTrue(operator.compare(offsetDateTime.plusHours(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.plusDays(1),offsetDateTime.toZonedDateTime()));
        assertTrue(operator.compare(offsetDateTime.toZonedDateTime().plusNanos(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.toLocalDate().plusYears(1),offsetDateTime.toLocalDate()));
        assertTrue(operator.compare(offsetDateTime.toLocalDateTime().plusNanos(1),offsetDateTime.toLocalDateTime()));
        assertTrue(operator.compare(offsetDateTime.toLocalTime().plusSeconds(1),offsetDateTime.toLocalTime()));
        assertFalse(operator.compare(offsetDateTime.minusHours(1),offsetDateTime));

        operator = new Operator(OperatorType.GREATER_EQUAL_TO);
        assertTrue(operator.compare(offsetDateTime.plusHours(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime,offsetDateTime.toZonedDateTime()));
        assertTrue(operator.compare(offsetDateTime.toZonedDateTime().plusNanos(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.toLocalDate().plusYears(1),offsetDateTime.toLocalDate()));
        assertTrue(operator.compare(offsetDateTime.toLocalDateTime(),offsetDateTime.toLocalDateTime()));
        assertTrue(operator.compare(offsetDateTime.toLocalTime().plusSeconds(1),offsetDateTime.toLocalTime()));
        assertFalse(operator.compare(offsetDateTime.minusHours(1),offsetDateTime));

        operator = new Operator(OperatorType.SMALLER_THAN);
        assertTrue(operator.compare(offsetDateTime.minusDays(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.minusNanos(1),offsetDateTime.toZonedDateTime()));
        assertTrue(operator.compare(offsetDateTime.toZonedDateTime().minusWeeks(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.toLocalDate().minusDays(1),offsetDateTime.toLocalDate()));
        assertTrue(operator.compare(offsetDateTime.toLocalDateTime().minusSeconds(1),offsetDateTime.toLocalDateTime()));
        assertTrue(operator.compare(offsetDateTime.toLocalTime().minusHours(1),offsetDateTime.toLocalTime()));
        assertFalse(operator.compare(offsetDateTime.plusDays(1),offsetDateTime));

        operator = new Operator(OperatorType.SMALLER_EQUAL_TO);
        assertTrue(operator.compare(offsetDateTime.minusDays(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime,offsetDateTime.toZonedDateTime()));
        assertTrue(operator.compare(offsetDateTime.toZonedDateTime().minusWeeks(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.toLocalDate().minusDays(1),offsetDateTime.toLocalDate()));
        assertTrue(operator.compare(offsetDateTime.toLocalDateTime(),offsetDateTime.toLocalDateTime()));
        assertTrue(operator.compare(offsetDateTime.toLocalTime(),offsetDateTime.toLocalTime()));
        assertFalse(operator.compare(offsetDateTime.plusDays(1),offsetDateTime));

        operator = new Operator(OperatorType.NOT_EQUAL);
        assertTrue(operator.compare(offsetDateTime.minusDays(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.minusNanos(1),offsetDateTime.toZonedDateTime()));
        assertTrue(operator.compare(offsetDateTime.toZonedDateTime().minusWeeks(1),offsetDateTime));
        assertTrue(operator.compare(offsetDateTime.toLocalDate().minusDays(1),offsetDateTime.toLocalDate()));
        assertTrue(operator.compare(offsetDateTime.toLocalDateTime().minusSeconds(1),offsetDateTime.toLocalDateTime()));
        assertTrue(operator.compare(offsetDateTime.toLocalTime().minusHours(1),offsetDateTime.toLocalTime()));
        assertFalse(operator.compare(offsetDateTime,offsetDateTime));
    }

    @Test
    public void compare_localDate_to_localDateTime() {
        Operator operator = new Operator(OperatorType.EQUAL);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot compare public final class java.time.LocalDate to public final class java.time.LocalDateTime");
        assertTrue(operator.compare(LocalDate.now(),LocalDateTime.now()));
    }

    @Test
    public void compare_localDate_to_offsetDateTime() {
        Operator operator = new Operator(OperatorType.EQUAL);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot compare public final class java.time.LocalDate to public final class java.time.OffsetDateTime");
        assertTrue(operator.compare(LocalDate.now(),OffsetDateTime.now()));
    }

    @Test
    public void compare_localDateTime_to_offsetDateTime() {
        Operator operator = new Operator(OperatorType.EQUAL);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot compare public final class java.time.LocalDateTime to public final class java.time.OffsetDateTime");
        assertTrue(operator.compare(LocalDateTime.now(),OffsetDateTime.now()));
    }

    @Test
    public void illegalArgument_and() {
        Operator operator = new Operator(OperatorType.AND);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2, 2));
    }

    @Test
    public void illegalArgument_or() {
        Operator operator = new Operator(OperatorType.OR);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2, 2));
    }

    @Test
    public void illegalArgument_contains() {
        Operator operator = new Operator(OperatorType.CONTAINS);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2, 2));
    }

    @Test
    public void illegalArgument_exists() {
        Operator operator = new Operator(OperatorType.EXISTS);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2, 2));
    }

    @Test
    public void illegalArgument_not() {
        Operator operator = new Operator(OperatorType.NOT);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Expected comparison operator");
        assertTrue(operator.compare(2,2));
    }

    @Test
    public void unsupported_greater_than() {
        Operator operator = new Operator(OperatorType.GREATER_THAN);
        thrown.expect(AQLUnsupportedFeatureException.class);
        thrown.expectMessage(">, >=, <, <= operators not yet supported for comparison of Strings.");
        operator.compare("SomeString", "SomeOtherString");
    }

    @Test
    public void unsupported_greater_equal_to() {
        Operator operator = new Operator(OperatorType.GREATER_EQUAL_TO);
        thrown.expect(AQLUnsupportedFeatureException.class);
        thrown.expectMessage(">, >=, <, <= operators not yet supported for comparison of Strings.");
        operator.compare("SomeString", "SomeOtherString");
    }

    @Test
    public void unsupported_smaller_than() {
        Operator operator = new Operator(OperatorType.SMALLER_THAN);
        thrown.expect(AQLUnsupportedFeatureException.class);
        thrown.expectMessage(">, >=, <, <= operators not yet supported for comparison of Strings.");
        operator.compare("SomeString", "SomeOtherString");
    }

    @Test
    public void unsupported_smaller_equal_to() {
        Operator operator = new Operator(OperatorType.SMALLER_EQUAL_TO);
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
