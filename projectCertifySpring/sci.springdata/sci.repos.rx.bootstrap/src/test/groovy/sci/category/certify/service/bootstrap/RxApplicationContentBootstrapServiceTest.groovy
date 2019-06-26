package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.testng.annotations.Test
import sci.category.certify.service.config.PrimesRxSynchronousReposConfigTest

@Test
@Slf4j
//@SpringBootTest
class RxApplicationContentBootstrapServiceTest extends PrimesRxSynchronousReposConfigTest {

    @Autowired
    @Qualifier("applicationContentBootstrap")
    private ApplicationContentBootstrapContract bootspinner

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        assert bootspinner
    }
    void featureCheck() {
        sanityCheck()
        def result = bootspinner.spinUp()
        assert result
        def findAll = primesRepositoryService.primesRepoContract.findAll()
        assert findAll
    }
    void confirmFullBootstrap() {
        def findAll = primesRepositoryService.primesRepoContract.findAll()
        assert findAll.size() == 100
    }
//    void testGetSyncRepoSpinner() {
//    }
}