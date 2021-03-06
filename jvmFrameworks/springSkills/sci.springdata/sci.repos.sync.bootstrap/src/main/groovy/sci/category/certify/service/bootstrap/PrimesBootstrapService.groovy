package sci.category.certify.service.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import sci.category.certify.repo.PrimesServiceContract
import sci.category.certify.service.PrimesService

@Component("primesBootstrapService")
class PrimesBootstrapService implements BootstrapContract {

    @Autowired
    @Qualifier("primesService")
    PrimesServiceContract primesService


    boolean spinUp() {
        assert primesService
        def repo = primesService.primesRepoContract
        assert repo
        def species = primesService.species
        assert species
        final def all = PrimesService.getPrimesInRange(RANGE,species)

        all.each { primePreimage ->
            def primeImage = primesService.save(primePreimage)
            assert null != primeImage.id
        }
        true
    }
    private final static def RANGE = 1..100
}
