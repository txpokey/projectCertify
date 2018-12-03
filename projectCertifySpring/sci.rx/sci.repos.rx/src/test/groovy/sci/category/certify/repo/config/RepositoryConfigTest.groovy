package sci.category.certify.repo.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesContentRepoUsingRxMongo

@Test
@Slf4j
@SpringBootTest
class RepositoryConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("primesContentRepoUsingRxMongo")
    PrimesContentRepoUsingRxMongo primesContentRepoUsingRxMongo

    void sanityCheck() {
        assert primesContentRepoUsingRxMongo
        log.debug("")
    }
}