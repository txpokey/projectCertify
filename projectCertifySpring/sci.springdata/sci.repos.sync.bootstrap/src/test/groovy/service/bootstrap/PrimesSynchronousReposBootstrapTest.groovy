package service.bootstrap

import groovy.util.logging.Slf4j
import org.testng.annotations.Test
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
//@SpringBootTest
class PrimesSynchronousReposBootstrapTest extends PrimesSynchronousReposConfigTest {

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        assert primesContentBaseService
        assert primesContentBootstrap
        def species = primesContentBaseService.primesRepoContract.species
        assert species
    }
    void featureCheck() {
        sanityCheck()
        def result = primesContentBootstrap.spinUp()
        assert result
        def findAll = primesContentBaseService.primesRepoContract.findAll()
        assert findAll
    }
}
