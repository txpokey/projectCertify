package edu.javial.cert.se.math

//import groovy.util;

/**
 * Created by mak on 9/12/14.
 */
class PrimeNumberTest extends GroovyTestCase {
  void testIsPrime() {

  }

  void testGetPrimes() {

  }

  void testMain() {
    for (int i = 2; i <= 1000; i++) {
      PrimeNumber.isPrime(i) ? log.info(i as String) : false ;
    }
  }
}
