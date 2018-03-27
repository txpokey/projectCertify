package edu.javial.cert.se.sx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.util.stream.IntStream;


public class AutoboxFeatureTest<T> {
    private static Log log = LogFactory.getLog(AutoboxFeatureTest.class);

    private String passStringThrough( String dum ) {
        return dum ;
    }
    private String convertTypeToString( T dum ) {
        String candidate = dum.toString() ;
        return candidate;
    }

// TODO nice to explore Optional here
//    private String convertTypeToString( Optional<T> dum ) {
//        String candidate = dum.orElse(T.class.newInstance()).toString() ; // SX: smoke
//        return candidate;
//    }

    interface SampleContractForAutoBoxingIntegers {
        Integer fromInt( int in ) ;
        int fromInteger( Integer in );
    }

    @Test
    public void intToStringConvertTest()
    {
        int count = 1;
        Integer c = count;

        String countAsString = count + "" ;

        assert "1".equals(countAsString);
//        assert "1".equals(passStringThrough((String)count));  // SX: will not smoke
        assert "1".equals(passStringThrough("" + count));

        assert "1".equals(convertTypeToString((T)c));

    }
    @Test
    public void autoBoxIntegerTest() {

        SampleContractForAutoBoxingIntegers sample = new SampleContractForAutoBoxingIntegers() {
            @Override
            public Integer fromInt(int in) {
                Integer candidate = in ;
                assert null != candidate ;
                assert candidate.intValue() == in ;
                return candidate;
            }

            @Override
            public int fromInteger(@Nonnull Integer in) {
                int candidate = in ;
                assert Integer.valueOf(candidate).equals(in);
                return candidate;
            }
        };
        IntStream.range(0, 3).forEachOrdered(n -> {
//            log.info( "result: " + sample.fromInt( n ));
//            log.info( "result: " + sample.fromInteger( sample.fromInt(n) ));
            int roundTripValue =  sample.fromInteger( sample.fromInt(n) ) ;
            assert roundTripValue == n ;
        });
    }
}
