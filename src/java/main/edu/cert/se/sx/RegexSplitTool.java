/**
 * 
 */
package javial.cert.sx;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mak
 * 
 */
public class RegexSplitTool {
	private static Log log = LogFactory.getLog(RegexSplitTool.class);
	private static String input0 = "Case0, Case1, Case2";
	private static String REGEX0 = "[,]\\s";
//	private static String input0 = "Case 0, Case 1, Case 2";
//	private static String REGEX0 = "[.,]+";

	boolean splitStringWithTrailingEdgeCase() {
		boolean ret = false;
		split: {
			try {
				String[] tokens = input0.split(REGEX0);
				List<String> collectedTokens = Arrays.asList(tokens); 
				// you must use generics above, else this for(:) Sx will not compile!
				for( String tok : collectedTokens ) {
					log.info( "regex culled this token:> " + tok );
					log.info( "now let's trim() that token:> " + tok.trim() );
					log.info( "now let's see if the tok and trimmed tok are '==':> " + (tok == tok.trim()));
				}
				ret = null != tokens ;
			} catch (Exception e) {
				log.fatal("spliter attempt threw ", e);
				break split ;
			}
			;
		} // split
		return ret;
	}
}
