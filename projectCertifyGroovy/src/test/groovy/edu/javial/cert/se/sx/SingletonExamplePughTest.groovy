package edu.javial.cert.se.sx
/*
 * Created by mak on 9/13/14.
 * TODO multi-threaded on the bumpCounter
 * TODO SingletonExamplePugh : dont want it as separate file, but has static methods.... so reverse and let test be
 * the innner class
 */
class SingletonExamplePughTest extends GroovyTestCase {

  SingletonExamplePugh tool0, tool1;

  void setUp() {
    tool0 = SingletonExamplePugh.getInstance();
    tool1 = SingletonExamplePugh.getInstance();
  }
  void testOrdinalVaue() {
    log.info("INSTANCE ordinal value:tool0> " + tool0);
    log.info("INSTANCE ordinal value:tool1> " + tool1);
  }


  void testBumpCounter() {
    int count0 = tool0.bumpCounter();
    assert 0 == count0
    int count1 = tool1.bumpCounter();
    assert 1 == count1
    assert 1 == tool0.getCount()
    assert 1 == SingletonExamplePugh.getCount()
  }

  void testGetInstance() {
    assert tool0;
    assert tool1;
    assert ((tool0 == tool1));
  }

}
