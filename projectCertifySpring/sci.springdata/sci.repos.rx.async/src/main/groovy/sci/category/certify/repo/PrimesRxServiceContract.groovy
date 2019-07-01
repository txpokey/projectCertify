package sci.category.certify.repo

import sci.category.certify.domain.PrimesRx

interface PrimesRxServiceContract{

    PrimesRx save(PrimesRx p )
    String getSpecies()
}

