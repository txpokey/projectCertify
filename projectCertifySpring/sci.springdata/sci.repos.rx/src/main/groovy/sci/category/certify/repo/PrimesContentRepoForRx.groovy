package sci.category.certify.repo

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.Primes
import sci.category.certify.repo.rx.PrimesRxRepoContract

@Repository
interface PrimesUsingRxRepoContractMongo extends PrimesRxRepoContract, ReactiveMongoRepository<Primes,Long>{}
