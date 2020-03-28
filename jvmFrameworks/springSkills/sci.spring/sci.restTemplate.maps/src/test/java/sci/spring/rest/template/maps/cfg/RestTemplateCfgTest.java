package sci.spring.rest.template.maps.cfg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.logging.Slf4j;
import org.spockframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import sci.spring.rest.template.maps.domain.Currency;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Slf4j
@Test
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RestTemplateCfgTest extends AbstractTestNGSpringContextTests {

    private final static String buildUrl = "http://data.fixer" +
            ".io/api/latest?access_key=3e71e8caaa61c017d627f66461436b5f&symbols=USD";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TestRestTemplate testRestTemplate;

    public void sanityCheck() {
        logger.debug("PING!");
        assert null != restTemplate;
        assert null != testRestTemplate;
    }

    public void testRestTemplate0() {
        sanityCheck();
        String json = testRestTemplate.getForObject(buildUrl, String.class);
        Currency map = null;
        final ObjectMapper mapper = new ObjectMapper();
        final TypeReference<Currency> valueTypeRef = new TypeReference<Currency>() {
        };
        try {
            //convert JSON string to Currency
            map = mapper.readValue(json, valueTypeRef);
        } catch (JsonProcessingException e) {
            final String sf1 = String.format("Exception converting '%s' to map", json);
            logger.debug(sf1, e);
        }
        Assert.notNull(map);
    }
    public void testRestTemplate() {
        sanityCheck();
        Currency currency1 = restTemplate.getForObject(buildUrl, Currency.class);
        Currency currency2 = testRestTemplate.getForObject(buildUrl, Currency.class);
        assert null != currency1;
        assert null != currency2;
        assert currency1.equals(currency2);
    }
}