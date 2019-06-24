package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesRepoMethods
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
@SpringBootTest
class PrimesContentServiceViaSyncTest extends PrimesSynchronousReposConfigTest{

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        assert primesContentBaseService
        assert primesContentBaseService.primesRepoContract
        assert primesContentBaseService.primesRepoContract.species
    }
    void testSave() {
        sanityCheck()
        final def species = primesContentBaseService.primesRepoContract.species

        assert range.size() >= TESTED_PRIME_INDEX
        List<Primes> primes = PrimesContentBaseService.getPrimesInRange(range,species)
        assert primes
        assert primes.size() >= TESTED_PRIME_INDEX
        def myPrimePick = primes[TESTED_PRIME_INDEX]
        def candidate = primesContentBaseService.save(myPrimePick)
        assert candidate
    }

    void testGetPrimesInRange() {
        def captured = PrimesContentBaseService.getPrimesInRange(range)
        captured
    }
    private final Range<Integer> range = 101..120
    private final TESTED_PRIME_INDEX = 0
}