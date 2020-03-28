package sci.certify.testing.spock.fundamentals.mock

import spock.lang.Specification
import spock.lang.Subject

class ExploreMockPlusTripleGreaterThanTerminal extends Specification{

    final String[] sizeThese = ['one', 'two', 'three', 'four', 'five']
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
    @Subject
    def util = new StringUtil()
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
    def "Calculate sizes of String values by stubbing calculator interface"() {
        given:
        def calculator = Mock(Calculator)
        util.calculator = calculator
        when:
        def total = util.size('one', 'two', 'three', 'four', 'five')
        then:
        calculator.calculateSize(_) >>> [1, 3, 4]
        total == 1 + 3 + 4 + 4 + 4
    }


}