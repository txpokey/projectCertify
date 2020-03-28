package hello.world

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic

@CompileStatic
class HelloWorldApplication{
    static void main(String[] args) {
        Micronaut.run(HelloWorldApplication)
    }
}