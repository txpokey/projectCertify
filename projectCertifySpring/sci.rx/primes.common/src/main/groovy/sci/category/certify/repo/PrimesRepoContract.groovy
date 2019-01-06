package sci.category.certify.repo

import sci.category.certify.domain.Primes

interface PrimesContentRepo {

}

interface PrimesRepoContract extends PrimesContentRepo {

    Primes save(Primes p )

}