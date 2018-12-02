package sci.category.certify.repo.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesContentRepoForH2

@Test
@Slf4j
@SpringBootTest
class RepositoryConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("primesContentRepoUsingH2")
    PrimesContentRepoForH2 primesContentRepoForH2

    void sanityCheck() {
        assert primesContentRepoForH2
        log.debug("")
    }
}