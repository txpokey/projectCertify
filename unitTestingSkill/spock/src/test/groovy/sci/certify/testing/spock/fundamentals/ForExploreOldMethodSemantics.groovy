package sci.certify.testing.spock.fundamentals

import spock.lang.Specification

class ForExploreOldMethodSemantics extends Specification {
    def "after addition of a new value the content is the initial value with the appended value"() {
        given:
        final StringBuilder builder = new StringBuilder('Spock ')
        when:
        builder << appendValue.capitalize()
        then:
        builder.toString() == old(builder.toString()) + appendValue.capitalize()
        where:
        appendValue << ['rocks!', 'is fun.', 'amazes.']
    }
}