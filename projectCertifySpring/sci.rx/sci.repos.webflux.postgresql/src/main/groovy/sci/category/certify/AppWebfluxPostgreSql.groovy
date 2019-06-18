package sci.category.certify

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["sci.category.certify"])

class AppWebfluxPostgreSql {
    static void main(String[] args) {
        SpringApplication.run AppWebfluxPostgreSql, args
    }

//    @Autowired
//    @Qualifier("bootstrapTool")
//    private BootstrapDataService spinner
//
//    @PostConstruct
//    void postConstruct() {
//        assert spinner
//        def result = spinner.spinUp()
//        assert result
//    }
}