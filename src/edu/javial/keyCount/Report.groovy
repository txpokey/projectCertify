package edu.javial.keyCount

/**
 * Created by mak on 7/15/14.
 */
class Report {

  def location = "./var/testData/keyCount"
  Report( String whereData ) { location = whereData ?: location }

  def List fetchFileContentsAsList() {
    new File(location).readLines()
  }

  def fetchAndProcessFileContentsAsKeyCounts = {
      def done = fetchFileContentsAsList().inject( [:] , processFileContentsAsKeyCount )
  }
  def processFileContentsAsKeyCount = { cache, l ->
    def m = [:]
    def keyAndValue = l.split(',')
    def key = keyAndValue[0]
    m[ key ] = ( keyAndValue[1] as Integer )
    def last = cache[key ] ?: 0
    cache[key] = last + m[key]
    return cache
  }
  def reportFileContentsAsKeyCounts = {
    def done = fetchAndProcessFileContentsAsKeyCounts()
    reportFileContentsKeyCounts()
  }
  def reportFileContentsKeyCounts = {
//    cache.each { k, v -> println "The total for ${k} is ${v}" }
  }
}
