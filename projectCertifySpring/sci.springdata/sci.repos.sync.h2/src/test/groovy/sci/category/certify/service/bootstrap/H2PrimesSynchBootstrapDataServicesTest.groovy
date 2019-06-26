package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class H2PrimesSynchBootstrapDataServicesTest extends PrimesSynchBootstrapDataServicesTest {
    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
    }
    void featureCheck() {
        this.sanityCheck()
        log.debug("PING")
        super.featureCheck()
        assert true
    }
}
