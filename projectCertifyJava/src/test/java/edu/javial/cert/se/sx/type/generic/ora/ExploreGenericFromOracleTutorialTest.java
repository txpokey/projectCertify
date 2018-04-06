package edu.javial.cert.se.sx.type.generic.ora;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Oracle Java8 Tutorial on Generics has a lot of code and test questions. This entire package is for exploring those
 * lessons and looking for work arounds to problems that were posited.
 */
public class ExploreGenericFromOracleTutorialTest {
    private static Log log = LogFactory.getLog(ExploreGenericFromOracleTutorialTest.class);

    public void oraTutorialQuestion_2 () {
//        public final class Algorithm {
//            public static <T> T max(T x, T y) {
//                return x > y ? x : y;  // COMPILE: T is always an Object and '>' terminal is primitive
//            }
//        }
        final class Algorithm {
            public <T extends Comparable<T>> T max(T x, T y) {
                return 0 < x.compareTo(y) ? x : y;
            }
        }
    }
    public void oraTutorialQuestion_10() {
        class Shape { /* ... */ }
        class Circle extends Shape { /* ... */ }
        class Rectangle extends Shape { /* ... */ }

        class Node<T> { /* ... */ }
        Node<Circle> nc = new Node<>();
//        Node<Shape>  ns = nc;

        class ReNode<X extends Shape> { } ;
        ReNode<Shape> rns0 = new ReNode<>() ;
//        ReNode<Shape> rns = ns ;
    }
    public void oraTutorialQuestion_11 () {
        class Node<T> implements Comparable<T> {
            public int compareTo(T obj) { /* ... */ return 0 ;}
            // ...
        }
        Node<String> node = new Node<>();
        Comparable<String> comp = node;
//        Comparable<Integer> comp1 = node;
    }

    public void oraTutorialExerciseWildCardErrorBad() {

        class Tuple<T extends Number>  {
            List<T> left , right ;
            Tuple( List<T> left, List<T> right) {
                this.left = left ; this. right = right;
            }
        }

        class WildcardErrorBad<T extends Number> {

/*
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
                log.debug("");
                l1 = left;
                log.debug("");
            }
            Tuple swapFirst(Tuple in) {
                List<T> left = rewrap(in.left) ;
                List<T> right = rewrap(in.right) ;
                swapFirstHelper( left , right ) ;
                log.debug("");
                Tuple candidate = new Tuple(left,right) ;
                log.debug("");
                return candidate ;
            }
            Tuple swapFirst0(Tuple in) {
                swapFirstHelper( in.left , in.right ) ; // FAILS: ArrayStoreException: java.lang.Double
                log.debug("");
                Tuple candidate = in ; //  new Tuple(left,right) ;
                log.debug("");
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
        SUT.doIt(li, ld);

        List<? extends Number> liT = li ;
        List<? extends Number> ldT = ld ;
        SUT.doIt(liT, ldT);

    }
}
