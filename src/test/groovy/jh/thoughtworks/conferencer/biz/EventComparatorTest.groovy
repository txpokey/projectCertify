package jh.thoughtworks.conferencer.biz

import jh.thoughtworks.conferencer.domain.Event

/*
 * Created by mak on 11/27/14.
 */
/**
 * Tests for the {@link EventComparator} class.
 */
class EventComparatorTest extends GroovyTestCase {
  EventComparator tool

  void setUp() {
    super.setUp()
    tool = new EventComparator()
  }
  void testCompare() {
    def events = [ seed0, less0, equal0, more0 ].collect { new Event(it)}
    def ref = events[0]
    def probe = events[1..3]
    // can't use the combinations() method on the iterator because of comparator.
    // so doing it 'by hand' here with the injector accumulating combos
    def data = probe.inject( [] , { all , it -> all << [ ref , it ] })

    def results = data.collect { testCombination it }
    assert [ 1 , 0 , -1 ] == results
  }
  def testCombination = { combo  ->
    def left = combo[0]
    def right = combo[1]

    tool.compare( left, right )
  }
  void testCompareBoundaries() {
    shouldFail { tool.compare( null, new Event(seed0)) }
    shouldFail { tool.compare(  new Event(seed0), null) }
  }
  final Map less0 = [
    line : 'less0' ,
    normalized : 'BAR' ,
    minutes : 21 ,
    session : 5 ,
    track : 3
  ]
  final Map equal0 = [
    line : 'equal0' ,
    normalized : 'BAR' ,
    minutes : 22 ,
    session : 5 ,
    track : 3
  ]
  final Map more0 = [
    line : 'more0' ,
    normalized : 'BAR' ,
    minutes : 23 ,
    session : 5 ,
    track : 3
  ]
  final Map seed0 = [
    line : 'seed0' ,
    normalized : 'BAR' ,
    minutes : 22 ,
    session : 5 ,
    track : 3
  ]
}
