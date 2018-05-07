package edu.javial.cert.se.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * https://java2blog.com/java-8-stream-filter-examples/
 */
@Test
public class Java8StreamFilterExamplesTest {
    private static Log log = LogFactory.getLog(Java8StreamFilterExamplesTest.class);

    static class Student {

        enum SEX {
            M("Male"), F("Female");

            private String sex;

            SEX(@Nonnull String _sex) {
                sex = _sex;
            }
            @Override
            public String toString() {
                return sex ;
            }
        }

        private int id;
        private String name;
        private SEX gender;
        private int age;

        Student(int id, @Nonnull String name, @Nonnull SEX gender, int age) {
            super();
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        int getId() {
            return id;
        }
        String getName() {
            return name;
        }
        SEX getGender() {
            return gender;
        }
        int getAge() {
            return age;
        }
        @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", gender=" + gender
                    + ", age=" + age + "]";
        }

        static List<Student> createStudentList() {
            final Student[] referenceStudentRolls = {
                    new Student(1, "Arpit", SEX.M, 19),
                    new Student(22, "John", SEX.M, 17),
                    new Student(3, "Mary", SEX.F, 14),
                    new Student(4, "Martin", SEX.M, 21),
                    new Student(5, "Monica", SEX.F, 16),
                    new Student(2, "John", SEX.M, 27),
                    new Student(6, "Ally", SEX.F, 20)
            };
            final List<Student> studentList = Arrays.asList(referenceStudentRolls);
            return studentList;
        }
    }

    public void originalTest() {
        final List<Student> studentList = Student.createStudentList();
        // Filter based on sex
        filterBasedOnGender(studentList, Student.SEX.M);
        // Filter based on name
        filterBasedOnName(studentList, "John");
    }

    private void filterBasedOnGender(@Nonnull List<Student> studentList, @Nonnull Student.SEX sex) {
        // Filter all male students
        List maleStudents = studentList.stream()
                .filter(getStudentGenderPredicate(sex))
                .collect(Collectors.toList());
        log.debug(sex + " students are :> " + maleStudents);
    }

    private Predicate<Student> getStudentGenderPredicate(@Nonnull Student.SEX sex) {
        return s -> s.getGender().equals(sex);
    }

    private void filterBasedOnName(@Nonnull List<Student> studentList, @Nonnull String name) {
        Student student = studentList.stream()
                .filter(getStudentNamePredicate(name))
                .findAny()
                .orElse(null);
        log.debug("Student with Name " + name + ":> " + student);
    }

    private Predicate<Student> getStudentNamePredicate(@Nonnull String name) {
        return s -> s.getName().equalsIgnoreCase(name);
    }

}
