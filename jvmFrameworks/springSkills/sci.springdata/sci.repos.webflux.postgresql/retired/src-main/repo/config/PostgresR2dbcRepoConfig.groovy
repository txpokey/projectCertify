package sci.category.certify.repo.config

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.data.r2dbc.function.DatabaseClient
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory
import org.springframework.data.relational.core.mapping.RelationalMappingContext
import sci.category.certify.repo.PrimesRepoMethods

//
import sci.category.certify.repo.PrimesWebfluxRepoPostgreSql

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource")
@Profile("default")
class PostgresConnectionConfig {
    String database
    String username
    String password
    String host
    String port

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
