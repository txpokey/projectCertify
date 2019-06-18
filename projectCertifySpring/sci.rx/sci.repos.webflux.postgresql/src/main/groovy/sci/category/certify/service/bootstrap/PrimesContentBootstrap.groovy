package sci.category.certify.service.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import sci.category.certify.service.PrimesContentBaseService

@Component("primesContentBootstrap")
class PrimesContentBootstrap implements BootstrapContract {

    @Autowired
    @Qualifier("primesContentBaseService")
    PrimesContentBaseService primesContentBaseService


    boolean spinUp() {
        all.each { primePreimage ->
            def primeImage = primesContentBaseService.save(primePreimage)
            assert null != primeImage.id
        }
        true
    }
    private final static def RANGE = 1..100
    private final static def all = PrimesContentBaseService.getPrimesInRange(RANGE)
}
