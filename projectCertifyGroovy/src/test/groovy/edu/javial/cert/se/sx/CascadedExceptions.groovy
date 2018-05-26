package edu.javial.cert.se.sx

import groovy.util.logging.Log

/**
 *
 */
//package edu.javial.cert.se.sx.exceptionHandling;



/**
 * @author mak
 * TODO convert into @Test
 */
@Log
public class CascadedExceptions {
    public static final String NPE_OUTCOME = "processing npe" ;
    public static final String EXCEPTION_OUTCOME = "processing general exception" ;
    public static final String FINALLY_OUTCOME = "processing finally" ;
    public static final String POST_BREAK = "POST_BREAK" ;
    public static final String PIPE_DELIMITER = "|" ;

//	@SuppressWarnings("finally")
    String createErrorScenarioSpecificToGeneral(Object redMeat) {
        String outcome = "" ;
        String candidate = outcome ;
        testNPE: {
            try {
                if (( null == redMeat )) {
                    throw new NullPointerException();
                } else {
                    throw new Exception() ;
                }
            } catch (NullPointerException e) {
                candidate += NPE_OUTCOME + PIPE_DELIMITER;
                log.debug(candidate);
            } catch (Exception e) {
                candidate += EXCEPTION_OUTCOME  + PIPE_DELIMITER;
                log.debug(candidate);
            } finally {
                candidate += FINALLY_OUTCOME  + PIPE_DELIMITER ;
                log.debug(candidate);
//				 break testNPE ; // get a warning here about not completing
                // finally normally. Hmmm
            }
        } // testNPE
        candidate += POST_BREAK  + PIPE_DELIMITER ;
        log.debug(candidate);
        return outcome = candidate ;
    }

    boolean willFinallyRunAfterBreak() {
        boolean ret = false;
        testNPE: {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                log.debug("processing npe");
            } catch (Exception e) {
                log.debug("processing general exception");
            } finally {
                log.debug("processing finally"); // you betchurass it runs b4 the break completes
                ret = true;
            }
        } // testNPE
        return ret;
    }

    boolean createErrorScenarioGeneralToSpecific() {
        boolean ret = false;
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
        // catch (NullPointerException e) {
        // // fails to compile
        // }
        return ret;
    }
}
