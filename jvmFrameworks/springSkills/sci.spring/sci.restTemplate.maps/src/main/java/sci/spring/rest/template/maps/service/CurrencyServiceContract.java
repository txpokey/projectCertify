package sci.spring.rest.template.maps.service;

import sci.spring.rest.template.maps.domain.Currency;

public interface CurrencyServiceContract {
    Currency getCurrency(String currencyCode) ;
}
