package edu.javial.cert.se.sx.type.inner.anon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SampleConcreteForAnon {
    private static Log log = LogFactory.getLog(SampleConcreteForAnon.class);

    void doit() {
        log.debug("dummy method") ;
        assert true ;
    }
    class SampleConcreteInnerForAnon {
        void innerDoit() {
            log.debug("dummy method") ;
            assert true ;
        }
    }
     SampleConcreteInnerForAnon getConcreteInnerForAnon() {
        return new SampleConcreteInnerForAnon() ;
    }
}
