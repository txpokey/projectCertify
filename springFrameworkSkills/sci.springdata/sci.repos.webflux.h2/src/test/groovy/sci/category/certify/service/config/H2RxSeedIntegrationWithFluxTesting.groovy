package sci.category.certify.service.config

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import reactor.util.annotation.NonNull
import sci.category.certify.domain.PrimesRx
import sci.category.certify.repo.PrimesRxRepositoryContract
import sci.category.certify.util.Print

import static sci.category.certify.service.bootstrap.constants.AdhocSqlStatements.*
import static hello.gorm.service.util.SqlViaFlux.*

@Test
@Slf4j
@SpringBootTest
@Profile("default")
class H2RxSeedIntegrationWithFluxTesting extends AbstractTestNGSpringContextTests{
    def species = "H2-rx"
    def printer = Print.getPrintln()

    @Autowired
    PrimesRxRepositoryContract repository
    @Autowired
    private final DatabaseClient client
    void sanityCheck() {
        assert repository
        assert client
        assert species
        log.debug(species)
    }
    void featureCheck() {
        sanityCheck()
        proveCorrectCountOfPrimesRxInDatabase(100)
        showConversionFluxToIterableOnAllPrimesRxInDatabase()
    }
//    @Transactional
    void createTablesManually() {
        // TODO: not seeing H2 SQL behaving as if commits happening
        doAutocommitSettings()
        doShowTables()
        runSqlExpectingVoidReturned(client, CREATE_TABLE_USING_H2_CONSOLE_CODE_EXAMPLE)
        runSqlExpectingSingleAnswer(client, SELECT_COUNT_ALL_TABLES_FROM_META_TABLE , "C")
        runSqlExpectingListAsAnswer(client, SELECT_ALL_TABLES_FROM_META_TABLE)
        runSqlExpectingListAsAnswer(client, SELECT_TABLES_AND_COUNTS_FROM_META_TABLE)
        false
//        showConversionFluxToIterableOnAllPrimesRxInDatabase()
    }

    void doAutocommitSettings() {
        def what = runSqlExpectingVoidReturned(client, SET_AUTOCOMMIT)
        what
    }
    void doShowTables() {
        def what = runSqlExpectingListAsAnswer(client, SHOW_TABLES)
        what
    }
    void checkSaveOneFeature() {
        final def currentRange = 101..101
        final def sizeExpected = currentRange.size()
        final List<PrimesRx> list = getPrimesRxInRange( currentRange, species )
        final Mono<PrimesRx> allSaved = repository.save(list[0]).log()

        StepVerifier
                .create(allSaved)
                .expectNextCount(sizeExpected)
                .verifyComplete()
        Flux<PrimesRx> allVerify = getAllPrimesRxInDatabase().log()
        StepVerifier
                .create(allVerify)
                .expectNextCount(100)
                .verifyComplete()
        showConversionFluxToIterableOnAllPrimesRxInDatabase()
    }
    void checkSaveAllFeature() {
        final def currentRange = 101..120
        final def sizeExpected = currentRange.size()
        final List<PrimesRx> list = getPrimesRxInRange( currentRange, species )
        final Flux<PrimesRx> all = repository.saveAll(list).log()
        StepVerifier
                .create(all)
                .expectNextCount(sizeExpected)
                .verifyComplete()
        showConversionFluxToIterableOnAllPrimesRxInDatabase()
    }
    static List<PrimesRx> getPrimesRxInRange(@NonNull Range<Integer> range, @NonNull String species ) {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i, species) }
        candidate
    }
    private static getPrimeViaConstructorOnMap(@NonNull int i, @NonNull String species) {
        def guid = java.util.UUID.randomUUID() as String
        Map m = [id: i, prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
        def p = new PrimesRx(m)
    }
    private showConversionFluxToIterableOnAllPrimesRxInDatabase() {
        Flux<PrimesRx> all = getAllPrimesRxInDatabase()
        def reduxAll = all.toIterable()
        reduxAll.each {
            p -> log.debug(p as String)
        }
    }

    private proveCorrectCountOfPrimesRxInDatabase(def limit) {
        Flux<PrimesRx> all = getAllPrimesRxInDatabase().log()

        StepVerifier
                .create(all)
                .expectNextCount(limit)
                .verifyComplete()
    }

    private getAllPrimesRxInDatabase() {
        Flux<PrimesRx> all = repository.findAll()
        all
    }


}
