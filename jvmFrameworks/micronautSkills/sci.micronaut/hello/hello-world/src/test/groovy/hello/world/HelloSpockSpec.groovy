package hello.world

import groovy.util.logging.Slf4j
import spock.lang.Shared
import spock.lang.Specification

//@MicronautTest
@Slf4j
class HelloSpockSpec extends Specification {

    @Shared message = 'Hello world!'
    def "The world can say hello using expect"(){
        log.info("this si a TEST")
        expect:
        message == 'Hello world!'
    }
}


