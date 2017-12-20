package javial.cert.sx

import org.junit.Test

import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertTrue

/**
 * Created by mak on 9/14/14.
 */
class CascadedExceptionsTest extends GroovyTestCase {
  CascadedExceptions tool;

  void setUp() {
    tool = new CascadedExceptions();
  }

  final String baseOutcome = CascadedExceptions.PIPE_DELIMITER + CascadedExceptions.FINALLY_OUTCOME + CascadedExceptions.PIPE_DELIMITER + CascadedExceptions.POST_BREAK + CascadedExceptions.PIPE_DELIMITER;
  final String nullOutcome = CascadedExceptions.NPE_OUTCOME + baseOutcome;
  final String elseOutcome = CascadedExceptions.EXCEPTION_OUTCOME + baseOutcome;

  void testCreateErrorScenarioSpecificToGeneral() {
    String outcomeOnNullInput = tool.createErrorScenarioSpecificToGeneral(null)
    assertTrue("cascadeExceptionTest - null - failed", outcomeOnNullInput == nullOutcome);

    String outcomeOnObjectInput = tool.createErrorScenarioSpecificToGeneral(this)
    assertTrue("cascadeExceptionTest - else - failed", outcomeOnObjectInput == elseOutcome);

  }

//
//  void testWillFinallyRunAfterBreak() {
//
//  }
}
