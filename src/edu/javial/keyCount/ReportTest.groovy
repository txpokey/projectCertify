package edu.javial.keyCount

//import org.junit.Test
import org.junit.Assert;

/**
 * Created by mak on 7/15/14.
 */
class ReportTest extends GroovyTestCase {
  public void testSanity() {
    Assert.assertTrue(true);
  }

  void testFoo() {
    Report instance = new Report()
    instance.reportFileContentsAsKeyCounts()
  }
}
