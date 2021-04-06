package edu.javial.cert.se.core.math


//import javax.annotation.Nonnull
import java.util.concurrent.ConcurrentSkipListSet

//@Slf4j
class PrimeNumberGroovy{


    static boolean isPrime( Integer p ) {
        final def specials = 1..3
        def candidate = specials.contains(p) ? true : privateIsPrime(p)
        candidate
    }

    private static privateIsPrime(int p) {
        final def limit = upperLimit(p)
        final def range = limit..2
        final def cl0 = { i -> 0 == (p % i) }
        def candidate = (range).any(cl0)
        def ret = !candidate
//        log.debug("${p}:> ${ret}")
        ret
    }

    private static boolean isUndiscovered(Integer number) {
        boolean ret = false
        boolean discovered = isDiscovered(number)
        ret = !discovered
    }

    private static boolean isDiscovered(Integer number) {
        boolean ret = primesFound.contains(number)
        ret
    }

    private static int upperLimit(Integer number) {
        int limit = (int) Math.sqrt(number)
        limit
    }

    List<Integer> getPrimes() {
        List<Integer> ret = new ArrayList<>(primesFound)
        ret
    }

    private boolean updatePrimesFound(Integer number) {
        boolean ret = primesFound.add(number)
        ret
    }
    private static ConcurrentSkipListSet<Integer> primesFound = new ConcurrentSkipListSet<>();

}
