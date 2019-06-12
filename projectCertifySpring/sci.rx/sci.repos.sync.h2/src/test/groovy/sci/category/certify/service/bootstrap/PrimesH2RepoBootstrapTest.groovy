package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class PrimesH2RepoBootstrapTest extends PrimesSynchronousReposBootstrapTest {

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
