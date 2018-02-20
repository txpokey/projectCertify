package edu.javial.cert.se.oop.override;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by mak on 9/25/14.
 */
public abstract class Animal {
    private static Log log = LogFactory.getLog(Animal.class);
    private String name_ = null;

    protected void setName(String name) {
        name_ = name;
    }
    protected String getName() {
        return name_;
    }

    public static String classLevelMethod() {
        final String msg = "The static method in Animal";
        return msg;
    }

    public Animal instanceLevelMethod() {
        final String msg = "The instance method returning:Animal> ";
        return this;
    }

    public class Dog {
        public Dog() {
            setName("Animal.Dog") ;
        }
    }

    public class Horse {
        // i thought you can only have one public class per file?!?!?
        // ah but this class is really Animal.Horse
        public Horse() {
            setName("Animal.Horse") ;
        }
    }
}