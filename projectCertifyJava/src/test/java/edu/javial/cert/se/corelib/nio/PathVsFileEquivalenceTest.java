package edu.javial.cert.se.corelib.nio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;

/**
 * test to show File and Path have a round-trip equivalence. also show <T>.toUri() features.
 */
public class PathVsFileEquivalenceTest {
    private static Log log = LogFactory.getLog(PathVsFileEquivalenceTest.class);
    private static String SLASH = File.separator;
    private static final String TEMP_DIRNAME = "/tmp";
    private static final String SEEDED_DIRNAME = "sciDir";
    private static final String SEEDED_FILENAME = "sciFile";
    private static final String REFERENCE_ABSOLUTE_DIRNAME = TEMP_DIRNAME  + SLASH + SEEDED_DIRNAME ;
    private static final String REFERENCE_ABSOLUTE_PATH = REFERENCE_ABSOLUTE_DIRNAME + SLASH + SEEDED_FILENAME ;

    @Test
    public void testPathToFileRoundTrip() {
    }
    @Test
    public void testFileToPathRoundTrip() {
        File file = new File( REFERENCE_ABSOLUTE_PATH );
        Path path = file.toPath();
        Path parent = path.getParent();
        Path filename = path.getFileName() ;
        String fileParent = file.getParent() ;
        String pathParent = parent.toString() ;
        assert fileParent.equals(pathParent) ;
        assert filename.toString().equals(file.getName()) ;
    }
}
/*
 * Created by mak on 2/20/18. */
