/**
 * 
 */
package edu.javial.cert.se.sx.pkg;

import edu.javial.cert.se.sx.pkg.PackagePrivateType.PubMemberWithinDefaultAccessClass;
import edu.javial.cert.se.sx.pkg.PackagePrivateType.StaticPubMemberWithinDefaultAccessClass;
import edu.javial.cert.se.sx.pkg.SamePkgAsDefaultVisibleTypeButPublicAccessItself.DefaultPackagedInnerClassOfAPublicAccessClass;
import edu.javial.cert.se.sx.pkg.SamePkgAsDefaultVisibleTypeButPublicAccessItself.StaticDefaultPackagedInnerClassOfAPublicAccessClass;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author mak
 * 
 */
public class PackagePrivateTypeVisibilityTest {
	private static Log log = LogFactory.getLog(PackagePrivateTypeVisibilityTest.class);

	@Test
	public void pubmemberTest() {
		member: {
			try {
				PackagePrivateType dp = new PackagePrivateType();
				PubMemberWithinDefaultAccessClass pm = dp.new PubMemberWithinDefaultAccessClass();
				assert null != pm : "pub member constructure failed to fire";
				StaticPubMemberWithinDefaultAccessClass spm = new PackagePrivateType.StaticPubMemberWithinDefaultAccessClass();
				assert null != spm : "static pub member constructure failed to fire";
			} catch (Exception e) {
				log.fatal("something went wrong", e);
				break member;
			}
		} // member
	}
	@Test
	public void defaultmemberTest() {
		member: {
			try {
				SamePkgAsDefaultVisibleTypeButPublicAccessItself dp = new SamePkgAsDefaultVisibleTypeButPublicAccessItself();
				DefaultPackagedInnerClassOfAPublicAccessClass pm = dp.new DefaultPackagedInnerClassOfAPublicAccessClass();
				assert null != pm : "pub member constructure failed to fire";
				StaticDefaultPackagedInnerClassOfAPublicAccessClass spm = new SamePkgAsDefaultVisibleTypeButPublicAccessItself.StaticDefaultPackagedInnerClassOfAPublicAccessClass();
				assert null != spm : "static pub member constructure failed to fire";
			} catch (Exception e) {
				log.fatal("something went wrong", e);
				break member;
			}

		} // member
	}
// 
// 	@Test
// 	public void test() {
// 		fail("Not yet implemented");
// 	}
// 
}
