package sci.certify.testing.spock.fundamentals

import spock.lang.Specification

class SpockTestBasics extends Specification {
    class UserService{
        List users

        int count() {
            return null == users ? -1 : users.size()
        }
    }

    def "Return total number of users"() {
        setup: 'Create UserService instance with 2 users'
        def userService = new UserService(users: ['mrhaki', 'hubert'])
        expect: 'Invoke count() method'
        2 == userService.count()
    }

    def "Return total number of users when no users constructed"() {
        setup: 'Create UserService instance with no users in constructor'
        def userService = new UserService()
        expect: 'Invoke count() method'
        -1 == userService.count()
    }

    def "Return total number of users verse where clause"() {
        setup: 'Create UserService instance with userList from where clause'
        def userService = new UserService(users: userList)
        expect: 'Invoke count() method'
        expectedCount == userService.count()
        where:
        expectedCount | userList
        -1            | null
        0             | []
        1             | ['mrhaki']
        2             | ['mrhaki', 'hubert']
    }
}
