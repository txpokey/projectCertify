package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class OraSynchronousServicesConfigTest extends SynchronousServicesConfigTest {

    void sanityCheck() {
        super.sanityCheck()
    }

}