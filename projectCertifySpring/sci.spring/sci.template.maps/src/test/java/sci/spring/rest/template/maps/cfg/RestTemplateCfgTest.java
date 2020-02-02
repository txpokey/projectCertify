package sci.spring.rest.template.maps.cfg;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

@Slf4j
@Test
@SpringBootTest
public class RestTemplateCfgTest extends AbstractTestNGSpringContextTests {

//    @Autowired
//    private RestTemplate restTemplate ;
    public void testRestTemplate() {
        logger.debug("PING!");
        assert null != "" ;
    }
}