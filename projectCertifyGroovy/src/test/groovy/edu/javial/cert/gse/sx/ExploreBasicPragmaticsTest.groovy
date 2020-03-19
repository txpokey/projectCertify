package edu.javial.cert.gse.sx

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.testng.annotations.Test

@Test

class ExploreBasicPragmaticsTest {
    final static Log log = LogFactory.getLog(ExploreBasicPragmaticsTest.class);
    @Test(threadPoolSize=3, invocationCount=5)
    void threadNgExplore() throws InterruptedException
    {
        log.debug("Thread ID: "+Thread.currentThread().getId());
    }
}
