package edu.javial.cert.se.core.collections

import spock.lang.Specification


class ImmutableCollectionsJava9Spec extends Specification{

    def "what kind of list"(){
        given:
        def immutableCollectionsList = List.of("1","2", "3")
        def arrayList = ["1","2","3"]
        expect:
        arrayList
        immutableCollectionsList
    }
    def "what kind of map"(){
        given:
        def immutableCollectionsMap = Map.of( "a" , "1", "b" , "2")
        def linkedHashMap = [ a: "1" , b: "2"]
        expect:
        linkedHashMap
        immutableCollectionsMap
    }
}