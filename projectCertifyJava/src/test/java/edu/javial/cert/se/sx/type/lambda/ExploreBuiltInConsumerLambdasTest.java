package edu.javial.cert.se.sx.type.lambda;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.function.Consumer;

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

}
