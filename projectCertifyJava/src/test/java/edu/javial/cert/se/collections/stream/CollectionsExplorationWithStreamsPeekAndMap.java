package edu.javial.cert.se.collections.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@Test

public class CollectionsExplorationWithStreamsPeekAndMap {
    private static Log log = LogFactory.getLog(CollectionsExplorationWithStreamsPeekAndMap.class);

/**
 * EH Book Ch 17 : fact checking claim about map seeing List<T> instead of <T> on the stream
 * plus confirming that map() signature is : "<R> Stream<R> map(Function<? super T, ? extends R> var1)"
 */

    public void discoverTypePedigreeFlowingThroughStreamOfCharacters() {
        getStreamOfCharactersAsTestData()
                .peek(getCharacterConsumerReport("before"))
                .map(getCharacter2IntegerFunction())
                .peek(getIntegerConsumerReport("after"))
                .forEach(i -> System.out.format("%d ", i));
    }

    private Stream<Character> getStreamOfCharactersAsTestData() {
        return Stream.of('a', 'b', 'c', 'd', 'e');
    }

    private Function<Character, Integer> getCharacter2IntegerFunction() {
        return c -> (int)c;
    }

    private Consumer<Integer> getIntegerConsumerReport(String preface) {
        return c -> log.debug(preface + " map(): class of <T> :> " + c.getClass());
    }

    private Consumer<Character> getCharacterConsumerReport(String preface) {
        return c -> log.debug(preface + " map(): class of <T> :> " + c.getClass());
    }
}
