package edu.javial.cert.se.core.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Test
public class ExploreMapTest {
    private static Log log = LogFactory.getLog(ExploreMapTest.class);

    public void checkContainsValue() {

        final String v1 = "this is my country";
        Map<String, String> map = new HashMap<>();
        map.put("t0", "my apple sauce is sweet");
        map.put("t1", v1);

        boolean hit0 = map.containsValue("apple");
        boolean hit1 = map.containsValue(v1);
        assert (hit0 || hit1) == true;
        map.keySet().forEach(k -> mapPatternBiConsumer.accept(map, k));

    }

    private final BiConsumer<Map<String, String>, String> mapPatternBiConsumer = (map, key) -> {
        Pattern p = Pattern.compile("^.*apple.*$");
        String val = map.get(key);
        Matcher m = p.matcher(val);
        boolean matches = m.matches();
        assert null != val;
    };
}
