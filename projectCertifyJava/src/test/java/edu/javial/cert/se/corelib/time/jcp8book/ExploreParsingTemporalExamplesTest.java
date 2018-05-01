package edu.javial.cert.se.corelib.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Locale;

@Test
public class ExploreParsingTemporalExamplesTest {
    private static Log log = LogFactory.getLog(ExploreParsingTemporalExamplesTest.class);

    private static final String STUBBED = "STUBBED";
    private static final LocalDate ldt = LocalDate.of(2015, 1, 20);

    public void quickExampleOnPredefinedFormatters_LocalDate() {


        LocalDate ldt = LocalDate.of(2015, 1, 20);

//        These are examples of using a predefined formatter:

        final String s0 = DateTimeFormatter.ISO_DATE.format(ldt);
        final String s1 = ldt.format(DateTimeFormatter.ISO_DATE);
        final String s2 = DateTimeFormatter.ISO_LOCAL_DATE.format(ldt);
        final String s22 = STUBBED; // DateTimeFormatter.ISO_LOCAL_TIME.format(ldt); java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay
        final String s222 = DateTimeFormatter.ISO_OFFSET_DATE.format(ldt);
        final String s3 = DateTimeFormatter.ISO_ORDINAL_DATE.format(ldt);
        final String s4 = DateTimeFormatter.ISO_WEEK_DATE.format(ldt);
        final String s5 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(ldt);
        final String s55 = ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));


        // ----------------
        String[] examples = {
                s0, s1, s2, s3, s4, s5, s55
        };
        Arrays.stream(examples).forEach(s -> log.debug(s));
    }
    public void quickExampleOnPredefinedFormatters_LocalTime() {


        LocalTime ldt = LocalTime.of(17,20);

//        These are examples of using a predefined formatter:

        final String s0 = DateTimeFormatter.ISO_TIME.format(ldt);
        final String s1 = ldt.format(DateTimeFormatter.ISO_LOCAL_TIME);
        final String s2 =  STUBBED;
        final String s22 = STUBBED;

        final String s50 = ldt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        final String s51 = ldt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));

        // ----------------
        String[] examples = {
                s0, s1, s2, s22, s50, s51
        };
        Arrays.stream(examples).forEach(s -> log.debug(s));
    }
    public void quickExampleOnPredefinedFormatters_LocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        final String s0 = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now);
        final String s1 = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(now);
        final String s2 = STUBBED;
        final String s3 = STUBBED;
        final String s4 = STUBBED;

        String[] examples = {
                s0, s1, s2, s3, s4
        };
        Arrays.stream(examples).forEach(s -> log.debug(s));
    }

    public void quickExampleOfParsingFromBook() {
        // Format according to ISO-8601
        String dateTimeStr1 = "2015-06-29T14:45:30";
// Custom format
        String dateTimeStr2 = "2015/06/29 14:45:30";
        LocalDateTime ldt = LocalDateTime.parse(dateTimeStr1);
// Using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
// DateTimeFormatter returns a TemporalAccessor instance
        TemporalAccessor ta = formatter.parse(dateTimeStr2);
// LocalDateTime returns an instance of the same type
        ldt = LocalDateTime.parse(dateTimeStr2, formatter);
        log.debug("");
    }
    public void foo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("QQQQ Y");
// With the current locale
        System.out.println(formatter.format(ldt));
        System.out.println(ldt.format(formatter));
// With another locale
        System.out.println(formatter.withLocale(Locale.GERMAN).format(ldt));
    }
}
