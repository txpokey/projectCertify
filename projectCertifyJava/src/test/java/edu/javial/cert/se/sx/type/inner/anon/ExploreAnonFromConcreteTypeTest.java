package edu.javial.cert.se.sx.type.inner.anon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;

public class ExploreAnonFromConcreteTypeTest {
    private static Log log = LogFactory.getLog(ExploreAnonFromConcreteTypeTest.class);

    private void inspectByClass(@Nonnull Object sample , @Nonnull String tag) {
        Class sampleType = sample.getClass();
        Class sampleTypeSuper = sampleType.getSuperclass();
        log.debug(tag +"> " + sampleType );
        log.debug(tag + "Super> " + sampleTypeSuper );
    }

    @Test
    /**
     * method uses contractor style to create anon inner class 'sample'.
     * then proves that the overridden method can see any method of the anon class
     */
    public void aConcreteTypeTest() {
        SampleConcreteForAnon sample = new SampleConcreteForAnon() {
            void redoit() {
                log.debug("can not compile a direct reference to this method from outside the anon") ;
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
        inspectByClass( sample , "SampleConcreteForAnon") ;

    }
    @Test
    /**
     * method uses interface 'SampleContractForAnon' to create anon inner class 'sampleAnon'.
     * then proves that the overridden method can see any method of the anon class.
     * it also repeats this approach via a lambda, since only one method declared on 'SampleContractInnerForAnon'
     */
    public void anInterfaceTypeTestUsingLambda(){
        SampleContractForAnon sampleAnon = new SampleContractForAnon() {
            void redoit() {
                log.debug("can not compile a direct reference to this method from outside the anon") ;
            }
            public void doit() { // COMPILE : must be public because using interface
                redoit();
                redoit2();
            }

            @Override
            public SampleContractInnerForAnon getContractInnerForAnon() {
                return () -> {
                    redoit();
                    log.debug("innerDoit method declared as lambda") ;
//                    SampleContractInnerForAnon.innerDoitDefault() ;  // COMPILE: cant do in static context
                    assert true ;
                };
            }

            void redoit2() {
                log.debug("can not compile a direct reference to this method from outside the anon") ;
            }
        } ;
        sampleAnon.doit();
        SampleContractForAnon.SampleContractInnerForAnon sampleInner = sampleAnon.getContractInnerForAnon() ;
        sampleInner.innerDoit();

        inspectByClass( sampleAnon , "SampleContractForAnon") ;
        inspectByClass( sampleInner , "SampleContractInnerForAnonViaLambda") ;

        assert sampleAnon instanceof SampleContractForAnon;
        assert sampleInner instanceof SampleContractForAnon.SampleContractInnerForAnon;
    }
    @Test
    public void anInterfaceTypeTestNotUsingLambda(){
        SampleContractForAnon sampleAnon = new SampleContractForAnon() {
            void redoit() {
                log.debug("can not compile a direct reference to this method from outside the anon") ;
            }
            public void doit() { // COMPILE : must be public because using interface
                redoit();
                redoit2();
            }

            @Override
            public SampleContractInnerForAnon getContractInnerForAnon() {
                SampleContractInnerForAnon candidate = new SampleContractInnerForAnon() {

                    @Override
                    public void innerDoit() {
                        log.debug("innerDoit implementation") ;
                    }
                };
                return candidate;
            }

            void redoit2() {
                log.debug("can not compile a direct reference to this method from outside the anon") ;
            }
        } ;
        sampleAnon.doit();
        SampleContractForAnon.SampleContractInnerForAnon sampleInner = sampleAnon.getContractInnerForAnon() ;
        sampleInner.innerDoit();
        inspectByClass( sampleAnon , "SampleContractForAnon") ;
        inspectByClass( sampleInner , "SampleContractInnerForAnonNoLambda") ;
        assert sampleAnon instanceof SampleContractForAnon;
        assert sampleInner instanceof SampleContractForAnon.SampleContractInnerForAnon;
    }

    @Test
    void method() {
        class MethodLocalClass { }
        MethodLocalClass mlc = new MethodLocalClass();
        if ( 1 == 1 ) {
            class IfLocalClass { }
            IfLocalClass ilc = new IfLocalClass();
        }
    }
}
