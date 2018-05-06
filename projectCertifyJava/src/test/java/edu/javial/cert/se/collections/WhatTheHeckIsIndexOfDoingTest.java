package edu.javial.cert.se.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

@Test
public class WhatTheHeckIsIndexOfDoingTest {
    private static Log log = LogFactory.getLog(WhatTheHeckIsIndexOfDoingTest.class);

    public void whatTheHeckIsIndexOfDoing() {
        class PayLoad implements Callable<String> {

            private int kept ;

            PayLoad(int kept) {
                this.kept = kept;
            }

            int getKept() {
                return kept ;
            }

            @Override
            public String call() throws Exception {
                final String ret = "Callable " + getKept() ;
                return ret ;
            }

            public boolean equals(Object c) {
                boolean ret = false ;
                if( null != c && c instanceof PayLoad) {
                    boolean candidate = this.getKept() == ((PayLoad) c).getKept();
                    ret = candidate ;
                }
                return ret ;
            }
        }
        final List<PayLoad> callables = new ArrayList<>();
        IntStream.rangeClosed(1, 10).forEach(
                i -> callables.add(new PayLoad(i))
        );
//
        Collections.shuffle(callables);
        List<String> startingPoint = new ArrayList<>();
        callables.stream().forEach( c -> startingPoint.add( callables.indexOf(c) + "") );
        List<String> startingPoint2 = new ArrayList<>();
        callables.stream().forEach( c -> startingPoint2.add( c.getKept() + "" ) );

        log.debug(startingPoint);
        log.debug(startingPoint2);
    }
}
