package edu.javial.cert.se.core.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

// TODO investigate ZoneRules , esp "transitions" and "offset" values

@Test
public class ExploreZonedDateTimeTest {
    private static Log log = LogFactory.getLog(ExploreZonedDateTimeTest.class);

    public void whatDoesZonedDateTimeLookLike() {
        ZoneId australiaZone = ZoneId.of("Australia/Victoria");
        ZonedDateTime zonedDateTime =
                ZonedDateTime.of(2015, 1, 30, 13, 59, 59, 999, australiaZone);
        log.debug(zonedDateTime);
        log.debug(zonedDateTime.getOffset());
    }
    public void lookAtAllZoneIdsForDateTime() {
        List<Function<ZoneId, ZonedDateTime>> list = Arrays.asList(getZonedDateTimeForExampleDateTime, getZonedDateTimeFromLocalDateTime );
        list.stream().forEach( m -> {
            lookAtAllZoneIdsForDateTime(m);
            log.debug("--------------------");
            }
        ) ;
    }

    final private Function<ZoneId, ZonedDateTime> getZonedDateTimeForExampleDateTime =
            this::getZonedDateTimeForExampleDateTime;
    final private Function<ZoneId, ZonedDateTime> getZonedDateTimeFromLocalDateTime =
            this::getZonedDateTimeFromExampleLocalDateTime;

    private void lookAtAllZoneIdsForDateTime(Function<ZoneId, ZonedDateTime> mapper) {
        ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).map(mapper)
                .sorted(zonedDateTimeComparator).forEach(
                zonePick -> {
                    log.debug(zonePick.getZone());
                    log.debug(zonePick.getOffset());
                }
        );
    }

    private Comparator<? super ZonedDateTime> zonedDateTimeComparator = Comparator.comparing(ZonedDateTime::getOffset);

    private ZonedDateTime getZonedDateTimeForExampleDateTime(ZoneId zoned) {
        return ZonedDateTime.of(2010, 7, 3, 9, 0, 59, 999, zoned);
    }

    private ZonedDateTime getZonedDateTimeFromExampleLocalDateTime(ZoneId zoned) {
        final LocalDateTime dateTime = LocalDateTime.of(2010, 7, 3, 9, 0, 59, 999);
        ZonedDateTime zonedDateTime = dateTime.atZone(zoned);
        return zonedDateTime;
    }
    private final ZoneId australiaZone = ZoneId.of("Australia/Victoria");

    public void directlyFromChapter22_ZonedDateTime() {
        ZonedDateTime now = ZonedDateTime.now();

        LocalDate currentDate = now.toLocalDate();
        LocalTime currentTime = now.toLocalTime();
        LocalDateTime currentDateTime = now.toLocalDateTime();

        //To get the value of a specified field
        int day = now.getDayOfMonth();
        int dayYear = now.getDayOfYear();
        int nanos = now.getNano();
        Month monthEnum = now.getMonth();
        int year = now.get(ChronoField.YEAR);
        long micro = now.getLong(ChronoField.MICRO_OF_DAY);
// This is new, gets the zone offset such as "-03:00"
        ZoneOffset offset = now.getOffset();
// To create another instance
        ZonedDateTime zdt1 = now.with(ChronoField.HOUR_OF_DAY, 10);
        ZonedDateTime zdt2 = now.withSecond(49);
// Since these methods return a new instance, we can chain them!
        ZonedDateTime zdt3 = now.withYear(2013).withMonth(12);


// The following two methods are specific to ZonedDateTime
// Returns a copy of the date/time with a
// different zone, retaining the instant
        ZonedDateTime zdt4 = now.withZoneSameInstant(australiaZone);
// Returns a copy of this date/time with a different time zone,
// retaining the local date/time if it's valid for the new time zone
        ZonedDateTime zdt5 = now.withZoneSameLocal(australiaZone);

// Adding
        ZonedDateTime zdt6 = now.plusDays(4);
        ZonedDateTime zdt7 = now.plusWeeks(3);
        ZonedDateTime zdt8 = now.plus(2, ChronoUnit.HOURS);

// Subtracting
        ZonedDateTime zdt9 = now.minusMinutes(20);
        ZonedDateTime zdt10 = now.minusNanos(99999);
        ZonedDateTime zdt11 = now.minus(10, ChronoUnit.SECONDS);
        //
        ZonedDateTime.now(ZoneId.of("America/Montreal"));


        log.debug("");
    }
    public void lookIntoIssue62_0() {
        LocalDate newYear2001 = LocalDate.of(2001, 1, 1);
        LocalDate zdt8 = newYear2001.plus(2, ChronoUnit.HOURS);
    }
    public void lookIntoIssue62_1() {
        ZonedDateTime newYear2001 = LocalDate.of(2001, 1, 1).atStartOfDay(australiaZone);
        ZonedDateTime zdt8 = newYear2001.plus(2, ChronoUnit.HOURS);
    }
}
