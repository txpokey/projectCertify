package edu.javial.cert.se.corelib.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

// TODO : ALIGNED_DAY_OF_WEEK_IN_MONTH is not making sense. unless Sunday is day 1 in these weeks.

@Test
public class ExploreLocalDateTest {
    private static Log log = LogFactory.getLog(ExploreLocalDateTest.class);

    private final LocalDate today = LocalDate.now();
    // With year(-999999999 to 999999999),
    // month (1 to 12), day of the month (1 - 31)}
    private final LocalDate newYear2001 = LocalDate.of(2001, 1, 1);
    // This version uses the enum java.time.Month
    private final LocalDate newYear2002 = LocalDate.of(2002, Month.JANUARY, 1);

    public void exploreAccessorMethods() {
        int year = today.getYear();
        int month = today.getMonthValue();
        Month monthAsEnum = today.getMonth(); // as an enum
        int dayYear = today.getDayOfYear();
        int dayMonth = today.getDayOfMonth();
        DayOfWeek dayWeekEnum = today.getDayOfWeek(); //as an enum
        log.debug("");
    }
    public void exploreChronoField() {
        int year = today.get(ChronoField.YEAR);
        int month = today.get(ChronoField.MONTH_OF_YEAR);
        int dayYear = today.get(ChronoField.DAY_OF_YEAR);
        int dayMonth = today.get(ChronoField.DAY_OF_MONTH);
        int dayWeek = today.get(ChronoField.DAY_OF_WEEK);
        int alignedDay = today.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);

        long dayEpoch = today.getLong(ChronoField.EPOCH_DAY);
        log.debug("");
    }

    public void exploreMath() {
        boolean after = newYear2001.isAfter(newYear2002); // false
        boolean before = newYear2001.isBefore(newYear2002); // true
        boolean equal = newYear2001.equals(newYear2002); // false
        boolean leapYear = newYear2001.isLeapYear(); // false
        log.debug("");
    }
    public void exploreImmutableViaWithMethod() {
        LocalDate newYear2003 = newYear2001.with(ChronoField.YEAR, 2003);
        LocalDate newYear2004 = newYear2001.withYear(2004);
        LocalDate december2001 = newYear2001.withMonth(12);
        LocalDate february2001 = newYear2001.withDayOfYear(32);
// Since these methods return a new instance, we can chain them!
        LocalDate xmas2001 = newYear2001.withMonth(12).withDayOfMonth(25);
        log.debug("");
    }
    public void exploreImmutableViaMath() {
// Adding
        LocalDate newYear2005 = newYear2001.plusYears(4);
        LocalDate march2001 = newYear2001.plusMonths(2);
        LocalDate january15_2001 = newYear2001.plusDays(14);
        LocalDate lastWeekJanuary2001 = newYear2001.plusWeeks(3);
        LocalDate newYear2006 = newYear2001.plus(5, ChronoUnit.YEARS);

// Subtracting
        LocalDate newYear2000 = newYear2001.minusYears(1);
        LocalDate nov2000 = newYear2001.minusMonths(2);
        LocalDate dec30_2000 = newYear2001.minusDays(2);
        LocalDate lastWeekDec2001 = newYear2001.minusWeeks(1);
        LocalDate newYear1999 = newYear2001.minus(2, ChronoUnit.YEARS);
        log.debug("");
    }

}
