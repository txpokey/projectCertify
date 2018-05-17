package edu.javial.cert.se.oop.generics;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * study Chapter on Generics : Herrera's book
 * https://github.com/eh3rrera/ocpj8-book
 */
@Test
public class ExploreGenericTest {

    public <T extends String> void exploreExtendsFinalType() {
        /*
        String stringStub = new String() { // COMPILE : String is 'final'
            @Override
            public int length() {
                int was = super.length();
                return -(was) ;
            }
        };
        String stringStub = new String() { }; // COMPILE : String is 'final'
*/
        class Printer<T extends String> {
            public T print(T t) {
                log.debug(t.toUpperCase());
                return (T) t.toUpperCase();
            }
        }
        Printer sut = new Printer<>();
        T candidate = (T) sut.print("hello boys!");
        assert "HELLO BOYS!".equals(candidate);
    }

    public void reviewTestQuestion6_4() {
        List<? super Number> list = new ArrayList<Object>(); // 1
        list.add(new Integer(2)); // 2
    /*
        list.add(new Object()); // 3 // COMPILE : effectively asking Object to be cast down
     */
        log.debug(list);

    }

    public void reviewTestQuestion_6_2() {
        class Question_6_2<T extends Number> {
            T t;

            public void exploreTextendsNumberAsFloat() {
                Question_6_2 q = new Question_6_2<Integer>(); // 1

                q.t = new Float(1); // 2
                log.debug(q.t);
            }

            /*
                        public void main2(String[] args) {
                            Question_6_2 q = new Question_6_2<String>(); // COMPILE : Number is not super String

                            q.t = new Float(1); // 2
                            System.out.println(q.t);
                        }
            */
            public void exploreTextendsNumberAsFloatOrBigDecimal() {
                Question_6_2 q = new Question_6_2<Integer>(); // 1

                q.t = new Float(1);
                q.t = new BigDecimal(11);
                log.debug(q.t);
            }

            public <T extends Integer> void exploreTparameterInTwoDifferentMeanings() {
                Question_6_2 q = new Question_6_2<Integer>(); // 1
                T bd;
                q.t = new Float(1);
                q.t = new BigDecimal(11);
                bd = (T) new Integer(22);
                log.debug(q.t);
            }
        }
        Question_6_2 q = new Question_6_2<Integer>(); // 1
        q.exploreTextendsNumberAsFloat();
//        q.main2(null);
        q.exploreTextendsNumberAsFloatOrBigDecimal();
        q.exploreTparameterInTwoDifferentMeanings();
    }

    private static Log log = LogFactory.getLog(ExploreGenericTest.class);

}
