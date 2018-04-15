package edu.javial.cert.se.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@Test
public class ExploringQueueMutationSemanticsTest {
    private static Log log = LogFactory.getLog(ExploringQueueMutationSemanticsTest.class);

    private static List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    public void test() {
        final List<Integer> referenceList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        final Class[] fodder = { ArrayDeque.class , PriorityQueue.class} ;
        for( Class c : fodder ) {
            Collection<Integer> dup = originalListFactory(referenceList);
            Queue<Integer> q = queueFactory(c, dup);
            verifyWhichIsHeadOnQueueImplementation(q);
        }
    }
    private void verifyWhichIsHeadOnQueueImplementation(@Nonnull Queue<Integer> queue) {
        assert queue.add(10);
        report(queue);
        assert queue.offer(11);
        report(queue);

        Integer fromPeek = queue.peek();
        report("fromPeek", fromPeek);
        report(queue);

        Integer fromElement = queue.element();
        report("fromElement", fromElement);
        report(queue);
        assert fromElement == fromPeek;

        Integer fromPoll = queue.poll();
        report("fromPoll", fromPoll);
        report(queue);
        log.info(queue.toString());
        assert fromElement == fromPoll;
    }

    private Function<Integer,Integer> cloningMapper = integer -> {
        Integer candidate = new Integer( integer.intValue() ) ; // just integer.intValue() will not cause clone!
        return candidate ;
    };

    private <T> Collection<T> originalListFactory(@Nonnull Collection<T> ref ) {
        Collection<T> deep = originalListFactory(ref, (Function<T, T>) cloningMapper);
        return deep ;
    }

    /*
     * deep copy implementation
     */
    private <T> Collection<T> originalListFactory(@Nonnull Collection<T> ref , @Nonnull Function<T,T> mapper ) {
        Collection<T> deep = ref.stream().map( mapper ).collect(Collectors.toList());
        return deep ;
    }
    /*
     * shallow copy implementation
     */
    @Deprecated
    private <T> Collection<T> originalListFactoryShallow(@Nonnull Collection<T> ref ) {
        Collection<T> shallow = new ArrayList<>(ref);
        return shallow ;
    }

    private <Q, T> Queue<T> queueFactory(@Nonnull Class<Q> q0c, @Nonnull Collection<T> constructArgument) {
        Queue<T> ret = null;

        try {
            Constructor<Q> cons = q0c.getConstructor(Collection.class);
            Object o = cons.newInstance(constructArgument);
            Queue<T> candidate = (Queue<T>) o;
            ret = candidate;
            log.debug("cons:>" + cons);
            log.debug("o:>" + o);
        } catch (Exception e) {
            log.fatal("factory for queues failed:> " + e );
        }
        return ret;
    }

    private static <E> String toReport(@Nonnull Collection<E> forReport) {
        return forReport.toString();
    }

    private static <E> void report(@Nonnull Collection<E> in, @Nonnull Collection<E> out) {
        log.debug("original:> " + toReport(in));
        log.debug("derived:> " + toReport(out));
    }
    private static <E> void report(@Nonnull Collection<E> out) {
        log.debug("original:> " + toReport(originalList));
        log.debug("derived:> " + toReport(out));
    }
    private static <E> void report(@Nonnull String preface, @Nonnull E reported) {
        log.debug(preface + ":> " + reported);
    }

    @Deprecated
    public void pqTest() {
        Queue<Integer> pq = queueFactory(PriorityQueue.class, originalListFactory(originalList));
        Integer fromPoll = pq.poll();
        report(originalList, pq);
        log.debug(pq);
        fromPoll = pq.poll();
        report(originalList, pq);
        log.debug(pq);
    }
    @Deprecated
    private void verifyWhichIsHeadOnQueueImplementation0(Queue<Integer> queue) {
        assert queue.add(10);
        report(originalList, queue);
        ((ArrayDeque) queue).addLast(11);
        report(originalList, queue);
        ((ArrayDeque) queue).addFirst(12);
        report(originalList, queue);
        Integer fromPop = (Integer) ((ArrayDeque) queue).pop();
        report("fromPop", fromPop);
        report(originalList, queue);
        ((ArrayDeque) queue).push(fromPop);
        report(originalList, queue);
    }
    @Deprecated
    private final Comparable<Integer> ignoreTesterForNow = Integer::new ;
}
