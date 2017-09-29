/**
 * 
 */
package javial.cert.sx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mak
 * 
 */
public class ShadowExperiments {
	private static Log log = LogFactory.getLog(ShadowExperiments.class);

	private int counter = -1;
	private static int scounter = -1;

	boolean shadowFieldExercise(int counter) {
		boolean ret = false;
		shadow: {
			try {
				counter = 5;
				log.info("counter:> " + counter);
				int dummy ;
//				boolean mistakenOperatorTest = (( dummy = 55 )) ? true : false ; // Sx error -> boolean
//				boolean mistakenOperatorTest = false ; // // Sx error -> boolean
//				if (( dummy = 55 )) {
//					mistakenOperatorTest = true ;
//				}
				ret = true;
			} catch (Exception e) {
				log.fatal("something went wrong", e);
				break shadow ;
			}
		} // shadow
		return ret;
	}
	boolean shadowFieldExerciseStatic(int scounter) {
		boolean ret = false;
		shadow: {
			try {
				scounter = 5;
				log.info("scounter:> " + scounter);
				ret = true;
			} catch (Exception e) {
				log.fatal("something went wrong", e);
				break shadow ;
			}
		} // shadow
		return ret;
	}
	boolean shadowFieldExerciseStaticFieldPoke(int scounter) {
		boolean ret = false;
		shadow: {
			try {
				this.scounter = 5;
				log.info("scounter:> " + this.scounter);
				ret = true;
			} catch (Exception e) {
				log.fatal("something went wrong", e);
				break shadow ;
			}
		} // shadow
		return ret;
	}
	boolean shadowFieldExerciseFieldPoke(int counter) {
		boolean ret = false;
		shadow: {
			try {
				this.counter = 5;
				log.info("counter:> " + this.counter);
				ret = true;
			} catch (Exception e) {
				log.fatal("something went wrong", e);
				break shadow ;
			}
		} // shadow
		return ret;
	}

}
