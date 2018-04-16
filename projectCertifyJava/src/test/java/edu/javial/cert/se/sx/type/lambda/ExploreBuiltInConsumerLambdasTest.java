package edu.javial.cert.se.sx.type.lambda;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Test
public class ExploreBuiltInConsumerLambdasTest {
    private static Log log = LogFactory.getLog(ExploreBuiltInConsumerLambdasTest.class);

    public void BookEHexample() {
        Consumer<String> first = t ->
                System.out.println("First:" + t);
        Consumer<String> second = t ->
                System.out.println("Second:" + t);
        first.accept("I am 1st!");
        first.andThen(second).accept("Hi");
    }

    static class Numbers {
        public static boolean isMoreThanFifty(int n1, int n2) {
            return (n1 + n2) > 50;

        }

        public List<Integer> findNumbersOriginal(
                List<Integer> l, BiPredicate<Integer, Integer> p) {

            List<Integer> newList = new ArrayList<>();
            for (Integer i : l) {

                if (p.test(i, i + 10)) {
                    newList.add(i);
                }
            }
            return newList;
        }

        public static List<Integer> findNumbers(
                @Nonnull List<Integer> l,
                @Nonnull BiPredicate<Integer, Integer> p) {
            final Integer fudgeFactor = 10;
            Predicate<Integer> predicateWithFudgeFactor = i -> p.test(i, i + fudgeFactor);
            List<Integer> newList = l.stream().filter(predicateWithFudgeFactor).collect(Collectors.toList());
            return newList;
            /*
             * i prefer using @Nonnull to declare the pre-condition rather than to use
             * assert Objects.nonNull(l) && Objects.nonNull(p);
             */
        }
    }

    public void methodReferenceToStaticMethod() {
        final List<Integer> input = Arrays.asList(12, 5, 45, 18, 33, 24, 40);
        List<Integer> out = Numbers.findNumbers(input, Numbers::isMoreThanFifty);
        log.debug(out);
    }
}
