package sci.certify.testing.spock.fundamentals.mock

import spock.lang.Specification

class ExploreStubsInSpock extends Specification{
    def "should always size the list at '3'"() {
        given:
        List list = Stub()
        list.size() >> 3
        expect:
        // let's see if this works
        list.size() == 3
    }
    def "should return 2 for method parameter equal to 2"() {
        given:
        List list = Stub()
        list.get(0) >> 0
        list.get(1) >> { throw new IllegalArgumentException() }
        list.get(2) >> 2
        expect:
        list.get(2) == 2
    }
}