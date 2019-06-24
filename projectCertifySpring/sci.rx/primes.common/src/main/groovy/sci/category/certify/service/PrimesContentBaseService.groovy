package sci.category.certify.service

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesRepoMethods

@Component("primesContentBaseService")
class PrimesContentBaseService  {
    @Autowired
    PrimesRepoMethods primesRepoContract

    Primes save(@NonNull Primes p) {
        Primes saved = primesRepoContract.save( p )
        assert saved
        saved
    }

    static List<Primes> getPrimesInRange(@NonNull Range<Integer> range, @NonNull String species = 'default') {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i,species) }
        candidate
    }

    private static getPrimeViaConstructorOnMap(@NonNull int i, @NonNull String species) {
        Map m = [prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species]
        def p = new Primes(m)
    }
}
