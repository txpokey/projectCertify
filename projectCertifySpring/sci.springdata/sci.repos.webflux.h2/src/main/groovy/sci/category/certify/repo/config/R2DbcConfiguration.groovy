package sci.category.certify.repo.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration

import javax.annotation.Nonnull

@Configuration
@Profile("default")

class R2DbcConfiguration extends AbstractR2dbcConfiguration {

    private final ConnectionFactory connectionFactory

    R2DbcConfiguration( @Nonnull ConnectionFactory connectionFactory ) {
        this.connectionFactory = connectionFactory
    }
    @Override
    ConnectionFactory connectionFactory() {
        this.connectionFactory
    }
}
