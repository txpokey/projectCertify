package edu.javial.cert.se.sx.type.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// TODO add meaningful examples...
public class ExploreLambdaTest {
    private Collection<Integer> originalListCloningFactory0() {
        final List<Integer> referenceList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> candidate = referenceList.stream().map(Integer::new)
                .collect(Collectors.toList());
        return candidate;
    }
}
