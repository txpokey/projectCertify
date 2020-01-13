package sci.spring.certify.sci.injection.cfg;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

@Slf4j
@Test
@SpringBootTest
public class InjectedFromYmlTest  extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("myClients")
    String[] clientArray ;

    public void sanityCheck() {
        assertNotNull(clientArray);
    }
}