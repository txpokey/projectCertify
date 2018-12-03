package sci.category.certify.rx.repo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["sci.category.certify"])
class RepositoryConfig {

    @Autowired
    sci.category.certify.rx.repo.PrimesContentRepoForH2 primesContentRepoForH2

    @Bean("primesContentRepoUsingH2")
    sci.category.certify.rx.repo.PrimesContentRepo getH2Repo() {
        def repo = primesContentRepoForH2
        repo
    }

}