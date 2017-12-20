package javial.cert.sx.override;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void testMain() throws Exception {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        Cat.testClassMethod();
        myAnimal.testInstanceMethod();
        ((Cat) myAnimal).testInstanceSymmetryBreakMethod("cast to Cat");
        myCat.testInstanceSymmetryBreakMethod("myCat");
    }
}