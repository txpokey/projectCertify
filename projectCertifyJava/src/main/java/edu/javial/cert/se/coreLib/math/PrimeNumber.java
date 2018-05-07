/**
 *
 */
package edu.javial.cert.se.coreLib.math;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mak This class writes out Prime numbers. A number is prime if it is
 *         divisible by 1 and the number itself and no other number.
 *         http://www.cs
 *         .utexas.edu/users/mitra/uxFall2004/cs303/assgn/prime.html
 */
public class PrimeNumber {
    private static Log log = LogFactory.getLog(PrimeNumber.class);
    private static Integer max = -1;
    private static ConcurrentHashMap<Integer, Integer> primesFound = new ConcurrentHashMap<Integer, Integer>();

    static {
        primesFound.put(max, max);
    }

    /**
     * This method tests whether a given number is prime or not. (thread-safe)
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
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

    public static boolean isUndiscovered(Integer number) {
        boolean ret = false;
        boolean discovered = isDiscovered(number);
        return ret = !discovered;
    }

    public static boolean isDiscovered(Integer number) {
        boolean ret = false;
        boolean lookup = number < primesFound.get(max) ;
        boolean discovered = lookup ? primesFound.contains(number) : false ;
        return ret = discovered;
    }

    private static int upperLimit(int number) {
        int limit = -1 ;
        return  limit = (int) Math.sqrt(number);
    }

    public static Collection<Integer> getPrimes() {
        return primesFound.values();
    }

    private static boolean updatePrimesFound(Integer number) {
        boolean ret = false;
        update:
        {
            try {
                // remember this is a concurrent hashMap
                primesFound.put(number, number);
                if (primesFound.get(max) < number) {
                    primesFound.put(max, number);
                }
                ret = true;
            } catch (Exception e) {
                log.fatal(
                        "something went wrong in attempting update on prime number cache",
                        e);
                break update;
            }
        }
        return ret;
    }
}