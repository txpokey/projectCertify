package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
/**
 * synchronous repo configuration test
 */
class PrimesPostgreSqlSynchronousReposConfigTest extends PrimesSynchronousReposConfigTest {

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
    }

}