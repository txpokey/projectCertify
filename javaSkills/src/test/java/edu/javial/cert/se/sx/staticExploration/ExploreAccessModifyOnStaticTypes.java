package edu.javial.cert.se.sx.staticExploration;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
@Slf4j
public class ExploreAccessModifyOnStaticTypes {

    private static class ComponentPrivateStatic { }
    public static class ComponentPublicStatic { }
    protected static class ComponentProtectedStatic { }
    static class ComponentDefaultStatic { }
    private static String serialNumberPrivate = "1234Private";
    public static String serialNumberPublic = "1234Public";
    protected static String serialNumberProtected = "1234Protected";
    static String serialNumberDefault = "1234Default";

    public static class Mouse {
        void printSN() {
            System.out.println("MOUSE-" + serialNumberPrivate);
        }
    }
    public void sanityCheck() {
        Assert.assertNotNull(log);
        log.info("ping!");
        log.debug("ping!");
    }
    private static Logger log = LoggerFactory.getLogger(ExploreAccessModifyOnStaticTypes.class);
}
