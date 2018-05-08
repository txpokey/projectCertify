package edu.javial.cert.se.corelib.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

@Test
public class ExploreMetaDataForOriginalFileObjectsByTest {
    private static Log log = LogFactory.getLog(ExploreMetaDataForOriginalFileObjectsByTest.class);
    private final static File devdir = new File( "/dev" ) ;
    private final static File devnull = new File( "/dev/null" ) ;
    private final static File devtty = new File( "/dev/tty" ) ;
    private final static File fakeout = new File( "/dev/fakeout" ) ;
    private final static File fakeoutDir = new File( "/fakeout" ) ;
    private final static File fakeoutDir2 = new File( "/fakeoutSlash/" ) ;
    private final static File ideaLink = new File( "/home/mak/ln/idea" ) ;
    private final static File idea = new File("/opt/com/jetbrains/idea/current/bin/idea.sh" ) ;
    private final static File[] filesForAttributes = {
            devdir, devnull, idea, ideaLink
    };
    private final static File[] filesForClassification = {
            ideaLink, devtty, devdir, fakeout, fakeoutDir, fakeoutDir2, devnull, idea, ideaLink
    };

    public static File[] getFilesForAttributedsTesting() {
        return filesForAttributes ;
    }
    public static File[] getFilesForForClassificationTesting() {
        return filesForClassification ;
    }

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
    private void exploreFileClassificationInspectors(@Nonnull File subjectFile ) {
        final Optional<BasicFileAttributes> attributes = getBasicFileAttributes(subjectFile) ;
        final HashMap<String, Boolean> report = new HashMap<>() ;
        report.put( "IfExists", checkIfExists( subjectFile , attributes) ) ;
        report.put( "IfRegularFile", checkIfRegularFile( subjectFile , attributes) ) ;
        report.put( "IfOrdinaryFile", checkIfOrdinaryFile( subjectFile , attributes) ) ;
        report.put( "IfDirectory", checkIfDirectory( subjectFile , attributes) ) ;
        report.put( "IfOther", checkIfOther( subjectFile , attributes) ) ;
        report.put( "IfSymbolicLink", checkIfSymbolicLink( subjectFile , attributes) ) ;

        log.debug( subjectFile + ":> " + report );
    }
    private boolean checkIfExists(@Nonnull File subjectFile , final @Nonnull Optional<BasicFileAttributes> attributes
    ) {
        boolean candidate = subjectFile.exists() ;
        return candidate;
    }
    private boolean checkIfOrdinaryFile(@Nonnull File subjectFile, final @Nonnull Optional<BasicFileAttributes> attributes ) {
        boolean candidate = subjectFile.isFile() ;
        return candidate;
    }
    private boolean checkIfDirectory(@Nonnull File subjectFile , final @Nonnull Optional<BasicFileAttributes> attributes) {
        boolean candidate = subjectFile.isDirectory() ;
        return candidate;
    }
   private boolean checkIfOther(@Nonnull File subjectFile , final @Nonnull Optional<BasicFileAttributes> attributes) {
        boolean isOther = attributes.isPresent() ? attributes.get().isOther() : false ;
        return isOther;
    }
    private boolean checkIfRegularFile(@Nonnull File subjectFile , final @Nonnull Optional<BasicFileAttributes> attributes) {
        boolean isRegularFile = attributes.isPresent() ? attributes.get().isRegularFile() : false ;
        return isRegularFile;
    }
    private boolean checkIfSymbolicLink(@Nonnull File subjectFile , final @Nonnull Optional<BasicFileAttributes>
            attributes) {
        boolean isSymbolicLink = attributes.isPresent() ? attributes.get().isSymbolicLink() : false ;
        return isSymbolicLink;
    }
    private void exploreFileLastModificationTime(@Nonnull File subjectFile ) {
        long lastModified = subjectFile.lastModified() ;
        Instant instant = Instant.ofEpochMilli(lastModified);
        log.debug( subjectFile + ":lastModified> " + instant );
    }
    private void exploreFileLastAccessTime(@Nonnull File subjectFile ) {
        Optional<BasicFileAttributes> attributes = getBasicFileAttributes(subjectFile);
        long lastAccessTime = attributes.isPresent() ? attributes.get().lastAccessTime().toMillis() : 0 ;
        Instant instant = Instant.ofEpochMilli(lastAccessTime);
        log.debug( subjectFile + ":lastAccessTime> " + instant );
    }

    private Optional<BasicFileAttributes> getBasicFileAttributes(@Nonnull File subjectFile ) {
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
