package edu.javial.cert.se.sx.type.generic;

public class OracleTutorialQuestion_9<T> {

//    public class Singleton<T> {
//
//        public static T getInstance() {
//            if (instance == null)
//                instance = new Singleton<T>(); // COMPILE: Singleton<T> is not cast to T
//
//            return instance;
//        }
//
//        private static T instance = null; // COMPILE: can't mix static with generic
//    }

    public T getInstance() {
        if (instance == null)
            instance = (T) new OracleTutorialQuestion_9<T>();
        return instance;
    }
    private T instance = null;
}
