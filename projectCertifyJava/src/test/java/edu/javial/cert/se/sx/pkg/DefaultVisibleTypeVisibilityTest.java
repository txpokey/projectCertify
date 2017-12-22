/**
 * 
 */
package javial.cert.sx.pkg;

import javial.cert.sx.pkg.DefaultVisibleType.PubMemberWithinDefaultAccessClass;
import javial.cert.sx.pkg.DefaultVisibleType.StaticPubMemberWithinDefaultAccessClass;
import javial.cert.sx.pkg.SamePkgAsDefaultVisibleTypeButPublicAccessItself.DefaultPackagedInnerClassOfAPublicAccessClass;
import javial.cert.sx.pkg.SamePkgAsDefaultVisibleTypeButPublicAccessItself.StaticDefaultPackagedInnerClassOfAPublicAccessClass;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author mak
 * 
 */
public class DefaultVisibleTypeVisibilityTest {
	private static Log log = LogFactory.getLog(DefaultVisibleTypeVisibilityTest.class);

	@Test
	public void pubmemberTest() {
		member: {
			try {
				DefaultVisibleType dp = new DefaultVisibleType();
				PubMemberWithinDefaultAccessClass pm = dp.new PubMemberWithinDefaultAccessClass();
				assert null != pm : "pub member constructure failed to fire";
				StaticPubMemberWithinDefaultAccessClass spm = new DefaultVisibleType.StaticPubMemberWithinDefaultAccessClass();
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
