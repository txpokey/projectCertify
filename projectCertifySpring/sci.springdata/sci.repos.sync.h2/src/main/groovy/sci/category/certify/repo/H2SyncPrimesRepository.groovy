package sci.category.certify.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes


@Repository
interface H2SyncPrimesRepository extends PrimesRepositoryContract , JpaRepository<Primes,Long> {
//    def species = "H2-sync"
}
