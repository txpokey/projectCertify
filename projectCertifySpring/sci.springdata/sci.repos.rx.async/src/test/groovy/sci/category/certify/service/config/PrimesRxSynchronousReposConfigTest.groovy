package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesRepositoryContract
import sci.category.certify.service.PrimesRepositoryService

@Test
@Slf4j
@SpringBootTest
/**
 * synchronous repo configuration test
 */
class PrimesRxSynchronousReposConfigTest extends AbstractTestNGSpringContextTests{

    @Autowired
    PrimesRepositoryContract primesRepoContract

    @Autowired
    @Qualifier("primesRepositoryService")
    PrimesRepositoryService primesRepositoryService

    void sanityCheck() {
        log.debug("PING")
        assert primesRepoContract
        assert primesRepositoryService
        assert primesRepositoryService.primesRepoContract
        assert primesRepositoryService.primesRepoContract == primesRepoContract
    }

}