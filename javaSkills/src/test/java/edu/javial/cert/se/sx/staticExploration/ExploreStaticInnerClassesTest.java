package edu.javial.cert.se.sx.staticExploration;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
/**
 * testing to prove static inner classes can be created without having an outer class instance.
 * and that outer class fields are not Sx visible to the inner class
 */
public class ExploreStaticInnerClassesTest {

    public int count0 = -1 ;
    private int count1 = -1 ;
    protected int count2 = -1 ;

    static class DefineStaticInnerClass {
        private int innerCount0 = -1 ;
        boolean doesTheUniverseExist() {
            return true ;
        }
        boolean isPublic() {
            return -1 == innerCount0 ;
//            return count0 == innerCount0 ; // FAILS TO COMPILE
        }
    }

    public void testConstructorOnInnerClass() {
        ExploreStaticInnerClassesTest.DefineStaticInnerClass inner = new DefineStaticInnerClass() ;
        Assert.assertTrue( null != inner ) ;
        boolean isUniverse = inner.doesTheUniverseExist() ;
        Assert.assertTrue( isUniverse ) ;
    }
    public void testOutterFieldsVisiblityToInnerClass() {
        testConstructorOnInnerClass();
        ExploreStaticInnerClassesTest.DefineStaticInnerClass inner = new DefineStaticInnerClass() ;
        int isPublic = count0 ;
        int isPrivate = count1 ;
        int isProtected = count2 ;
        boolean isAll = count0 == count1 && count0 == count2 ;
        Assert.assertTrue( isAll ) ;
        boolean f = inner.isPublic() ;
        Assert.assertTrue( f ) ;
    }
}
