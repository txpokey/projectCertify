package edu.javial.cert.se.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;
import java.util.*;


@Test
public class ExploringQueueDirectionPragmaticsTest {
    private static Log log = LogFactory.getLog(ExploringQueueDirectionPragmaticsTest.class);

    private static List<Integer> originalList = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

    public void verifyWhichIsHeadOnQueueImplementation0() {
        Queue<Integer> queue = null ;
        queue = new ArrayDeque<>( originalList );
        assert queue.add(10);
        report( originalList , queue );
        ((ArrayDeque) queue).addLast(11);
        report( originalList , queue );
        ((ArrayDeque) queue).addFirst(12);
        report( originalList , queue );
        Integer fromPeek = queue.peek() ;
        report( "fromPeek" , fromPeek );
        report( originalList , queue );

        Integer fromElement = queue.element() ;
        report( "fromElement" , fromElement );
        report( originalList , queue );
        assert fromElement == fromPeek ;

        Integer fromPoll = queue.poll() ;
        report( "fromPoll" , fromPoll );
        report( originalList , queue );
        assert fromElement == fromPoll ;

        Integer fromPop = (Integer) ((ArrayDeque) queue).pop();
        report( "fromPop" , fromPop );
        report( originalList , queue );
        ((ArrayDeque) queue).push(fromPop) ;
        report( originalList , queue );
    }
/*    private <T,Q> void verifyWhichIsHeadOnQueueImplementation(Class<Q> qClass , List<T> originalList ) {
        Queue<Integer> queue = null ;
        queue = new ArrayDeque<>( originalList );
        assert queue.add(10);
        report( originalList , queue );
        ((ArrayDeque) queue).addLast(11);
        report( originalList , queue );
        ((ArrayDeque) queue).addFirst(12);
        report( originalList , queue );
        Integer fromPeek = queue.peek() ;
        report( "fromPeek" , fromPeek );
        report( originalList , queue );

        Integer fromElement = queue.element() ;
        report( "fromElement" , fromElement );
        report( originalList , queue );
        assert fromElement == fromPeek ;

        Integer fromPoll = queue.poll() ;
        report( "fromPoll" , fromPoll );
        report( originalList , queue );
        assert fromElement == fromPoll ;

        Integer fromPop = (Integer) ((ArrayDeque) queue).pop();
        report( "fromPop" , fromPop );
        report( originalList , queue );
        ((ArrayDeque) queue).push(fromPop) ;
        report( originalList , queue );
    }*/
    public void test() {
        Class<ArrayDeque> q0c = ArrayDeque.class ;
        try {
            Constructor<ArrayDeque> cons = q0c.getConstructor(Collection.class);
            Object o = cons.newInstance(originalList) ;
            log.debug("cons:>" + cons) ;
            log.debug("o:>" + o) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ArrayDeque<Integer> q0 = q0c.newInstance() ;
//        verifyWhichIsHeadOnQueueImplementation( )
    }
    private static <E> String toReport(@Nonnull Collection<E> forReport) {
        return forReport.toString() ;
    }

    private static <E> void report(Collection<E> in, Collection<E> out) {
        log.debug("original:> " + toReport(in));
        log.debug("derived:> "  + toReport(out));
    }
    private static <E> void report(@Nonnull String preface , @Nonnull E reported) {
        log.debug( preface + ":> "  + reported );
    }
}
