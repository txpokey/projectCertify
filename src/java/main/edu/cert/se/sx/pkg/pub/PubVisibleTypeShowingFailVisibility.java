/**
 * 
 */
package javial.cert.sx.pkg.pub;

import javial.cert.sx.pkg.SamePkgAsDefaultVisibleTypeButPublicAccessItself;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
// SX error because of visibility
//import javial.cert.sx.pkg.SamePkgAsDefaultPkgClassButPublicAccess.StaticDefaultPackagedInnerClassOfAPublicAccessClass;
//import javial.cert.sx.pkg.DefaultPackagedInnerClassOfAPublicAccessClass;

/**
 * @author mak
 * @TODO clean up - class has stubbed code all over the place
 */
public class PubVisibleTypeShowingFailVisibility {
	private static Log log = LogFactory.getLog(PubVisibleTypeShowingFailVisibility.class);

//	private DefaultPkg sneeky = new DefaultPkg() ;  // get a not visible SX error
	public void defaultmemberTest() {
		member: {
			try {
				SamePkgAsDefaultVisibleTypeButPublicAccessItself dp = new SamePkgAsDefaultVisibleTypeButPublicAccessItself();
//				DefaultPackagedInnerClassOfAPublicAccessClass pm = dp.new DefaultPackagedInnerClassOfAPublicAccessClass();
//				assert null != pm : "pub member constructure failed to fire";
//				StaticDefaultPackagedInnerClassOfAPublicAccessClass spm = new SamePkgAsDefaultPkgClassButPublicAccess.StaticDefaultPackagedInnerClassOfAPublicAccessClass();
//				assert null != spm : "static pub member constructure failed to fire";
			} catch (Exception e) {
				log.fatal("something went wrong", e);
				break member;
			}

		} // member
	}

}
