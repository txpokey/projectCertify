package hello.gorm

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@CompileStatic
class HelloGormApplication{
    static void main(String[] args) {
        Micronaut.run(HelloGormApplication)
    }
}