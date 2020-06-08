package sci.spring.rest.template.maps.cfg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.logging.Slf4j;
import org.spockframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;
import sci.spring.rest.template.maps.domain.Currency;

@Slf4j
@Test // inherit random port
public class RestTemplateComparisonTest extends RestTemplateCfgTest {
    @Autowired
    @Qualifier("currencyUrl")
    private String currencyUrl;

    public void testRestTemplate0() {
        sanityCheck();
        String json = getTestRestTemplate().getForObject(currencyUrl, String.class);
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
        Currency currency1 = getRestTemplate().getForObject(currencyUrl, Currency.class);
        Currency currency2 = getTestRestTemplate().getForObject(currencyUrl, Currency.class);
        assert null != currency1;
        assert null != currency2;
        assert currency1.equals(currency2);
    }

    public void testRestTemplate2() {
        sanityCheck();
        Currency currency1 = service.getCurrency("dummy");
        Currency currency2 = getTestRestTemplate().getForObject(currencyUrl, Currency.class);
        assert null != currency1;
        assert null != currency2;
        assert currency1.equals(currency2);
    }
}
