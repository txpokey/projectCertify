package sci.category.certify.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes


@Repository
interface PrimesSynchronousRepoForPostgreSql extends PrimesSynchronousRepoMethods , JpaRepository<Primes,Long> {}
