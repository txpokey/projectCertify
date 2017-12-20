/**
 * 
 */
package javial.cert.sx.pkg;

/**
 * @author mak
 * can promote visibility but not demote visibility of any of these overridden methods relative to the visibilty of the parent class
 */
public class ShadowMethodChild extends ShadowMethodParent {

	public ShadowMethodChild() {
	}

	private void privateParentMethod() { 
// can be public, protected, default and private
	}

	protected void protectedMethodParent() {
		// can be public, protected 

	}

	void defaultVisibleMethodParent() {
		// can be public, protected, default 

	}

	public void publicMethodParent() {
		// can be public 

	}

}
