package com.javial.iview.trickQuestions;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by mak on 4/20/15.
 */
public class TrickyTenProblems {

    public void sillyCompare() {
        boolean ret;
        if (0.1 * 3 != 0.3) {
            ret = true;
        }
        else {
            ret = false;
        }
        ret = 0.1 * 3 != 0.3 ;
        assert ret ;
    }

    public void trickyDoubleMinMath() {
        double extrema32 = Integer.MIN_VALUE ;
        double extrema64 = Double.MIN_VALUE ;
        System.out.println(Math.min(extrema64, 0.0d));
    }
    public void trickyDoubleInfinityMath() {
        double infinity = 1.0/0.0 ;
        System.out.println(infinity);
        assert infinity == Double.POSITIVE_INFINITY;
    }

    public void characterSetTest() {
        try {
            char[] chars = new char[]{'\u0097'};  // need to set the character encoding else returns  a "?"
            String str = new String(chars);
            byte[] bytes = str.getBytes();
            byte[] bytesUTF8 = str.getBytes("UTF-8"); // charsetName = "UTF-8"
            System.out.println(str);
            System.out.println(Arrays.toString(bytes));
            System.out.println(Arrays.toString(bytesUTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    class Employee {
        String name;
        int id;

        public int compareTo(Object o) {
            Employee emp = (Employee) o;
            return this.id - emp.id;
        }
    }
}
