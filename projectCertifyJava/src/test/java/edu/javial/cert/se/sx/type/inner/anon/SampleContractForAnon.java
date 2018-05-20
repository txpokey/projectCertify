package edu.javial.cert.se.sx.type.inner.anon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface SampleContractForAnon {

    void doit() ;

    SampleContractInnerForAnon getContractInnerForAnon() ;

    @FunctionalInterface
    interface SampleContractInnerForAnon {
        void innerDoit() ;
        default void innerDoitDefault() {
            log.debug("running inside default method of functional interface");
        }
    }
    static Log log = LogFactory.getLog(SampleContractForAnon.class);

}
