package edu.javial.cert.se.oop.override;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by mak on 9/25/14.
 */
public class Cat extends Animal {
    private static Log log = LogFactory.getLog(Cat.class);
    public Cat() {
        setName("Animal.Cat") ;
    }
//    @Override // DEBUG : barking about this method not really an override?
    public static String classLevelMethod() {
        final String msg = "The static method in Cat" ;
        return msg ;
    }
    @Override // but this will of course compile without it
    public Cat instanceLevelMethod() {
        final String msg = "The instance method:Cat> " ;
        return this ;
    }
//    public String instanceSymmetryBreakMethod(String tok) {
//        final String msg = "The instance SymmetryBreak method in Cat:> " ;
//        return(msg + tok)  ;
//    }

    public class AlleyCat {
        public String instanceLevelMethod() {
            final String msg = "The instance method in AlleyCat:" ;
            return(msg + this)  ;
        }
    }
}