package sci.category.certify.service

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesRepoMethods

@Component("primesRepositoryService")
class PrimesContentBaseService  {
    @Autowired
    @Qualifier("primesRepoMethods")
    PrimesRepoMethods primesRepoMethods

    Mono<Primes> save(@NonNull Primes p) {
        def saved = primesRepoMethods.save( p )
        assert saved
        saved
    }
   Primes save0(@NonNull Primes p) {
        Primes saved = primesRepoMethods.save( p )
        assert saved
        saved
    }

    static List<Primes> getPrimesInRange(@NonNull Range<Integer> range, @NonNull String species ) {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i, species) }
        candidate
    }
    static List<Primes> getPrimesInRange(@NonNull Range<Integer> range) {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i, "default") }
        candidate
    }

    private static getPrimeViaConstructorOnMap(@NonNull int i, @NonNull String species) {
        Map m = [prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
        def p = new Primes(m)
    }
}
