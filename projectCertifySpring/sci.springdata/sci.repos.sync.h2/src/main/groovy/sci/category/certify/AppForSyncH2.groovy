package sci.category.certify

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import sci.category.certify.service.bootstrap.BootstrapDataService

import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["sci.category.certify"])

class AppForSyncH2{
    static void main(String[] args) {
        SpringApplication.run AppForSyncH2, args
    }

    @Autowired
    @Qualifier("syncBootstrapDataServices")
    private BootstrapDataService spinner

    @PostConstruct
    void postConstruct() {
        assert spinner
        def result = spinner.spinUp()
        assert result
    }
}