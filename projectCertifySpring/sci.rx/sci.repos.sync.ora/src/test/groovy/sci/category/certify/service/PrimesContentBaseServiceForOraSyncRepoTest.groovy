package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.springframework.boot.test.context.SpringBootTest
import org.testng.annotations.Test

@Test
@Slf4j
@SpringBootTest
class PrimesContentBaseServiceForOraSyncRepoTest extends PrimesContentBaseServiceForSyncTest{

    void testSave() {
        super.testSave()
    }

    void testGetPrimesInRange() {
        super.testGetPrimesInRange()
    }

}