package sci.spring.rest.template.maps.cfg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.logging.Slf4j;
import org.spockframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import sci.spring.rest.template.maps.domain.Currency;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Test
@SpringBootTest
public class RestTemplateCfgTest extends AbstractTestNGSpringContextTests {

    private final static String buildUrl = "http://data.fixer" +
            ".io/api/latest?access_key=3e71e8caaa61c017d627f66461436b5f&symbols=USD";
    @Autowired
    private RestTemplate restTemplate;

    public void sanityCheck() {
        logger.debug("PING!");
        Assert.notNull(restTemplate);
    }

    public void testRestTemplate() {
        sanityCheck();
        String json = restTemplate.getForObject(buildUrl, String.class);
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
}