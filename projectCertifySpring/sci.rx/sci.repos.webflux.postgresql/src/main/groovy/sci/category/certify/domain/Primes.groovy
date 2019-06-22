package sci.category.certify.domain

import org.springframework.lang.NonNull

//import javax.persistence.Entity
//import javax.persistence.GeneratedValue
//import javax.persistence.GenerationType
//import javax.persistence.Id

//import org.springframework.data.mongodb.core.mapping.Document
//@Entity
//@Document
class Primes{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    Integer prime
    Boolean truth
    String species
    String toString() { "[${species}, ${prime}, ${truth}]"}
    static Primes of(@NonNull Integer p, @NonNull Boolean truth, @NonNull String species = "TBD") {
        def primeAsMap = [ prime: p , truth: truth , species: species ]
        def primeRx = new Primes(primeAsMap)
        primeRx
    }
}
