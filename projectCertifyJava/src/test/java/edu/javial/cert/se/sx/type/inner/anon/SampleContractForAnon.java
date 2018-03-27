package edu.javial.cert.se.sx.type.inner.anon;

public interface SampleContractForAnon {

    void doit() ;

    SampleContractInnerForAnon getContractInnerForAnon() ;

    @FunctionalInterface
    interface SampleContractInnerForAnon {
        void innerDoit() ;
    }
}
