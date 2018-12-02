package sci.category.certify.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import sci.category.certify.repo.PrimesContentRepo

class PrimesContentServiceUsingH2 extends PrimesContentBaseService{
    @Autowired
    @Qualifier("primesContentRepoUsingH2")
    private PrimesContentRepo primesContentRepo

    @Override
    PrimesContentRepo getRepository() {
        return primesContentRepo
    }
}
