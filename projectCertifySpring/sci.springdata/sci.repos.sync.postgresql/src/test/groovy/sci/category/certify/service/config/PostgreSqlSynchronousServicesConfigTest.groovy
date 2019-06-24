package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class PostgreSqlSynchronousServicesConfigTest extends SynchronousServicesConfigTest {

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
    }

}