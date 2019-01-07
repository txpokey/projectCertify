package sci.category.certify.rx.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import sci.category.certify.repo.PrimesContentRepo
import sci.category.certify.service.PrimesContentBaseService

class PrimesContentServiceUsingRxMongo extends PrimesContentBaseService {
    @Autowired
    @Qualifier("primesContentRepoUsingMongo")
    private PrimesContentRepo primesContentRepo

    @Override
    PrimesContentRepo getRepository() {
        return primesContentRepo
    }
}