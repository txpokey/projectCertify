package hello.gorm.domain

import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic

@CompileStatic
@Entity
//@Table(name="PRIMES_RX")
class Primes{
    Long id
    Integer prime
    Boolean truth
    String species
    String toString() { "[${species}, ${prime}, ${truth}]"}
}
