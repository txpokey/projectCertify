package edu.javial.cert.se.corelib.threading;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Test
public class ExploreUseOfAtomicIntegerTest {
    private static Log log = LogFactory.getLog(ExploreUseOfAtomicIntegerTest.class);

    static AtomicInteger n = new AtomicInteger(0);

    static void add() {
        System.out.println(n.incrementAndGet());
    }
    static void addWithLogger() {
        log.debug(n.incrementAndGet()); // significant performance hit, sometimes the message never gets time to run.
    }

    public void doit()
    {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Runnable r = () -> add();
        for (int i = 0; i < 4; i++) {
            service.execute(r);
        }
        service.shutdown();
    }
}
