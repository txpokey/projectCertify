/**
 * 
 */
package edu.javial.cert.se.sx;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author mak
 *
 */
public class MultipleSyntaxTest {
	private static Log log = LogFactory.getLog(MultipleSyntaxTest.class);
	@Test
	public void computeOverrideTest() {
		OverrideSignatureExamples tool = new OverrideSignatureExamples() ;
		boolean OK = tool.computeSilly(10) ;
		assertTrue( "computeSilly test failed" , OK) ;
	}
	@Test
	public void shadowExperimentsTest() {
		ShadowExperiments tool = new ShadowExperiments() ;
		boolean OK = tool.shadowFieldExercise(10) ;
		assertTrue( "shadowFieldExercise test failed" , OK) ;
		OK = tool.shadowFieldExerciseStatic(10) ;
		assertTrue( "shadowFieldExerciseStatic test failed" , OK) ;
		OK = tool.shadowFieldExerciseFieldPoke(10) ;
		assertTrue( "shadowFieldExerciseFieldPoke test failed" , OK) ;
		OK = tool.shadowFieldExerciseStaticFieldPoke(10) ;
		assertTrue( "shadowFieldExerciseStaticFieldPoke test failed" , OK) ;
	}
	@Test
	public void regexSplitterTest() {
		RegexSplitTool tool = new RegexSplitTool() ;
		boolean OK = tool.splitStringWithTrailingEdgeCase() ;
		assertTrue( "regexSplitter test failed" , OK) ;
	}
	@Test
	public void multiDimArrayTest() {
		MultiDimArrayTool tool = new MultiDimArrayTool() ;
		boolean OK = tool.verifyMutilDimArrayCalcs() ;
		assertTrue( "multiDimArray test failed" , OK) ;
	}
//	@Test
//	public void cascadeExceptionTest() {
//		CascadedExceptions tool = new CascadedExceptions();
//		boolean cascadeOK = tool.createErrorScenarioSpecificToGeneral() ;
//		boolean finallyOK = tool.willFinallyRunAfterBreak() ;
//		assertTrue( "cascadeExceptionTest failed" , cascadeOK && finallyOK) ;
//	}

}
