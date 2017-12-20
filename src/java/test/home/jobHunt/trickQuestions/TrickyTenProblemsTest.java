package com.javial.iview.trickQuestions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrickyTenProblemsTest {

    TrickyTenProblems testUnit;

    @Before
    public void setUp() throws Exception {
        testUnit = new TrickyTenProblems();
    }

    @Test
    public void testSillyCompare() throws Exception {
        testUnit.sillyCompare();
        boolean ret = 0.1 * 3 != 0.3;
        System.out.println(ret);

        System.out.println(0.1);
        System.out.println(3f);
        System.out.println(0.1 * 3);
        System.out.println(0.1f * 3f);
        System.out.println(0.1f * 3);
        System.out.println(0.1d * 3);

        assert ret;
//        true
//        0.1
//        3.0
//        0.30000000000000004
//        0.3
//        0.3
//        0.30000000000000004

    }

    @Test
    public void testTrickyDoubleMath() throws Exception {
        testUnit.trickyDoubleMinMath();
    }

    @Test
    public void testCharacterSetTest() throws Exception {
        testUnit.characterSetTest();
    }

    @Test
    public void testTrickyDoubleInfinityMath() throws Exception {
        testUnit.trickyDoubleInfinityMath();
    }

    @Test
    public void testTrickyCastingInteger() {
        assert (Integer) 1 == (Integer) 1;
        assert (Integer) 222 != (Integer) 222;
        Integer try0 = (Integer) 222;
        Integer try1 = (Integer) 222;
        assert try0 != try1 ;
        try0 = (Integer) 127 ;
        try1 = (Integer) 127 ;
        assert try0 == try1 ;
        try0 = (Integer) 128 ;
        try1 = (Integer) 128 ;
        assert try0 != try1 ;
        assertEquals(try0,try1);
        assert try0.equals(try1);
    }
    public void testSystemHaltExistence() {
//        System.halt(0);   // NO does not exist
        System.exit(0);
    }
    public void testRuntimeHaltExistence() {
        Runtime.getRuntime().exit(0);
        Runtime.getRuntime().halt(0);
    }
}