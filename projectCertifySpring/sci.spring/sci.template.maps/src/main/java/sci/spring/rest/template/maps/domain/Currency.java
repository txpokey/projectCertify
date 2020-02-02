package sci.spring.rest.template.maps.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private String base;
    private String date;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    //    private Rates rates;
    private Map<String, Double> rates ;
    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public Rates getRates() {
//        return this.rates;
//    }
//
//    public void setRates(Rates rates) {
//        this.rates = rates;
//    }
}