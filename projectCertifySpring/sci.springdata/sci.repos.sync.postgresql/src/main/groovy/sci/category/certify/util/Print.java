package sci.category.certify.util;

import java.util.function.Consumer;

public class Print {

//    public static Object foo = null ;
//
//    void makeItUp() {
//        List<String> list = Arrays.asList( "One" , "Two") ;
//        list.stream().forEach(getPrintln());
//    }

    public static Consumer<String> getPrintln() {
        return System.out::println;
    }
}
