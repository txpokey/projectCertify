package sci.category.certify

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["sci.category.certify"])

class App{
    static void main(String[] args) {
        SpringApplication.run App, args
    }
//    @Autowired
//    @Qualifier("applicationContentBootstrap")
//    private BootstrapDataService spinner
//
//    @PostConstruct
//    void postConstruct() {
//        assert spinner
//        def result = spinner.spinUp()
//        assert result
//    }
}