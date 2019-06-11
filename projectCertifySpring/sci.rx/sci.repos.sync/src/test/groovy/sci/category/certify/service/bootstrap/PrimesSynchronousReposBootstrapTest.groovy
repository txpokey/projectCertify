package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import sci.category.certify.service.config.PrimesSynchronousReposConfigTest

@Test
@Slf4j
@SpringBootTest
class PrimesContentBootstrapTest extends PrimesSynchronousReposConfigTest {

    void sanityCheck() {
        assert primesContentBaseService
        assert primesContentBootstrap
    }
    void featureCheck() {
        sanityCheck()
        def result = primesContentBootstrap.spinUp()
        assert result
        def findAll = primesContentBaseService.primesRepoContract.findAll()
        assert findAll
    }
}
