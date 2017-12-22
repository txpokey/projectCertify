package edu.javial.cert.se.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringExploringTest extends StringExploring {

    @Test
    public void testIsCapitalized() throws Exception {
        assert isCapitalized("A") ;
        assert false == isCapitalized("a") ;
        assert false == isCapitalized("1") ;
        assert false == isCapitalized("~") ;
        assert false == isCapitalized(" ") ;
    }
}