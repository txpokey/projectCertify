package sci.spring.rest.template.maps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sci.spring.rest.template.maps.domain.Currency;

@Service
public class FixerIoCurrencyService implements CurrencyServiceContract {
    @Autowired
    @Qualifier("currencyUrl")
    private String currencyUrl;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;

    //
    @Override
    public Currency getCurrency(String currencyCode) {
        Currency currency = getRestTemplate().getForObject(currencyUrl, Currency.class);
        return currency;
    }
}
