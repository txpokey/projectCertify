package sci.category.certify.service.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import sci.category.certify.service.PrimesRepositoryService

@Component("primesBootstrapService")
class PrimesBootstrapService implements BootstrapContract {

    @Autowired
    @Qualifier("primesRepositoryService")
    PrimesRepositoryService primesRepositoryService


    boolean spinUp() {
        assert primesRepositoryService
        def repo = primesRepositoryService.primesRepoContract
        assert repo
        def species = primesRepositoryService.species
        assert species
        final def all = PrimesRepositoryService.getPrimesInRange(RANGE,species)

        all.each { primePreimage ->
            def primeImage = primesRepositoryService.save(primePreimage)
            assert null != primeImage.id
        }
        true
    }
    private final static def RANGE = 1..100
//    private final static def all = PrimesRepositoryService.getPrimesInRange(RANGE)
}
