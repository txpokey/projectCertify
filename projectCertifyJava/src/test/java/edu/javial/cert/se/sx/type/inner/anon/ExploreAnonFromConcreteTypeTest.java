package edu.javial.cert.se.sx.type.inner.anon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

public class ExploreAnonFromConcreteTypeTest { // TODO need other class for testing inner class Sx
    private static Log log = LogFactory.getLog(ExploreAnonFromConcreteTypeTest.class);

    @Test
    public void aConcreteTypeTest() {
        SampleConcreteForAnon sample = new SampleConcreteForAnon() {
            void redoit() {
                log.debug("can not compile a direct reference to this method") ;
            }
            @Override
            void doit() {
                super.doit();
                redoit();
            }
        } ;
        sample.doit();

        SampleConcreteForAnon.SampleConcreteInnerForAnon sampleInner = sample.getConcreteInnerForAnon() ;
        sampleInner.innerDoit();
    }
    @Test
    public void anInterfaceTypeTest(){
        SampleContractForAnon sampleAnon = new SampleContractForAnon() {
            void redoit() {
                log.debug("can not compile a direct reference to this method") ;
            }
            public void doit() { // COMPILE : must be public because using interface
                redoit();
                redoit2();
            }

            @Override
            public SampleContractInnerForAnon getContractInnerForAnon() {
                return () -> {
                    log.debug("dummy method") ;
                    assert true ;
                };
            }

            void redoit2() {
                log.debug("can not compile a direct reference to this method") ;
            }
        } ;
        sampleAnon.doit();
        SampleContractForAnon.SampleContractInnerForAnon sampleInner = sampleAnon.getContractInnerForAnon() ;
        sampleInner.innerDoit();
    }
}
