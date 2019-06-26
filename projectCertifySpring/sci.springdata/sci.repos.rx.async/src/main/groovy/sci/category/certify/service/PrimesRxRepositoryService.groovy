package sci.category.certify.service

import edu.javial.cert.se.core.math.PrimeNumberGroovy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component
import sci.category.certify.domain.PrimesRx
import sci.category.certify.repo.PrimesRxRepositoryContract
import sci.category.certify.repo.PrimesRxServicesContract

@Component("primesRepositoryService")
class PrimesRxRepositoryService implements PrimesRxServicesContract {
    @Autowired
    PrimesRxRepositoryContract primesRepoContract

    private String species

    @Autowired
    PrimesRxRepositoryService(@Qualifier("primesRepositorySpecies") String species ) {
        this.species = species
    }

    PrimesRx save(@NonNull PrimesRx p) {
        PrimesRx saved = primesRepoContract.save( p )
        assert saved
        saved
    }

    @Override
    String getSpecies() {
        return species
    }

    static List<PrimesRx> getPrimesInRange(@NonNull Range<Integer> range, @NonNull String species = 'default') {
        def candidate = (range).collect { i -> getPrimeViaConstructorOnMap(i,species) }
        candidate
    }

    private static getPrimeViaConstructorOnMap(@NonNull int i, @NonNull String species) {
        Map m = [prime: i, truth: PrimeNumberGroovy.isPrime(i), species: species]
        def p = new PrimesRx(m)
    }
}
