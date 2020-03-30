package sci.certify.testing.spock.fundamentals

import spock.lang.Specification
import spock.lang.Unroll

class ExploreUnroll extends Specification{
    @Unroll
    def "check if '#value' is lower case"() {
        expect:
        value.every { (it as char).isLowerCase() } == result
        where:
        value || result
        'A' || false
        'Ab' || false
        'aB' || false
        'a' || true
        'ab' || true
    }
    @Unroll
// Alternatively syntax as
// unroll annotation argument:
// @Unroll("'#value' is #unrollDescription")
    def "'#value' is #unrollDescription"() {
        expect:
        value.every { (it as char).isLowerCase() } == result
        where:
        value || result
        'A' || false
        'Ab' || false
        'aB' || false
        'a' || true
        'ab' || true
        unrollDescription = result ? 'lower case' : 'not lower case'
    }
}
