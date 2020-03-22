package sci.category.certify.service.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sci.category.certify.service.bootstrap.ApplicationContentBootstrapContract
import sci.category.certify.service.bootstrap.PrimesRxBootstrapService

@Configuration
class SyncApplicationContentBootstrapListConfig{

    @Autowired
    @Qualifier("primesBootstrapService")
    private PrimesRxBootstrapService spinner

    @Bean(name = "applicationContentBootstrapList")
    List<ApplicationContentBootstrapContract> getRxRepoSpinner() {
        assert spinner
        [spinner]
    }

}