package edu.javial.cert.se.pragmatic.patterns.optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.Test;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * exploring Java 8 Optional
 */
@Test
public class OptionalAsNullObjectPatternTest {
    private static Log log = LogFactory.getLog(OptionalAsNullObjectPatternTest.class);
    private static File FILE_NULLOBJECT = new File("/dev/null");
    private static File FILE_NULL = null ;

    public void testWhatEmptyMeans() {
        Optional<File> emptyFile = Optional.empty();
        log.info("emptyFile:asString:> " + emptyFile);
        log.info("emptyFile:asClass:> " + emptyFile.getClass());
        log.info("of:isPresent:> " + emptyFile.isPresent());
//
        File orElse = emptyFile.orElse(FILE_NULLOBJECT);
        log.info("orElse:asString:> " + orElse);
        log.info("orElse:asClass:> " + orElse.getClass());
        log.info("orElse:return maybe null:> " + emptyFile.orElse(null));
//
        Optional<File> of = Optional.of(FILE_NULLOBJECT);
        log.info("of:asString:> " + of);
        log.info("of:asClass:> " + of.getClass());
        log.info("of:isPresent:> " + of.isPresent());
        log.info("of:get:> " + of.get());
//
        Optional<File> optionalOfNullableOnDevNull = Optional.ofNullable(orElse);
        log.info("optionalOfNullableOnDevNull:asString:> " + optionalOfNullableOnDevNull);
        log.info("optionalOfNullableOnDevNull:asClass:> " + optionalOfNullableOnDevNull.getClass());
//
        Optional<File> optionalOfNullableOnNullOfTypeFile = Optional.ofNullable(FILE_NULL);
        log.info("optionalOfNullableOnNullOfTypeFile:isPresent:> " + optionalOfNullableOnNullOfTypeFile.isPresent());
        log.info("optionalOfNullableOnNullOfTypeFile:asString> " + optionalOfNullableOnNullOfTypeFile);
        log.info("optionalOfNullableOnNullOfTypeFile:asClass> " + optionalOfNullableOnNullOfTypeFile.getClass());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void triggerExceptionOnGetEmpty() {
        Optional<File> emptyFile = Optional.empty();
        emptyFile.get() ;
        log.info("I SHOULD NOT BE HERE");
    }
}

/*
 * Created by mak on 2/23/18.
 */