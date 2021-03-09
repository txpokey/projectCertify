package edu.javial.cert.se.oop.functional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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

        @Override public void method(List<Double> l) {
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
        final List<String> stringList = Arrays.asList("this", "is", "a", "list");
        final List<Double> doubleList = Arrays.asList(5.0, 4.0, 3.0, 2.0, 1.0);
        return new Object[][]{
                {stringList, doubleList}
        };
    }

    public void ternaryOperatorsUseCaseForLambda() {
        Integer config = 1;
        Integer example = 3;
        Predicate<Integer> testResult = 0 == config ? (i) -> {
            return 0 == i % 2;
        } :
                (i) -> {
                    return 0 == i % 3;
                };
        boolean result = testResult.test(3);
        assert result;
    }

    public void ternaryOperatorsUseCaseForLambdaUsingArrayInitializer() {
        Integer config = 1;
        Integer example = 3;
        Predicate<Integer>[] array = new Predicate[]{(i) -> {
            return 0 == (Integer) i % 2;
        }, (i) -> {
            return 0 == (Integer) i % 3;
        }};
        Predicate<Integer> testResult = 0 == config ? array[0] : array[1];
        boolean result = testResult.test(3);
        assert result;
    }

    private static Log log = LogFactory.getLog(ExploreFunctionInterfacingTest.class);

}
