/**
 *
 */
package edu.javial.cert.se.core.math;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This class writes out Prime numbers. A number is prime if it is
 * divisible by 1 and the number itself and no other number.
 * @see <a href="http://www.cs.utexas.edu/users/mitra/uxFall2004/cs303/assgn/prime.html">Primes Algorithm </a>
 */
public class PrimeNumber {
    private static Log log = LogFactory.getLog(PrimeNumber.class);
    private ConcurrentSkipListSet<Integer> primesFound = new ConcurrentSkipListSet<>();

    /**
     * This method tests whether a given number is prime or not. (thread-safe?)
     * @param num number being tested vs. primes
     * @return whether prime or not
     */
    public boolean isPrime(int num) {
        boolean prime = false;
        primeCheck:
        {
            if (isUndiscovered(num)) {
                int limit = upperLimit(num);
                for (int i = limit; 1 < i ; i--) {
                    if (0 == ( num % i )) {
                        break primeCheck;
                    } // if
                } // for
                prime = updatePrimesFound(num);
            } // if undiscovered
        } // primeCheck
        return prime;
    }

    public boolean isUndiscovered(Integer number) {
        boolean ret = false;
        boolean discovered = isDiscovered(number);
        return ret = !discovered;
    }

    public boolean isDiscovered(Integer number) {
        boolean ret = primesFound.contains(number) ;
        return ret ;
    }

    private static int upperLimit(int number) {
        int limit = (int) Math.sqrt(number) ;
        return  limit ;
    }

    public Collection<Integer> getPrimes() {
        List<Integer> ret = new ArrayList<>(primesFound);
        return ret ;
    }

    private boolean updatePrimesFound(Integer number) {
        boolean ret = primesFound.add(number);
        return ret;
    }
}