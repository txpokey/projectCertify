package sci.category.certify.service.config

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.springframework.transaction.annotation.Transactional
import org.testng.annotations.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import reactor.util.annotation.NonNull
import sci.category.certify.domain.PrimesRx
import sci.category.certify.repo.PrimesRxRepositoryContract

@Test
@Slf4j
@SpringBootTest
@Profile("default")
class H2RxSeedIntegrationWithFluxTesting extends AbstractTestNGSpringContextTests{
    def species = "H2-rx"

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
    @Transactional
    void featureCheck() {
        sanityCheck()
        proveCorrectCountOfPrimesRxInDatabase(100)
        showConversionFluxToIterableOnAllPrimesRxInDatabase()
    }
//    select count(*) from primes_rx ;
    @Transactional
    void createTablesManually0() {
        def DDL0 = """
 drop table IF EXISTS primes_rx cascade constraints ;
 drop sequence hibernate_sequence ;
 create sequence hibernate_sequence start with 1 increment by  1 ;
 create table primes_rx (id number(19,0) not null, prime number(10,0), species varchar2(255 char), truth number(1,0), primary key (id)) ;
 """
         def DDL = """
 show tables ;
"""
        def EXPLORE = """
            show tables ;
"""
        def what = client.execute().sql(DDL0 as String).then().log().block()
//        def what2 = client.execute().sql("SELECT count(*) PRIMES_RX ").then().log()
//        def what2 = client.execute().sql("SELECT count(*) FROM INFORMATION_SCHEMA.TABLES ").then().log()
//        def ddlWork = client.select().from("primes_rx").fetch()
//        StepVerifier
//                .create(what2)
//                .expectNextCount(1)
//                .verifyComplete()
//        def work = client.execute().sql(EXPLORE as String).then().subscribe( System.out.&println )
        false
//        showConversionFluxToIterableOnAllPrimesRxInDatabase()
    }
    @Transactional
    void doAutocommitSettings() {
        def DDL0 = """
 SET AUTOCOMMIT on;
 """
        def what = client.execute().sql(DDL0 as String).then().log()
        StepVerifier
                .create(what)
                .verifyComplete()
    }
    @Transactional
    void createTablesManually() {
        def DDL0 = """
 drop table IF EXISTS primes_rx cascade constraints ;
 drop sequence hibernate_sequence ;
 create sequence hibernate_sequence start with 1 increment by  1 ;
 create table primes_rx (id number(19,0) not null, prime number(10,0), species varchar2(255 char), truth number(1,0), primary key (id)) ;
"""
        def what = client.execute().sql(DDL0 as String).then().log()
        StepVerifier
                .create(what)
                .verifyComplete()
    }
    @Transactional
    void peekTablesManually() {
        def DDL0 = """
SELECT count(*) from PRIMES_RX ;
"""
        def what = client.execute().sql(DDL0 as String).fetch().all().log()
        StepVerifier
                .create(what)
                .verifyComplete()
    }
    @Transactional
    void peekTablesManually1() {
        def what = client.select().from("primes_rx").fetch().all().log()
        StepVerifier
                .create(what)
                .verifyComplete()
    }
    void foo() {
        doAutocommitSettings()
        createTablesManually()
        peekTablesManually()
//        showConversionFluxToIterableOnAllPrimesRxInDatabase()
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
