package sci.category.certify.repo

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes

//import org.springframework.data.repository.reactive.ReactiveSortingRepository
import sci.category.certify.repo.util.SqlWork

@Repository
interface PrimesWebfluxRepoPostgreSql
        extends PrimesRepoMethods,
                R2dbcRepository<Primes, String>{
    def species = "postgres"

    def LIST_USERS = SqlWork.LIST_USERS
    def LIST_USERS_PASSWORD = SqlWork.LIST_USERS_PASSWORD

//    @Query('select passwd as password_md5, from pg_shadow order by usename;')
//    Flux<String> adHocQuery()

}
