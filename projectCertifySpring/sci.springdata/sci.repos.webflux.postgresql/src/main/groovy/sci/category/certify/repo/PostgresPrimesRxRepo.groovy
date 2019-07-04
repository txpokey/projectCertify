package sci.category.certify.repo

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import sci.category.certify.domain.PrimesRx

@Repository
interface PostgresPrimesRxRepo
        extends PrimesRxRepositoryContract,
                R2dbcRepository<PrimesRx, Long>{
}
