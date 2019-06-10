package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesSynchronousRepoMethods

@Test
@Slf4j
@SpringBootTest
class PrimesContentBaseServiceForSyncTest extends AbstractTestNGSpringContextTests {

//    @Autowired
//    PrimesSynchronousRepoMethods primesRepoContract

    void testSave() {
    }

    void testGetPrimesInRange() {
        final Range<Integer> range = 1..20
        def captured = PrimesContentBaseService.getPrimesInRange(range)
        captured
    }
}