package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class PostgresPrimesSyncContentBaseServiceTest extends PrimesSyncContentBaseServiceTest {

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

    void testGetPrimesInRangeClient() {
        def candidate = super.testGetPrimesInRange()
        assert candidate
        assert super.range.size() == candidate.size()
        log.debug("size of primesInRange: ${candidate.size()}")
    }

}