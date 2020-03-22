/**
 * 
 */
package edu.javial.cert.se.sx.exploreClasses;

/**
 * @author mak
 * can promote visibility but not demote visibility of any of these overridden methods relative to the visibilty of the parent class
 */
public class ShadowMethodChild_AllProtectedMethodsVsParent extends ShadowMethodParent {

    protected ShadowMethodChild_AllProtectedMethodsVsParent() {
	}

    protected void privateParentMethod() {
// can be public, protected, default and private
	}

	protected void protectedMethodParent() {
		// can be public, protected 

	}

    protected void defaultVisibleMethodParent() {
		// can be public, protected, default 

	}

    public void publicMethodParent() {
		// can be public NOT protected, private, or default

	}

}
