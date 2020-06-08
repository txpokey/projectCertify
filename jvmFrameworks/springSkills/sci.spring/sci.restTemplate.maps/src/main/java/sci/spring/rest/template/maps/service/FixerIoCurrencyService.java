package sci.spring.rest.template.maps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sci.spring.rest.template.maps.domain.Currency;

@Service
public class FixerIoCurrencyService implements CurrencyServiceContract {

    @Override
    public Currency getCurrency(String currencyCode) {
        Currency currency = getRestTemplate().getForObject(buildUrl, Currency.class);
        return currency;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;
    private final static String buildUrl = "http://data.fixer" +
            ".io/api/latest?access_key=3e71e8caaa61c017d627f66461436b5f&symbols=USD";
}
