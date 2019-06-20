package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import reactor.core.publisher.Flux
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesRepoMethods
import sci.category.certify.service.PrimesContentBaseService

@Test
@Slf4j
@SpringBootTest
class PrimesContentBaseServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    @Qualifier("primesRepoMethods")
    PrimesRepoMethods repository

    @Autowired
    @Qualifier("primesContentBaseService")
    private PrimesContentBaseService service

    @Autowired
    @Qualifier("bootstrapTool")
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
        def whatNext = what.log().subscribe( report1() )
        whatNext
        inspected
    }

    private def inspect() {
        def findAllStreamPart0 = repository.findAll()
                .log().subscribe( )
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

    void featureExampleProbe() {
        log.debug("ENTER")
        def species = repository.species
        assert species
        def allAsList = PrimesContentBaseService.getPrimesInRange(1..11, species)
        log.debug("BEGIN")
        repository.saveAll(
            [
                    Primes.of( 1, true, "adhoc"),
                    Primes.of( 2, true, "adhoc"),
                    Primes.of( 3, true, "adhoc"),
                    Primes.of( 4, false, "adhoc"),
            ]
        ).log().subscribe()
        log.debug("SLEEP")

        Thread.sleep(2000)
        def xlog = LoggerFactory.getLogger(PrimesContentBaseServiceTest.class)
        repository.findAll().log().subscribe { xlog.info("findAll - $it") }
        log.debug("END")
    }
}
