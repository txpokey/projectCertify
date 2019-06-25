package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import service.bootstrap.SynchApplicationContentBootstrapServiceTest

@Test
@Slf4j
@SpringBootTest
class OraSynchApplicationContentBootstrapServiceTest extends SynchApplicationContentBootstrapServiceTest {
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