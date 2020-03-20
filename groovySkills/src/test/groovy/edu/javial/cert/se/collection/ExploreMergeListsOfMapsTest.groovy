package edu.javial.cert.se.collection

import org.testng.annotations.Test

@Test
//@Slf4j
class ExploreMergeListsOfMapsTest {
    final def listA = [[Name: 'mr good', note: 'good',rating:9], [Name: 'mr bad', note: 'bad',rating:5]]
    final def listB = [[Name: 'mr good', note: 'good',score:77], [Name: 'mr bad', note: 'bad', score:12]]

    void tryGroupBy() {
        def listIn = listA + listB
        def grouped = listIn.groupBy { item -> item.Name }
        def answer = grouped.inject([], { candidate, item -> candidate += mergeMapkeys( item.value )})
//        log.info(answer.dump())
    }

    private def mergeMapkeys( List maps ) {
        def ret =  maps.inject([:],{ mergedMap , map -> mergedMap << map })
        ret
    }
}
