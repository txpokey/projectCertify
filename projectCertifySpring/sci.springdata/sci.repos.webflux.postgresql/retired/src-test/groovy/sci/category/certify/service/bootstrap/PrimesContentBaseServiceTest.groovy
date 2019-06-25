package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.r2dbc.function.DatabaseClient
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesWebfluxRepoPostgreSql
import sci.category.certify.service.PrimesContentBaseService
import sci.category.certify.service.config.AdhocPostgreSqlConnectionTest

@Test
@Slf4j
@SpringBootTest
class PrimesContentBaseServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    @Qualifier("primesRepoMethods")
    PrimesWebfluxRepoPostgreSql repository
//    PrimesRepoMethods repository

    @Autowired
    @Qualifier("primesRepositoryService")
    private PrimesContentBaseService service

    @Autowired
    @Qualifier("applicationContentBootstrap")
    private BootstrapDataService spinner

    void sanityCheck() {
        assert repository
        assert service
        assert spinner
    }

    void featureSanityCheck() {
        def species = repository.species
        assert species
        def allAsList = PrimesContentBaseService.getPrimesInRange(1..11, species)
        assert allAsList
        def first = allAsList[0]
        assert first
        def inspected = inspect()

        def what = repository.save(first)
        assert what
//        def whatNext = what.subscribe(report())
        def whatNext = what.log().subscribe(report1())
        whatNext
        inspected
    }

    private def inspect() {
        def findAllStreamPart0 = repository.findAll()
                .log().subscribe()
//        def findAllStreamPart1 = findAllStreamPart0.as( { pub -> StepVerifier.create( pub )})
//                .expectNextCount(1)
//                .verifyComplete()
        findAllStreamPart0
    }

    private report0() {
        { it ->
            System.out.println(it)
        }
    }

    private report1() {
        System.out.println("HERE")
    }

    private reportViaLogger() {
        { it -> log.debug(it) }
    }

    void logFeature() {
        tutorialFluxMapOperator()
    }

    private void tutorialFluxMapOperator() {
        final cl = { i -> i * 10 }
        def o = range5.map(cl).log().subscribe()
        o
    }
    private final def range5 = Flux.range(1, 5)
    private final def FOUR_PRIMES = Flux.just(
            Primes.of(1, true, "adhoc"),
            Primes.of(2, true, "adhoc"),
            Primes.of(3, true, "adhoc"),
            Primes.of(4, false, "adhoc"),
    )

    void featureExampleProbe() {
        log.debug("ENTER")
        def species = repository.species
        assert species
        def allAsList = PrimesContentBaseService.getPrimesInRange(1..11, species)
        def step0 = FOUR_PRIMES.flatMap{
            p -> repository.save(p)

        }
        log.debug("BEGIN")
        StepVerifier.create( step0 ).expectNextCount(4).verifyComplete()
        log.debug("SLEEP")

        Thread.sleep(2000)
        log.debug("END")
    }

    void exploreCustomerQuery() {
        Flux<String> adHocQuery = repository.adHocQuery()
        StepVerifier.create( adHocQuery ).expectNextCount(1).verifyComplete()
    }

    @Autowired
    @Qualifier("databaseClient")
    DatabaseClient databaseClient

    void clientBasedFeatureProbe() {
        Flux<Example> all = databaseClient.execute()
                .sql(LIST_USERS)
                .fetch().all()
        all
        def what = all.block()
        what

    }
    void clientBasedFeatureProbe1() {
        Flux<Example> all = databaseClient.execute()
                .sql(LIST_USERS)
                .fetch().all()
        all
        def what = all.block()
        what

    }

    void clientBasedFeatureProbe0() {
        Flux<Example> all = databaseClient.execute()
                .sql(LIST_USERS)
                .as(Example.class)
                .fetch().all()
        all
        def what = all.subscribe(
                {
                    it ->
                        def candidate = it.class
                }
        )
        what
    }
    final static def LIST_USERS = AdhocPostgreSqlConnectionTest.LIST_USERS

    class Example{
        String user_id
        String username
        String password_md5
    }
}
