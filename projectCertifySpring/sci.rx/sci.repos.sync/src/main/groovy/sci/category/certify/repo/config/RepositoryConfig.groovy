package sci.category.certify.repo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["sci.category.certify"])
class RepositoryConfig {

//    @Autowired
//    PrimesRepoContractForH2 primesContentRepoForH2
//
//    @Bean("primesContentRepoUsingH2")
//    PrimesRepoContract getH2Repo() {
//        def repo = primesContentRepoForH2
//        repo
//    }

}