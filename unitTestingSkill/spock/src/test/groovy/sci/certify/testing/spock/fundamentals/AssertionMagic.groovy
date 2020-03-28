package sci.certify.testing.spock.fundamentals

import spock.lang.Specification

class AssertionMagic extends Specification {
    def "Create new course with teacher and description"() {
        setup:
        def courseService = new CourseService()
        when:
        def course = courseService.create('mrhaki', 'Groovy Goodness')
        then:
        'Groovy Goodness' == course.description
        !course.students
        'Mrhaki'.equalsIgnoreCase(course.teacher.name)
    }
    class CourseService {
        Course create(String teacherName, String description) {
            new Course(teacher: new Person(name: teacherName), description: description)
        }
    }
    class Course {
        Person teacher
        String description
        List<Person> students
    }
    class Person {
        String name
    }
}
