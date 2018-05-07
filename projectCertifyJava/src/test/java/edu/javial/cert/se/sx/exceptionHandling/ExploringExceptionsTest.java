package edu.javial.cert.se.sx.exceptionHandling;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

@Test
public class ExploringExceptionsTest {
    private static Log log = LogFactory.getLog(ExploringExceptionsTest.class);

    public void useStandardErr() {
        try {
            int[] arr = new int[3];
            for(int i = 0; i <= arr.length; i++) {
                arr[i] = i * 2;
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught");
            System.err.println("Exception caught via stderr");
            log.debug("Exception caught");
            log.error("Exception caught");
            log.fatal("Exception caught");
            log.warn("Exception caught");
        }
        System.out.println("Done");
    }
}
