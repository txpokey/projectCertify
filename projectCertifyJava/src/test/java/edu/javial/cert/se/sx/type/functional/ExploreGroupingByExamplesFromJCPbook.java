package edu.javial.cert.se.sx.type.functional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Test
public class ExploreGroupingByExamplesFromJCPbook {
    private static Log log = LogFactory.getLog(ExploreGroupingByExamplesFromJCPbook.class);

    public void test() {
        Map<Integer, Map<String, List<Integer>>> map =
            Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                .collect(
                    groupingBy(
                        i -> i / 10 * 10,
                        TreeMap::new,
                        groupingBy(i -> (i % 2 == 0) ? "EVEN" : "ODD")
                    )
                );
        log.debug(map);
    }

}
