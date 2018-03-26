package edu.javial.cert.se.sx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Optional;

public class AutoboxFeatureTest<T> {
    private static Log log = LogFactory.getLog(AutoboxFeatureTest.class);

    private String passStringThrough( String dum ) {
        return dum ;
    }
    private String convertTypeToString( T dum ) {
        String candidate = dum.toString() ;
        return candidate;
    }
    Optional<T> wanker ;

//    private String convertTypeToString( Optional<T> dum ) {
//        String candidate = dum.orElse(T.class.newInstance()).toString() ; // SX: smoke
//        return candidate;
//    }
    @Test
    public void intToStringAutoBoxTest()
    {
        int count = 1;
        Integer c = count;

        String countAsString = count + "" ;

        assert "1".equals(countAsString);
//        assert "1".equals(passStringThrough((String)count));  // SX: will not smoke
        assert "1".equals(passStringThrough("" + count));

        assert "1".equals(convertTypeToString((T)c));

        ;

    }
}
