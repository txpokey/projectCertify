package hello.gorm.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/map")
class HelloMapsController{

    final private Map useCasesMapCandidate = [
            plan : "My God! It's Full of Stars" ,
            edu : ["physics","applied math"],
            meal : [lunch : "chili" , diner : ["chicken","rice"]]
    ]
    @Get("useCases")
    def whatWillThisDo() {
        def re = HttpResponse.status(HttpStatus.OK).body(useCasesMapCandidate)
        re
    }
}
