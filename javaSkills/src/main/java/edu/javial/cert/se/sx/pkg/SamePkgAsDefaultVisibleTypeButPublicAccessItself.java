/**
 * 
 */
package edu.javial.cert.se.sx.pkg;

/**
 * @author mak
 * 
 */
public class SamePkgAsDefaultVisibleTypeButPublicAccessItself {
	private PackagePrivateType sneeky = new PackagePrivateType();

	public SamePkgAsDefaultVisibleTypeButPublicAccessItself() {

	}

	boolean defaultPkgOperation() {
		return true;
	}

	class DefaultPackagedInnerClassOfAPublicAccessClass {

	}

	static class StaticDefaultPackagedInnerClassOfAPublicAccessClass {

	}
}
