package sci.category.certify.repo

import domain.PrimesRx
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface PrimesContentRepoRx {

//    Mono<Primes> save( Primes p )

}

@Repository
interface PrimesContentRepoUsingRxMongo extends PrimesContentRepoRx, ReactiveMongoRepository<PrimesRx,Long>{}
