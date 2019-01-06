package sci.category.certify.service

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import org.springframework.lang.NonNull
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesContentRepo

interface PrimesContentServiceContract extends PrimesContentRepo {

    PrimesContentRepo getRepository()

}

abstract class PrimesContentBaseService implements PrimesContentServiceContract {

//    @Override
    Primes save(@NonNull Primes p) {
        Primes saved = getRepository().save( p )
        saved
    }

    static List<Primes> getPrimesInRange(@NonNull Range<Integer> range) {
        def candidate = (range).collect { i -> [ prime : i, truth: PrimeNumberGroovy.isPrime( i ) ] }
        candidate
    }
}
