package edu.javial.cert.se.corelib.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

@Test
public class Chapter22Quiz {
    private static Log log = LogFactory.getLog(Chapter22Quiz.class);

    public void quiz_2() {
        ZoneOffset offset = ZoneOffset.of("Z");
        System.out.println(
                offset.get(ChronoField.HOUR_OF_DAY)
        );
    }    public void quiz_3() {
        final String PLUS5_ID_PREIMAGE = "+05:00";

        ZonedDateTime zdt =
                ZonedDateTime.of(2015,02,28,5,0,0,0,
                        ZoneId.of(PLUS5_ID_PREIMAGE));
        System.out.println(zdt.toLocalTime());

        ZoneId zoneIdOfMinus3AndMore = ZoneId.of(PLUS5_ID_PREIMAGE);

        log.debug("");
    }
    public void quiz_4() {
        ZonedDateTime zdt =
                ZonedDateTime.of(2015,10,4,0,0,0,0,
                        ZoneId.of("America/Asuncion"))
                        .plus(Duration.ofHours(1));
        System.out.println(zdt);
    }
    public void quiz_5() {
        ZonedDateTime zdt =
                ZonedDateTime.of(2015,3,22,0,0,0,0,
                        ZoneId.of("America/Asuncion"))
                        .minus(Period.ofDays(1));
        System.out.println(zdt);
    }
    public void quiz_7() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(
                formatter
                        .withLocale(Locale.ENGLISH)
                        .format(LocalDateTime.of(2015, 5, 7, 16, 0))
        );
    }
    public void quiz_8() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm:ss X");
        OffsetDateTime odt =
                OffsetDateTime.parse("11:50:20 Z", formatter);
    }
}
