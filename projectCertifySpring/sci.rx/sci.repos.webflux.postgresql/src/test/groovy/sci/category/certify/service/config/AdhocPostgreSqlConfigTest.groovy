package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesWebfluxRepoPostgreSql

@Test
@Slf4j
@SpringBootTest
class AdhocPostgreSqlConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    PrimesWebfluxRepoPostgreSql repository

    void sanityCheck() {
        assert true
    }
}
