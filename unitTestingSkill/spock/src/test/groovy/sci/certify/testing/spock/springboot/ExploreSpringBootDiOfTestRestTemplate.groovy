package sci.certify.testing.spock.springboot

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ExploreSpringBootDiOfTestRestTemplate extends Specification{
    private final static String buildUrl = "http://data.fixer" +
            ".io/api/latest?access_key=3e71e8caaa61c017d627f66461436b5f&symbols=USD"

    @Autowired
    private TestRestTemplate testRestTemplate

    def "sanityCheck"() {
        expect:
        testRestTemplate
    }

    def "integration test on currency conversion"() {
        expect:
        testRestTemplate
        when:
//        Currency currency = testRestTemplate.getForObject(buildUrl, Currency.class) // doesnt Currency(map)
        String json = testRestTemplate.getForObject(buildUrl, String.class)
        def map = new JsonSlurper().parseText(json)
        Currency currency = new Currency(map)
        then:
        currency
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Currency{
        private boolean success
        @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "UTC")
        private Integer timestamp
        private String base
        private String date
        private Map<String, Double> rates

        @Override
        int hashCode() {
            return Objects.hash(rates, base)
        }

        @Override
        boolean equals(final Object obj) {
            if (obj instanceof Currency) {
                final Currency other = (Currency) obj
                return Objects.equals(rates, other.rates) && Objects.equals(base, other.base)
            } else {
                return false
            }
        }
    }
}
