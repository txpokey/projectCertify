package edu.javial.cert.se.core.threading;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * prove that futures from executor are returned in the same order as the invokeAll(arg)
 */
@Test
public class BookExploreExecutorsTestWithSlf4jLogger {
    // using log4j VERSION 1.x with the log4j.properties
    private static Logger log = LogManager.getLogger(BookExploreExecutorsTestWithSlf4jLogger.class.getName());; // V1
    final private int THREADS_USED = 3;

    @DataProvider
    private final Object[][] getCallables(){
        final List<MyCallable> callables = new ArrayList<>();
        IntStream.rangeClosed(1, 10).forEach( i -> callables.add( new MyCallable(i) ));
        return new Object[][] {
                {callables},
        };
    }

    class MyCallable implements Callable<String> {
        final private int id ;
        final private long sleeper = new Random().nextInt(1000);
        final private String payload ;

        MyCallable(int id) {
            this.id = id ;
            this.payload = "Callable " + id + ":" + sleeper ;
        }
        @Override
        public String call() throws Exception {
            Thread.sleep(sleeper);
            return payload;
        }

        private int getId() {
            return id;
        }

        String getPayload() {
            return payload;
        }
    }

    /**
     * take a random collection of callables, have them executed, and report on their order of results
     * using DataProvider ala TestNG to inject the test data into the use case test
     * @param callables test data
     */
    @Test(dataProvider = "getCallables")
    public void exploreExampleExecutorWithNonTrivialPool(@Nonnull List<MyCallable> callables) {
        Collections.shuffle(callables);
        List<Future<String>> futures = getFuturesFromExecuteCallables(callables);
        report(callables, futures);
    }

    /**
     * take the callables, execute them and return the list of futures
     * @param callables
     * @return
     */
    private List<Future<String>> getFuturesFromExecuteCallables(@Nonnull List<MyCallable> callables) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_USED );
        List<Future<String>> futures = null ;
        try {
            futures = executor.invokeAll(callables);
        } catch (InterruptedException  e) {
            log.debug("exception:> " + e.getMessage());
        }
        return futures;
    }

    /**
     * report both the callable and futures so we can compare the order of results
     * @param callables
     * @param futures
     */
    private void report(@Nonnull List<MyCallable> callables,@Nonnull List<Future<String>> futures) {
        final String callablesBanner = "notice: order of callables list:> ";
        final String resultsBanner = "notice: futures will be ordered to match the order of the callables list:> ";

        log.debug("PING!");
        log.debug(String.format("%s%n%s", callablesBanner, report(callables)));
        log.debug(String.format("%s%n%s", resultsBanner, reportFutures(futures)));
    }

    /**
     * take the callable list and convert that into a list of each payload.
     * for purpose of comparing to the order of the futures
     * @param list
     * @return
     */
    private List<String> report(@Nonnull List<MyCallable> list) {
        List<String> seeResults = new ArrayList<>();
        final Consumer<MyCallable> stringConsumer = l -> {
            String msg = String.format("%s%n", l.getPayload());
            seeResults.add(msg);
        };
        list.stream().forEach(stringConsumer);
        return seeResults;
    }

    /**
     * walk the futures and report out the outcome and the final state
     * @param futures
     * @return
     */
    private List<String> reportFutures(@Nonnull List<Future<String>> futures)  {
        List<String> seeResults = new ArrayList<>();
        final Consumer<Future<String>> futureConsumer = f -> {
            try {
                // run the methods on futures to see result data
                String msg = String.format("%s - %s%n", f.get(), f.isDone());
                seeResults.add(msg);
            } catch (InterruptedException | ExecutionException e) {
                log.debug("exception:> " + e.getMessage());
            }
        };
        futures.stream().forEach(futureConsumer);
        return seeResults;
    }

}
/*
*
2018-05-17|00:40:54 BookExploreExecutorsTest.report.70 [DEBUG] notice: order of callables list:>
[Callable 1:348
, Callable 2:541
, Callable 8:969
, Callable 9:597
, Callable 4:455
, Callable 7:995
, Callable 6:296
, Callable 3:682
, Callable 5:485
, Callable 10:864
]
2018-05-17|00:40:54 BookExploreExecutorsTest.report.71 [DEBUG] notice: futures will be ordered to match the order of the callables list:>
[Callable 1:348 - true
, Callable 2:541 - true
, Callable 8:969 - true
, Callable 9:597 - true
, Callable 4:455 - true
, Callable 7:995 - true
, Callable 6:296 - true
, Callable 3:682 - true
, Callable 5:485 - true
, Callable 10:864 - true
]

===============================================
Default Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================
*
*/