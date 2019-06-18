package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesRepoMethods
import sci.category.certify.service.bootstrap.BootstrapDataService

@Test
@Slf4j
@SpringBootTest
class AdhocPostgreSqlConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("primesRepoMethods")
    PrimesRepoMethods repository

    @Autowired
    @Qualifier("bootstrapTool")
    private BootstrapDataService spinner

    void sanityCheck() {
        assert repository
        assert spinner
    }
}
