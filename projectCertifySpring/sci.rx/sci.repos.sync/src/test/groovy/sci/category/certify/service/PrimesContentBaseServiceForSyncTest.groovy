package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesSynchronousRepoMethods
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
@SpringBootTest
class PrimesContentBaseServiceForSyncTest extends PrimesSynchronousReposConfigTest {

    void testSave() {
        assert primesContentBaseService
        assert primesContentBaseService.primesRepoContract
        List<Primes> primes = PrimesContentBaseService.getPrimesInRange(range)
        def myPrimePick = primes[6]
        def candidate = primesContentBaseService.save(myPrimePick)
        assert candidate
    }

    void testGetPrimesInRange() {
        def captured = PrimesContentBaseService.getPrimesInRange(range)
        captured
    }
    private final Range<Integer> range = 1..20

}