package hello.world

import Client
import EmbeddedServer
import MicronautTest
import RxHttpClient
import HttpResponse
import HttpStatus
import AutoCleanup
import Specification

import Inject


@MicronautTest
class HelloControllerSpec extends Specification {

    @Inject
    EmbeddedServer embeddedServer

    @AutoCleanup @Inject @Client("/")
    RxHttpClient client



    void "test index"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/hello")

        expect:
        response.status == HttpStatus.OK
    }
}
