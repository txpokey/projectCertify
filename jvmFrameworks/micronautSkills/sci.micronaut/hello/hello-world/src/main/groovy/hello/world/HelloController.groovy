package hello.world

import groovy.util.logging.Slf4j
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Slf4j
@Controller("/hello")
class HelloController {

    @Get("/")
    HttpStatus index() {
        log.debug("This is a HELLO WORLD")
        return HttpStatus.OK
    }
    @Get("Bob") // this mapping is case sensitive
    def bobIsHere() {
        log.debug(BOB_MESSAGE)
        def re = HttpResponse.status(HttpStatus.OK).body(BOB_MESSAGE)
        re
    }
    private final static BOB_MESSAGE = "This is a HELLO WORLD from Bob"
}