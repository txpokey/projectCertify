package sci.category.certify.repo.config

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration

//
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory
import org.springframework.data.relational.core.mapping.RelationalMappingContext
import sci.category.certify.repo.PrimesWebfluxRepoPostgreSql

@Configuration
@EnableR2dbcRepositories(basePackages = ["sci.category.certify"])
abstract class PostgresR2dbcRepoConfig extends AbstractR2dbcConfiguration{
    @Value("spring.datasource.database")
    private String database
    @Value("spring.datasource.username")
    private String username
    @Value("spring.datasource.password")
    private String password
    @Value("spring.datasource.host")
    private String host
    @Value("spring.datasource.port")
    private String port

//    @Bean(name = "postgresConnectionFactory")
//    ConnectionFactory connectionFactory() {
//        PostgresqlConnectionFactory connFactory = new PostgresqlConnectionFactory(
//                PostgresqlConnectionConfiguration.builder()
//                        .host(host)
//                        .port(port as Integer)
//                        .database(database)
//                        .username(username)
//                        .password(password).build()
//        )
//        return connFactory
//    }

//    @Autowired
//    @Qualifier("postgresConnectionFactory")
//    ConnectionFactory connFactory
//
//    @Bean(name = "databaseClient")
//    DatabaseClient getDatabaseClient() {
//        def connFactory = connectionFactory()
//        DatabaseClient databaseClient = DatabaseClient.create(connFactory)
//        databaseClient
//    }
    @Bean
    def  PrimesWebfluxRepoPostgreSql repository(R2dbcRepositoryFactory factory ){
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
    DatabaseClient databaseClient(ConnectionFactory factory)  {
        def candidate =  DatabaseClient.builder().connectionFactory(factory).build()
        candidate
    }
    @Bean
    PostgresqlConnectionFactory connectionFactory()  {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder() //
                .host(host)
                .port(port as Integer)
                .database(database)
                .username(username)
                .password(password).build()
        PostgresqlConnectionFactory candidate =  new PostgresqlConnectionFactory(config)
        candidate
    }
}
