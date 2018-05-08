
package edu.javial.cert.se.corelib.collections;

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

	public void hashSetSubSetTest() {
		NavigableSetTester tool = new NavigableSetTester() ;
		boolean OK = tool.navsetTest() ;
		assert OK : "hash set testing subsets failed" ;
	}
	public void wasNullBeAccepted() {
		HashMap<String,Boolean> results = new HashMap<>();
		results.put("wasNullBeAcceptedAsHashMapKey" , wasNullBeAcceptedAsHashMapKey() ) ;
		results.put("wasNullBeAcceptedAsHashSetMember" , wasNullBeAcceptedAsHashSetMember() ) ;
		results.put("wasNullBeAcceptedAsArrayListElement" , wasNullBeAcceptedAsArrayListElement() ) ;
		results.put("wasNullBeAcceptedAsTreeMapKey" , wasNullBeAcceptedAsTreeMapKey() ) ;
		results.put("wasNullBeAcceptedAsTreeSetMember" , wasNullBeAcceptedAsTreeSetMember() ) ;
		log.debug(results);
	}
//2018-05-07|20:21:55 CollectionsExplorationWithNullDataTests.wasNullBeAcceptedAsTreeMapKey.41 [DEBUG] null value is not any good to this type:> java.lang.NullPointerException
//2018-05-07|20:21:55 CollectionsExplorationWithNullDataTests.wasNullBeAcceptedAsTreeSetMember.54 [DEBUG] null value is not any good to this type:> java.lang.NullPointerException
//2018-05-07|20:21:55 CollectionsExplorationWithNullDataTests.wasNullBeAccepted.31 [DEBUG] {wasNullBeAcceptedAsTreeSetMember=false, wasNullBeAcceptedAsArrayListElement=true, wasNullBeAcceptedAsHashMapKey=true, wasNullBeAcceptedAsHashSetMember=true, wasNullBeAcceptedAsTreeMapKey=false}

	private boolean wasNullBeAcceptedAsTreeMapKey() {
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

	private boolean wasNullBeAcceptedAsTreeSetMember() {
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

	private boolean wasNullBeAcceptedAsArrayListElement() {
		List<String> list = new ArrayList<>() ;
		Boolean candidate = list.add(null) ;
		return candidate;
	}

	private boolean wasNullBeAcceptedAsHashSetMember() {
		HashSet<String> map = new HashSet<>() ;
		Boolean candidate = map.add(null) ;
		return candidate;
	}

	private boolean wasNullBeAcceptedAsHashMapKey() {
		HashMap<String,LocalDateTime> map = new HashMap<>() ;
		LocalDateTime now = LocalDateTime.now();
		Object candidate = map.put(null, null) ;
		boolean isNull = candidate == null ;
		boolean isTime = now.equals(candidate = map.put(null, now));
		isTime = now.equals(candidate = map.put(null, now));
		return isNull && isTime ;
	}

}
