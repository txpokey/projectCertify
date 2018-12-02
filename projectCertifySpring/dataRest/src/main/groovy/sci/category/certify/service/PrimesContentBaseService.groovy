package sci.category.certify.service

import org.springframework.lang.NonNull
import sci.category.certify.domain.Primes

abstract class PrimesContentBaseService implements PrimesContentServiceContract {

    @Override
    Primes save(@NonNull Primes p) {
        Primes saved = getRepository().save( p )
        saved
    }
}
