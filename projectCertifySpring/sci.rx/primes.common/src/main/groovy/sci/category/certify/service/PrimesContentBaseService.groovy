package sci.category.certify.service

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesSynchronousRepoMethods

@Component("PrimesContentBaseService")

class PrimesContentBaseService  {
    @Autowired
    PrimesSynchronousRepoMethods primesRepoContract

    Primes save(@NonNull Primes p) {
        Primes saved = primesRepoContract.save( p )
        assert saved
        saved
    }

    static List<Primes> getPrimesInRange(@NonNull Range<Integer> range) {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i) }
        candidate
    }

    private static getPrimeViaConstructorOnMap(int i) {
        Map m = [prime: i, truth: PrimeNumberGroovy.isPrime(i)]
        def p = new Primes(m)
    }
}
