package sci.category.certify.service

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sci.category.certify.domain.PrimesRx
import sci.category.certify.repo.PrimesRxRepositoryContract
import sci.category.certify.repo.PrimesRxServiceContract

import javax.annotation.Nonnull

@Component("primesService")
class PrimesRxService implements PrimesRxServiceContract {
    @Autowired
    PrimesRxRepositoryContract primesRepoContract

    private String species

    @Autowired
    PrimesRxService(@Qualifier("primesRepositorySpecies") String species ) {
        this.species = species
    }

    Mono<PrimesRx> save(@Nonnull PrimesRx p) {
        Mono<PrimesRx> saved = primesRepoContract.save( p )
        assert saved
        saved
    }

    @Override
    Flux<PrimesRx> saveAll(@Nonnull List<PrimesRx> plist) {
        def candidate = primesRepoContract.saveAll( plist )
        candidate
    }

    @Override
    String getSpecies() {
        return species
    }

    static List<PrimesRx> getPrimesInRange(@Nonnull Range<Integer> range, @Nonnull String species = 'default') {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i,species) }
        candidate
    }

    private static getPrimeViaConstructorOnMap(@Nonnull int i, @Nonnull String species) {
        Map m = [prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species]
        def p = new PrimesRx(m)
    }
}
