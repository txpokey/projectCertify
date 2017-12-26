/**
 * 
 */
package edu.javial.cert.se.sx;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mak
 * 
 */
public class TrivialFileDirCreation {
	private static Log log = LogFactory.getLog(TrivialFileDirCreation.class);
	private static final String FILE_ERROR_MSG = "unable to create file";
	private static final String DIR_ERROR_MSG = "unable to create directory";
	private static final String RENAME_ERROR_MSG = "unable to rename";
    private static final Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---" );
    private static final FileAttribute[] attrs = new FileAttribute[] {PosixFilePermissions.asFileAttribute(perms)};


    boolean createTempFile() {
		boolean ret = false;
		final String requestedSeed = "sciFile" ;
		File temp = privateCreateTempFile(requestedSeed);
        ret = null != temp;
        return ret ;
	}
    boolean createDirThenFile() {
        boolean ret = false;
        boolean dirOK = false;
        boolean fileOK = false;
        Path p = privateCreateTempDir() ;
        File f = privateCreateFile(p.toString(),"sciFile");
        return null != p && null != f ;
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
    private File privateCreateFile(String requestedDirectory, String requestedFileName) {
        File ret = null ;
        create : {
            Path path = Paths.get(requestedDirectory, requestedFileName);
            File temp = privateCreateFile(path);
            ret = temp;
        }
        return ret;
    }
    private File privateCreateFile(Path requestedDirectory, String requestedFileName) {
        File ret = null ;
        create : {
//            Path path = Paths.get(requestedDirectory, requestedFileName);
            Path path = requestedDirectory.resolve(requestedFileName);
            File temp = privateCreateFile(path);
            ret = temp;
        }
        return ret;
    }
    private File privateCreateFile(Path requestedPath) {
        File ret = null ;
        create : {
            try {
                File temp = privateCreateFileAsPath(requestedPath).toFile();
                ret = temp;
            } catch (Exception e) {
                log.fatal("failed on creating file from requested path:> " + requestedPath);
            }
        }
        return ret;
    }
    private Path privateCreateFileAsPath(Path requestedPath) {
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

    Path privateCreateTempDir() {
        Path ret = null;
        try {
            Path path = Files.createTempDirectory("sciDir", attrs);
            Path absPath = path.toAbsolutePath();
            log.debug(absPath.toString());
            ret = path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret ;
    }
}
