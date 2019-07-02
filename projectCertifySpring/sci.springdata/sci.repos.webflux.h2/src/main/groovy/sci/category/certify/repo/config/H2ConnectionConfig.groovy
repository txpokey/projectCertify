package sci.category.certify.repo.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource")
@Profile("default")
class H2ConnectionConfig{
    String inMemory
    String username
//    H2ConnectionConfiguration{password='null', url='mem:testdb', username='null'}
    @Bean
    ConnectionFactory connectionFactory() {
        def connectionConfig = H2ConnectionConfiguration.builder()
                .inMemory(inMemory)
                .username(username)
                .password('')
                .build()
        def peeker = connectionConfig.toString()
        ConnectionFactory connectionFactory = new H2ConnectionFactory(connectionConfig)
        connectionFactory
    }
}

