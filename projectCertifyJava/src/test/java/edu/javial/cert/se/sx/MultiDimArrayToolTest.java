package edu.javial.cert.se.sx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mak on 2/20/18.
 */
class MultiDimArrayToolTest { // TODO DEBUG
    private static Log log = LogFactory.getLog(MultiDimArrayToolTest.class);
    private int pmi[][] = new int[2][2];
    private Integer pmI[][] = new Integer[2][2];
    @Test
    void verifyMutilDimArrayCalcs() {
        boolean ret = false ;
        checksx: {
            try {
                int x[][] = { { 1, 2 }, { 3, 4 } };
                int[] y[] = x;
                int[][] z = x;
                int q[][] = new int[2][2];
                Integer lI0[][] = new Integer[2][2];
                Integer lI1[][] = { { 1, 2 }, { 3, 4 } } ; // autobox works here
                Integer lI2[][] =  null ; // x ; // autobox never gets a chance here

                log.debug("y test: " + y[0][1]) ;
                log.debug("z test: " + z[0][1]) ;
                log.debug("q test: " + q[0][1]) ;
                log.debug("pmi test: " + pmi[0][1]) ;
                log.debug("pmI test: " + pmI[0][1]) ;
                log.debug("lI0 test: " + lI0[0][1]) ;
                log.debug("lI1 test: " + lI1[0][1]) ;
                try {
                    log.debug("lI2 test: " + lI2[0][1]) ; // NPE raised here
                } catch (NullPointerException e) {
                    log.debug("got the expected exception on the lI1 test");
                }
                ret = true ;
            } catch (Exception e) {
                log.fatal("failed to handle multidim array ", e);
                break checksx ;
            }
        } // checksx
        assert ret ;
    }
}