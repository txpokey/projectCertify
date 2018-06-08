package edu.javial.cert.se.core.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Test
public class ExploreListTest {
    private static Log log = LogFactory.getLog(ExploreListTest.class);

    public void lookAtArrayListPedigree() {
        final List<Integer> input = Arrays.asList(12, 5, 45, 18, 33, 24, 40);
        log.debug(input.getClass());
        final List<Integer> inputRedux = new ArrayList<>(input);
        log.debug(inputRedux.getClass());
    }

}
