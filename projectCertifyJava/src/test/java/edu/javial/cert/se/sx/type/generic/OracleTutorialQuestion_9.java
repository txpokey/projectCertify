package edu.javial.cert.se.sx.type.generic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

public class OracleTutorialQuestion_9<T> {
    private static Log log = LogFactory.getLog(OracleTutorialQuestion_9.class);

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

    public T getInstance() { // this code is nonsense
        if (instance == null)
            instance = (T) new OracleTutorialQuestion_9<T>();
        return instance;
    }
    private T instance = null;
}
//
//class OracleTutorialQuestion_9_Refactored<T> {
//    private static Log log = LogFactory.getLog(OracleTutorialQuestion_9.class);
////
////    private static HashMap instance ;
////
////    public T getInstance() {
////        return (null == instance) ? newInstance() : (T) instance.get(0) ;
////    }
////    private synchronized T newInstance() {
////    }
//    public T getInstance() {
//        return new T() ;
//    }
//}