/**
 * 
 */
package javial.cert.sx.pkg;

/**
 * @author mak
 *
 */
class DefaultVisibleType {
	
	public boolean promotedVisibility() {
		boolean ret = false ;
		ret = true ;
		return ret ;
	}
	public class PubMemberWithinDefaultAccessClass {
		public PubMemberWithinDefaultAccessClass() {
			
		}
	}
	static public class StaticPubMemberWithinDefaultAccessClass {
		public StaticPubMemberWithinDefaultAccessClass() {
			
		}
		
	}

}
