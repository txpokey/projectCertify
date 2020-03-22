package edu.javial.cert.se.core.util.compare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO  BiFunction<Computer, Computer, Integer> biff

@Test
public class ExploreComparisonObjectsTest {
    private static Log log = LogFactory.getLog(ExploreComparisonObjectsTest.class);

    public void whatDoesStringDo() {
        String[] fodder = {"foo", "bar", "foobar"};
        int c01 = fodder[0].compareTo(fodder[1]);
        int c10 = fodder[1].compareTo(fodder[0]);
        int c02 = fodder[0].compareTo(fodder[2]);
        assert ( 0 < c01 ) && ( 0 > c10 ) && ( 0 > c02 );
        log.debug("");
    }

    class Computer implements Comparable<Computer> {
        private String brand;
        private int id;

        public Computer(String brand, int id) {
            this.brand = brand;
            this.id = id;
        }

        // Let's compare first by brand and then by id
        public int compareTo(Computer other) {
            // Reusing the implementation of String
            int result = this.brand.compareTo(other.brand);

            // If the objects are equal, compare by id
            if (result == 0) {
                // Let's do the comparison "manually"
                // instead of using Integer.compareTo()
                if (this.id > other.id) result = 1;
                else if (this.id < other.id) result = -1;
                // else result = 0;
            }
            return result;
        }

        // equals and compareTo must be consistent
        // to avoid errors in some cases
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof Computer)) return false;
            return this.brand.equals(other)
                    && this.id == ((Computer) other).id;
        }

        public String toString() {
            final String s = this.brand + "-" + this.id;
            return s;
        }
    }

    public void exampleOfComparableInChapter16() {

        final Computer[] computersArray = {
                new Computer("Lenovo", 1),
                new Computer("Apple", 2),
                new Computer("Dell", 3),
                new Computer("Lenovo", 2)
        };
        Computer c1 = computersArray[0];
        Computer c2 = computersArray[1];
        Computer c3 = computersArray[2];
        Computer c4 = computersArray[3];

        // Some comparisons
        log.debug(c1.compareTo(c1)); // c1 == c1
        log.debug(c1.compareTo(c2)); // c1 > c2
        log.debug(c2.compareTo(c1)); // c2 < c1
        log.debug(c1.compareTo(c4)); // c1 < c2
        log.debug(c1.equals(c4)); // c1 != c2

        List<Computer> sorted = Stream.of(computersArray).sorted().collect(Collectors.toList());
        log.debug(Arrays.toString(sorted.toArray()));

        final BiFunction<Computer, Computer, Integer> biff = (item1, item2) -> item1.compareTo(item1);
//        Stream.of(computersArray).reduce(biff)
//        List<Integer> results = new ArrayList<>() ;
//        for( int i = 1 ; i < computersArray.length ; i++) {
//            results.add( computersArray[i-1].compareTo(computersArray[i]));
//        }
//    }
//        Stream.of(computersArray).map(biff).collect(Collectors.toList());
    }
}