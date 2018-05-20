package edu.javial.cert.se.oop.functional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
public class ExploreFunctionInterfacingTest {
    @FunctionalInterface
    interface A {
        void method(List<Double> l);
    }
    @FunctionalInterface
    interface B extends A {
        void method(List l);
    }
    @Test(dataProvider = "getPayload")
    public void exploreFunctionalAsAnonymous(List<String> stringList, List<Double> doubleList) {
        A a = new A() {

            @Override
            public void method(List<Double> l) {
                log.debug("list size:> " + l.size());
            }
        };
        B b = new B() {

            @Override
            public void method(List l) {
                log.debug("list size:> " + l.size());
            }
        };
        /** COMPILE: erasure issue
         B caca = new B() {

            @Override
            public void method(List<Double> l) {
                log.debug("list size:> " + l.size());
            }
        } ;
         */
        report(a, b, stringList, doubleList);
    }

    private void report(A a, B b, List<String> stringList, List<Double> doubleList) {
        log.debug(stringList);
        b.method(stringList);
        log.debug(doubleList);
        a.method(doubleList);
        log.debug(doubleList);
        b.method(doubleList);
        log.debug("BOOYA!");
    }
    @Test(dataProvider = "getPayload")
    public void exploreFunctionalAsLambda(List<String> stringList, List<Double> doubleList) {
        A a = l -> log.debug("list size:> " + l.size());
        B b = l -> log.debug("list size:> " + l.size());
        report(a, b, stringList, doubleList);
    }
    @DataProvider
    private final Object[][] getPayload() {
        final List<String> stringList = Arrays.asList("this", "is", "a" , "list");
        final List<Double> doubleList = Arrays.asList(5.0,4.0,3.0,2.0,1.0);
        return new Object[][]{
                {stringList, doubleList}
        };
    }
    private static Log log = LogFactory.getLog(ExploreFunctionInterfacingTest.class);

}
