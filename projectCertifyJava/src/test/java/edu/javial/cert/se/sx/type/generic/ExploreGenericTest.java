package edu.javial.cert.se.sx.type.generic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Test
public class ExploreGenericTest {
    private static Log log = LogFactory.getLog(ExploreGenericTest.class);

    public <T extends String> void exploreExtendsFinalType() {
//        String stringStub = new String() { // COMPILE : String is 'final'
//            @Override
//            public int length() {
//                int was = super.length();
//                return -(was) ;
//            }
//        };
//        String stringStub = new String() { }; // COMPILE : String is 'final'

        class Printer<T extends String> {

            public T print(T t) {
                System.out.println(t.toUpperCase()); // OK!
                return (T) t.toUpperCase() ;
            }
        }
        Printer sut = new Printer<>() ;
//        char[] dummy = { 'a', 'b', 'c'} ;
        T candidate = (T) sut.print("hello boys!");
        assert "HELLO BOYS!".equals(candidate);
    }

    public void reviewTestQuestion6_4() {
        List<? super Number> list = new ArrayList<Object>(); // 1
        list.add(new Integer(2)); // 2
//        list.add(new Object()); // 3 // COMPILE : effectively asking Object to be cast down
    }

    public void reviewTestQuestion_6_2() {
        class Question_6_2 <T extends Number> {
            T t;
            public void main(String[] args) {
                Question_6_2 q = new Question_6_2<Integer>(); // 1

                q.t = new Float(1); // 2
                System.out.println(q.t);
            }
            public void main2(String[] args) {
//                Question_6_2 q = new Question_6_2<String>(); // COMPILE : Number is not super String
//
//                q.t = new Float(1); // 2
//                System.out.println(q.t);
            }
            public void main3(String[] args) {
                Question_6_2 q = new Question_6_2<Integer>(); // 1

                q.t = new Float(1);
                q.t = new BigDecimal(11);
                System.out.println(q.t);
            }
            public <T extends Integer> void main4(String[] args) {
                Question_6_2 q = new Question_6_2<Integer>(); // 1
                T bd ;
                q.t = new Float(1);
                q.t = new BigDecimal(11);
                bd = (T) new Integer(22) ;
                System.out.println(q.t);
            }
        }
        Question_6_2 q = new Question_6_2<Integer>(); // 1
        q.main(null);
        q.main2(null);
        q.main3(null);
        q.main4(null);
    }

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

        class WildcardErrorBad<T extends Number> {

//            void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
//                Number temp = l1.get(0);
//                l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
//                // got a CAP#2 extends Number;
//                // same bound, but different types
//                l2.set(0, temp);	    // expected a CAP#1 extends Number,
//                // got a Number
//            }
            void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
                List<T> left = new ArrayList<>();
//                left.addAll((Collection<? extends T>) l1); // COMPILE: OK
                left.addAll((Collection<T>) l1);
                List<T> right = new ArrayList<>();
                right.addAll((Collection<T>) l1);
                swapFirstHelper(left,right);
                swapFirstHelper( (List<T>) l1 , (List<T>) l2 ) ;
                right = (List<T>) l2 ;
                swapFirstHelper( left , right ) ;
            }
            void swapFirstHelper( List<T> left , List<T> right) {
                T temp = left.get(0) ;
                left.set(0, right.get(0));
                right.set(0,temp);
            }
//            void swapFirstHelper( List<List<? extends Number>> dummy) {
//
//            }
            void swapFirstHelper( List<Object> dummy ) {

            }
        }
        WildcardErrorBad SUT =  new WildcardErrorBad();

        List<Integer> li = Arrays.asList(1, 2, 3);
        List<Double>  ld = Arrays.asList(10.10, 20.20, 30.30);
        SUT.swapFirst(li, li);
        SUT.swapFirstHelper(li, li);
        List<? extends Number> ll = li ;
        List<? extends Number> rr = Arrays.asList(10.10, 20.20, 30.30);
        List<List<? extends Number>> wrapped = Arrays.asList(ll,rr);
        List<Object> llO = Arrays.asList(1, 2, 3);

        SUT.swapFirstHelper( wrapped ) ;
        SUT.swapFirstHelper( llO ) ;
        SUT.swapFirst(ll, ll);
        SUT.swapFirstHelper(ll, ll);
        List<Number> llT = Arrays.asList(1, 2, 3);
        List<Number> rrT = Arrays.asList(10.10, 20.20, 30.30);
        SUT.swapFirst(llT, llT);
        SUT.swapFirstHelper(llT, llT);
        List<?> llW = Arrays.asList(1, 2, 3);
        List<?> rrW = Arrays.asList(10.10, 20.20, 30.30);
        SUT.swapFirst(llW, llW);
        SUT.swapFirstHelper(llW, llW);
    }
}
