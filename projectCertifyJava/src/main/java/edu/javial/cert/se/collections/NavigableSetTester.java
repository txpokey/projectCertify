/**
 * 
 */
package edu.javial.cert.se.collections;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import edu.javial.cert.se.math.PrimeNumber;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mak
 * 
 */
public class NavigableSetTester {
	private static Log log = LogFactory.getLog(NavigableSetTester.class);
	private NavigableSet<Integer> ns = null;
	{
		try {
			for (int i = 2; i < 100; i++) {
				PrimeNumber.isPrime(i);
			}
//			Collection<Integer> primes = PrimeNumber.getPrimes();
//			NavigableSet<Integer> set = new TreeSet<Integer>(primes);
//			ns = set;
			log.info( ns ) ;
		} catch (Exception e) {
			log.fatal("unable to set up tester because of a problem", e);
		}
	}

	public boolean navsetTest() {
		boolean ret = false;
		navset: {
			try {
				SortedSet<Integer> head = ns.headSet(new Integer(50));
				for (Integer i : head) {
					log.info(i);
				} // for
				ret = true ;
			} catch (Exception e) {
				log.fatal("exception during test", e);
				break navset;
			}
		} // navset
		return ret;
	}
}
