package sci.certify.testing.spock.fundamentals

import spock.lang.Specification
import spock.lang.Stepwise
import spock.util.mop.ConfineMetaClassChanges

// We use @Stepwise in this specification
// to show that changes in the metaClass
// done in the first feature method do not
// work in the second feature method.
@Stepwise
class ExploreMetaClassChanges extends Specification{
    // After this feature method is finished,
// the metaClass changes to the given
// class (String in our case) are reverted.
    @ConfineMetaClassChanges([String])
    def "talk like a pirate"() {
        setup:
        String.metaClass.asPirate = { ->
            return "Yo-ho-ho, ${delegate}"
        }
        expect:
        'mrhaki'.asPirate() == 'Yo-ho-ho, mrhaki'
    }
// In this feature method we no longer
// can use the asPirate() method that was
// added to the metaClass.
    def "keep on talking like a pirate"() {
        when:
        'hubert'.asPirate()
        then:
        thrown(MissingMethodException)
    }
}
