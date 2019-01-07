package sci.category.certify.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesRepoContract

interface PrimesRepoContract extends PrimesContentRepo {

    Primes save(Primes p )

}
@Repository
interface PrimesRepoContractForH2 extends PrimesRepoContract, JpaRepository<Primes,Long>{}