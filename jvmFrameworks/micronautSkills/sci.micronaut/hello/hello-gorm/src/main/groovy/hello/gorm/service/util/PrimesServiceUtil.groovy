package hello.gorm.service.util

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import hello.gorm.domain.Primes

import javax.annotation.Nonnull

class PrimesServiceUtil{

    static List<Primes> getPrimesInRange(@Nonnull Range<Integer> range, @Nonnull String species = 'default') {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i,species) }
        candidate
    }

    private static def getPrimeViaConstructorOnMap(@Nonnull int i, @Nonnull String species) {
        Map m = [prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species]
        def p = new Primes(m)
    }

}
