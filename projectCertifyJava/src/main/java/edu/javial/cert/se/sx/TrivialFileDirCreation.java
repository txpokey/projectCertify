/**
 * 
 */
package edu.javial.cert.se.sx;

import java.io.File;

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

	boolean createTempFile() {
		boolean ret = false;
		final String requestedPathName = "sciFile" ;
		File temp = privateCreateTempFile(requestedPathName);
        ret = null != temp;
        return ret ;
	}

private File privateCreateTempFile(String requestedPathName) {
    File ret = null;
    create: {
        try {
            File temp = File.createTempFile(requestedPathName, null);
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
	boolean createDirThenFile() {
		return true ;
	}
	boolean createDirThenFile_CLOBBER() { /*DEBUG*/
		boolean ret = false;
		boolean dirOK = false;
		boolean fileOK = false;
		boolean renameOK = false;
		create: {
			String errmsg = DIR_ERROR_MSG;
			File f = new File("target/tmp", "sciFile3");
			File fr = new File("target/tmp", "sciFile3.txt");
			File d = new File("target", "tmp");
			try {
				if (dirOK = d.mkdir()) {
					errmsg = FILE_ERROR_MSG;
					if (fileOK = f.createNewFile()) {
						errmsg = RENAME_ERROR_MSG;
						if (renameOK = f.renameTo(fr)) {
							String path = f.getAbsolutePath();
							log.info(path);
						}
					}
				}
			} catch (Throwable e) {
				log.fatal(errmsg, e);
				break create;
			}
		} // create
		ret = dirOK && fileOK && renameOK; // only to get rid of a stupid warning 
		return ret ;
	}
}
