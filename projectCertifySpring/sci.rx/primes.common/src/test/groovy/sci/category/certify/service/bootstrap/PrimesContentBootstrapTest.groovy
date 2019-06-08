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

//    @Autowired
//    @Qualifier("primesContentServiceUsingH2")
//    PrimesContentBaseService primesContentServiceUsingH2

    @Autowired
    @Qualifier("primesContentBootstrap")
    PrimesContentBootstrap primesContentBootstrap


    void sanityCheck() {
//        assert primesContentServiceUsingH2
        assert primesContentBootstrap
        log.debug("")
    }
    void featureCheck() {
        sanityCheck()
        def result = primesContentBootstrap.spinUp()
        result
        log.debug("")
    }
}

//    @Bean("bootstrapTool")
//    BootstrapDataService getBootstreapBean() {
//        def spinner = new BootstrapDataService()
//    }
