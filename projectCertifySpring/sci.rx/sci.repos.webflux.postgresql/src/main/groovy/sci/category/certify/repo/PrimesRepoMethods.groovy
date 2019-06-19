package sci.category.certify.repo

import reactor.core.publisher.Mono
import sci.category.certify.domain.Primes

interface PrimesRepoMethods{

    Mono<Primes> save(Primes p )

    String species

}

