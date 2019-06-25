package service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.testng.annotations.Test
import sci.category.certify.service.bootstrap.PrimesBootstrapService
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
//@SpringBootTest
class PrimesSynchBootstrapDataServicesTest extends PrimesSynchronousReposConfigTest {

    @Autowired
    @Qualifier("primesBootstrapService")
    PrimesBootstrapService primesBootstrapService

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        assert primesRepositoryService
        assert primesBootstrapService
        assert primesBootstrapService.primesRepositoryService == primesRepositoryService
        def species = primesRepositoryService.species
        assert species
    }
    void featureCheck() {
        sanityCheck()
        def result = primesBootstrapService.spinUp()
        assert result
        def findAll = primesRepositoryService.primesRepoContract.findAll()
        assert findAll
    }
}
