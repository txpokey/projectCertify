package edu.javial.cert.se.corelib.string;

import org.testng.annotations.Test;

@Test
public class StringExploringTest  {
    public static final boolean isCapitalized( final String s ) {
        final String UPPERCASE_REGEX = "[A-Z]" ;
        return s.substring(0,1).matches(UPPERCASE_REGEX);
    }
    @Test
    public void testIsCapitalized() throws Exception {
        assert isCapitalized("A") ;
        assert false == isCapitalized("a") ;
        assert false == isCapitalized("1") ;
        assert false == isCapitalized("~") ;
        assert false == isCapitalized(" ") ;
    }
}