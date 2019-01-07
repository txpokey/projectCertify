package sci.category.certify

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["sci.category.certify"])

class AppForSyncH2{
    static void main(String[] args) {
        SpringApplication.run AppForSyncH2, args
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