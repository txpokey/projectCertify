package edu.javial.cert.se.corelib.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.*;
import java.time.temporal.ChronoField;

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
        LocalTime zeroHour = LocalTime.of(0, 0, 0, 0 );
        LocalDateTime thisMorningMidnight = LocalDate.now().atStartOfDay();
        LocalTime midnight = LocalTime.from(thisMorningMidnight);
        LocalDateTime thisMorning2am = am2.atDate(LocalDate.from(thisMorningMidnight));
        ZonedDateTime thisMorning2amChicago = ZonedDateTime.of(thisMorning2am, ZoneId.of("America/Chicago"));
        log.debug("");
    }
    public void directlyFromChapter21_LocalTime() {
        LocalTime now = LocalTime.now();

//        Once we have an instance of LocalTime, we can get the hour, the minutes, and other information with methods like the following:

        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now. getSecond();
        int nanosecond = now. getNano();

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
