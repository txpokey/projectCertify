package jh.thoughtworks.conferencer.biz

import jh.thoughtworks.conferencer.domain.Event

/**
 * Created by mak on 11/27/14.
 */
class EventComparator implements Comparator<Event>{
  @Override
  int compare(Event o1, Event o2) {
    assert o1
    assert o2
    return o1.minutes - o2.minutes
  }
}
