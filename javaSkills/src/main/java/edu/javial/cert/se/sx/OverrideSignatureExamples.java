/**
 * 
 */
package edu.javial.cert.se.sx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mak
 * 
 */
public class OverrideSignatureExamples {
	private static Log log = LogFactory.getLog(OverrideSignatureExamples.class);

	boolean computeSilly(Integer in) {
		boolean ret = false;
		silly: {
			try {
				Integer answer = 1 + 2;
				log.info("answer seed:> " + answer);
				log.info("in:> " + in);
				answer += in;
				log.info("answer:> " + answer);
				ret = true;
			} catch (Exception e) {
				log.fatal("something wrong", e);
				break silly;
			}
		}
		return ret;
	}
//	Integer computeSilly(Integer in) {  // SX error over duplicate name
//		Integer ret ;
//		silly: {
//			try {
//				Integer answer = 1 + 2;
//				log.info("answer seed:> " + answer);
//				log.info("in:> " + in);
//				answer += in;
//				log.info("answer:> " + answer);
//				ret = answer ;
//			} catch (Exception e) {
//				log.fatal("something wrong", e);
//				break silly;
//			}
//		}
//		return ret;
//	}

}
