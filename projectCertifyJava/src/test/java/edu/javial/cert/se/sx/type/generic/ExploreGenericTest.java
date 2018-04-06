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

}
