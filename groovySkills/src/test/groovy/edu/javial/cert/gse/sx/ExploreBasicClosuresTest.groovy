package edu.javial.cert.gse.sx

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.testng.annotations.Test

@Test
class ExploreBasicClosuresTest{
    final static Log log = LogFactory.getLog(ExploreBasicClosuresTest.class);

    void lookAtInjectAsReduction() {
        def sum = (1..4).inject(0) { result, i -> result + i }
        assert 10 == sum
        def sum2 = (1..4).inject(0, { result, i -> result + i })
        assert sum2 == sum
    }

}
