package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
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
        def s = repository.species
        def allAsList = PrimesContentBaseService.getPrimesInRange(1..11, repository.species)
        assert allAsList
    }
}
