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
class PrimesH2SynchronousReposConfigTest extends PrimesSynchronousReposConfigTest {

    void sanityCheck() {
        super.sanityCheck()
    }

}