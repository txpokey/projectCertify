package edu.javial.algorithm

/**
 * Created by Bob Makowski on 7/17/14.
 */
class Palindrome {

  static String EMPTY = ""
  static String SCRUBBER = "[^a-z0-9]" // this ignores Locale
  def detect = { String raw ->
    def candidate = raw ?: EMPTY
    String scrubbed = scrubTerminals candidate.toLowerCase()
    def ret = (scrubbed == EMPTY) ? false : (scrubbed.reverse() == scrubbed)
    return ret
  }
  def scrubTerminals = { String candidate ->
    candidate?.replaceAll(SCRUBBER, EMPTY)
  }
}
