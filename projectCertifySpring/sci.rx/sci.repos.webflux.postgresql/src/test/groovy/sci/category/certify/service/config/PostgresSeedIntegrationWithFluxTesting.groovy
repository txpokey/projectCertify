package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import sci.category.certify.domain.Primes
import sci.category.certify.repo.PrimesRepoMethods

@Test
@Slf4j
@SpringBootTest
@Profile("default")
class PostgresSeedIntegrationWithFluxTesting extends AbstractTestNGSpringContextTests{

//    @Autowired
//    PrimesWebfluxRepoPostgreSql repository
    @Autowired
    PrimesRepoMethods repository

    void sanityCheck() {
        assert repository
    }

    void featureCheck() {
        sanityCheck()
        Flux<Primes> all = repository.findAll()

        StepVerifier
                .create(all)
                .expectNextCount(100)
                .verifyComplete()
    }


}
