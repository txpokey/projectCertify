package edu.javial.cert.se.core.collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExampleRequiredOrPermittedAttributeIdiom {
    final static Log log = LogFactory.getLog(ExampleRequiredOrPermittedAttributeIdiom.class);

    static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttrs, Set<K>permittedAttrs) {
        boolean valid = true;
        Set<K> attrs = attrMap.keySet();

        valid = isValidVsAttributes(requiredAttrs, valid, attrs, "Missing attributes: ");
        valid = isValidVsAttributes(attrs, valid, permittedAttrs, "Illegal attributes: ");
        return valid;
    }
    private static <K> boolean isValidVsAttributes(Set<K> requiredAttrs, boolean valid, Set<K> attrs, String s) {
        if (!attrs.containsAll(requiredAttrs)) {
            Set<K> missing = new HashSet<K>(requiredAttrs);
            missing.removeAll(attrs);
            log.debug(s + missing);
            valid = false;
        }
        return valid;
    }
}
