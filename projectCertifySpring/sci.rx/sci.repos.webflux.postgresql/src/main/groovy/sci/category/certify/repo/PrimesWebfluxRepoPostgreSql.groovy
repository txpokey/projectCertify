package sci.category.certify.repo

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes

@Repository
interface PrimesWebfluxRepoPostgreSql
        extends PrimesRepoMethods,
                R2dbcRepository<Primes, Long>{
    def species = "postgres"

}
