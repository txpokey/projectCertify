package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesRepositoryContract
import sci.category.certify.service.PrimesService

@Test
@Slf4j
//@SpringBootTest
/**
 * synchronous repo configuration test
 */
class PrimesSynchronousReposConfigTest extends AbstractTestNGSpringContextTests{

    @Autowired
    PrimesRepositoryContract primesRepoContract

    @Autowired
    @Qualifier("primesService")
    PrimesService primesService

    void sanityCheck() {
        log.debug("PING")
        assert primesRepoContract
        assert primesService
        assert primesService.primesRepoContract
        assert primesService.primesRepoContract == primesRepoContract
    }

}