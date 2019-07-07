package hello.world

import groovy.util.logging.Slf4j
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus


@Slf4j
@Controller("/hello")
class HelloController {

    @Get("/")
    HttpStatus index() {
        log.debug("This is a HELLO WORLD")
        return HttpStatus.OK
    }
}