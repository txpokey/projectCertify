package sci.certify.testing.spock.fundamentals

import spock.lang.Specification
import spock.lang.Subject

class UserServiceSpec extends Specification{
    @Subject
    private UserService userService = new DefaultUserService()

    def "check user properties"() {
        when:
        final User user = userService.findUser("mrhaki")
        then:
        // Assert each property.
        user.username == "mrhaki"
        user.name == "Hubert A. Klein Ikkink"
    }

    def "check user properties using with()"() {
        when:
        final User user = userService.findUser("mrhaki")
        then:
        // Assert using with().
        with(user) {
            username == "mrhaki"
            name == "Hubert A. Klein Ikkink"
        }
    }

    def "check expected user properties using with()"() {
        expect:
        with(userService.findUser("mrhaki")) {
            username == "mrhaki"
            name == "Hubert A. Klein Ikkink"
        }
    }

    interface UserService{
        User findUser(final String username)
    }

    class DefaultUserService implements UserService{
        User findUser(final String username) {
            new User(username: "mrhaki", name: "Hubert A. Klein Ikkink")
        }
    }

    class User{
        String username
        String name
    }
}
