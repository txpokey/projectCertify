package sci.category.certify.service.bootstrap.repository
//
//import com.category.fans.domain.CollegeEvent
//import com.category.fans.repository.CollegeEventRepository
//import com.category.fans.service.bootstrap.BootstrapContract
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Component
//
//import java.time.LocalDate
//
//@Component("collegeEventsBootstrap")
//class PrimesContentBootstrap implements BootstrapContract {
//
//    private static def formatter = BootstrapContract.MONTH_DATE_YEAR_FORMATTER
//
//    @Autowired
//    private CollegeEventRepository eventRepository
//
//    boolean spinUp() {
//        all.each { mapIn ->
//            def event0 = new CollegeEvent(mapIn)
//            def m0 = eventRepository.saveAndFlush(event0)
//            assert m0.id
//        }
//        true
//    }
//
//    private final static def header = [
//            [ name : "2018 Fall Guitar Events at Collin College" ,
//              date : "Date" ,
//              time : "Time" ,
//              room : "Location/Room" ,
//              event : "Events"
//            ] ,
//    ]
//    private final static def events = [
//            [ name : "Guitar Get Together" ,
//              date : "8/31/2018" ,
//              time : "Friday 1-3pm" ,
//              room : "C104 Spring Creek" ,
//              event : "Guitar Get Together"
//            ] ,
//            [ name : "Guitar Get Together" ,
//              date : "9/14/2018" ,
//              time : "Friday 1-3pm" ,
//              room : "C104 Spring Creek" ,
//              event : "Guitar Get Together"
//            ] ,
//            [ name : "Guitar Get Together" ,
//              date : "10/12/2018" ,
//              time : "Friday 1-3pm" ,
//              room : "C104 Spring Creek" ,
//              event : "Guitar Get Together"
//            ] ,
//            [ name : "Guitar Get Together" ,
//              date : "10/26/2018" ,
//              time : "Friday 1-3pm" ,
//              room : "C104 Spring Creek" ,
//              event : "Guitar Get Together"
//            ] ,
//            [ name : "Guitar Get Together" ,
//              date : "11/9/2018" ,
//              time : "Friday 1-3pm" ,
//              room : "C104 Spring Creek" ,
//              event : "Guitar Get Together"
//            ] ,
//            [ name : "Guitar Get Together" ,
//              date : "11/30/2018" ,
//              time : "Friday 1-3pm" ,
//              room : "C104 Spring Creek" ,
//              event : "Guitar Get Together"
//            ] ,
//            [ name : "Jay Armstrong" ,
//              date : "10/10/2018" ,
//              time : "Wed 12pm" ,
//              room : "B-187 Spring Creek" ,
//              event : "WNR Student Recital: Jay Armstrong"
//            ] ,
//            [ name : "Aaron Ringo, Luthier" ,
//              date : "10/17/2018" ,
//              time : "Wed 12pm" ,
//              room : "B-187 Spring Creek" ,
//              event : "WNR Recital: Aaron Ringo, Luthier"
//            ] ,
//
//            [ name : "Guitar Artist Showcase" ,
//              date : "11/14/2018" ,
//              time : "Wed 7pm " ,
//              room : "The Arts Gallery (A-175)" ,
//              event : "Guitar Artist Showcase"
//            ]
//            ,
//            [ name : "Solo Guitar Concert " ,
//              date : "12/5/2018" ,
//              time : "Wed 7pm " ,
//              room : "The Arts Gallery (A-175)" ,
//              event : "Solo Guitar Concert "
//            ]
//            ,
//            [ name : "Guitar/Piano Ensembles Concert" ,
//              date : "11/27/2018" ,
//              time : "Tue 7pm" ,
//              room : "John Anthony Theatre  " ,
//              event : "Guitar/Piano Ensembles Concert"
//            ]
//    ].sort {a,b-> compareOnDateField(a, b) }
//
//    private static compareOnDateField(LinkedHashMap<String, String> a, LinkedHashMap<String, String> b) {
//        LocalDate.parse(a.date, formatter).compareTo(LocalDate.parse(b.date, formatter))
//    }
//    private final static def all = header + events
//}
