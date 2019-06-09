package sci.category.certify.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes


interface PrimesSynchronousRepoMethods{

    Primes save( Primes p )

}
@Repository
interface PrimesRepoForH2 extends PrimesSynchronousRepoMethods, JpaRepository<Primes,Long>{}
