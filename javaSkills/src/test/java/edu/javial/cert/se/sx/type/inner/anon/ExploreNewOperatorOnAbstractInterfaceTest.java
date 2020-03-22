package edu.javial.cert.se.sx.type.inner.anon;

import org.testng.annotations.Test;

@Test
public class ExploreNewOperatorOnAbstractInterfaceTest {

    abstract class ExampleAbstractClass {

        boolean isUniverseExist() {
            return false ;
        }
    }
    interface UniverseExistsOrNot {
        boolean isUniverseExist() ;
    }

    public void examineInnerClassFromAbstract() {

        ExampleAbstractClass exampleAbstractClass = new ExampleAbstractClass() {

            @Override
            boolean isUniverseExist() {
                return true ;
            }
        };

        assert exampleAbstractClass.isUniverseExist() ;

    }
    public void examineInnerClassFromInterface() {

        UniverseExistsOrNot universeExistsOrNot = new UniverseExistsOrNot() {

            @Override
            public boolean isUniverseExist() {
                return true;
            }
        };

        assert universeExistsOrNot.isUniverseExist() ;

    }
    public void examineInnerClassFromLambda() {

        UniverseExistsOrNot universeExistsOrNot = () -> true;

        assert universeExistsOrNot.isUniverseExist() ;

    }
}
