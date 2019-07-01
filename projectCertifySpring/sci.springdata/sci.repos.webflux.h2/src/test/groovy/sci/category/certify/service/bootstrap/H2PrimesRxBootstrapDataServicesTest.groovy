package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.service.config.H2R2DbcConfigurationTest

@Test
@Slf4j
@SpringBootTest
class H2PrimesRxBootstrapDataServicesTest extends H2R2DbcConfigurationTest {

    @Autowired
    @Qualifier("primesBootstrapService")
    PrimesRxBootstrapService primesBootstrapService

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        assert primesBootstrapService
    }
    void featureCheck() {
        sanityCheck()
        def result = primesBootstrapService.spinUp()
        assert result
        def findAll = primesBootstrapService.primesService.findAll()
        assert findAll
    }
}
