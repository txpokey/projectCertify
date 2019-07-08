package hello.gorm.service.bootstrap

import hello.gorm.domain.Primes
import hello.gorm.service.PrimesService
import hello.gorm.service.util.PrimesServiceUtil

import javax.annotation.Nonnull

@javax.inject.Singleton
class PrimesBootStrap{

    private PrimesService primesService

    PrimesBootStrap( @Nonnull PrimesService primesService ) {
        this.primesService = primesService
    }
    List<Primes> executeBootStrap() {
        def all = PrimesServiceUtil.getPrimesInRange(1..100)
        def candidate = all.collect {
            p ->
                def just = primesService.save(p)
                just
        }
        candidate
    }
}
