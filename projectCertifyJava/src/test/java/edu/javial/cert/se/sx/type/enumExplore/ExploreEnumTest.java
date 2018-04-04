package edu.javial.cert.se.sx.type.enumExplore;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Test
public class ExploreEnumTest {
    private static Log log = LogFactory.getLog(ExploreEnumTest.class);

    interface Inspector<E extends Enum> {
        default void inspect() {
            E e = (E) this;
            peek(e);
        }
    }

    enum AllDefaultValues implements Inspector {
        TRY0, TRY1
    }

    enum DefineEnumValuesExample implements Inspector {
        RETRY0(10), RETRY1(-10);

        public int getValue() {
            return value;
        }

        DefineEnumValuesExample(int assign) {
            value = assign;
            asString = this.name() + "(" + this.value + ")";
        }

        public String toString() {
            return asString;
        }

        private int value;
        private String asString;

    }


    @DataProvider
    public final Object[][] getAllEnumTypesBeingTested() {
        return new Object[][]{{AllDefaultValues.class}, {DefineEnumValuesExample.class}};
    }

    @Test(dataProvider = "getAllEnumTypesBeingTested")
    public <E extends Enum> void applyStaticPeekOverEntireEnumType(Class<E> input) {
        log.debug("ENTER");
        applyConsumerToEntireEnumConvertedToStream(input, ExploreEnumTest::peek);
        log.debug("LEAVE");
    }

    @Test(dataProvider = "getAllEnumTypesBeingTested")
    public <E extends Enum> void applyInstanceMethodInspectOverEntireEnumType(Class<E> input) {
        log.debug("ENTER");
        Arrays.stream(input.getEnumConstants()).forEachOrdered(e -> ((Inspector<E>) e).inspect());
        log.debug("LEAVE");
    }

//
//    public void applyStaticPeekOverEntireEnumType0() {
//        log.debug("ENTER");
//        applyConsumerToEntireEnumConvertedToStream(AllDefaultValues.class, ExploreEnumTest::peek);
//        applyConsumerToEntireEnumConvertedToStream(DefineEnumValuesExample.class, ExploreEnumTest::peek);
//        log.debug("LEAVE");
//    }

    private static <E extends Enum> void peek(E element) {
        log.debug("name:> " + element.name());
        log.debug("toString:> " + element.toString());
        log.debug("ordinal:> " + element.ordinal());
    }

    private static <E extends Enum> void applyConsumerToEntireEnumConvertedToStream(@Nonnull Class<E> enumType,
                                                                                    @Nonnull Consumer<E> function) {
        expressEnumTypeAsStream(enumType).forEachOrdered(function);
    }

    private static <E extends Enum> Stream<E> expressEnumTypeAsStream(@Nonnull Class<E> enumType) {
        return Arrays.stream(enumType.getEnumConstants());
    }

}
