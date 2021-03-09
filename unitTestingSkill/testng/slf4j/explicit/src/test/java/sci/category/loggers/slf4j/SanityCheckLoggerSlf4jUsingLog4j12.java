package sci.category.loggers.slf4j;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

@Slf4j
@Test
public class SanityCheckLoggerSlf4jUsingLog4j12 {
    private static Logger log = LoggerFactory.getLogger(SanityCheckLoggerSlf4jUsingLog4j12.class);
    public void sanityCheck() {
        log.info("PING!");
        log.debug("PING!");
    }
}
