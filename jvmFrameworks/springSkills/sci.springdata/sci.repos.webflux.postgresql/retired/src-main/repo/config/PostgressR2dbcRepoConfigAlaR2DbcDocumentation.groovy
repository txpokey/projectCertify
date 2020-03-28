package sci.category.certify.repo.config

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy
import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy
import org.springframework.data.r2dbc.dialect.Dialect
import org.springframework.data.r2dbc.dialect.PostgresDialect
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory
import sci.category.certify.repo.PrimesRepoMethods
import sci.category.certify.repo.PrimesWebfluxRepoPostgreSql

//
@Configuration
@EnableR2dbcRepositories(basePackages = ["sci.category.certify"])
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource")
@Profile("brokenOnTransactionMethod")

class PostgressR2dbcRepoConfigAlaR2DbcDocumentation extends AbstractR2dbcConfiguration{
    String database
    String username
    String password
    String host
    String port

    @Override
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
    @Bean
    PostgressR2dbcRepoConfigAlaR2DbcDocumentation getConfig() {
        def candidate = new PostgressR2dbcRepoConfigAlaR2DbcDocumentation()
        candidate
    }

    @Bean
    @Qualifier("connectionFactory")
    PostgresqlConnectionFactory getConnectionFactory() {
        def papa = getConfig()
        def candidate = papa.connectionFactory()
        candidate
    }

    @Bean(name = "primesRepoMethods")
    PrimesRepoMethods getRepository(R2dbcRepositoryFactory repositoryFactory) {
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
}
