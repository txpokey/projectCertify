package sci.category.certify.domain

import org.springframework.lang.NonNull

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

//import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Entity
//@Document
class Primes{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    Integer prime
    Boolean truth
    String species
    String toString() { "[${prime},${species}]"}
    static Primes of(@NonNull Integer p, String species = "TBD") {
        def primeAsMap = [ prime: p , species: species ]
        def primeRx = new Primes(primeAsMap)
        primeRx
    }
}
