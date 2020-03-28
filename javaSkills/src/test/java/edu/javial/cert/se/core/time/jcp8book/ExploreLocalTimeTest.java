package edu.javial.cert.se.core.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

@Test
public class ExploreLocalTimeTest {
    private static Log log = LogFactory.getLog(ExploreLocalTimeTest.class);

    public void introLocalTime() {
        // With hour (0-23) and minutes (0-59)
        LocalTime fiveThirty = LocalTime.of(5, 30);
// With hour, minutes, and seconds (0-59)
        LocalTime noon = LocalTime.of(12, 0, 0);
// With hour, minutes, seconds, and nanoseconds (0-999,999,999)
        LocalTime almostMidnight = LocalTime.of(23, 59, 59, 999999);
        LocalTime am2 = LocalTime.of(02, 0);
        LocalTime am2PlusZero = LocalTime.of(02, 0).plusHours(0);
        LocalTime zeroHour = LocalTime.of(0, 0, 0, 0);
        LocalDateTime thisMorningMidnight = LocalDate.now().atStartOfDay();
        LocalTime midnight = LocalTime.from(thisMorningMidnight);
        LocalDateTime thisMorning2am = am2.atDate(LocalDate.from(thisMorningMidnight));
        ZonedDateTime thisMorning2amChicago = ZonedDateTime.of(thisMorning2am, ZoneId.of("America/Chicago"));
        log.debug("");
    }

    public void exploreInstant() {
        Instant now = Instant.now();
        long i = now.getLong(ChronoField.MICRO_OF_SECOND);
        long sec = now.getEpochSecond();
        Instant more = now.plus(1, ChronoUnit.DAYS);
        log.debug("");
    }

    public void explorePeriod() {
// dif1 will be 1 year 2 months 2 days
        Period dif1 = Period.between(LocalDate.of(2000, 2, 10), LocalDate.of(2001, 4, 12));
// dif2 will be 25 days
        Period dif2 = Period.between(LocalDate.of(2013, 5, 9), LocalDate.of(2013, 6, 3));
// dif3 will be -2 years -3 days
        Period dif3 = Period.between(LocalDate.of(2014, 11, 3), LocalDate.of(2012, 10, 31));
        Period z = Period.ZERO;
        z.get(ChronoUnit.DAYS);
        z.plusDays(0);
        z.withDays(0);
        log.debug("");
    }

    public void exploreDuration() {
        Duration dif = Duration.between(Instant.ofEpochSecond(123456789), Instant.ofEpochSecond(99999));
        List<TemporalUnit> willPass = dif.getUnits(); // Seconds and Nanos
        final Predicate<ChronoUnit> chronoUnitPredicate = v -> !willPass.contains(v);
        List<TemporalUnit> getWillFailOnThese = Arrays.stream(ChronoUnit.values()).filter(chronoUnitPredicate).collect
                (Collectors.toList());
        log.debug("temporalUnitBiFunction4Get");
        findWhichUnitsAreSupported(dif, getWillFailOnThese, temporalUnitBiFunction4Get);
        findWhichUnitsAreSupported(dif, willPass, temporalUnitBiFunction4Get);
        log.debug("temporalUnitBiFunction4Of");
        findWhichUnitsAreSupported(dif, getWillFailOnThese, temporalUnitBiFunction4Of);
        findWhichUnitsAreSupported(dif, willPass, temporalUnitBiFunction4Of);
        log.debug("");
    }
    final private BiFunction<Duration, TemporalUnit, Object> temporalUnitBiFunction4Get = (duration, couldThrow ) ->
            duration.get
            (couldThrow);
    final private BiFunction<Duration, TemporalUnit, Object> temporalUnitBiFunction4Of = (dummy, couldThrow ) ->
            Duration.of
            (1, couldThrow);

    private void findWhichUnitsAreSupported(Duration duration, List<TemporalUnit> mayFailOnThese,
                                            BiFunction<Duration, TemporalUnit, Object> biFunction) {
        for( TemporalUnit couldThrow : mayFailOnThese )
        {
            try {
                Object candidate = biFunction.apply(duration,couldThrow);
                log.debug("works:> " + couldThrow );
            } catch (UnsupportedTemporalTypeException e) {
                log.debug(e.getMessage());
            }
        }
    }

    final private Consumer<TemporalUnit> getTemporalUnitConsumer__NOTUSED(Duration dif) {
        return dif::get;
    }
    public void directlyFromChapter21_LocalTime() {
        LocalTime now = LocalTime.now();

//        Once we have an instance of LocalTime, we can get the hour, the minutes, and other information with methods like the following:

        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int nanosecond = now.getNano();

//        We can also use the get() method:

        /*
            int get(java.time.temporal.TemporalField field) // value as int
            long getLong(java.time.temporal.TemporalField field) // value as long
         */


//        Just like in the case of LocalDate, we can have, for example:

        int hourAMPM = now.get(ChronoField.HOUR_OF_AMPM); // 0 - 11
        int clockHourAMPM = now.get(ChronoField.CLOCK_HOUR_OF_AMPM);
        int hourDay = now.get(ChronoField.HOUR_OF_DAY); // 0 - 23
        int minuteDay = now.get(ChronoField.MINUTE_OF_DAY); // 0 - 1,439
        int minuteHour = now.get(ChronoField.MINUTE_OF_HOUR); // 0 - 59
        int secondDay = now.get(ChronoField.SECOND_OF_DAY); // 0 - 86,399
        int secondMinute = now.get(ChronoField.SECOND_OF_MINUTE);// 0 - 59
        long nanoDay = now.getLong(ChronoField.NANO_OF_DAY);//0-86399999999
        int nanoSecond = now.get(ChronoField.NANO_OF_SECOND);//0-999999999
        log.debug("");
    }
}
