package edu.javial.cert.se.corelib.nio;

import edu.javial.cert.se.corelib.io.ExploreMetaDataForOriginalFileObjectsByTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Test
/**
 * test to show File and Path have a round-trip equivalence. also show <T>.toUri() features.
 */
public class PathVsFileEquivalenceTest {
    private static Log log = LogFactory.getLog(PathVsFileEquivalenceTest.class);
    private static String SLASH = File.separator;
    private static final String TEMP_DIRNAME = "/tmp";
    private static final String SEEDED_DIRNAME = "sciDir";
    private static final String SEEDED_FILENAME = "sciFile";
    private static final String REFERENCE_ABSOLUTE_DIRNAME = TEMP_DIRNAME + SLASH + SEEDED_DIRNAME;
    private static final String REFERENCE_ABSOLUTE_PATH = REFERENCE_ABSOLUTE_DIRNAME + SLASH + SEEDED_FILENAME;
    private final static File[] filesForAttributes = ExploreMetaDataForOriginalFileObjectsByTest
            .getFilesForAttributedsTesting();
    private final static File[] filesForClassification = ExploreMetaDataForOriginalFileObjectsByTest
            .getFilesForForClassificationTesting();

    public void testPathToFileRoundTrip() {
    }

    public void testFileToPathRoundTrip() {
        File file = new File(REFERENCE_ABSOLUTE_PATH);
        Path path = file.toPath();
        Path parent = path.getParent();
        Path filename = path.getFileName();
        String fileParent = file.getParent();
        String pathParent = parent.toString();
        assert fileParent.equals(pathParent);
        assert filename.toString().equals(file.getName());
    }

    Function<File, Path> getPath = f -> f.toPath();

    Function<Path, List<Path>> getPathBrakedown = p -> {
        final int count = p.getNameCount();
        final List<Path> ret = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ret.add(p.getName(i));
        }
        return ret;
    };
    Function<Path, Map<Integer, Path>> getPathBrakedownAsMap = p -> {
        final int count = p.getNameCount();
        final Map<Integer, Path> ret = new HashMap<>();
        for (int i = 0; i < count; i++) {
            ret.put(i, p.getName(i));
        }
        ret.put(count, p);
        return ret;
    };
    Function<Path, Map<Integer, Path>> getSubPathBrakedownAsMap = p -> {
        final int count = p.getNameCount();
        final Map<Integer, Path> ret = new HashMap<>();
        for (int i = 1; i < count; i++) {
            ret.put(i, p.subpath(0, i));
        }
        ret.put(count, p);
        return ret;
    };

    public void exploreSubPathPragmatics() {
        Arrays.stream(filesForClassification).map(getPath).map(getPathBrakedown).forEach(l -> log.debug(l));
        Arrays.stream(filesForClassification).map(getPath).map(getPathBrakedownAsMap).forEachOrdered(l -> log.debug(l));
        Arrays.stream(filesForClassification).map(getPath).map(getSubPathBrakedownAsMap).forEach(l -> log.debug(l));
    }

    public void explorePathIterationExample() {
        final Path idea = new File("/opt/com/jetbrains/idea/current/bin/idea.sh").toPath();
        Consumer<Path> executePathGetNameRunner = p -> {
            for (Path name : p) {
                log.debug(name);
            }
        };
        Stream.of(idea).forEach(executePathGetNameRunner);
    }
}
/*
 * Created by mak on 2/20/18.
 * */
