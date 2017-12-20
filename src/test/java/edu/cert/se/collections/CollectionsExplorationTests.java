/**
 * 
 */
package javial.cert.collections;

import org.junit.Test;

/**
 * @author mak
 *
 */
public class CollectionsExplorationTests {

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
