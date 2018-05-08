package edu.javial.cert.se.oop.functional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * has Function, BiFunction, Consumer, BiConsumer, GroupingBy, Collectors.mapping examples
 */
@Test
public class ExploreBiFunctionalTypesUsingStackOverflowProblem {
    private static Log log = LogFactory.getLog(ExploreBiFunctionalTypesUsingStackOverflowProblem.class);

    // https://stackoverflow.com/questions/26340688/group-by-and-sum-objects-like-in-sql-with-java-lambdas/26346574#26346574
    class Foo {
        public int getId() {
            return id;
        }

        //            id:int / name;String / targetCost:double / actualCost:double
        int id;
        String name;

        public double getTargetCost() {
            return targetCost;
        }

        double targetCost;
        double actualCost;

        Foo(int id, String name, double targetCost, double actualCost) {
            this.id = id;
            this.name = name;
            this.targetCost = targetCost;
            this.actualCost = actualCost;
        }

        Foo(Foo a, Foo b) {
            this(a.id, a.name,
                    a.targetCost + b.targetCost,
                    a.actualCost + b.actualCost);
        }

        public String toString() {
            return String.format("(%d,%s,%.2f,%.2f)", id, name, targetCost, actualCost);
        }
    }

    final Foo[] data = {
            new Foo(1, "P1", 300, 400),
            new Foo(2, "P2", 600, 400),
            new Foo(3, "P3", 30, 20),
            new Foo(3, "P3", 70, 20),
            new Foo(1, "P1", 360, 40),
            new Foo(4, "P4", 320, 200),
            new Foo(4, "P4", 500, 900)
    };
    final BinaryOperator<Foo> fooConstructorAsBinaryOperator = (a, b) -> new Foo(a, b);
    final BinaryOperator<Foo> fooBinaryOperator = (a, b) -> new Foo(a.id, a.name, a.targetCost + b.targetCost, a.targetCost + b.actualCost);

    public void exploreStreamsCollectedToMapViaConstructorAsBinaryOperatorForMerge() {
        exploreStreamsCollectedToMapViaBinaryOperatorArgumentForMerge(fooConstructorAsBinaryOperator);
    }

    public void exploreStreamsCollectedToMapViaConstructorAsBinaryOperatorForMerge2() {
        exploreStreamsCollectedToMapViaBinaryOperatorArgumentForMerge(fooBinaryOperator);
    }
    public void exploreStreamsCollectedToMapViaBinaryOperatorArgumentForMerge(BinaryOperator<Foo> mergingOperator) {
        final Stream<Foo> stream0 = Stream.of(data);
        Collection<Foo> hv = stream0.collect(toMap(Foo::getId, Function.identity(), mergingOperator)).values();
        List<Foo> result = new ArrayList<>(hv);
        log.debug(result);
    }

    private Function<? super Map.Entry<Integer, List<Foo>>, Foo> reducingFunction = (Map.Entry<Integer, List<Foo>> in)
            -> {
        final Foo ret = in.getValue().stream().reduce(fooBinaryOperator).get();
        return ret;
    };
    public void exploreStreamsGroupedIntoMapsButCollectedByMappingWithReducingFunction() {
        final Stream<Foo> dataStream = Stream.of(data);
        final Map<Integer, List<Foo>> groupedByIdMap = dataStream.collect(Collectors.groupingBy(Foo::getId));
        final List<Foo> result = groupedByIdMap.entrySet().stream().collect(Collectors.mapping
                (reducingFunction, Collectors.toList()));
        log.debug(result);
    }

    /********************* SCIENCE EXPERIMENTS *********************************/
    public void exploreStreamsReducedByBinaryOperator() {
        final Stream<Foo> stream1 = Stream.of(data);
        Optional<Foo> justOneLeft = stream1.reduce(fooConstructorAsBinaryOperator);
        log.debug(justOneLeft);
    }

    private BiConsumer<Integer, List<Foo>> reduceBiConsumer(@Nonnull BinaryOperator<Foo> binOp, @Nonnull List<Foo>
            result) {
        BiConsumer<Integer, List<Foo>> integerListBiConsumer = (key, value) -> {
            Optional<Foo> residueForGivenKey = value.stream().reduce(binOp);
            result.add(residueForGivenKey.get());
        };
        return integerListBiConsumer;
    }

    public void exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiConsumer() {
        final Stream<Foo> stream2 = Stream.of(data);
        Map<Integer, List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        List<Foo> reductionTarget = new ArrayList<>();
        groupedByIdMap.forEach(reduceBiConsumer(fooBinaryOperator, reductionTarget));
        log.debug(reductionTarget);
    }

    final private BinaryOperator<List<Foo>> combineListsOfFooBiOperator = (foo0, foo1) -> {
        List<Foo> ret = new ArrayList<>();
        ret.addAll(foo0);
        ret.addAll(foo1);
        return ret;
    };

