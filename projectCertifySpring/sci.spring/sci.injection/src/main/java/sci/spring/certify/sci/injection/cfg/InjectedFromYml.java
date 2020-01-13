package sci.spring.certify.sci.injection.cfg;

import groovy.util.logging.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class InjectedFromYml {
    @Bean(name = "myClients")
    public String[] getClients() {
        return clients;
    }

    public void setClients(String[] clients) {
        this.clients = clients;
    }

    private String[] clients ;
}
