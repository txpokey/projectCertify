package sci.category.certify.repo.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.annotation.Nonnull

@Configuration
@Profile("default")
@EnableTransactionManagement

class R2DbcConfiguration extends AbstractR2dbcConfiguration {

    private final ConnectionFactory connectionFactory

    R2DbcConfiguration( @Nonnull ConnectionFactory connectionFactory ) {
        this.connectionFactory = connectionFactory
    }
    @Override
    ConnectionFactory connectionFactory() {
        this.connectionFactory
    }
    @Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory)
    }
}
