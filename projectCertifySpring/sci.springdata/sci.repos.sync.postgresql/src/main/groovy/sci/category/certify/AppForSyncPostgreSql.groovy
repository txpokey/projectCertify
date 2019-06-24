package sci.category.certify

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import sci.category.certify.service.bootstrap.BootstrapDataService

import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["sci.category.certify"])

class AppForSyncPostgreSql {
    static void main(String[] args) {
        SpringApplication.run AppForSyncPostgreSql, args
    }

    @Autowired
    @Qualifier("syncBootstrapDataServices")
    private BootstrapDataService bootspinner

    @PostConstruct
    void postConstruct() {
        assert bootspinner
//        def result = bootspinner.spinUp()
//        assert result
    }
}