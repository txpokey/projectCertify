package sci.spring.rest.template.maps.cfg;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Slf4j
@Test
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RestTemplateCfgTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TestRestTemplate testRestTemplate;

    public void sanityCheck() {
        logger.debug("PING! from sanity check");
        assert null != restTemplate;
        assert null != testRestTemplate;
    }
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public TestRestTemplate getTestRestTemplate() {
        return testRestTemplate;
    }
}