package javial.cert.sx.cast;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CastGymnasticsTest {

    @Test
    public void testGetWeirdOnCasting() throws Exception {

    }
    @Test
    public void testListStringCastToListObject() {
        List<String> myNullStrings = null;
        List<Object> myTargetObjects = null;
        List<?> myTargetWildcarded = null;
//        myTargetObjects = myNullStrings;  // SX error : incompatible types
        myTargetWildcarded = myNullStrings;  // Java8 : not a SX error
        assertNull( "List<String> is not castable to List<?>", myTargetWildcarded);
        String[] myStringArray = {"front", "center", "tail"};
        List<String> myStringList = Arrays.asList(myStringArray);
        assertNotNull( "array of strings converted to List failed", myStringList);
        Object whatWillItBeAtRunTime = Arrays.asList(myStringArray);
        myTargetWildcarded = Arrays.asList(myStringArray);

        assertNotNull( "Arrays.asList output can be assigned List<?>", myTargetWildcarded);

    }
}