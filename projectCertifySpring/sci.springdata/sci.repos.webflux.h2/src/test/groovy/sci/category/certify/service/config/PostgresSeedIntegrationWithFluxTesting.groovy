package sci.category.certify.service.config

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
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

    void sanityCheck() {
        assert repository
        def species = "H2-rx"
        assert species
        log.debug(species)
    }

    void featureCheck() {
        sanityCheck()
        proveCorrectCountOfPrimesRxInDatabase(100)
        showConversionFluxToIterableOnAllPrimesRxInDatabase()
    }
    void checkSaveOneFeature() {
        final def currentRange = 101..101
        final def sizeExpected = currentRange.size()
        final List<PrimesRx> list = getPrimesRxInRange( currentRange, repository.species )
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
        final List<PrimesRx> list = getPrimesRxInRange( currentRange, repository.species )
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
//        Map m = [id: guid, prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
        Map m = [id: i, prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
//        Map m = [            prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
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
