package sci.category.certify.service.bootstrap

import org.springframework.stereotype.Component

import java.time.format.DateTimeFormatter

interface BootstrapContract {
    final static def MONTH_DATE_YEAR_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy" )
    boolean spinUp()
}

@Component("bootstrapTool")
class BootstrapDataService implements BootstrapContract {

    private final List<BootstrapContract>  bootstrapingList

    BootstrapDataService( List<BootstrapContract> list ) {
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