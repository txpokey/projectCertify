package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import service.config.SyncBootstrapDataServicesConfigTest

@Test
@Slf4j
@SpringBootTest
class PostgresPrimesSyncBootstrapDataServicesConfigTest extends SyncBootstrapDataServicesConfigTest {

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
    }

}