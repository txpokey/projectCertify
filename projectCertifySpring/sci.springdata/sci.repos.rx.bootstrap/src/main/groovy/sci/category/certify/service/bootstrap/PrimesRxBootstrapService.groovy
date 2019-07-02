package sci.category.certify.service.bootstrap

import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import sci.category.certify.repo.PrimesRxServiceContract
import sci.category.certify.service.PrimesRxService

@Component("primesBootstrapService")
class PrimesRxBootstrapService implements BootstrapContract {

    @Autowired
    @Qualifier("connectionFactory")
    ConnectionFactory connectionFactory

    @Autowired
    @Qualifier("databaseClient")
    DatabaseClient databaseClient

    @Autowired
    @Qualifier("primesService")
    PrimesRxServiceContract primesService


    boolean spinUp() {
        assert primesService
        def repo = primesService.primesRepoContract
        assert repo
        def species = primesService.species
        assert species
//        def ddlOk = manuallyRunDdl()
//        assert ddlOk
        final def all = PrimesRxService.getPrimesInRange(RANGE,species)

        def incomingFlux = primesService.saveAll(all).log()
        StepVerifier
                .create(incomingFlux)
                .expectNextCount(all.size())
                .verifyComplete()
        true
    }
//    private boolean manuallyRunDdl(){
//        ReactiveTransactionManager tm = new R2dbcTransactionManager(connectionFactory);
//
//        TransactionalOperator rxtx = TransactionalOperator.create(tm);
//        def DDL = """
//            drop table primes cascade constraints
//"""
//        Mono<Void> wtf = databaseClient.execute().sql(DDL as String).then()
//                .as(rxtx.&transactional)
//        false
//    }
    private final static def RANGE = 1..100
}
