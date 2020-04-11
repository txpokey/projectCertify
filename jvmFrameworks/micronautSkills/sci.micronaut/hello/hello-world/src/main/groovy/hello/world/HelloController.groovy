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
        def timedMessage = "${BOB_MESSAGE} @ ${new Date()}"
        log.debug(timedMessage)
        def re = HttpResponse.status(HttpStatus.OK).body(timedMessage)
        re
    }
    private final static BOB_MESSAGE = "This is a HELLO WORLD from Bob"
}