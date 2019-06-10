package sci.category.certify

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Profile
import sci.category.certify.service.bootstrap.BootstrapDataService

import javax.annotation.PostConstruct

//@SpringBootApplication(scanBasePackages = ["sci.category.certify"])
@Profile(["deadbeef"])

class App{
    static void main(String[] args) {
        SpringApplication.run App, args
    }
    @Autowired
    @Qualifier("bootstrapTool")
    private BootstrapDataService spinner

    @PostConstruct
    void postConstruct() {
        assert spinner
//        def result = spinner.spinUp()
//        assert result
    }
}