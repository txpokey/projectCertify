package hello.gorm

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic

@CompileStatic
class HelloGormApplication{
    static void main(String[] args) {
        Micronaut.run(HelloGormApplication)
    }
}