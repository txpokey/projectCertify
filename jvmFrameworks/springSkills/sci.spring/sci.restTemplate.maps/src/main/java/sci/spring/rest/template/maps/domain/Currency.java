package sci.spring.rest.template.maps.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private boolean success;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "UTC")
    private Date timestamp;
    private String base;
    private String date;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    //    private Rates rates;
    private Map<String, Double> rates;

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

    @Override
    public int hashCode(){
        return Objects.hash(rates, base);
    }

    @Override
    public boolean equals(final Object obj){
        if(obj instanceof Currency){
            final Currency other = (Currency) obj;
            return Objects.equals(rates, other.rates)
                    && Objects.equals(base, other.base);
        } else{
            return false;
        }
    }
}