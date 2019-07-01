package sci.category.certify.repo

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sci.category.certify.domain.PrimesRx

interface PrimesRxServiceContract{

    Mono<PrimesRx> save(PrimesRx p )
    Flux<PrimesRx> saveAll(List<PrimesRx> plist )
    String getSpecies()
}

