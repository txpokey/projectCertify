package sci.category.certify.rx.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes


interface PrimesContentRepo {

    Primes save( Primes p )

}
@Repository
interface PrimesContentRepoForH2 extends PrimesContentRepo, JpaRepository<Primes,Long>{}
