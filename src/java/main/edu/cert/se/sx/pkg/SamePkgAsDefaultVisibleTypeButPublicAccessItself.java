/**
 * 
 */
package javial.cert.sx.pkg;

/**
 * @author mak
 * 
 */
public class SamePkgAsDefaultVisibleTypeButPublicAccessItself {
	private DefaultVisibleType sneeky = new DefaultVisibleType();

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
