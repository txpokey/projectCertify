package edu.javial.cert.se.corelib.time;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Test
public class ExploreLocalTemporalExamplesJCP8BookTest {
    private static Log log = LogFactory.getLog(ExploreLocalTemporalExamplesJCP8BookTest.class);

    public void whatIsTimeZoneForSingapore() {
        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        log.debug(singaporeZoneId);
        log.debug(singaporeZoneId.getRules());
    }

    public void whatIsTimeZoneZulu() {
        List<ZoneId> zones = Stream.of(ZoneId.of("Z"), ZoneId.of("-2"), ZoneOffset.ofHours(-6)).collect(Collectors
                .toList());
        log.debug(zones);
    }

    public void whatIsSystemDefaultTimeZone() {
        ZoneId punisher = ZoneId.systemDefault();
        log.debug(punisher);
        log.debug(punisher.getRules());
        ZonedDateTime now = ZonedDateTime.now();
        log.debug(now);

    }

    public void whatIsTimeZoneForUTC11() {
        ZoneId id = ZoneId.of("UTC+11:00");
        log.debug(id);
    }

    public void streamOfZoneIds() {
        String[] idPreImages = {
                "Z",
                "-2",
                "UTC+11:00",
                "Asia/Singapore"
        };
        List<ZoneId> zones = Stream.of(idPreImages).collect(Collectors.mapping(ZoneId::of, Collectors.toList()));
        log.debug(zones);
    }

    public void whatDoesZonedDateTimeLookLike() {
        ZoneId australiaZone = ZoneId.of("Australia/Victoria");
        ZonedDateTime zonedDateTime =
                ZonedDateTime.of(2015, 1, 30, 13, 59, 59, 999, australiaZone);
        log.debug(zonedDateTime);
    }

    public void whatDoesOffsetDateTimeLookLike() {
        OffsetDateTime odt = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+03:00"));
        OffsetTime ot = OffsetTime.of(LocalTime.now(), ZoneOffset.of("-08:00"));
        log.debug(odt);
        log.debug(ot);
    }


}
