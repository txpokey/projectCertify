/**
 * 
 */
package edu.javial.cert.se.sx.pkg;

/**
 * @author mak
 *
 */
class PackagePrivateType {
	
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
	static private class StaticPrivateClass {
	    public StaticPrivateClass() {}
    }
    static class StaticPackagePrivateClass {
        public StaticPackagePrivateClass() {}
    }
    static protected class StaticProtectedClass {
        public StaticProtectedClass() {}
    }

    protected class ProtectedClass {
        public ProtectedClass() {}
    }
	private class PrivateClass {
	    public PrivateClass() {}
    }
     class PackagePrivateClass {
        public PackagePrivateClass() {}
    }

}
