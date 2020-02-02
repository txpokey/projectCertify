package sci.spring.rest.template.maps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sci.spring.rest.template.maps.domain.Currency;

@Service
public class FixerIoCurrencyService implements CurrencyServiceContract {
    @Override
    public Currency getCurrency(String currencyCode) {
        Currency currency = restTemplate.getForObject("http://api.fixer.io/latest?base={currencyCode}", Currency.class, currencyCode);
        return currency;
    }

    @Autowired
    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
