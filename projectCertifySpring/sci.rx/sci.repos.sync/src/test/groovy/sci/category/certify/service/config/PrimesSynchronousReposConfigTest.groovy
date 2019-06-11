package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesSynchronousRepoMethods
import sci.category.certify.service.PrimesContentBaseService


@Test
@Slf4j
@SpringBootTest
/**
 * synchronous repo configuration test
 */
class PrimesSynchronousReposConfigTest extends AbstractTestNGSpringContextTests{

    @Autowired
    PrimesSynchronousRepoMethods primesRepoContract

    @Autowired
    @Qualifier("PrimesContentBaseService")
    PrimesContentBaseService primesContentBaseService

    void sanityCheck() {
        assert primesRepoContract
        assert primesContentBaseService
        assert primesContentBaseService.primesRepoContract
        assert primesContentBaseService.primesRepoContract == primesRepoContract
    }

}