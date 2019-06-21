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
@EnableJdbcRepositories(basePackages = ["sci.category.certify"])
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource")
@Profile("default")
class PostgresR2dbcRepoConfig {
    String database
    String username
    String password
    String host
    String port

//    @Bean(name = "primesRepoMethods")
//    PrimesRepoMethods getRepository(R2dbcRepositoryFactory repositoryFactory) {
//        def candidate = repositoryFactory.getRepository(PrimesWebfluxRepoPostgreSql.class)
//        candidate
//    }
//
//    @Bean
//    R2dbcRepositoryFactory repositoryFactory(DatabaseClient databaseClient) {
//        Dialect dialect = new PostgresDialect()
//        ReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(dialect)
//        def candidate = new R2dbcRepositoryFactory(databaseClient, strategy)
//        candidate
//    }
//
//    @Bean
//    DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
//        def candidate = DatabaseClient.builder().connectionFactory(connectionFactory).build()
//        candidate
//    }
    @Bean(name = "primesRepoMethods")
    def  PrimesRepoMethods repository(R2dbcRepositoryFactory factory ){
        def candidate = factory.getRepository(PrimesWebfluxRepoPostgreSql.class)
        candidate
    }
    @Bean
    R2dbcRepositoryFactory factory(DatabaseClient client)  {
        def context = new RelationalMappingContext()
        context.afterPropertiesSet()
        def candidate = new R2dbcRepositoryFactory(client, context)
        candidate
    }
    @Bean
    DatabaseClient databaseClient(ConnectionFactory connectionFactory)  {
        def candidate =  DatabaseClient.builder().connectionFactory(connectionFactory).build()
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
