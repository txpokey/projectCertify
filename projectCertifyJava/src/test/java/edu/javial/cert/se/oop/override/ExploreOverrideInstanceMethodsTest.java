package edu.javial.cert.se.oop.override;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

// TODO : complete this idea and get these tests working
@Test
public class ExploreOverrideInstanceMethodsTest {
    private static Log log = LogFactory.getLog(ExploreOverrideInstanceMethodsTest.class);
    public static String classLevelMethod() {
        final String msg = "The static method in ExploreOverrideInstanceMethodsTest";
        return msg;
    }
    public abstract class Animal {

        private String name = null;
        private String message = null;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        protected void setMessage(String message) {
            this.message = message;
        }

        public Animal instanceLevelMethod() {
            final String msg = "The instance method returning:Animal> ";
            setMessage(msg);
            return this;
        }
    }
    public class Horse extends Animal {
        // i thought you can only have one public class per file?!?!?
        // ah but this class is really ExploreOverrideInstanceMethodsTest.Horse
        public Horse() {
            setName("Animal.Horse");
        }
    }
    public class Dog extends Animal {
        public Dog() {
            setName("Animal.Dog");
        }
    }
    public class Cat extends Animal {
        public Cat() {setName("Animal.Cat");}
        @Override // but this will of course compile without it
        public Cat instanceLevelMethod() {
            final String msg = "The instance method:Cat> ";
            setMessage(msg);
            return this;
        }
    }
    public class AlleyCat {
        public String instanceLevelMethod() {
            final String msg = "The instance method in AlleyCat:" ;
            return(msg + this)  ;
        }
    }

    public void thisNeedsCompleting() { // TODO
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
//        Animal.testClassMethod();
//        Cat.testClassMethod();
//        myAnimal.testInstanceMethod();
//        ((Cat) myAnimal).testInstanceSymmetryBreakMethod("cast to Cat");
//        myCat.testInstanceSymmetryBreakMethod("myCat");
    }
    }