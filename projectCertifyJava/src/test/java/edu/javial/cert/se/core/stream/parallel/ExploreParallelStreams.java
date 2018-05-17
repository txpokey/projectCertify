package edu.javial.cert.se.core.stream.parallel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Test
public class ExploreParallelStreams {
    public void whereDoesParallelBegin() {
        // parallel pragmatics capture the processing of the entire stream and processing calls
        double start = System.nanoTime();
        Stream.of("b", "d", "a", "c", "e")
                .sorted()
                .filter(s -> {
                    log.debug("Filter:" + s);
                    return !"d".equals(s);
                })
                .parallel()
                .map(s -> {
                    log.debug("Map:" + s);
                    return s += s;
                })
                .forEach(System.out::println);
        double duration = (System.nanoTime() - start) / 1_000_000;
        log.debug(duration + " milliseconds");

    }

    public void Question_17_4() {
        // sequential wins as last pragmatic standing :)
        IntStream.of(1, 1, 3, 3, 7, 6, 7)
                .distinct()
                .parallel()
                .map(i -> i * 2)
                .sequential()
                .forEach(System.out::print);
    }

    private static Log log = LogFactory.getLog(ExploreParallelStreams.class);

}