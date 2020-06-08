package sci.spring.rest.template.maps.cfg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class RestTemplateCfg {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    private String currencyUrl;
    @Bean(name = "currencyUrl")
    public String getCurrencyUrl() {
        return currencyUrl;
    }
    public void setCurrencyUrl(String currencyUrl) {
        this.currencyUrl = currencyUrl;
    }

}