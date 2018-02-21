/**
 * 
 */
package edu.javial.cert.se.corelib.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mak
 * TODO : Path is for special filesystem development, and part of NIO.
 * TODO : refactor for File and Files.
 * TODO : create actual tests of file and directory creation
 * DONE : create tests showing round-trip equivalence of Path and File
 */
public class DirectoryPlusFileCreationTest {
	private static Log log = LogFactory.getLog(DirectoryPlusFileCreationTest.class);
	private static final String FILE_ERROR_MSG = "unable to create file";
	private static final String DIR_ERROR_MSG = "unable to create directory";
	private static final String RENAME_ERROR_MSG = "unable to rename";
    private static final Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---" );
    private static final FileAttribute[] attrs = new FileAttribute[] {PosixFilePermissions.asFileAttribute(perms)};

    private static final String SEEDED_DIRNAME = "sciDir";
    private static final String SEEDED_FILENAME = "sciFile";
    //
    ////            Path path = Paths.get(requestedDirectory, requestedFileName);
    //
    boolean createDirThenFile() {
        boolean ret = false;
        boolean dirOK = false;
        boolean fileOK = false;
        Path dirPath = privateCreateTempDir() ;
        Path completedPath = dirPath.resolve(SEEDED_FILENAME);
        Path createdFileAsPath = privateCreateFileFromPath(completedPath);
        Object d0 = createdFileAsPath.getParent() ;
        Object n0 = createdFileAsPath.getFileName();
        File f = createdFileAsPath.toFile() ;  // TODO exception
        Object d = f.getParent() ;
        Object n =f.getName();
        Object p = f.toPath();
        return null != f ;
    }
    private Path privateCreateTempDir() {
        Path ret = null;
        try {
            Path path = Files.createTempDirectory(SEEDED_DIRNAME, attrs);
            Path absPath = path.toAbsolutePath();
            log.debug(absPath.toString());
            ret = path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret ;
    }

    private Path privateCreateFileFromPath(Path requestedPath) {
        Path ret = null ;
        create : {
            try {
                Path temp = Files.createFile(requestedPath,attrs);
                ret = temp;
            } catch (IOException e) {
                log.fatal("failed on creating file from requested path:> " + requestedPath);
            }
        }
        return ret;
    }

    boolean createTempFile() {
		boolean ret = false;
		File temp = privateCreateTempFile(SEEDED_DIRNAME);
        ret = null != temp;
        return ret ;
	}

    private File privateCreateTempFile(String requestedSeed) {
        File ret = null;
        create: {
            try {
                File temp = File.createTempFile(requestedSeed, null);
                String path = temp.getAbsolutePath();
                log.debug(path);
                ret = temp ;
            } catch (Exception e) {
                log.fatal(FILE_ERROR_MSG, e);
                break create;
            }
        } // create
        return ret;
    }
}
