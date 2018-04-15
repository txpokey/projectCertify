package edu.javial.cert.se.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;
import java.util.*;


@Test
public class ExploringQueueMutationSemanticsTest {
    private static Log log = LogFactory.getLog(ExploringQueueMutationSemanticsTest.class);

    private static List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

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

    private void verifyWhichIsHeadOnQueueImplementation(Queue<Integer> queue) {
        assert queue.add(10);
        report(originalList, queue);
        assert queue.offer(11);
        report(originalList, queue);

        Integer fromPeek = queue.peek();
        report("fromPeek", fromPeek);
        report(originalList, queue);

        Integer fromElement = queue.element();
        report("fromElement", fromElement);
        report(originalList, queue);
        assert fromElement == fromPeek;

        Integer fromPoll = queue.poll();
        report("fromPoll", fromPoll);
        report(originalList, queue);
        assert fromElement == fromPoll;
    }

    public void test() {
        final List<Integer> referenceList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        Class<ArrayDeque> q0c = ArrayDeque.class;
        Collection<Integer> aqList = originalListFactory(referenceList);
        Queue<Integer> aq0 = queueFactory(q0c, aqList);
        verifyWhichIsHeadOnQueueImplementation(aq0);
    }

    private <T> Collection<T> originalListFactory(Collection<T> ref ) {
        final Comparable<Integer> ignoreTesterForNow = Integer::new ;
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
            e.printStackTrace();
        }
        return ret;
    }

    private static <E> String toReport(@Nonnull Collection<E> forReport) {
        return forReport.toString();
    }

    private static <E> void report(Collection<E> in, Collection<E> out) {
        log.debug("original:> " + toReport(in));
        log.debug("derived:> " + toReport(out));
    }

    private static <E> void report(@Nonnull String preface, @Nonnull E reported) {
        log.debug(preface + ":> " + reported);
    }
}
