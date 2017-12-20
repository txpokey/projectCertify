package javial.cert.sx.override;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by mak on 9/25/14.
 */
public abstract class Animal {
    private static Log log = LogFactory.getLog(Animal.class);

    public static void testClassMethod() {
        final String msg = "The static method in Animal" ;
        log.info(msg);
    }
//    public void testInstanceMethod() {
//        final String msg = "The instance method:Animal> " ;
//        log.info(msg + this )  ;
//    }

    public Animal testInstanceMethod() {
        final String msg = "The instance method returning:Animal> " ;
        log.info(msg + this )  ;
        return this ;
    }

    class Dog {

    }
    public class Horse {
        // i thought you can only have one public class per page?!?!?
        // ah but this class is really Animal.Horse
    }
}
