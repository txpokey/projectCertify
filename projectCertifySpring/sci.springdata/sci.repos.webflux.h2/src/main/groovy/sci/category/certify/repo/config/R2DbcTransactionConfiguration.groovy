package sci.category.certify.repo.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

import javax.annotation.Nonnull

@Configuration
@Profile("default")
class R2DbcTransactionConfiguration  {

    private final ConnectionFactory connectionFactory

    R2DbcTransactionConfiguration(@Nonnull ConnectionFactory connectionFactory ) {
        this.connectionFactory = connectionFactory
    }

//    @Bean
//    TransactionalOperator transactionalOperator() {
//        TransactionalOperator operator = TransactionalOperator.create(tm)
//        operator
//    }

}