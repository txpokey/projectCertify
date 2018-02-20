package edu.javial.cert.se.sx.override;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

//import static org.junit.Assert.*;

public class CatTest {
    private static Log log = LogFactory.getLog(CatTest.class);

    @Test
    public void testMain() throws Exception { // TODO
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
//        Animal.testClassMethod();
//        Cat.testClassMethod();
//        myAnimal.testInstanceMethod();
//        ((Cat) myAnimal).testInstanceSymmetryBreakMethod("cast to Cat");
//        myCat.testInstanceSymmetryBreakMethod("myCat");
    }
}