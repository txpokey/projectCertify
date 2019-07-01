package sci.category.certify.service.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import reactor.test.StepVerifier
import sci.category.certify.repo.PrimesRxServiceContract
import sci.category.certify.service.PrimesRxService

@Component("primesBootstrapService")
class PrimesRxBootstrapService implements BootstrapContract {

    @Autowired
    @Qualifier("primesService")
    PrimesRxServiceContract primesService


    boolean spinUp() {
        assert primesService
        def repo = primesService.primesRepoContract
        assert repo
        def species = primesService.species
        assert species
        final def all = PrimesRxService.getPrimesInRange(RANGE,species)

        def incomingFlux = primesService.saveAll(all).log()
        StepVerifier
                .create(incomingFlux)
                .expectNextCount(all.size())
                .verifyComplete()
        true
    }
    private final static def RANGE = 1..100
}
