package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.service.bootstrap.BootstrapDataService
import sci.category.certify.service.bootstrap.PrimesSynchronousReposBootstrapTest

@Test
@Slf4j
@SpringBootTest
class SynchronousServicesConfigTest extends PrimesSynchronousReposBootstrapTest {

    @Autowired
    @Qualifier("synchronousRepoBootstrapTool")
    private BootstrapDataService bootspinner

    void sanityCheck() {
        assert bootspinner
    }
    void testGetSyncRepoSpinner() {
    }
}