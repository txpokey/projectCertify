/**
 * 
 */
package edu.javial.cert.se.sx.exploreClasses;

/**
 * @author mak
 * can promote visibility but not demote visibility of any of these overridden methods relative to the visibilty of the parent class
 */
public class ShadowMethodChild_AllPublicMethodsVsParent extends ShadowMethodParent {

	public ShadowMethodChild_AllPublicMethodsVsParent() {
	}

    public void privateParentMethod() {
// can be public, protected, default and private
	}

    public void protectedMethodParent() {
		// can be public, protected 

	}

    public void defaultVisibleMethodParent() {
		// can be public, protected, default 

	}

	public void publicMethodParent() {
		// can be public 

	}

}
