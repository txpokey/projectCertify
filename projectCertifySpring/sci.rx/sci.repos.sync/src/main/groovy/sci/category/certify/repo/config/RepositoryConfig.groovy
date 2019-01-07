package sci.category.certify.repo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import sci.category.certify.repo.PrimesRepoContract
import sci.category.certify.repo.PrimesRepoContractForH2

@Configuration
@EnableJpaRepositories(basePackages = ["sci.category.certify"])
class RepositoryConfig {

    @Autowired
    PrimesRepoContractForH2 primesContentRepoForH2

    @Bean("primesContentRepoUsingH2")
    PrimesRepoContract getH2Repo() {
        def repo = primesContentRepoForH2
        repo
    }

}