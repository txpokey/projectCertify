package sci.category.certify.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import sci.category.certify.repo.PrimesContentRepo
import sci.category.certify.repo.PrimesRepoContractForH2

@Service
class PrimesContentServiceUsingH2 extends PrimesContentBaseService {

    @Autowired
//    @Qualifier("primesContentRepoUsingH2")
    private PrimesRepoContractForH2 primesContentRepo

    @Override
    PrimesContentRepo getRepository() {
        return primesContentRepo
    }
}
