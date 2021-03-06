/**
 * NavigableSetTester
 */
package edu.javial.cert.se.core.collections;

import edu.javial.cert.se.core.math.PrimeNumber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @author mak
 *  TODO get NavigableSetTester to work with new version of PrimeNumber
 */
public class NavigableSetTester {
	private static Log log = LogFactory.getLog(NavigableSetTester.class);
	private NavigableSet<Integer> ns = null;
    public NavigableSetTester()
	{
		factory : {
			try {
				PrimeNumber factory = new PrimeNumber() ;
				IntStream.rangeClosed(1, 1000).parallel().forEach(i -> factory.isPrime(i));
				Collection<Integer> primes = factory.getPrimes();
				ns = new TreeSet<>(primes);
				log.info( ns ) ;
			} catch (Exception e) {
				log.fatal("unable to set up tester because of a problem", e);
				break factory;
			}
		}
	}
	private NavigableSet getSet() {
		return ns ;
	}

	public boolean navsetTest() { /*DEBUG*/
		boolean ret = false;
		NavigableSetTester tester = new NavigableSetTester() ;
		headset: {
			try {
				SortedSet<Integer> head = tester.getSet().headSet(new Integer(50));
				for (Integer i : head) {
					log.info(i);
				} // for
				ret = true ;
			} catch (Exception e) {
				log.fatal("exception during test", e);
				break headset;
			}
		} // headset
		return ret;
	}
	@Test
	public void hashSetSubSetTest() {
		NavigableSetTester tool = new NavigableSetTester() ;
		boolean OK = tool.navsetTest() ;
		assert OK : "hash set testing subsets failed" ;
	}
}
