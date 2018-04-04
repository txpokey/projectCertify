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
 /*
  ****************************** TESTING ******************************
  */
    @DataProvider
    public final Object[][] getAllEnumTypesBeingTested() {
        return new Object[][]{{AllDefaultValues.class}, {DefineEnumValuesExample.class}};
    }

    @Test(dataProvider = "getAllEnumTypesBeingTested")
    public <E extends Enum> void applyStaticPeekOverEntireEnumType(Class<E> enumTypeAsInput) {
        log.debug("ENTER");
        applyConsumerToEntireEnumConvertedToStream(enumTypeAsInput, ExploreEnumTest::peek);
        log.debug("LEAVE");
    }


    @Test(dataProvider = "getAllEnumTypesBeingTested")
    public <E extends Enum> void applyInstanceMethodInspectOverEntireEnumType(Class<E> enumTypeAsInput) {
        /*
         * inspectorFunction as a work around :
         * once I added @DataProviders I could no longer use Inspector::inspect as Consumer<E> in forEachOrdered()
         *     cf. exampleUsingInspectorInspect()
         */
        final Consumer<E> inspectorFunction = e -> ((Inspector<E>) e).inspect() ;
        log.debug("ENTER");
        applyConsumerToEntireEnumConvertedToStream(enumTypeAsInput, inspectorFunction);
        log.debug("LEAVE");
    }

    public <E extends Enum> void exampleUsingInspectorInspect() {
        log.debug("ENTER");
        applyConsumerToEntireEnumConvertedToStream(AllDefaultValues.class, Inspector::inspect);
        applyConsumerToEntireEnumConvertedToStream(DefineEnumValuesExample.class, Inspector::inspect);
        log.debug("LEAVE");
    }
    /*
     ****************************** CONVENIENCE ******************************
     */
    private static <E extends Enum> void peek(E element) {
        log.debug("name:> " + element.name());
        log.debug("toString:> " + element.toString());
        log.debug("ordinal:> " + element.ordinal());
    }

    private static <E extends Enum> void applyConsumerToEntireEnumConvertedToStream(@Nonnull Class<E> enumTypeAsInput,
                                                                                    @Nonnull Consumer<E> function) {
        expressEnumTypeAsStream(enumTypeAsInput).forEachOrdered(function);
    }

    private static <E extends Enum> Stream<E> expressEnumTypeAsStream(@Nonnull Class<E> enumTypeAsInput) {
        return Arrays.stream(enumTypeAsInput.getEnumConstants());
    }

}
