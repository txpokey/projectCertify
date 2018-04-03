package edu.javial.cert.se.sx.type.inner.anon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SampleConcreteForAnon {
    private static Log log = LogFactory.getLog(SampleConcreteForAnon.class);

    void doit() {
        log.debug("dummy doIt method from SampleConcreteForAnon") ;
        assert true ;
    }
    class SampleConcreteInnerForAnon {
        void innerDoit() {
            log.debug("dummy method on SampleConcreteForAnon inner class") ;
            assert true ;
        }
    }
     SampleConcreteInnerForAnon getConcreteInnerForAnon() {
        return new SampleConcreteInnerForAnon() ;
    }
}
