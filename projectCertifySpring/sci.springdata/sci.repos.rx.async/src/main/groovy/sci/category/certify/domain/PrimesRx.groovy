package sci.category.certify.domain

import javax.annotation.Nonnull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

//import org.springframework.data.mongodb.core.mapping.Document
@Entity
//@Document
class PrimesRx{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    Integer prime
    Boolean truth
    String species
    String toString() { "[${species}, ${prime}, ${truth}]"}
    static PrimesRx of(@Nonnull Integer p, @Nonnull Boolean truth, @Nonnull String species = "TBD") {
        def primeAsMap = [ prime: p , truth: truth , species: species ]
        def primeRx = PrimesRx.of(primeAsMap)
        primeRx
    }
    static PrimesRx of(@Nonnull Map map) {
        assert map.prime
        assert null != map.truth
        assert map.species
        def primeRx = new PrimesRx(map)
        primeRx
    }
}
