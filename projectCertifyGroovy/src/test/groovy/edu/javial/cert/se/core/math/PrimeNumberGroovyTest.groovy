package edu.javial.cert.se.core.math

import groovy.util.logging.Slf4j
import org.testng.annotations.Test

@Test
@Slf4j
class PrimeNumberGroovyTest {

    private final static def RANGE = 1..11
    void exploreAlgorithm() {
        def candidate = (RANGE).collect { i -> [ (i) : PrimeNumberGroovy.isPrime( i ) ] }
        candidate
    }
}