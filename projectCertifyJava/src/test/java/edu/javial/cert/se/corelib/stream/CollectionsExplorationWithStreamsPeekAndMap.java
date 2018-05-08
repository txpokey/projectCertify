package edu.javial.cert.se.corelib.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

@Test

public class CollectionsExplorationWithStreamsPeekAndMap {
    private static Log log = LogFactory.getLog(CollectionsExplorationWithStreamsPeekAndMap.class);

    public void mapUseCase() {
        Stream.of('a', 'b', 'c', 'd', 'e')
                .map(c -> (int)c)
                .forEach(i -> System.out.format("%d ", i));
    }
    public void mapUseCaseRefactoredForFunctionalSignatureClarity() {
        Stream<Character> characterStream = Stream.of('a', 'b', 'c', 'd', 'e');
        Function<Character, Integer> characterIntegerFunction = c -> (int) c;
        Stream<Integer> integerStream = characterStream
                .map(characterIntegerFunction);
        integerStream
                .forEach(i -> System.out.format("%d ", i));
    }
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
        return c -> (int) c;
    }

    private Consumer<Integer> getIntegerConsumerReport(String preface) {
        return c -> log.debug(preface + " map(): class of <T> :> " + c.getClass());
    }

    private Consumer<Character> getCharacterConsumerReport(String preface) {
        return c -> log.debug(preface + " map(): class of <T> :> " + c.getClass());
    }

    public void flatmapUseCase() {
        List<Character> aToD = Arrays.asList('a', 'b', 'c', 'd');
        List<Character> eToG = Arrays.asList('e', 'f', 'g');
        Stream.of(aToD, eToG)
                .flatMap(l -> l.stream())
                .map(c -> (int) c)
                .forEach(i -> System.out.format("%d ", i));
    }
    public void flatmapUseCaseRefactoredForFunctionalSignatureClarity() {
        List<Character> aToD = Arrays.asList('a', 'b', 'c', 'd');
        List<Character> eToG = Arrays.asList('e', 'f', 'g');
        Stream<List<Character>> stream = Stream.of(aToD, eToG);
        Function<List<Character>, Stream<? extends Character>> listStreamFunction = l -> l.stream();
        Stream<Character> characterStream = stream
                .flatMap(listStreamFunction);
        Function<Character, Integer> characterIntegerFunction = c -> (int) c;
        Stream<Integer> integerStream = characterStream
                .map(characterIntegerFunction);
        integerStream
                .forEach(i -> System.out.format("%d ", i));
    }

    public void Question_16_1() {
        List<String> strings =
                Arrays.asList( "Stream","Operations","on","Collections");
        Collections.sort(strings, String::compareTo);
        System.out.println(strings.get(0));
    }
    public void Question_17_1() {
        Map<Boolean, List<Integer>> map =
                Stream.of(1, 2, 3, 4)
                        .collect(partitioningBy(i -> i < 5));
        System.out.println(map);
    }

    public void Question_17_3() {
        Stream.of("aaaaa", "bbbb", "ccc")
                .map(s -> s.split(""))
                .peek(s -> System.out.println("peek> " + s[0]))
                .limit(1)
                .forEach(System.out::println);
    }

    public void Question_17_7() {
        Map<Integer, Map<Boolean, List<Integer>>> map =
                Stream.of(56, 54, 1, 31, 98, 98, 16)
                        .collect(groupingBy(
                                (Integer i) -> i % 10,
                                TreeMap::new,
                                partitioningBy((Integer i) -> i > 5)
                                )
                        );
        System.out.println(map);
    }
}
