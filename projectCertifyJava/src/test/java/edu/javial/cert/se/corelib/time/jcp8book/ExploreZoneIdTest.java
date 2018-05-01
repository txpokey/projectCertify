package edu.javial.cert.se.corelib.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO keep an eye on the region/city zone id and Sx of other 2 styles of ZoneId spec
@Test
public class ExploreZoneIdTest {
    private static Log log = LogFactory.getLog(ExploreZoneIdTest.class);

    public void whatIsTimeZoneForSingapore() {
        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        ZoneId zoneIdOfPlus3 = ZoneId.of("+3");
        ZoneId zoneIdOfMinus3 = ZoneId.of("-3");
/*
    // THROWS
        ZoneId zoneIdOfMinus3AndMore = ZoneId.of("+5:00");
*/
        ZoneId zoneIdUTC11 = ZoneId.of("UTC+11");

        log.debug(singaporeZoneId);
        log.debug(singaporeZoneId.getRules());
    }

    public void whatIsTimeZoneZulu() {
        ZoneId Z = ZoneId.of("Z");
        ZoneId UTC = ZoneOffset.UTC;

        log.debug(Z);
        log.debug(UTC);
        log.debug(((ZoneOffset) UTC).get(ChronoField.OFFSET_SECONDS));
        assert Z.equals(UTC);
    }

    public void whatIsSystemDefaultTimeZone() {
        ZoneId punisher = ZoneId.systemDefault();
        log.debug(punisher);
        log.debug(punisher.getRules());
        TimeZone defaultTZ = TimeZone.getDefault();
        ZoneId defaultTZid = ZoneId.of(defaultTZ.getID());
        log.debug(defaultTZ);
        log.debug(defaultTZid);
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

    public void lookAtAllZoneIds() {
        ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).forEach(

                z -> {
                    log.debug(z.getId());
                    log.debug(z.normalized().getClass());
                }
        );

    }
}
