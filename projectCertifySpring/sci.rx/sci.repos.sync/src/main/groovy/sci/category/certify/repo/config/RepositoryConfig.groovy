package sci.category.certify.repo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["sci.category.certify"])
class RepositoryConfig {

//    @Autowired
//    PrimesRepoForH2 PrimesRepoForH2
//
//    @Bean("primesContentRepoUsingH2")
//    PrimesSynchronousRepoMethods getH2Repo() {
//        def repo = PrimesRepoForH2
//        repo
//    }

}