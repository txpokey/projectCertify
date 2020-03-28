package edu.javial.cert.se.sx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Optional;

public class NullExplorationTest {
    private static Log log = LogFactory.getLog(NullExplorationTest.class);

    private String cLevelAttribute ;

    private String methodReturningNull() {
        String testIt = null ; // SX: will fail compile without some initialization
        return testIt ;
    }
    private Optional<String> methodReturningOptionalWithNull(){
        Optional<String> candidate = Optional.ofNullable(methodReturningNull());
        return candidate;
    }
    @Test
    public void  uninitializedMemberLevelAttributeTest(){
        String test0 = methodReturningNull() ;
        assert null == test0 ;
        Optional<String> test1 = methodReturningOptionalWithNull();
        assert "null" == test1.orElse("null");
    }
    private void exploreOfNullable() {
        Optional<String> summary = Optional.ofNullable("A summary");
        summary.ifPresent(System.out::println);
    }
}
