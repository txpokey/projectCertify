package edu.javial.keyCount

import org.junit.Assert;

/**
 * Created by Bob Makowski on 7/15/14.
 */
class ReportTest extends GroovyTestCase {
  public void testSanity() {
    Assert.assertTrue(true);
  }

  /*
   * functional end to end test
   */
  void testReportFileContentsAsKeyCounts() {
    Report customFileLocationContents = new Report( Report.defaultLocation )
    customFileLocationContents.reportFileContentsAsKeyCounts()
  }
}
