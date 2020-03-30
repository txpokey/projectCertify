package sci.certify.testing.spock.fundamentals

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification

class ExploreIgnoreScenarios extends Specification{
    private static boolean isOsWindows() {
        System.properties['os.name'] == 'windows'
    }
    @IgnoreIf({ Boolean.valueOf(properties['spock.ignore.longRunning']) })
    def "run spec if Java system property 'spock.ignore.longRunning' is not set or false"() {
        expect:
        true
    }
    @IgnoreIf({ Boolean.valueOf(env['SPOCK_IGNORE_LONG_RUNNING']) })
    def "run spec if environment variable 'SPOCK_IGNORE_LONG_RUNNING' is not set or false"() {
        expect:
        true
    }
    @IgnoreIf({ javaVersion < 1.7 })
    def "run spec if run in Java 1.7 or higher"() {
        expect:
        true
    }
    @IgnoreIf({ javaVersion != 1.7 })
    def "run spec if run in Java 1.7"() {
        expect:
        true
    }
    @IgnoreIf({ isOsWindows() })
    def "run only if run on non-windows operating system"() {
        expect:
        true
    }
    @Requires({ Boolean.valueOf(sys['spock.longRunning']) })
    def "run spec if Java system property 'spock.longRunning' is true"() {
        expect:
        true
    }
    @Requires({ Boolean.valueOf(env['SPOCK_LONG_RUNNING']) })
    def "run spec if environment variable 'SPOCK_LONG_RUNNING' is true"() {
        expect:
        true
    }
    @Requires({ javaVersion >= 1.7 })
    def "run spec if run in Java 1.7 or higher expressed as @Requires"() {
        expect:
        true
    }
    @Requires({ jvm.isJava8() })
    def "run spec if run in Java 1.8"() {
        expect:
        true
    }
    @Requires({ os.isWindows() })
    def "run only if run on windows operating system"() {
        expect:
        true
    }
    @Requires({ jvm.isJava7Compatible() })
    class RequiresSpec extends Specification {
        def "all feature methods run only if JVM is Java 7 compatible"() {
            expect:
            true
        }
    }
}
