package example.hackerrank.practice;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Test
public class PracticeTry0 {
    public void findNumberTest() {
        List<Integer> list = List.of( 1 , 2, 3, 5 ) ;
        String shouldBeTrue = findNumber(list,5) ;
        String shouldBeFalse = findNumber(list,4) ;
        assert "NO".equalsIgnoreCase(shouldBeFalse)  ;
        assert "YES".equalsIgnoreCase(shouldBeTrue)  ;
        assert true ;
    }
    public void findOddTest() {
        List<Integer> inList = List.of( 1 , 2, 3, 5 ) ;
        List<Integer> oList = oddNumbers(1,5);
        assert oList.containsAll(List.of(1,3,5)) ;
    }
    public static String findNumber(List<Integer> arr, int k) {
        boolean hit = arr.contains(k) ;
        return hit ? "YES" : "NO" ;
    }
    public static List<Integer> oddNumbers(int l, int r) {
        Stream<Integer> stream = IntStream.rangeClosed(l,r).boxed();
        List<Integer> list = stream.filter( i -> 0 != i % 2 ).collect(Collectors.toList());
        return list ;
    }
}
