package sci.category.certify.service

import groovy.util.logging.Slf4j
import org.testng.annotations.Test

@Test
@Slf4j
//@SpringBootTest
//class PrimesContentBaseServiceTest extends AbstractTestNGSpringContextTests {
class PrimesContentBaseServiceTest  {

    void testSave() {
    }

    void testGetPrimesInRange() {
        final Range<Integer> range = 1..20
        def captured = PrimesContentBaseService.getPrimesInRange(range)
        captured
    }
}