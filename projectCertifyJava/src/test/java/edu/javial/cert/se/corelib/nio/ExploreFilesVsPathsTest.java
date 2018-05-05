package edu.javial.cert.se.corelib.nio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

@Test
public class ExploreFilesVsPathsTest {
    private static Log log = LogFactory.getLog(ExploreFilesVsPathsTest.class);

    public void exploreFilesWalk() {
        try( Stream<Path>  walkSlashTmp = Files.walk(Paths.get("/home/mak/t"), 3) ) {
            walkSlashTmp.forEach(System.out::println);
        } catch (IOException e) {
            log.debug(e.getMessage());
        }
    }
    public void exploreFilesList() {
        try( Stream<Path>  walkSlashTmp = Files.list(Paths.get("/home/mak/t") ) ){
            walkSlashTmp.forEach(System.out::println);
        } catch (IOException e) {
            log.debug(e.getMessage());
        }
    }
    public void exploreFilesFind0() {
        BiPredicate<Path, BasicFileAttributes> predicate =
                (path, attrs) -> {
                    return attrs.isDirectory();
                };
        int maxDepth = 2;
        try(Stream<Path> stream =
                    Files.find(Paths.get("/home/mak/t"),
                            maxDepth, predicate)) {
            stream.forEach(System.out::println);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
