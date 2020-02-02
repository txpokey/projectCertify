package sci.spring.rest.template.maps.cfg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import sci.spring.rest.template.maps.domain.Currency;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Test
@SpringBootTest
public class RestTemplateCfgTest extends AbstractTestNGSpringContextTests {

    private final static String buildUrl = "http://data.fixer" +
            ".io/api/latest?access_key=3e71e8caaa61c017d627f66461436b5f&symbols=USD" ;
    @Autowired
    private RestTemplate restTemplate ;
    public void testRestTemplate() {
        LocalDateTime n = LocalDateTime.now() ;
        LocalDate n1 = LocalDate.now() ;
        logger.debug("PING!");
        assert null != "" ;
        assert null != restTemplate ;
        String json = restTemplate.getForObject(buildUrl, String.class);
//        Map<String,String> map = new HashMap<String,String>();
        Currency map = null ;
        ObjectMapper mapper = new ObjectMapper();

        try {
            //convert JSON string to Map
            map = mapper.readValue(json, new TypeReference<Currency>(){});
        } catch (Exception e) {
//            json
//            final String sf1=String.format("name is %s",name);
            final String sf1=String.format("Exception converting '%s' to map",json);
            logger.debug(sf1, e);
        }

        assert null != map;
    }
}