package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesRxRepositoryContract
import sci.category.certify.service.PrimesRxService

@Test
@Slf4j
//@SpringBootTest
/**
 * synchronous repo configuration test
 */
class PrimesRxSynchronousReposConfigTest extends AbstractTestNGSpringContextTests{

    @Autowired
    PrimesRxRepositoryContract primesRepoContract

    @Autowired
    @Qualifier("primesService")
    PrimesRxService PrimesService

    void sanityCheck() {
        log.debug("PING")
        assert primesRepoContract
        assert PrimesService
        assert PrimesService.primesRepoContract
        assert PrimesService.primesRepoContract == primesRepoContract
    }

}