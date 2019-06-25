package sci.category.certify

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import sci.category.certify.service.bootstrap.ApplicationContentBootstrapService

import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["sci.category.certify"])

class AppForSyncOra{
    static void main(String[] args) {
        SpringApplication.run AppForSyncOra, args
    }
    @Autowired
    @Qualifier("applicationContentBootstrap")
    private ApplicationContentBootstrapService bootspinner

    @PostConstruct
    void postConstruct() {
        assert bootspinner
//        def result = bootspinner.spinUp()
//        assert result
    }
}