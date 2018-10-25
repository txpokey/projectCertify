package edu.javial.cert.se.sx.staticExploration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

interface NeedStaticContract {

    default   String[] getMyStaticRoutes() {
        return new String[0];
    };
}

@Test
public class ExploreInterfacesVsStaticMethodsTest implements NeedStaticContract {

    public String[] getMyStaticRoutes() {
        final String[] candidate = { "toughGuy"} ;
        return candidate;
    }

    public void whichRouteWillRun() {
        String[] whichWillItBe = getStaticRoutes() ;
        log.debug("");
    }
    public static String[] getStaticRoutes() {
        final ExploreInterfacesVsStaticMethodsTest candidate = new ExploreInterfacesVsStaticMethodsTest();
        return candidate.getMyStaticRoutes() ;
    }
    private static Log log = LogFactory.getLog(ExploreInterfacesVsStaticMethodsTest.class);

}
