package service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.testng.annotations.Test
import sci.category.certify.service.bootstrap.BootstrapDataService
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
//@SpringBootTest
class SynchApplicationBootstrapDataServicesTest extends PrimesSynchronousReposConfigTest {

    @Autowired
    @Qualifier("syncBootstrapDataServices")
    private BootstrapDataService bootspinner

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        assert bootspinner
    }
    void featureCheck() {
        sanityCheck()
        def result = bootspinner.spinUp()
        assert result
        def findAll = primesContentBaseService.primesRepoContract.findAll()
        assert findAll
    }
//    void testGetSyncRepoSpinner() {
//    }
}