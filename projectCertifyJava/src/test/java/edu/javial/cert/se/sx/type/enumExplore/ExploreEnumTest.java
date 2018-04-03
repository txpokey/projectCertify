package edu.javial.cert.se.sx.type.enumExplore;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Test
public class ExploreEnumTest {
    private static Log log = LogFactory.getLog(ExploreEnumTest.class);

    enum AllDefaultValues implements EnumTestHarness {
        TRY0, TRY1
    }

    interface EnumTestHarness<E extends Enum> {
        default void inspectEnumObject() {
            E e = (E) this ;
            peek(e);
        }
        default void inspect() {
            inspectEnumObject();
        }
    }

    public void applyStaticPeekOverEntireEnumType() {
        log.debug("");
        applyConsumerToEntireEnumConvertedToStream(AllDefaultValues.class, ExploreEnumTest::peek);
    }
    public void applyEnumHarnessInspectorOverEntireEnumType() {
        log.debug("");
        applyConsumerToEntireEnumConvertedToStream(AllDefaultValues.class, EnumTestHarness::inspect);
    }

    private static <E extends Enum> void peek(E element) {
        log.debug("name:> " + element.name() );
        log.debug("toString:> " + element.toString() );
        log.debug("ordinal:> " + element.ordinal() );
    }
    private static <E extends Enum> void applyConsumerToEntireEnumConvertedToStream(@Nonnull Class<E> declare ,
                                                                                    @Nonnull Consumer<E> function ) {
        expressEnumTypeAsStream(declare).forEachOrdered(function);
    }
    private static <E extends Enum>  Stream<E> expressEnumTypeAsStream(@Nonnull Class<E> declare) {
        return Arrays.stream(declare.getEnumConstants()) ;
    }
}
