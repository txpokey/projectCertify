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
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesRepoMethods

import java.lang.reflect.Array

@Test
@Slf4j
@SpringBootTest
@Profile("default")
class PostgresSeedIntegrationWithFluxTesting extends AbstractTestNGSpringContextTests{

    @Autowired
    PrimesRepoMethods repository

    void sanityCheck() {
        assert repository
        assert repository.species
        log.debug(repository.species)
        log.debug(java.util.UUID.randomUUID() as String)
    }

    void featureCheck() {
        sanityCheck()
        proveCorrectCountOfPrimesInDatabase(100)
        showConversionFluxToIterableOnAllPrimesInDatabase()
    }
    void checkSaveOneFeature() {
        final def currentRange = 101..101
        final def sizeExpected = currentRange.size()
        final List<Primes> list = getPrimesInRange( currentRange, repository.species )
        final Mono<Primes> allSaved = repository.save(list[0]).log()

        StepVerifier
                .create(allSaved)
                .expectNextCount(sizeExpected)
                .verifyComplete()
        Flux<Primes> allVerify = getAllPrimesInDatabase().log()
        StepVerifier
                .create(allVerify)
                .expectNextCount(100)
                .verifyComplete()
        showConversionFluxToIterableOnAllPrimesInDatabase()
    }
    void checkSaveAllFeature() {
        final def currentRange = 101..120
        final def sizeExpected = currentRange.size()
        final List<Primes> list = getPrimesInRange( currentRange, repository.species )
        final Flux<Primes> all = repository.saveAll(list).log()
        StepVerifier
                .create(all)
                .expectNextCount(sizeExpected)
                .verifyComplete()
        showConversionFluxToIterableOnAllPrimesInDatabase()
    }
    static List<Primes> getPrimesInRange(@NonNull Range<Integer> range, @NonNull String species ) {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i, species) }
        candidate
    }
    private static getPrimeViaConstructorOnMap(@NonNull int i, @NonNull String species) {
        def guid = java.util.UUID.randomUUID() as String
//        Map m = [id: guid, prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
        Map m = [id: i, prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
//        Map m = [            prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species ]
        def p = new Primes(m)
    }
    private showConversionFluxToIterableOnAllPrimesInDatabase() {
        Flux<Primes> all = getAllPrimesInDatabase()
        def reduxAll = all.toIterable()
        reduxAll.each {
            p -> log.debug(p as String)
        }
    }

    private proveCorrectCountOfPrimesInDatabase(def limit) {
        Flux<Primes> all = getAllPrimesInDatabase().log()

        StepVerifier
                .create(all)
                .expectNextCount(limit)
                .verifyComplete()
    }

    private getAllPrimesInDatabase() {
        Flux<Primes> all = repository.findAll()
        all
    }


}
