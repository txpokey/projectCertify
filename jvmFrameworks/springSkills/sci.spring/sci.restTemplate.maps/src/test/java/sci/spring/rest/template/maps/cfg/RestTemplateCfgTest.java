package sci.spring.rest.template.maps.cfg;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import sci.spring.rest.template.maps.service.FixerIoCurrencyService;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Slf4j
@Test
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RestTemplateCfgTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    protected FixerIoCurrencyService service ;
    @Autowired
    @Qualifier("currencyUrl")
    private String currencyUrl;

    public void sanityCheck() {
        logger.debug("PING! from sanity check");
        assert null != restTemplate;
        assert null != testRestTemplate;
        assert null != service;
        assert null != currencyUrl;
    }
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public TestRestTemplate getTestRestTemplate() {
        return testRestTemplate;
    }
}