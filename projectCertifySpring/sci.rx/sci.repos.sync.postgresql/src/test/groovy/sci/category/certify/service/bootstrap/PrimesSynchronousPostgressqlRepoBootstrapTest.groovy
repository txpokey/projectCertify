package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class PrimesSynchronousPostgreSqlRepoBootstrapTest extends PrimesSynchronousReposBootstrapTest {
    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
    }
    void featureCheck() {
        super.featureCheck()
    }
}
