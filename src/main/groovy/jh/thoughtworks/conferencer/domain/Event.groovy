package jh.thoughtworks.conferencer.domain

/**
 * Created by mak on 11/27/14.
 */
class Event {
  public final static String UNKNOWN_EVENT = 'unknownEvent'
  public final static String UNKNOWN_INPUT = 'unknownInput'
  public final static int UNKNOWN_COUNT = -1
  String line = UNKNOWN_INPUT
  String normalized = UNKNOWN_EVENT
  int minutes = UNKNOWN_COUNT
  int track = UNKNOWN_COUNT
  int session = UNKNOWN_COUNT
}
