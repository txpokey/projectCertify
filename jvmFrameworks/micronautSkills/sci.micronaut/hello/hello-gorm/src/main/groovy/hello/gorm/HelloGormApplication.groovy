package hello.gorm

import groovy.transform.CompileStatic
import io.micronaut.runtime.Micronaut

@CompileStatic
class HelloGormApplication{
    static void main(String[] args) {
        Micronaut.run(HelloGormApplication)
    }
}