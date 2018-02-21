package edu.javial.cert.se.sx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

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
                //
                Assert.assertTrue("y test:> ", 2 == y[0][1]);
                Assert.assertTrue("z test:> ", 2 == z[0][1]);
                Assert.assertTrue("q test:> ", 0 == q[0][1]);
                Assert.assertTrue("pmi test:> ", 0 == pmi[0][1]);
                Assert.assertTrue("pmI test:> ", null == pmI[0][1]);
                Assert.assertTrue("lI0 test:> ", null == lI0[0][1]);
                Assert.assertTrue("lI0 test:> ", 2 == lI1[0][1]);

                try {
                    log.debug("lI2 test: " + lI2[0][1]) ; // NPE raised here
                    Assert.fail("lI0 test:>  lI2[0][1] should raise NPE");
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