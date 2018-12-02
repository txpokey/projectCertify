package sci.category.certify.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Primes{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    Integer prime
    Boolean truth

}