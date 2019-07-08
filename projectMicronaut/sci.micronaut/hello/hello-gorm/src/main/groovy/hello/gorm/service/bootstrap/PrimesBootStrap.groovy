package hello.gorm.service.bootstrap

import hello.gorm.domain.Primes
import hello.gorm.service.PrimesService
import hello.gorm.service.util.PrimesServiceUtil

import javax.annotation.Nonnull

@javax.inject.Singleton
class PrimesBootStrap{

    private PrimesService primesService

    final def species = "bootstrap-sync"

    PrimesBootStrap( @Nonnull PrimesService primesService ) {
        this.primesService = primesService
    }
    List<Primes> executeBootStrap() {
        def all = PrimesServiceUtil.getPrimesInRange(1..100, species)
        def candidate = all.collect {
            p ->
                def just = primesService.save(p)
                just
        }
        candidate
    }
}
