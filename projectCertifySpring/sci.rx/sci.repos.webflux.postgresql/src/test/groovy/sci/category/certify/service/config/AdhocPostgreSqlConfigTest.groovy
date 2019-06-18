package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class AdhocPostgreSqlConfigTest extends AbstractTestNGSpringContextTests {
//class AdhocPostgreSqlConfigTest{

    void sanityCheck() {
        assert true
    }
}
