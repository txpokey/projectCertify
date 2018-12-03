package sci.category.certify.repo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import sci.category.certify.repo.PrimesContentRepo
import sci.category.certify.repo.PrimesContentRepoForH2

@Configuration
@EnableJpaRepositories(basePackages = ["sci.category.certify"])
class RepositoryConfig {

    @Autowired
    PrimesContentRepoForH2 primesContentRepoForH2

    @Bean("primesContentRepoUsingH2")
    PrimesContentRepo getH2Repo() {
        def repo = primesContentRepoForH2
        repo
    }

}