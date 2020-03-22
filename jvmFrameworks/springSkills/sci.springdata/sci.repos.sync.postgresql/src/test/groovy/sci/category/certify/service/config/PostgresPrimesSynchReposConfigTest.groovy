package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.repo.PostgresSyncPrimesRepository

@Test
@Slf4j
@SpringBootTest
/**
 * synchronous repo configuration test
 */
class PostgresPrimesSynchReposConfigTest extends PrimesSynchronousReposConfigTest {

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        PostgresSyncPrimesRepository repo = PrimesService.primesRepoContract
        assert repo
        def species = PrimesService.species
        assert species
    }

}