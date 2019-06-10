package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.service.PrimesContentBaseService

@Test
@Slf4j
@SpringBootTest
class PrimesContentBootstrapTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("PrimesContentBaseService")
    PrimesContentBaseService primesContentBaseService

    @Autowired
    @Qualifier("primesContentBootstrap")
    PrimesContentBootstrap primesContentBootstrap

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
