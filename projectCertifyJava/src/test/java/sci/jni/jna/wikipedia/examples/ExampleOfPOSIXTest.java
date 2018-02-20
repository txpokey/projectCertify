package sci.jni.jna.wikipedia.examples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mak on 2/20/18.
 */
class ExampleOfPOSIXTest {
    final static Log logger = LogFactory.getLog(ExampleOfPOSIXTest.class);

    @Test
    void confirmLibraryFound() {
        Object tester = ExampleOfPOSIX.POSIX.INSTANCE.getClass();
        assert null != tester ;
        logger.debug("what is tester?:> " + tester);
    }

    @Test
    void confirmMainNullWorks() {
        ExampleOfPOSIX.POSIX posix = ExampleOfPOSIX.POSIX.INSTANCE;
        int dirSuccessCode = posix.mkdir("/tmp/newdir", 0777);
        assert 0 == dirSuccessCode ;
        int renameSuccessCode = posix.rename("/tmp/newdir","/tmp/renamedir");
        assert 0 == renameSuccessCode ;
        int rmSuccessCode = posix.rmdir("/tmp/renamedir");
        assert 0 == rmSuccessCode ;
    }
}