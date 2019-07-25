package edu.javial.cert.functional

import groovy.util.logging.Slf4j
import org.testng.annotations.Test

@Slf4j
@Test
class ExploreLambdaAlternative{

    void sumOfOddNumbers_FunctionalProgrammingExample() {

        List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7)

        int sum = numbers.stream() // Create Stream
                .filter({number -> (number % 2 != 0)} ) // Intermediate Operation
                .reduce(0, Integer.&sum) // Terminal Operation

        // number -> (number % 2 != 0) => Lambda Expression
        // Integer::sum => Method Reference
        // What is Functional Interface

        assert 11 == sum 
    }
}
