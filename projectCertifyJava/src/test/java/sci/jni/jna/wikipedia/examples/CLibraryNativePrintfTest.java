package sci.jni.jna.wikipedia.examples;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

//import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mak on 2/19/18.
 * WORKS: DONE: 2/20/18
 */
class CLibraryNativePrintfTest {
    final static Logger logger = LoggerFactory.getLogger(CLibraryNativePrintfTest.class);

    @Test
    void discoverLogging(){
        logger.debug("this is my logging test");
    }
    @Test
    void discoverProperties() {
        Properties props = System.getProperties();
        assert null != props ;

        List<?> testList = Collections.list(props.propertyNames()) ;
        Object tester = testList.get(0).getClass();
        logger.debug("what is tester?:> " + tester);

        for( String key : Collections.list((Enumeration<String>)props.propertyNames())) {
            logger.debug(key + ":> " + props.getProperty(key) );
        }
    }
    @Test
    void discoveryLibraryPathing() {
        final String JNA_PICKER = "jna.library.path";
        final String LIB_PICKER = "java.library.path";
        logger.debug( JNA_PICKER + ":> " + System.getProperty(JNA_PICKER));
        logger.debug( LIB_PICKER + ":> " + System.getProperty(LIB_PICKER));
    }
    @Test
    void confirmLibraryFound() {
        Object tester = CLibraryNativePrintf.CLibrary.INSTANCE.getClass();
        assert null != tester ;
        logger.debug("what is tester?:> " + tester);
        CLibraryNativePrintf.CLibrary.INSTANCE.printf("Hello, World\n");
    }
    @Test
    void confirmPrintfWorks() {
        CLibraryNativePrintf.CLibrary.INSTANCE.printf("Hello, World\n");
    }
    @Test
    void confirmMainNullWorks() {
        CLibraryNativePrintf.main(null);
    }
    @Test
    void confirmMainArgsWorks() {
        String[] args = { "foo" , "bar" };
        CLibraryNativePrintf.main(args);
    }
}