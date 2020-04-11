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
    final List<Integer> inputList = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

    public void lookAtArrayListPedigree() {
        log.debug(inputList.getClass());
        final List<Integer> inputRedux = new ArrayList<>(inputList);
        log.debug(inputRedux.getClass());
    }

}
