package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.domain.Primes
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
@SpringBootTest
class PrimesSyncContentBaseServiceTest extends PrimesSynchronousReposConfigTest{

    void sanityCheck() {
        log.debug("PING")
        super.sanityCheck()
        assert primesRepositoryService
        assert primesRepositoryService.primesRepoContract
        assert primesRepositoryService.species
    }
    void testSave() {
        sanityCheck()
        final def species = getRepositorySpecies()

        assert range.size() >= TESTED_PRIME_INDEX
        List<Primes> primes = getPrimesInRange(range,species)
        assert primes
        assert primes.size() >= TESTED_PRIME_INDEX
        def myPrimePick = primes[TESTED_PRIME_INDEX]
        def candidate = primesRepositoryService.save(myPrimePick)
        assert candidate
    }

    private getRepositorySpecies() {
        primesRepositoryService.species
    }

    private getPrimesInRange(Range range, String species) {
        List<Primes> primes = PrimesRepositoryService.getPrimesInRange(range, species)
        primes
    }

    void testGetPrimesInRange() {
        final def species = getRepositorySpecies()
        def captured = PrimesRepositoryService.getPrimesInRange(range, species)
        captured
    }
    private final Range<Integer> range = 101..120
    private final TESTED_PRIME_INDEX = 0
}