    public void exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiFunctionUsingBiConsumerInnerClass() {
        final Stream<Foo> stream2 = Stream.of(data);

        Map<Integer, List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        final Stream<Map<Integer, List<Foo>>> mapStream = Stream.of(groupedByIdMap);
        BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunction = (List<Foo> result, Map<Integer, List<Foo>> in) -> {
            List<Foo> ret = result;
            in.entrySet().forEach(
                    new Consumer<Map.Entry<Integer, List<Foo>>>() {
                        @Override
                        public void accept(Map.Entry<Integer, List<Foo>> integerListEntry) {
                            final Optional<Foo> fooOptional = integerListEntry.getValue().stream().reduce(fooBinaryOperator);
                            ret.add(fooOptional.get());
                        }
                    }
            );
            return ret;
        };
        List<Foo> reductionTarget = new ArrayList<>();
        final List<Foo> reduceResult = mapStream.reduce(reductionTarget, reducingBiFunction, combineListsOfFooBiOperator);
        log.debug(reduceResult);
    }

    public void
    exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiFunctionUsingBiConsumerInnerClassConvertedToLambda() {
        final Stream<Foo> stream2 = Stream.of(data);

        Map<Integer, List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        final Stream<Map<Integer, List<Foo>>> mapStream = Stream.of(groupedByIdMap);
        BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunction = (List<Foo> result,
                                                                                                Map<Integer, List<Foo>> in) -> {
            List<Foo> ret = result;
            in.entrySet().forEach(
                    integerListEntry -> {
                        final Optional<Foo> fooOptional = integerListEntry.getValue().stream().reduce(fooBinaryOperator);
                        ret.add(fooOptional.get());
                    }
            );
            return ret;
        };
        List<Foo> reductionTarget = new ArrayList<>();
        final List<Foo> reduceResult = mapStream.reduce(reductionTarget, reducingBiFunction, combineListsOfFooBiOperator);
        log.debug(reduceResult);
    }

    /***************************** BIFUNCTION EXAMPLES **************************************/

    BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunctionAlaMapToCollect =
            (List<Foo> result, Map<Integer, List<Foo>> in) -> {
                List<Foo> candidate = in.entrySet().stream().map( integerListEntry -> reducingFunction.apply(
                        integerListEntry ))
                        .collect(toList());
                result.addAll(candidate);
                return result;
            };
    BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunctionAlaCollectorMapping =
            (List<Foo> result, Map<Integer, List<Foo>> in) -> {
                List<Foo> candidate = in.entrySet().stream().collect(Collectors.mapping(reducingFunction, Collectors
                        .toList()));
                result.addAll(candidate);
                return result;
            };
    BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunctionWithForEach =
            (List<Foo> result, Map<Integer, List<Foo>> in) -> {
                in.entrySet().forEach(
                        getEntryConsumer(result)
                );
                return result;
            };
    public void exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiFunctionUsingBiConsumer() {
        exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiFunctionUsingBiConsumer(reducingBiFunctionAlaMapToCollect) ;
        exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiFunctionUsingBiConsumer(reducingBiFunctionAlaCollectorMapping) ;
        exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiFunctionUsingBiConsumer(reducingBiFunctionWithForEach) ;
    }
    private void exploreStreamsCollectedByGroupingOverIdsThenReducedViaBiFunctionUsingBiConsumer(BiFunction<List<Foo>,
            ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunction) {

        final Stream<Foo> stream2 = Stream.of(data);

        Map<Integer, List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        final Stream<Map<Integer, List<Foo>>> mapStream = Stream.of(groupedByIdMap);

        List<Foo> reductionTarget = new ArrayList<>();
        final List<Foo> reduceResult = mapStream.reduce(reductionTarget, reducingBiFunction, combineListsOfFooBiOperator);
        log.debug(reduceResult);
    }
    /***************************** CONSUMER EXAMPLES **************************************/

    private Consumer<Map.Entry<Integer, List<Foo>>> getEntryConsumer(List<Foo> ret) {
        return integerListEntry -> {
            final Foo foo = reducingFunction.apply( integerListEntry ) ;
            ret.add(foo);
        };
    }
    private Consumer<Map.Entry<Integer, List<Foo>>> getEntryConsumerUsingReduceWithIdentity(List<Foo> ret) {
        return integerListEntry -> {
            List<Foo> tmp = integerListEntry.getValue();
            Foo patsy = tmp.get(0);
            Foo identity = new Foo(patsy.id, patsy.name, 0, 0);
            final Foo foo = integerListEntry.getValue().stream().reduce(
                    identity,
                    fooBinaryOperator);
            ret.add(foo);
        };
    }
}

