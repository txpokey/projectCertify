package sci.category.certify.service.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sci.category.certify.service.bootstrap.BootstrapDataService
import sci.category.certify.service.bootstrap.PrimesContentBootstrap

@Configuration
class ReactiveServicesConfig {

    @Autowired
    @Qualifier("primesBootstrapService")
    private PrimesContentBootstrap spinner

    @Bean(name = "reactiveRepoBootstrapTool")
    BootstrapDataService getSyncRepoSpinner() {
        assert spinner
        BootstrapDataService bootstrap = new BootstrapDataService([spinner])
    }

}