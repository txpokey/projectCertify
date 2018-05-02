package edu.javial.cert.se.corelib.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

@Test
public class ExploreMetaDataForOriginalFileObjectsByTest {
    private static Log log = LogFactory.getLog(ExploreMetaDataForOriginalFileObjectsByTest.class);
    private final File devdir = new File( "/dev" ) ;
    private final File devnull = new File( "/dev/null" ) ;
    private final File devtty = new File( "/dev/tty" ) ;
    private final File fakeout = new File( "/dev/fakeout" ) ;
    private final File fakeoutDir = new File( "/fakeout" ) ;
    private final File fakeoutDir2 = new File( "/fakeout/" ) ;
    private final File ideaLink = new File( "/home/mak/ln/idea" ) ;
    private final File idea = new File("/opt/com/jetbrains/idea/current/bin/idea.sh" ) ;
    private final File[] filesForAttributes = {
            devdir, devnull, idea, ideaLink
    };
    private final File[] filesForClassification = {
            devtty, devdir, fakeout, fakeoutDir, fakeoutDir2, devnull, idea, ideaLink
    };

    public void exploreLinkOption(){
        LinkOption[] options = LinkOption.values();
        log.debug(options);
    }
    public void exploreFileLastModificationTime() {
        Arrays.stream(filesForAttributes).forEach(this::exploreFileLastModificationTime);
        Arrays.stream(filesForAttributes).forEach(this::exploreFileLastAccessTime);

        log.debug("");
    }
    public void exploreFilesForClassification() {
        Arrays.stream(filesForClassification).forEach(this::exploreFileClassificationInspectors);

        log.debug("");
    }
    private void exploreFileClassificationInspectors(File subjectFile ) {
        checkIfExists( subjectFile ) ;
        checkIfRegularFile( subjectFile ) ;
        checkIfOther( subjectFile ) ;
        checkIfOrdinaryFile( subjectFile ) ;
        checkIfDirectory( subjectFile ) ;
    }
    private boolean checkIfExists(File subjectFile ) {
        boolean candidate = subjectFile.exists() ;
        log.debug( subjectFile + ":exists()> " + candidate );
        return candidate;
    }
    private boolean checkIfOrdinaryFile(File subjectFile ) {
        boolean candidate = subjectFile.isFile() ;
        log.debug( subjectFile + ":isFile()> " + candidate );
        return candidate;
    }
    private boolean checkIfDirectory(File subjectFile ) {
        boolean candidate = subjectFile.isDirectory() ;
        log.debug( subjectFile + ":isDirectory()> " + candidate );
        return candidate;
    }
    private void exploreFileLastModificationTime(File subjectFile ) {
        long lastModified = subjectFile.lastModified() ;
        Instant instant = Instant.ofEpochMilli(lastModified);
        log.debug( subjectFile + ":lastModified> " + instant );
    }
    private void exploreFileLastAccessTime(File subjectFile ) {
        Optional<BasicFileAttributes> attributes = getBasicFileAttributes(subjectFile);
        long lastAccessTime = attributes.isPresent() ? attributes.get().lastAccessTime().toMillis() : 0 ;
        Instant instant = Instant.ofEpochMilli(lastAccessTime);
        log.debug( subjectFile + ":lastAccessTime> " + instant );
    }
    private boolean checkIfOther(File subjectFile ) {
        Optional<BasicFileAttributes> attributes = getBasicFileAttributes(subjectFile);
        boolean isOther = attributes.isPresent() ? attributes.get().isOther() : false ;
        log.debug( subjectFile + ":isOther> " + isOther );
        return isOther;
    }
    private boolean checkIfRegularFile(File subjectFile ) {
        Optional<BasicFileAttributes> attributes = getBasicFileAttributes(subjectFile);
        boolean isRegularFile = attributes.isPresent() ? attributes.get().isRegularFile() : false ;
        log.debug( subjectFile + ":isRegularFile> " + isRegularFile );
        return isRegularFile;
    }
    private Optional<BasicFileAttributes> getBasicFileAttributes(File subjectFile ) {
        Path path = subjectFile.toPath() ;
        BasicFileAttributes attrs = null ;
        try {
            attrs = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            log.debug("no attributes exist :> " + e.getMessage());
        }
        Optional<BasicFileAttributes> ret = Optional.ofNullable(attrs);
        return ret ;
    }

}
