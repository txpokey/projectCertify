package edu.javial.cert.se.core.stream.comparator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

@Test
public class ExploreSortingStreamsViaComparatorTest {

    /**
     * using both sorted and foreach to report on a {@code Stream<String>} sort result
     * {@code Stream<T> sorted(Comparator<? super T> comparator)}
     * {@code void forEach(Consumer<? super T> action)}
     */
    public void exploreSortingStreamsViaComparator() {
        final List<String> strings =
                Arrays.asList("Stream","Operations","on","Collections");
        final Comparator<String> stringComparator = (s1, s2) -> s2.length() - s1.length();
        final Consumer<String> trivialReportAsConsumer = s -> log.debug(s);
        strings.stream()
                .sorted(stringComparator)
                .forEach(trivialReportAsConsumer);
        log.debug("");
    }
    private static Log log = LogFactory.getLog(ExploreSortingStreamsViaComparatorTest.class);
}

