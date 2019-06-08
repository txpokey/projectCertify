package edu.javial.cert.se.core.math

import groovy.util.logging.Slf4j
import org.testng.annotations.Test

@Test
@Slf4j
class PrimeNumberGroovyTest{

    private final static def RANGE = 1..11
    private final static def REFERENCE_ANSWER = [
            [prime: 1, truth: true],
            [prime: 2, truth: true],
            [prime: 3, truth: true],
            [prime: 4, truth: false],
            [prime: 5, truth: true],
            [prime: 6, truth: false],
            [prime: 7, truth: true],
            [prime: 8, truth: false],
            [prime: 9, truth: false],
            [prime: 10, truth: false],
            [prime: 11, truth: true],
    ]

    void exploreAlgorithm() {
        def candidate = (RANGE).collect { i -> [prime: (i), truth: PrimeNumberGroovy.isPrime(i)] }
        assert candidate
        assert candidate == REFERENCE_ANSWER
    }
}