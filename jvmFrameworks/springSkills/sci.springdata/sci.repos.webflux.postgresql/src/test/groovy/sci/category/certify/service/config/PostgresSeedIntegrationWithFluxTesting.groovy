package sci.category.certify.service.config

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
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

@Test
@Slf4j
@SpringBootTest
@Profile("default")
class PostgresSeedIntegrationWithFluxTesting extends AbstractTestNGSpringContextTests{

    @Autowired
    PrimesRxRepositoryContract repository
    @Autowired
    DatabaseClient databaseClient
    @Autowired
    @Qualifier("primesRepositorySpecies")
    String species

    void sanityCheck() {
        assert repository
        assert databaseClient
        assert species
        log.debug(species)
    }

    void featureCheck() {
        sanityCheck()
        showAllPrimesInDatabase()
    }
    void checkSaveOneFeature() {
        final def currentRange = 101..101
        final def sizeExpected = currentRange.size()
        final List<PrimesRx> list = getPrimesInRange( currentRange, species )
        final Mono<PrimesRx> primeSaved = repository.save(list[0]).log()

        //        stepVerify(primeSaved, sizeExpected)

        def what = primeSaved.block()  // TODO: complains about identifier missing? also need onError()

        showAllPrimesInDatabase()
    }



    void checkSaveAllFeature() {
        final def currentRange = 103..120
        final def sizeExpected = currentRange.size()
        final List<PrimesRx> list = getPrimesInRange( currentRange, species )
        final Flux<PrimesRx> all = repository.saveAll(list).log()

        //        stepVerify(all, sizeExpected)

        def what = all.toIterable().each {
            p -> log.debug(p as String)
        }

        showAllPrimesInDatabase()
    }


    static List<PrimesRx> getPrimesInRange(@NonNull Range<Integer> range, @NonNull String species ) {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i, species) }
        candidate
    }
    private static getPrimeViaConstructorOnMap(@NonNull int i, @NonNull String species) {
//        Map m = [id: guid, prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
        Map m = [id: i, prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
//        Map m = [            prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
        def p = new PrimesRx(m)
        p
    }
    private showAllPrimesInDatabase() {
        Flux<PrimesRx> all = getAllPrimesInDatabase()
        def reduxAll = all.toIterable()
        reduxAll.each {
            p -> log.debug(p as String)
        }
    }

    private proveCorrectCountOfPrimesInDatabase(def limit) {
        Flux<PrimesRx> all = getAllPrimesInDatabase().log()

        StepVerifier
                .create(all)
                .expectNextCount(limit)
                .verifyComplete()
    }

    private getAllPrimesInDatabase() {
        Flux<PrimesRx> all = repository.findAll()
        all
    }
    private static stepVerify(Flux<PrimesRx> all, int sizeExpected) {
        StepVerifier
                .create(all)
                .expectNextCount(sizeExpected)
                .verifyComplete()
    }
    private static stepVerify(Mono<PrimesRx> primeSaved, int sizeExpected) {
        StepVerifier
                .create(primeSaved)
                .expectNextCount(sizeExpected)
                .verifyComplete()
    }

}
