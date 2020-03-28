package sci.category.certify.repo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("default")
class PrimesRepositorySpeciesConfig {

    @Bean(name = "primesRepositorySpecies")
    String getSpecies() {
        final String species = "postgres-sync"
    }
}