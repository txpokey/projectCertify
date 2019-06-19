package sci.category.certify.repo

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

//import org.springframework.data.repository.reactive.ReactiveSortingRepository
import sci.category.certify.domain.Primes

@Repository
interface PrimesWebfluxRepoPostgreSql
        extends PrimesRepoMethods,
                R2dbcRepository<Primes, String>{
    def species = "postgres"
}
