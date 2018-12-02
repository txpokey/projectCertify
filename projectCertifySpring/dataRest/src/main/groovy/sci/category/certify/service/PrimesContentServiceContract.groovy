package sci.category.certify.service

import sci.category.certify.repo.PrimesContentRepo

interface PrimesContentServiceContract extends PrimesContentRepo {

    PrimesContentRepo getRepository()

}
