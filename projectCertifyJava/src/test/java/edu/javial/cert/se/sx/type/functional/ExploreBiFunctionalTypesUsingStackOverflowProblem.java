package edu.javial.cert.se.sx.type.functional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@Test
public class ExploreBiFunctionalTypesUsingStackOverflowProblem {
    private static Log log = LogFactory.getLog(ExploreBiFunctionalTypesUsingStackOverflowProblem.class);
// https://stackoverflow.com/questions/26340688/group-by-and-sum-objects-like-in-sql-with-java-lambdas/26346574#26346574
    class Foo {
        public int getId() {
            return id;
        }

        //            id:int / name;String / targetCost:double / actualCost:double
        int id ;
        String name ;

        public double getTargetCost() {
            return targetCost;
        }

        double targetCost ;
        double actualCost ;
        Foo( int id , String name , double targetCost , double actualCost ) {
            this.id = id ;
            this.name = name;
            this.targetCost = targetCost;
            this.actualCost = actualCost;
        }
        Foo( Foo a , Foo b) {
            this(a.id, a.name,
                    a.targetCost + b.targetCost,
                    a.actualCost + b.actualCost);
        }
        public String toString() {
            final String s[] = { this.id + "" , this.name + "" , this.targetCost + "" , this.actualCost + "" };
            final String j = Stream.of(s).collect(Collectors.joining(","));
            final String report = "(" + j + ")";
            return report ;
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
    } ;
    final BinaryOperator<Foo> fooConstructorAsBinaryOperator = (a, b) -> new Foo(a, b);
    final BinaryOperator<Foo> fooBinaryOperator = (a, b) -> new Foo(a.id, a.name, a.targetCost + b.targetCost, a.targetCost + b.actualCost);

    public void exploreStreamsCollectedToMapViaConstructorAsBinaryOperatorForMerge0() {

        final Stream<Foo> stream0 = Stream.of(data);
        Collection<Foo> hv = stream0.collect(toMap( Foo::getId, Function.identity(), fooConstructorAsBinaryOperator
        )).values();
        log.debug("");
    }
    public void exploreStreamsCollectedToMapViaConstructorAsBinaryOperatorForMerge() {

        final Stream<Foo> stream0 = Stream.of(data);
        Collection<Foo> hv = stream0.collect(toMap( Foo::getId, Function.identity(), fooBinaryOperator )).values();
        log.debug("");
    }
    public void exploreStreamsCollectedByMapsViaBiConsumer2() {

        final Stream<Foo> stream1 = Stream.of(data);
        Optional<Foo> justOneLeft = stream1.reduce(fooConstructorAsBinaryOperator);
        log.debug("");
    }
    private BiConsumer<Integer, List<Foo>> reduceBiConsumer(@Nonnull BinaryOperator<Foo> binOp , @Nonnull List<Foo>
            result ) {
        BiConsumer<Integer, List<Foo>> integerListBiConsumer = (key, value) -> {
            Optional<Foo> residueForGivenKey = value.stream().reduce(binOp);
            result.add(residueForGivenKey.get());
        };
        return integerListBiConsumer ;
    }
    public void exploreStreamsCollectedByMapsViaBiConsumer3() {
        final Stream<Foo> stream2  = Stream.of(data);
        Map<Integer,List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        List<Foo> result2 = new ArrayList<>();
        groupedByIdMap.forEach(reduceBiConsumer(fooBinaryOperator, result2));
        log.debug(result2);
    }
    private BiFunction<Object,? super Map<Integer,List<Foo>>,Object> myDummy;
    private BinaryOperator<Object> moreDummy;

    private void exploreStreamsCollectedByMapsViaBiConsumer4Skaffold() {
        final Stream<Foo> stream2  = Stream.of(data);

        Map<Integer,List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        final Stream<Map<Integer, List<Foo>>> mapStream = Stream.of(groupedByIdMap);
        List<Foo> dummyList = null ;
        BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> myDummy = null ;
        BinaryOperator<List<Foo>> moreDummy = null ;
        final List<Foo> reduceResult = mapStream.reduce(dummyList, myDummy, moreDummy) ;
        log.debug(reduceResult);
    }
    final private BinaryOperator<List<Foo>> combineListsOfFooBiOperator = (foo0, foo1) -> {
        List<Foo> ret = new ArrayList<>();
        ret.addAll(foo0) ;
        ret.addAll(foo1) ;
        return ret ;
    }  ;
    public void exploreStreamsCollectedByMapsViaBiConsumer4() {
        final Stream<Foo> stream2  = Stream.of(data);

        Map<Integer,List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        final Stream<Map<Integer, List<Foo>>> mapStream = Stream.of(groupedByIdMap);
        List<Foo> dummyList = new ArrayList<>();
        BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunction = (List<Foo> result, Map<Integer, List<Foo>> in ) -> {
            List<Foo> ret = new ArrayList<>() ;
            in.entrySet().forEach(
                    new Consumer<Map.Entry<Integer, List<Foo>>>() {
                        @Override
                        public void accept(Map.Entry<Integer, List<Foo>> integerListEntry) {
                            final Optional<Foo> fooOptional = integerListEntry.getValue().stream().reduce(fooBinaryOperator);
                            ret.add( fooOptional.get() );
                        }
                    }
            );
            return ret ;
        };
        final List<Foo> reduceResult = mapStream.reduce(dummyList, reducingBiFunction, combineListsOfFooBiOperator) ;
        log.debug(reduceResult);
    }
    public void exploreStreamsCollectedByMapsViaBiConsumer4L() {
        final Stream<Foo> stream2  = Stream.of(data);

        Map<Integer,List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        final Stream<Map<Integer, List<Foo>>> mapStream = Stream.of(groupedByIdMap);
        List<Foo> dummyList = new ArrayList<>();
        BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunction = (List<Foo> result,
                                                                                          Map<Integer, List<Foo>> in ) -> {
            List<Foo> ret = new ArrayList<>() ;
            in.entrySet().forEach(
                    integerListEntry -> {
                        final Optional<Foo> fooOptional = integerListEntry.getValue().stream().reduce(fooBinaryOperator);
                        ret.add( fooOptional.get() );
                    }
            );
            return ret ;
        };

        final List<Foo> reduceResult = mapStream.reduce(dummyList, reducingBiFunction, combineListsOfFooBiOperator) ;
        log.debug(reduceResult);
    }
    public void exploreStreamsCollectedByMapsViaBiConsumer5() {
        final Stream<Foo> stream2  = Stream.of(data);

        Map<Integer,List<Foo>> groupedByIdMap = stream2.collect(Collectors.groupingBy(Foo::getId));
        final Stream<Map<Integer, List<Foo>>> mapStream = Stream.of(groupedByIdMap);
        List<Foo> dummyList = new ArrayList<>();
        BiFunction<List<Foo>, ? super Map<Integer, List<Foo>>, List<Foo>> reducingBiFunction = (List<Foo> result, Map<Integer, List<Foo>> in ) -> {
            List<Foo> ret = new ArrayList<>() ;
            in.entrySet().forEach(
                    integerListEntry -> {
                        List<Foo> tmp = integerListEntry.getValue();
                        Foo patsy = tmp.get(0);
                        Foo indentity = new Foo(patsy.id, patsy.name, 0, 0);
                        final Foo foo = integerListEntry.getValue().stream().reduce(
                                indentity,
                                fooBinaryOperator);
                        ret.add(foo);
                    }
            );
            return ret ;
        };

        final List<Foo> reduceResult = mapStream.reduce(dummyList, reducingBiFunction, combineListsOfFooBiOperator) ;
        log.debug(reduceResult);
    }
}

