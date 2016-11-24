package jh.thoughtworks.conferencer.domain

/**
 * Tests for the {@link Event} class.
 */
/*
 * Created by mak on 11/27/14.
 */

  class EventTest extends GroovyTestCase {
  void testGetLine() {
    def e = new Event()
    print e.dump()
  }
  void testConstructorDefaults() {
    def e = new Event()
    assert Event.UNKNOWN_INPUT == e.line
    assert Event.UNKNOWN_EVENT == e.normalized
    assert Event.UNKNOWN_COUNT == e.minutes
    assert Event.UNKNOWN_COUNT == e.session
    assert Event.UNKNOWN_COUNT == e.track
  }
  void testConstructorMapped() {
    final Map seed0 = [
      line : 'FOO' ,
      normalized : 'BAR' ,
      minutes : 22 ,
      session : 5 ,
      track : 3
    ]
    def e = new Event(seed0)
    assert seed0.line == e.line
    assert seed0.normalized == e.normalized
    assert seed0.minutes == e.minutes
    assert seed0.session == e.session
    assert seed0.track == e.track
  }
}
