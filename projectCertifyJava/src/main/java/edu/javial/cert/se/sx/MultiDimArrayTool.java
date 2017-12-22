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
class MultiDimArrayTool {
	private static Log log = LogFactory.getLog(MultiDimArrayTool.class);
	private int pmi[][] = new int[2][2];
	private Integer pmI[][] = new Integer[2][2];

	boolean verifyMutilDimArrayCalcs() {
		boolean ret = false;
		checksx: {
			try {
				int x[][] = { { 1, 2 }, { 3, 4 } };
				int[] y[] = x;
				int[][] z = x;
				int q[][] = new int[2][2];
				Integer lI0[][] = new Integer[2][2];
				Integer lI1[][] = { { 1, 2 }, { 3, 4 } } ; // autobox works here
				Integer lI2[][] =  null ; // x ; // autobox never gets a chance here

				log.info("y test: " + y[0][1]) ;
				log.info("z test: " + z[0][1]) ;
				log.info("q test: " + q[0][1]) ;
				log.info("pmi test: " + pmi[0][1]) ;
				log.info("pmI test: " + pmI[0][1]) ;
				log.info("lI0 test: " + lI0[0][1]) ;
				log.info("lI1 test: " + lI1[0][1]) ;
				try {
					log.info("lI2 test: " + lI2[0][1]) ; // NPE raised here
				} catch (NullPointerException e) {
					log.info("got the expected exception on the lI1 test");
				}
				ret = true ;
			} catch (Exception e) {
				ret = false;
				log.fatal("failed to handle multidim array ", e);
				break checksx ;
			}
		} // checksx
		return ret;
	}
}
