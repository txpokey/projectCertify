package edu.javial.cert.se.oop.generics.ora;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 * BOOYA is explores rare case generics with static keyword. class is dual to Algorithm in oraTutorialQuestion_2()
 */
class BOOYA<T> {
    public static <T extends Comparable<T>> T max(T x, T y) { // BUT: no static members 4 inner classes
        return 0 < x.compareTo(y) ? x : y;
    }
    public final List<T> list = new ArrayList<>(); // SX: cant be static and use <T>
}
/**
 * Oracle Java8 Tutorial on Generics has a lot of code and test questions. This entire package is for exploring those
 * lessons and looking for work arounds to problems that were posited.
 */
public class ExploreGenericFromOracleTutorialTest {
    private static Log log = LogFactory.getLog(ExploreGenericFromOracleTutorialTest.class);

    @Test
    public void oraTutorialQuestion_2 () {
        /*
        public final class Algorithm {
            public static <T> T max(T x, T y) {
                return x > y ? x : y;  // COMPILE: T is always an Object and '>' terminal is primitive
            }
        }
         */

        final class Algorithm {
            public <T extends Comparable<T>> T max(T x, T y) { // BUT: no static members 4 inner classes
                return 0 < x.compareTo(y) ? x : y;
            }
        }
        Algorithm sut = new Algorithm();
        Integer ai = BOOYA.max(1,2) ;  // just to show BOOYA has a static involving Type Parameter
        assert ai.equals(2);
        String as = sut.max("1","2") ;
        assert as.equals("2");
        as = sut.max("2","1") ;
        assert as.equals("2");
        Double ad = sut.max( 2.0 , 1.0);
        assert ad.equals(2.0);
        log.debug("");
    }
    @Test
    public void oraTutorialQuestion_10() {
        class Shape { /* ... */ }
        class Circle extends Shape { /* ... */ }

        class Node<T> { T t; /* ... */ }
        Node<Circle> nc = new Node<>();
        Node<Shape>  ns = new Node<>(); // = nc;  // COMPILE: Node<Shape> !~ Node<Circle>
        Node<? extends Shape> dummy = new Node<>() ;

        Class c_nw = dummy.getClass() ;
        Class c_nc = nc.getClass() ;
        Class c_ns = ns.getClass() ;
        assert c_nw.equals(c_nc);
        assert c_nw.equals(c_ns);
        dummy = ns ;
        dummy = nc ;

        log.debug("");
    }
    @Test(expectedExceptions = ClassCastException.class)
    public void oraTutorialQuestion_11 () {
        class Node<T> implements Comparable<T> {
            public int compareTo(@Nonnull T obj) { /* ... */ return 0 ;}
            // ...
        }
        Node<String> node = new Node<>();
        Comparable<String> comp = "1";
        Comparable compRaw = node ;
        compRaw = 1 ; // AUTOBOX
        final int i = compRaw.compareTo(comp); // THROWS : ClassCastException
        assert false ; // NOTREACHED
        log.debug("i:> " + i );
    }

    @Test
    public void oraTutorialExerciseWildCardErrorBad() {

        class Tuple<T extends Number>  {
            List<T> left , right ;
            Tuple( List<T> left, List<T> right) {
                this.left = left ; this. right = right;
            }
        }

        class WildcardErrorBad<T extends Number> {

/*
        .............. original problem .......................
            void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
                Number temp = l1.get(0);
                l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
                // got a CAP#2 extends Number;
                // same bound, but different types
                l2.set(0, temp);	    // expected a CAP#1 extends Number,
                // got a Number
            }
 */

            void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
                List<T> left = rewrap(l1) ;
                List<T> right = rewrap(l2) ;
                swapFirstHelper( left , right ) ;
                l1 = left;
                log.debug("");
            }
            Tuple swapFirst(Tuple in) {
                List<T> left = rewrap(in.left) ;
                List<T> right = rewrap(in.right) ;
                swapFirstHelper( left , right ) ;
                Tuple candidate = new Tuple(left,right) ;
                return candidate ;
            }
            Tuple swapFirst0(Tuple in) {
                swapFirstHelper( in.left , in.right ) ; // THROWS: ArrayStoreException: java.lang.Double
                Tuple candidate = in ; //  new Tuple(left,right) ;
                return candidate ;
            }
            private List<T> rewrap( List<? extends Number> in) {
                List<T> candidate = new ArrayList<>();
                candidate.addAll((Collection<T>) in);
                return candidate;
            }
            private void swapFirstHelper( List<T> left , List<T> right) {
                T temp = left.get(0) ;
                left.set(0, (T) right.get(0));
                right.set(0,(T) temp);
            }
            private Tuple<T> doIt( List<T> left , List<T> right ) {
                Tuple<T> candidate = swapFirst(new Tuple( left, right));
                swapFirst( left , right ) ;
                return candidate ;
            }
        }
        WildcardErrorBad SUT =  new WildcardErrorBad();

        List<Integer> li = Arrays.asList(1, 2, 3);
        List<Double>  ld = Arrays.asList(10.10, 20.20, 30.30);
        SUT.doIt(li, ld); // TODO : test the swap

        List<? extends Number> liT = li ;
        List<? extends Number> ldT = ld ;
        SUT.doIt(liT, ldT); // TODO : test the swap

    }
}
