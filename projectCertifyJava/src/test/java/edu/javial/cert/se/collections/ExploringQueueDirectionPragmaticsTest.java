package edu.javial.cert.se.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.*;


@Test
public class ExploringQueueDirectionPragmaticsTest {
    private static Log log = LogFactory.getLog(ExploringQueueDirectionPragmaticsTest.class);

    private static List<Integer> originalList = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

    public void verifyWhichIsHeadOnQueueImplementation() {
        Queue<Integer> queue = null ;
        queue = new ArrayDeque( originalList );
        report( originalList , queue );
    }

    private static <E> String toReport(@Nonnull Collection<E> forReport) {
        return forReport.toString() ;
    }
    private static <E> void report(Collection<E> in, Collection<E> out) {
        log.debug("original:> " + toReport(in));
        log.debug("derived:> "  + toReport(out));
    }
}
