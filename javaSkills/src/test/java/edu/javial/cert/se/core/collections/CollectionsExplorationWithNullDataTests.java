
package edu.javial.cert.se.core.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author mak
 *
 */
@Test
public class CollectionsExplorationWithNullDataTests {
	final static Log log = LogFactory.getLog(CollectionsExplorationWithNullDataTests.class);

	public void hashSetSubSetTest() { // TODO : revisit NavigableSetTester
		NavigableSetTester tool = new NavigableSetTester() ;
		boolean OK = tool.navsetTest() ;
		assert OK : "hash set testing subsets failed" ;
	}
	public void canNullBeAccepted() {
		HashMap<String,Boolean> results = new HashMap<>();
		results.put("canNullBeAcceptedAsHashMapKey" , canNullBeAcceptedAsHashMapKey() ) ;
		results.put("canNullBeAcceptedAsHashSetMember" , canNullBeAcceptedAsHashSetMember() ) ;
		results.put("canNullBeAcceptedAsArrayListElement" , canNullBeAcceptedAsArrayListElement() ) ;
		results.put("canNullBeAcceptedAsTreeMapKey" , canNullBeAcceptedAsTreeMapKey() ) ;
		results.put("canNullBeAcceptedAsTreeSetMember" , canNullBeAcceptedAsTreeSetMember() ) ;
		log.debug(results.entrySet());
	}
//2018-05-16|20:43:02 CollectionsExplorationWithNullDataTests.canNullBeAccepted.32 [DEBUG] [canNullBeAcceptedAsHashSetMember=true, canNullBeAcceptedAsHashMapKey=true, canNullBeAcceptedAsTreeSetMember=false, canNullBeAcceptedAsArrayListElement=true, canNullBeAcceptedAsTreeMapKey=false]
	private boolean canNullBeAcceptedAsTreeMapKey() {
		TreeMap<String,Integer> map = new TreeMap<>() ;
		Object candidate = null;
		boolean ret = false ;
		try {
			candidate = map.put(null,null);
			ret = null == candidate;
		} catch (Exception e) {
			log.debug("null value is not any good to this type:> " + e);
		}
		return ret ;
	}

	private boolean canNullBeAcceptedAsTreeSetMember() {
		TreeSet<String> map = new TreeSet<>() ;
		Object candidate = null;
		boolean ret = false ;
		try {
			candidate = map.add(null);
			ret = null == candidate;
		} catch (Exception e) {
			log.debug("null value is not any good to this type:> " + e);
		}
		return ret ;
	}

	private boolean canNullBeAcceptedAsArrayListElement() {
		List<String> list = new ArrayList<>() ;
		Boolean candidate = list.add(null) ;
		return candidate;
	}

	private boolean canNullBeAcceptedAsHashSetMember() {
		HashSet<String> map = new HashSet<>() ;
		Boolean candidate = map.add(null) ;
		return candidate;
	}

	private boolean canNullBeAcceptedAsHashMapKey() {
		HashMap<String,LocalDateTime> map = new HashMap<>() ;
		LocalDateTime now = LocalDateTime.now();
		Object candidate = map.put(null, null) ;
		boolean isNull = candidate == null ;
		boolean isTime = now.equals(candidate = map.put(null, now));
		isTime = now.equals(candidate = map.put(null, now));
		return isNull && isTime ;
	}

}
