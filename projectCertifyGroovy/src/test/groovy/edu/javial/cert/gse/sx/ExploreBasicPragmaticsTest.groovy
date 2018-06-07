package edu.javial.cert.gse.sx

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.testng.annotations.Test

import java.util.logging.Level

@Test
class ExploreBasicPragmaticsTest  extends GroovyTestCase {
    final static Log log = LogFactory.getLog(ExploreBasicPragmaticsTest.class);

    void testMe() {
        log.log( Level.INFO , "test me")
        log.log( Level.INFO , "where is the line number?" )
//        log.debug("where is the line number?")

    }

    void biteMe() {
        log.log( Level.INFO , "bite me")
    }
    @Test(threadPoolSize=3, invocationCount=5)
    public void threadNgExplore() throws InterruptedException
    {
        log.debug("Thread ID: "+Thread.currentThread().getId());
    }
}
