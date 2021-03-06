package sci.category.certify.domain

import javax.annotation.Nonnull
import javax.persistence.*

//import org.springframework.data.mongodb.core.mapping.Document
@Entity
//@Document
@Table(name="PRIMES_RX")
class Primes{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    Integer prime
    Boolean truth
    String species
    String toString() { "[${species}, ${prime}, ${truth}]"}
    static Primes of(@Nonnull Integer p, @Nonnull Boolean truth, @Nonnull String species = "TBD") {
        def primeAsMap = [ prime: p , truth: truth , species: species ]
        def primeRx = Primes.of(primeAsMap)
        primeRx
    }
    static Primes of(@Nonnull Map map) {
        assert map.prime
        assert null != map.truth
        assert map.species
        def primeRx = new Primes(map)
        primeRx
    }
}
