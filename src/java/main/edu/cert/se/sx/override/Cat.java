package javial.cert.sx.override;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by mak on 9/25/14.
 */
 class Cat extends Animal {
    private static Log log = LogFactory.getLog(Animal.class);

    //    @Override // this will NOT compile
    public static void testClassMethod() {
        final String msg = "The static method in Cat" ;
        log.info(msg)  ;
    }
//
//    @Override // but this will of course compile without it
//    public Animal testInstanceMethod() {
//        final String msg = "The instance method:Cat> " ;
//        log.info(msg + this )  ;
//        return this ;
//    }
    @Override // but this will of course compile without it
    public Cat testInstanceMethod() {
        final String msg = "The instance method:Cat> " ;
        log.info(msg + this )  ;
        return this ;
    }
    public void testInstanceSymmetryBreakMethod(String tok) {
        final String msg = "The instance SymmetryBreak method in Cat:" ;
        log.info(msg + tok)  ;
    }

    class Dog {
        public void testInstanceMethod() {
            final String msg = "The instance lmethod in Dog:" ;
            log.info(msg + this)  ;
        }
    }
    public class Horse {
        // i thought you can only have one public class per page?!?!?
        // ah but this class is really Animal.Horse
    }
}