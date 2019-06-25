package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test
import service.bootstrap.PrimesSynchBootstrapDataServicesTest

@Test
@Slf4j
@SpringBootTest
class PrimesContentBaseServiceForH2SyncRepoTest extends PrimesSynchBootstrapDataServicesTest{

    void testSave() {
        super.testSave()
    }

    void testGetPrimesInRange() {
        super.testGetPrimesInRange()
    }

}