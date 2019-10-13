package edu.javial.cert.se.sx.exploreClasses;

/**
 * can not have private or protected top level classes
 */
public class ExplorePublicAccessModifiersClassLevel {

    private class PrivateAccessInnerClass {}
    protected class ProtectedAccessInnerClass {}
    class DefaultAccessInnerClass {}
}

/**
 * example of default level class
 */
class DefaultAccessModifiersClassLevel {
    private class PrivateAccessInnerClass {}
    protected class ProtectedAccessInnerClass {}
    class DefaultAccessInnerClass {}
}