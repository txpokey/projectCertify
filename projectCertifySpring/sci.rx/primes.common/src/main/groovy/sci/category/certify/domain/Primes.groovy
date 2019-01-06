package sci.category.certify.domain

//import javax.persistence.Entity
//import org.springframework.data.mongodb.core.mapping.Document

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

//@Entity
//@Document
class Primes{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    Integer prime
    Boolean truth
}
