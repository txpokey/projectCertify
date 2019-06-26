package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.service.bootstrap.SynchApplicationContentBootstrapServiceTest

@Test
@Slf4j
@SpringBootTest
class H2PrimesSyncApplicationContentBootstrapListConfigTest extends SynchApplicationContentBootstrapServiceTest {

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
    }

}