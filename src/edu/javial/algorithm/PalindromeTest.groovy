package edu.javial.algorithm

import edu.javial.keyCount.Report
import org.junit.Assert;

/**
 * Created by Bob Makowski on 7/17/14.
 */
class PalindromeTest extends GroovyTestCase {
  /*
   * functional end to end test
   */
  void testDetect() {
    Palindrome palindrome = new Palindrome()
    assert true  == palindrome.detect("Ah, Satan sees Natasha")
    assert false == palindrome.detect("never")
    assert false == palindrome.detect( null )
    assert false == palindrome.detect( ",." )
    assert false == palindrome.detect( "" )
  }
}
