package sci.certify.testing.spock.fundamentals

import spock.lang.Specification
import spock.lang.Subject

class ExploreMockPlusTripleGreaterThanTerminal extends Specification{
    @Subject
    def util = new StringUtil()
    final String[] sizeThese = ['one', 'two', 'three', 'four', 'five']

    def "explore string sum passing in closure for the calculation"() {
        when:
        def count = sizeThese.sum { it -> it.length() }
        then:
        -1 != count
    }
    def "explore calculator variation with stub only 'one' string "() {
        given:
        Calculator calculator = Stub() {
            calculateSize('one') >> 10000
        }
        when:
        def count = sizeThese.sum { it -> calculator.calculateSize(it) }
        then:
        -1 != count
    }
    def "explore calculator variation with stub any string "() {
        given:
        Calculator calculator = Stub() {
            calculateSize(_) >> { def ss ->
                String tok = ss[0]
                10000 + tok.length()
            }
        }
        when:
        def count = sizeThese.sum { it ->
            calculator.calculateSize(it)
        }
        then:
        -1 != count
    }
    def "Calculate sizes of String values"() {
        given:
        def calculator = Mock(Calculator)
        util.calculator = calculator
        calculator.calculateSize(sizeThese) >>> {10000}
        util.calculator = calculator
        when:
        def total = util.size()
        then:
        total == 1 + 3 + 4 + 4 + 4
    }
    def "Calculate sizes of String values - THIS BOOK EXAMPLE DOES NOT WORK "() {
        given:
        def calculator = Mock(Calculator)
        util.calculator = calculator
        when:
        def total = util.size('one', 'two', 'three', 'four', 'five')
        then:
        calculator.calculateSize(_) >>> [1, 3, 4]
        total == 1 + 3 + 4 + 4 + 4
    }
    interface Calculator {
        int calculateSize(final String s)
    }
    class StringUtil{
        def calculator

        int size(final String[] s) {
            int result = s.sum { it -> calculator.calculateSize(it) }
            result
        }
    }
    def "should return Role.USER when asked for role"() {
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