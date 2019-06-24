package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import service.bootstrap.SynchApplicationBootstrapDataServicesTest

@Test
@Slf4j
@SpringBootTest
class PostgresPrimesSynchApplicationBootstrapDataServicesTest extends SynchApplicationBootstrapDataServicesTest {
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
    void confirmFullBootstrap() {
        sanityCheck()
        super.confirmFullBootstrap()
        assert true
    }
}