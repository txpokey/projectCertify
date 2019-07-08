package hello.gorm.controller

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import hello.gorm.domain.Primes
import hello.gorm.service.PrimesService
import hello.gorm.service.util.PrimesServiceUtil
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject

@Slf4j
@Controller("/hello")
class HelloController{

    @Inject PrimesService primesService

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
    @Transactional
    @Get("findAll") // this mapping is case sensitive
    def doFindAll() {
        log.debug("HERE")
        def candidate = primesService.findAll()
        def re = HttpResponse.status(HttpStatus.OK).body(candidate)
        re
    }
    @Transactional
    @Get("bootStrap")
    def doBootStrap() {
        List<Primes> candidate = PrimesServiceUtil.executeBootStrap(primesService)
        candidate
    }


    private final static BOB_MESSAGE = "This is a HELLO WORLD from Bob"
}