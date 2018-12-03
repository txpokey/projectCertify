package sci.category.certify.rx.repo

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes

interface PrimesContentRepoRx {

//    Mono<Primes> save( Primes p )

}

@Repository
interface PrimesContentRepoUsingRxMongo extends PrimesContentRepoRx, ReactiveMongoRepository<Primes,Long>{}
