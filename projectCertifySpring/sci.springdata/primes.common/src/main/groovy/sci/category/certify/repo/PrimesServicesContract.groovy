package sci.category.certify.repo

import sci.category.certify.domain.Primes

interface PrimesServicesContract{

    Primes save(Primes p )
    String getSpecies()
}

