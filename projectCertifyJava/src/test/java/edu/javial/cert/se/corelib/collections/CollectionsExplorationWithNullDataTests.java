/**
 * 
 */
package edu.javial.cert.se.corelib.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author mak
 *
 */
@Test
public class CollectionsExplorationWithNullDataTests {
	final static Log log = LogFactory.getLog(CollectionsExplorationWithNullDataTests.class);

	public void hashSetSubSetTest() {
		NavigableSetTester tool = new NavigableSetTester() ;
		boolean OK = tool.navsetTest() ;
		assert OK : "hash set testing subsets failed" ;
	}
	public void willNullBeAccepted() {
		willNullBeAcceptedAsHashMapKey() ;
		willNullBeAcceptedAsHashSetMember() ;
		willNullBeAcceptedAsArrayListElement() ;
		willNullBeAcceptedAsTreeMapKey() ;
		willNullBeAcceptedAsTreeSetMember() ;
	}
	private boolean willNullBeAcceptedAsTreeMapKey() {
		TreeMap<String,Integer> map = new TreeMap<>() ;
		Object candidate = null;
		try {
			candidate = map.put(null,null);
		} catch (Exception e) {
			log.debug("null value is not any good to this type:> " + e);
		}
		return null == candidate ? false : map.equals(candidate) ;
	}

	private boolean willNullBeAcceptedAsTreeSetMember() {
		TreeSet<String> map = new TreeSet<>() ;
		Object candidate = null;
		try {
			candidate = map.add(null);
		} catch (Exception e) {
			log.debug("null value is not any good to this type:> " + e);
		}
		return null == candidate ? false : map.equals(candidate) ;
	}

	private boolean willNullBeAcceptedAsArrayListElement() {
		List<String> map = new ArrayList<>() ;
		Object candidate = map.add(null) ;
		return map.equals(candidate);
	}

	private boolean willNullBeAcceptedAsHashSetMember() {
		HashSet<String> map = new HashSet<>() ;
		Object candidate = map.add(null) ;
		return map.equals(candidate);
	}

	private boolean willNullBeAcceptedAsHashMapKey() {
		HashMap<String,Integer> map = new HashMap<>() ;
		Object candidate = map.put(null, null) ;
		return map.equals(candidate);
	}

}
