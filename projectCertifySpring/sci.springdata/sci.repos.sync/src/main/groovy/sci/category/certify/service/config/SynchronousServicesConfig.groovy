package sci.category.certify.service.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sci.category.certify.service.bootstrap.BootstrapDataService
import sci.category.certify.service.bootstrap.PrimesContentBootstrap

@Configuration
class SynchronousServicesConfig {

    @Autowired
    @Qualifier("primesContentBootstrap")
    private PrimesContentBootstrap spinner

    @Bean(name = "synchronousRepoBootstrapTool")
    BootstrapDataService getSyncRepoSpinner() {
        assert spinner
        BootstrapDataService bootstrap = new BootstrapDataService([spinner])
    }

}