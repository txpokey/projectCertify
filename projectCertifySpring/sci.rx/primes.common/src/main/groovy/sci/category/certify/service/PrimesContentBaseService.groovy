package sci.category.certify.service

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import org.springframework.lang.NonNull
import sci.category.certify.domain.Primes

//interface PrimesContentServiceContract extends PrimesContentRepo {
//
//    PrimesContentRepo getRepository()
//
//}

//abstract class PrimesContentBaseService implements PrimesContentServiceContract {
abstract class PrimesContentBaseService  {

//    @Override
    Primes save(@NonNull Primes p) {
//        Primes saved = getRepository().save( p )
        assert false
        Primes saved = null
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
