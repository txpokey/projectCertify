package edu.javial.keyCount

/**
 * Created by Bob Makowski on 7/15/14.
 */
class Report {

  static def defaultLocation = "./var/testData/keyCount"
  def location = defaultLocation

  Report(String whereData) { location = whereData ?: defaultLocation }

  def reportFileContentsAsKeyCounts = {
    def reportingMap = fetchAndProcessFileContentsAsKeyCounts()
    reportFileContentsKeyCounts reportingMap
  }

  /**
   * fetches the content line by line, parses each line, and maps the key, value pairs.
   */
  def fetchAndProcessFileContentsAsKeyCounts = {
    fetchFileContentsAsList().inject([:], processFileContentsAsKeyCount)
  }

  /**
   * converts file into a List of lines
   */
  def List fetchFileContentsAsList() {
    verifiedFileLocation(location).readLines()
  }

  /**
   * parses a line, and maps the key, value pairs.
   */
  def processFileContentsAsKeyCount = { Map keyCountMap, String line ->
    String[] parsedLine = line.split(",")
    validateParsedLine(parsedLine)
    String key = parsedLine[0]
    Integer value = parsedLine[1] as Integer
    keyCountMap[key] = (keyCountMap[key] ?: 0) + value
    return keyCountMap
  }
  def reportFileContentsKeyCounts = { reportingMap ->
    reportingMap.each { k, v -> println "The total for ${k} is ${v}" }
  }

  def validateParsedLine( String[] tokenArray ) {
    assert null != tokenArray
    assert null != tokenArray[0]
    assert null != tokenArray[1]
  }

  def File verifiedFileLocation( String path ) {
    assert null != path
    File f = new File(path)
    assert f.exists()
    assert f.file
    return f
  }
}
