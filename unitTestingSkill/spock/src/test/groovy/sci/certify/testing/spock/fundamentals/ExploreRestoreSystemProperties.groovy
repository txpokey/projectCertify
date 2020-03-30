package sci.certify.testing.spock.fundamentals

import spock.lang.Specification
import spock.lang.Stepwise
import spock.util.environment.RestoreSystemProperties

// Use Stepwise extension so the order
// of method invocation is guaranteed.
@Stepwise
class ExploreRestoreSystemProperties extends Specification{
// Changes to Java system properties in this
// method are undone once the method is done.
    @RestoreSystemProperties
    def "first method adds a Java system property"() {
        setup:
        System.properties['spockAdded'] = 'Spock is gr8'
        expect:
        System.properties['spockAdded'] == 'Spock is gr8'
    }

    def "second method has no access to the new property"() {
        expect:
        !System.getProperty('spockAdded')
    }
}