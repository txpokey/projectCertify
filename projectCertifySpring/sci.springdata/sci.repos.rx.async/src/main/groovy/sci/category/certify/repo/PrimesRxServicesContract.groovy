package sci.category.certify.repo

import sci.category.certify.domain.PrimesRx

interface PrimesRxServicesContract{

    PrimesRx save(PrimesRx p )
    String getSpecies()
}

