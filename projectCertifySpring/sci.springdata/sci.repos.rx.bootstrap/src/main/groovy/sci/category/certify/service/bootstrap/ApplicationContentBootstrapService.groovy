package sci.category.certify.service.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

import java.time.format.DateTimeFormatter

interface BootstrapContract{
    final static def MONTH_DATE_YEAR_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy")

    boolean spinUp()
}

interface ApplicationContentBootstrapContract extends BootstrapContract{}

@Component("applicationContentBootstrap")
class ApplicationContentBootstrapService implements ApplicationContentBootstrapContract{

    private final List<BootstrapContract> bootstrapingList

    @Autowired
    ApplicationContentBootstrapService(@Qualifier("applicationContentBootstrapList")
                                               List<ApplicationContentBootstrapContract> list) {
        bootstrapingList = list
    }

    boolean spinUp() {
        bootstrapingList.each { member ->
            def result = member.spinUp()
            assert result
        }
        true
    }


}