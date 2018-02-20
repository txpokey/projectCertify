/**
 * 
 */
package edu.javial.cert.se.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author mak
 *
 */
public class CollectionsExplorationTests { // TODO think CollectionsExplorationTests is not useful?
	final static Log logger = LogFactory.getLog(CollectionsExplorationTests.class);

	@Test
	public void hashSetSubSetTest() {
		NavigableSetTester tool = new NavigableSetTester() ;
		boolean OK = tool.navsetTest() ;
		assert OK : "hash set testing subsets failed" ;
	}
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
