package sci.category.certify.repo

import sci.category.certify.domain.PrimesRx

interface PrimesServicesContract{

    PrimesRx save(PrimesRx p )
    String getSpecies()
}

