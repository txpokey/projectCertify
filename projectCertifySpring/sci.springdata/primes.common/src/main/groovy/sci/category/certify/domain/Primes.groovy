package sci.category.certify.domain

import javax.annotation.Nonnull


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

//import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Entity
//@Document
class Primes{ // TODO: need to adopt features from the webflux version of Primes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    Integer prime
    Boolean truth
    String species
    String toString() { "[${species}, ${prime}, ${truth}]"}
    static Primes of(@Nonnull Integer p, String species = "TBD") {
        def primeAsMap = [ prime: p , species: species ]
        def primeRx = new Primes(primeAsMap)
        primeRx
    }
}
