package edu.javial.cert.se.corelib.threading;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@Test
public class BookExploreExecutorsTest {
    private static Log log = LogFactory.getLog(BookExploreExecutorsTest.class);

    public void exploreExampleExecutorWithNonTrivialPool() {

        final List<Callable<String>> callables = new ArrayList<>();
        IntStream.rangeClosed(1, 10).forEach(
            i -> callables.add( () -> {
                        long sleeper = new Random().nextInt(1000 ) ;
                        Thread.sleep( sleeper ) ;
                        return "Callable " + i + ":" + sleeper ;
                    }
            )
        );
//
//        Collections.shuffle(callables);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<String> seeResults = new ArrayList<>();
        try {
            List<Future<String>> futures = executor.invokeAll(callables);
            for(Future<String> f : futures){
                String msg = String.format("%s - %s%n", f.get(), f.isDone());
                seeResults.add(msg);
            }
        } catch(InterruptedException | ExecutionException e) { log.debug("exception:> " + e.getMessage()); }
        log.debug("\n" + seeResults);
    }
}
