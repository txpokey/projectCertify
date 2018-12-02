package sci.category.certify.service.bootstrap

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

import java.time.format.DateTimeFormatter

interface BootstrapContract {
    final static def MONTH_DATE_YEAR_FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy" )
    boolean spinUp()
}

@Slf4j
@Service("bootstrapTool")
class BootstrapDataService implements BootstrapContract {

    @Autowired
    @Qualifier("primesContentBootstrap")
    BootstrapContract primesContentBootstrap

    boolean spinUp() {
        final def bootstrapingList = [ primesContentBootstrap ]

        bootstrapingList.each { member ->
            def result = member.spinUp()
            assert result
        }
        true
    }


}