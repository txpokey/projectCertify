package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.PrimesRxRepositoryContract
import sci.category.certify.repo.config.R2DbcConfiguration

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

@Test
@Slf4j
@SpringBootTest
@Profile("default")
class H2R2DbcConfigurationTest extends AbstractTestNGSpringContextTests{


    @Autowired
    @Qualifier("primesRepositorySpecies")
    String primesRepositorySpecies

    @Autowired
    R2DbcConfiguration r2DbcConfiguration

    @Autowired
    PrimesRxRepositoryContract repo

    void sanityCheck() {
        assert primesRepositorySpecies
        assert r2DbcConfiguration
        assert repo
    }
}
