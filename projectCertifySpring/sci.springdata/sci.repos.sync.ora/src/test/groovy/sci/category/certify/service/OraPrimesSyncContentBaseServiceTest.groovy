package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class OraPrimesSyncContentBaseServiceTest extends PrimesSyncContentBaseServiceTest {

    void sanityCheck() {
        log.debug("PING")
        log.debug(java.util.UUID.randomUUID() as String)
        super.sanityCheck()
    }

    void testSave() {
        sanityCheck()
        super.testSave()
        assert true
    }

    void testGetPrimesInRange() {
        super.testGetPrimesInRange()
    }

}