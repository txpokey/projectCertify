package edu.javial.cert.gse.sx

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.testng.annotations.Test

@Test
class ExploreBasicSyntaxTest {
    final static Log log = LogFactory.getLog(ExploreBasicSyntaxTest.class);

    void testMe() {
        log.debug("test me")
    }

    void lookAtLists() {
        def stringyList = [ "this" , "${new Date()}" , 'isA', "test:> ${this}"]
        log.debug(stringyList)
        def list = [0,1,2,3,4]
        assert list[2] == 2
        list[2] = 4
        assert list[0..2] == [0,1,4]
        list[0..2] = [6,6,6] // this is COOL example...
        assert list == [6,6,6,3,4]

        def listOfNames = ['Grace','Rob','Emmy']
        assert ('Emmy' in listOfNames)
    }
    void lookAtAppendingMaps() {
        def schoolTerm0 = [ schoolYear: 2018, schoolTerm: 'spring' ]
        def schoolTerm1 = [ schoolYear: 2018, schoolTerm: 'spring' ]
        def schoolTerm2 = [ schoolYear: 2018, schoolTerm: 'fall' ]
        def lookupSchoolTerm = [:]
        lookupSchoolTerm << [ key: '2018|spring|' , value : schoolTerm0 ]
        lookupSchoolTerm << [ key: '2018|fall|' , value : schoolTerm2 ]
        lookupSchoolTerm << [ keydup: '2018|fall|' , dupvalue : schoolTerm1 ]
        def lookupSchoolTerms = []
        lookupSchoolTerms << [ key: '2018|spring|' , value : schoolTerm0 ]
        lookupSchoolTerms << [ key: '2018|fall|' , value : schoolTerm2 ]
        lookupSchoolTerms << [ keydup: '2018|fall|' , dupvalue : schoolTerm1 ]

//        log.debug("schoolYears:> ${lookupSchoolTerms*.value}")
        log.debug("lookupSchoolTerms.properties:> ${lookupSchoolTerms.properties}")
        log.debug("lookupSchoolTerms.dump:> ${lookupSchoolTerms.dump()}")
        log.debug("DONE")
    }


    void lookAtRanges() {
        final def aThruD = ('a'..'d')
        assert aThruD.collect() == ['a','b','c','d']
        def propsMap = aThruD.properties
        log.debug("propsMap:> ${propsMap}")

        int count = -1 ;
        def x = ('a'..'d').stream().forEach( { x -> log.debug(x) ; ++count } )
        assert count == aThruD.size() - 1
        assert null == x

        def range = 0..5
        assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
        assert (0..<5).collect() == [0, 1, 2, 3, 4]
        assert (0..5) instanceof List
        assert (0..5).size() == 6
        log.debug("DONE")
    }
    void lookAtSpread() {
        def cars = [
                new Car(make: 'Peugeot', model: '508'),
                new Car(make: 'Renault', model: 'Clio')]
        def makes = cars*.make
        assert makes == ['Peugeot', 'Renault']
    }
    void lookAtSpreadArgs() {
        def args = [4,5,6]
        assert function(*args) == 26
        args = [4]
        assert function(*args,5,6) == 26
        args = [4,5]
        assert function(*args,6) == 26
        args = [5,6]
        assert function(4, *args) == 26
    }
    void lookAtSpreadMaps() {
        def m1 = [c:3, d:4]
        def map = [a:1, b:2, *:m1]
        assert map == [a:1, b:2, c:3, d:4]
        def mm1 = [c:3, d:4]
        def mmap = [a:1, b:2, *:mm1, d: 8]
        assert mmap == [a:1, b:2, c:3, d:8]
    }
    void lookAtCallOperator() {
        def mc = new MyCallable()
        assert mc.call(2) == 4
        assert mc(2) == 4
    }
    int function(int x, int y, int z) {
        x*y+z
    }
    class Car {
        String make
        String model
    }

    class MyCallable {
        int call(int x) {
            2*x
        }
    }
}
