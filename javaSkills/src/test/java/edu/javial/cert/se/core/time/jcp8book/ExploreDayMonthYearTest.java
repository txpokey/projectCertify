package edu.javial.cert.se.core.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.*;
import java.time.temporal.ChronoField;

@Test
public class ExploreDayMonthYearTest {
    private static Log log = LogFactory.getLog(ExploreDayMonthYearTest.class);

    ZonedDateTime now_zdt = ZonedDateTime.now();
    LocalDateTime now_ldt = now_zdt.toLocalDateTime();


    public void exploreMonthYear() {
        exploreMonthYear(now_ldt);
        exploreMonthYear(now_zdt);
    }

    private void exploreMonthYear(ZonedDateTime now) {
        log.debug(now);
        exploreMonthYear(getMonth(now), getYear(now));
    }
    private void exploreMonthYear(LocalDateTime now) {
        log.debug(now);
        exploreMonthYear(getMonth(now), getYear(now));
    }

    private void exploreMonthYear(int month, int year) {
        Month monthEnum = Month.of(month);
        Year yearEnum = Year.of(year);
        log.debug(monthEnum);
        log.debug(yearEnum);
    }

    private int getMonth(ZonedDateTime now) {
        return now.get(ChronoField.MONTH_OF_YEAR);
    }
    private int getMonth(LocalDateTime now) {
        return now.get(ChronoField.MONTH_OF_YEAR);
    }
    private int getYear(ZonedDateTime now) {
        return now.get(ChronoField.YEAR);
    }
    private int getYear(LocalDateTime now) {
        return now.get(ChronoField.YEAR);
    }
}
