package sci.category.certify.service.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import sci.category.certify.domain.Primes
import sci.category.certify.service.PrimesContentBaseService

@Component("primesContentBootstrap")
class PrimesContentBootstrap implements BootstrapContract {

    @Autowired
    private PrimesContentBaseService primesContentServiceUsingH2

    boolean spinUp() {
        all.each { mapIn ->
            def event0 = new Primes(mapIn)
            def m0 = primesContentServiceUsingH2.save(event0)
            assert null != m0.id
        }
        true
    }
    private final static def RANGE = 1..100
    private final static def all = PrimesContentBaseService.getPrimesInRange(RANGE)
}
