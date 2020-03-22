package sci.category.certify.repo

import sci.category.certify.domain.Primes

interface PrimesServiceContract{

    Primes save(Primes p )
    String getSpecies()
}

