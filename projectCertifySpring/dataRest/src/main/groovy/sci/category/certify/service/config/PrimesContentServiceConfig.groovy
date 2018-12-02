package sci.category.certify.service.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sci.category.certify.service.PrimesContentServiceUsingH2
import sci.category.certify.service.bootstrap.BootstrapDataService

@Configuration

class PrimesContentServiceConfig {
    @Bean("primesContentServiceUsingH2")
    PrimesContentServiceUsingH2 getPrimesContentServiceUsingH2() {
        def service = new PrimesContentServiceUsingH2()
        service
    }
}

