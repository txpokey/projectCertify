package sci.category.certify.service.util

import groovy.util.logging.Slf4j
import org.testng.annotations.Test

import javax.annotation.Nonnull

@Test
@Slf4j
class NullityTests{

//    void sanityCheck() {
//
//        final def mapFor1 = [prime: 1, truth: false, species: 'mapFor1']
//        def shouldPass = Primes.of(mapFor1)
//        shouldPass
//
//    }
//    @Test(expectedExceptions = AssertionError.class)
//    void expectFails() {
//        final def goofyMap = [ prime: null, truth: false, species: 'goofyMap']
//        def shouldFail = Primes.of(  goofyMap )
//        shouldFail
//    }

    void sanityCheck() {
        methodDemonstratingNullity( "I am Groot")
    }
    @Test(expectedExceptions = AssertionError.class)
    void expectFails() {
        methodDemonstratingNullity( null )
    }
    private void methodDemonstratingNullity( @Nonnull String species ) {
        log.debug("method ran in this case : ${species}")
    }
}
