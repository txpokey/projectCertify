package edu.javial.cert.se.core.time.jcp8book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.*;

// TODO : make sure you explore the EXACT syntax allowed with *.of(String of) methods
@Test
public class ExploreOffsetTest {
    private static Log log = LogFactory.getLog(ExploreOffsetTest.class);

    public void whatDoesOffsetDateTimeLookLike() {
        OffsetDateTime odt = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+03:00"));
        OffsetTime ot = OffsetTime.of(LocalTime.now(), ZoneOffset.of("-08:00"));
        log.debug(odt);
        log.debug(ot);
    }
}
