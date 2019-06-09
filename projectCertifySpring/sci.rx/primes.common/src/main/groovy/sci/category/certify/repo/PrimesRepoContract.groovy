package sci.category.certify.repo

import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes

@Repository
interface PrimesRepoContract {

    Primes save(Primes p )

}

