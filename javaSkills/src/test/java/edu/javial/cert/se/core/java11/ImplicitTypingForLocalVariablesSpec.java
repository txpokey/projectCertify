package edu.javial.cert.se.core.java11 ;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

// TODO where is java11 when you need it?
public class ImplicitTypingForLocalVariablesSpec {

    public void sanityCheck() {
//        var list = new ArrayList<String>();    // infers ArrayList<String>
//        var stream = list.stream();            // infers Stream<String>
//        var path = Paths.get("/dev/null");        // infers Path
//        var bytes = Files.readAllBytes(path);  // infers bytes[]
    }

}