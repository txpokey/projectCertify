package sci.category.certify.rx.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import sci.category.certify.service.PrimesContentBaseService

class PrimesContentServiceUsingRxMongo extends PrimesContentBaseService {
    @Autowired
    @Qualifier("primesContentRepoUsingH2")
    private sci.category.certify.rx.repo.PrimesContentRepo primesContentRepo

    @Override
    sci.category.certify.rx.repo.PrimesContentRepo getRepository() {
        return primesContentRepo
    }
}
