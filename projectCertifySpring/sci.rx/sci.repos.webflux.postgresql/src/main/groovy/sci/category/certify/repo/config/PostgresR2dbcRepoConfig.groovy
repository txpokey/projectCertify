package sci.category.certify.repo.config

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory

//
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy
import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy
import org.springframework.data.r2dbc.dialect.Dialect
import org.springframework.data.r2dbc.dialect.PostgresDialect
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory
import sci.category.certify.repo.PrimesWebfluxRepoPostgreSql

@Configuration
@EnableR2dbcRepositories(basePackages = ["sci.category.certify"])
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource")
class PostgresR2dbcRepoConfig extends AbstractR2dbcConfiguration{
    String database
    String username
    String password
    String host
    String port

    @Bean
    PrimesWebfluxRepoPostgreSql repository(R2dbcRepositoryFactory repositoryFactory) {
        def candidate = repositoryFactory.getRepository(PrimesWebfluxRepoPostgreSql.class)
        candidate
    }

    @Bean
    R2dbcRepositoryFactory repositoryFactory(DatabaseClient databaseClient) {
        Dialect dialect = new PostgresDialect()
        ReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(dialect)
        def candidate = new R2dbcRepositoryFactory(databaseClient, strategy)
        candidate
    }

    @Bean
    DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        def candidate = DatabaseClient.builder().connectionFactory(connectionFactory).build()
        candidate
    }

    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        final def dbPort = port as Integer
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder() //
                .host(host)
                .port(dbPort)
                .database(database)
                .username(username)
                .password(password).build()
        PostgresqlConnectionFactory candidate = new PostgresqlConnectionFactory(config)
        candidate
    }
}
