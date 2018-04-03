/**
 *
 */
package edu.javial.cert.se.corelib.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import javax.annotation.Nonnull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author mak
 *         TODO : Path is for special filesystem development, and part of NIO.
 *         TODO : INWORK : refactor for File and Files.
 *         DONE : create actual tests directory creation
 *         TODO : create actual tests of file creation
 *         DONE : create tests showing round-trip equivalence of Path and File
 */
public class DirectoryPlusFileCreationTest {
    private static Log log = LogFactory.getLog(DirectoryPlusFileCreationTest.class);
    private static final String FILE_ERROR_MSG = "unable to create file";
    private static final String DIR_ERROR_MSG = "unable to create directory";
    private static final String RENAME_ERROR_MSG = "unable to rename";
    private static final Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
    private static final FileAttribute[] attrs = new FileAttribute[]{PosixFilePermissions.asFileAttribute(perms)};

    private static final String SLASH = File.separator;
//    private static final String SEEDED_DIRNAME = "/tmp/sciDir" + Math.random() + SLASH + Math.random();
//    private static final String SEEDED_FILENAME = "sciFile" + Math.random();
    private static final Path SEEDED_AS_PATH = generateRandomPathFromSeed();
    private static final Path SEEDED_PATH_PARENT = SEEDED_AS_PATH.getParent();
    private static final File SEEDED_AS_FILE = generateRandomPathFromSeed().toFile();
    private static final File SEEDED_FILE_PARENT = SEEDED_AS_FILE.getParentFile();

    //
//    @AfterAll
//    static void tearDownAll() {
//        log.info("HERE");
//        tearDown_testCreateDirectoryByRequestedPath() ;
//        tearDown_testCreateDirectoryByRequestedFile() ;
//    }
    private static Path generateRandomPathFromSeed() {
        String dn = "/tmp/sciDir" + Math.random() + SLASH + Math.random();
        String fn = "sciFile" + Math.random();
        return Paths.get(dn, fn) ;
    }

    @Test
    public void testCreateDirectoryByRequestedPath() {
        assertNotNull(SEEDED_PATH_PARENT);
        Path returnedPath = privateCreateDirectory(SEEDED_PATH_PARENT);
        assertNotNull(returnedPath);
        assertEquals(SEEDED_PATH_PARENT.toString(), returnedPath.toString());
        assert( tearDown_testCreateDirectoryByRequestedPath() );
    }

    @Test
    public void testCreateDirectoryByRequestedFile() {
        assertNotNull(SEEDED_FILE_PARENT);
        File returnedFile = privateCreateDirectory(SEEDED_FILE_PARENT);
        assertNotNull(returnedFile);
        assertEquals(SEEDED_FILE_PARENT.toString(), returnedFile.toString());
        assert( tearDown_testCreateDirectoryByRequestedFile() );
    }

    private Path privateCreateDirectory(Path requestedParentPath) {
        assertNotNull(requestedParentPath); // TODO : replace with @NotNull
        Path ret = null;
        try {
            Path p = Files.createDirectories(requestedParentPath, attrs);
            assertNotNull(p);
            ret = p;
        } catch (IOException e) {
            log.debug("cant create requested directory:> " + requestedParentPath, e);
        }
        return ret;
    }

    private File privateCreateDirectory(File requestedParentFile) {
        assertNotNull(requestedParentFile);
        boolean candidate = requestedParentFile.mkdirs() ;
        File ret = candidate ? requestedParentFile : null ;
        return ret;
    }
    private static boolean tearDown_testDirectory( Path requestedParentPath ) {
        assertNotNull(requestedParentPath);
        boolean tornDown = false ;
        try {
            boolean candidate1 = Files.deleteIfExists(requestedParentPath);
            boolean candidate0 = Files.deleteIfExists(requestedParentPath.getParent());
            tornDown = candidate0 && candidate1 ;
        } catch (IOException e) {
            log.debug("cant delete requested directory:> " + requestedParentPath, e);
        }
        return tornDown ;
    }
    private static boolean tearDown_testCreateDirectoryByRequestedPath(){
        boolean tornDown = tearDown_testDirectory(SEEDED_PATH_PARENT) ;
        return tornDown ;
    }
    private static boolean tearDown_testCreateDirectoryByRequestedFile(){
        boolean tornDown = tearDown_testDirectory(SEEDED_FILE_PARENT.toPath()) ;
        return tornDown ;
    }
}
