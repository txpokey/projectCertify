package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import io.r2dbc.postgresql.PostgresqlConnection
import io.r2dbc.postgresql.PostgresqlConnectionFactory
//import io.r2dbc.spi.Connection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.r2dbc.function.DatabaseClient
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sci.category.certify.repo.PrimesRepoMethods
import sci.category.certify.service.PrimesContentBaseService
import sci.category.certify.service.bootstrap.BootstrapDataService
import sci.category.certify.repo.util.Print

@Test
@Slf4j
@SpringBootTest
class AdhocPostgreSqlConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("primesRepoMethods")
    PrimesRepoMethods repository

    @Autowired
    @Qualifier("primesService")
    private PrimesContentBaseService service

    @Autowired
    @Qualifier("applicationContentBootstrap")
    private BootstrapDataService spinner

    @Autowired
    @Qualifier("databaseClient")
    DatabaseClient databaseClient

    @Autowired
    @Qualifier("connectionFactory")
    PostgresqlConnectionFactory connectionFactory

    void sanityCheck() {
        assert repository
        assert service
        assert spinner
        assert databaseClient
    }

    void examineClientInterface() {
        sanityCheck()
        Mono<PostgresqlConnection> connectionAsMono = connectionFactory.create()
        assert connectionAsMono
        def connection = connectionAsMono.block()
        def stmt = connection.createStatement(LIST_USERS)
        def executed = stmt.execute()
        def nothingHere = executed.subscribe(Print.getPrintln())
        nothingHere
    }
    final static def LIST_USERS = """
        select usesysid as user_id,
               usename as username,
               usesuper as is_superuser,
               passwd as password_md5,
               valuntil as password_expiration
        from pg_shadow
        order by usename;
"""
    private static void printOn(Flux<?> flux) {
        flux.subscribe({ s -> System.out.println(s) } )
    }
}
