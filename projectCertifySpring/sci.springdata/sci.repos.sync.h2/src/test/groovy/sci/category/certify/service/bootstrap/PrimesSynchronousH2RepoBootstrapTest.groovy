package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
@SpringBootTest
class PrimesSynchronousH2RepoBootstrapTest extends PrimesSynchronousReposConfigTest {
    void sanityCheck() {
        super.sanityCheck()
    }
    void featureCheck() {
        super.featureCheck()
    }
}
