package edu.javial.cert.se.core.string;

import org.testng.annotations.Test;
// TODO : StringExploringTest : not even really scratching the surface... UGH
@Test
public class StringExploringTest  {
    public static final boolean isCapitalized( final String s ) {
        final String UPPERCASE_REGEX = "[A-Z]" ;
        return s.substring(0,1).matches(UPPERCASE_REGEX);
    }
    public void testIsCapitalized() throws Exception {
        assert isCapitalized("A") ;
        assert false == isCapitalized("a") ;
        assert false == isCapitalized("1") ;
        assert false == isCapitalized("~") ;
        assert false == isCapitalized(" ") ;
    }

    final String EXAMPLE_STRING = "Example on Heap but is it Reused?" ;
    String ExampleOnHeapAndReUsed = EXAMPLE_STRING ;

    String ExampleWithConstructor = new String(EXAMPLE_STRING);

    public void exploreReUseFromHeap() {
        String onStack = EXAMPLE_STRING ;
        assert onStack == ExampleOnHeapAndReUsed ;
        String newOnStack = new String(EXAMPLE_STRING) ;
        assert onStack != newOnStack ;
        assert ExampleWithConstructor != newOnStack ;
    }
}