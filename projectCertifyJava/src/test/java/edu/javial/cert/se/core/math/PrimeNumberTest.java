package edu.javial.cert.se.core.math;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

@Test
public class PrimeNumberTest {
    private static Log log = LogFactory.getLog(PrimeNumberTest.class);

    public void smokeTest() {
        PrimeNumber factory = new PrimeNumber() ;
        IntStream.rangeClosed(1, 1000).parallel().forEach( i -> factory.isPrime(i));
        log.debug(factory.getPrimes());
    }

}