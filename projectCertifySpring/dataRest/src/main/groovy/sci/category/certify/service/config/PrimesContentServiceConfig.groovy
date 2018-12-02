package sci.category.certify.service.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import sci.category.certify.service.PrimesContentServiceUsingH2

@Configuration

class PrimesContentServiceConfig {
    @Profile("h2Conventional")
    @Bean("primesContentServiceUsingH2")
    PrimesContentServiceUsingH2 getPrimesContentServiceUsingH2() {
        def service = new PrimesContentServiceUsingH2()
        service
    }
}

