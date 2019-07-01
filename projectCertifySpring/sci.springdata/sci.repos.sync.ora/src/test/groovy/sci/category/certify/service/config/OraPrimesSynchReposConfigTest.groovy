package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesRepositoryContract

@Test
@Slf4j
@SpringBootTest
/**
 * synchronous repo configuration test
 */
class OraPrimesSynchReposConfigTest extends PrimesSynchronousReposConfigTest {

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        PrimesRepositoryContract repo = PrimesService.primesRepoContract
        assert repo
        def species = PrimesService.species
        assert species
    }

}