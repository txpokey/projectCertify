package sci.certify.testing.spock.fundamentals

import spock.lang.Specification

import static org.hamcrest.Matchers.*

class ExploreHamcrestMatchers extends Specification{

    def "sample usage of hamcrest matcher hasKey"() {
        given:
        final sampleMap = [name: 'mrhaki']
        expect:
        sampleMap hasKey('name')
        sampleMap not(hasKey('party')) // To show assertion message.
    }

}
