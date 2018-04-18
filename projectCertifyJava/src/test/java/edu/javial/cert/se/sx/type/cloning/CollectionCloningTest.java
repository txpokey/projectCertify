package edu.javial.cert.se.sx.type.cloning;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

// cf. https://javarevisited.blogspot.com/2014/03/how-to-clone-collection-in-java-deep-copy-vs-shallow.html

/**
 *
 */
@Test
public class CollectionCloningTest {
    private static Log log = LogFactory.getLog(CollectionCloningTest.class);

    public void demonstrateShallowCopy() {
        Collection<Employee> org = getEmployeesOrganization();
        Collection<Employee> shallowCopy = getEmployeesViaShallowCopy(org);
        log.debug("Original Collection :> " + org);
        log.debug("Copy Collection :> " + shallowCopy);
        convertAllToStaff(org);
        log.debug("Original Collection after modification :> " + org);
        log.debug("shallowCopy Collection without modification :> " + shallowCopy);
    }

    public void demonstrateDeepCopy() {
        Collection<Employee> org;
        org = getEmployeesOrganization();
        Collection<Employee> deepCopy = getEmployeesViaDeepCopy(org);
        log.debug("Original Collection without modification :> " + org);
        log.debug("DeepCopy Collection without modification :> " + deepCopy);
        convertAllToStaff(deepCopy);
        log.debug("Original Collection after DeepCopy modification :> " + org);
        log.debug("DeepCopy Collection after modification :> " + deepCopy);
    }

    private Collection<Employee> getEmployeesViaDeepCopy(@Nonnull Collection<Employee> org) {
        HashSet<Employee> replacement = org.stream().map(Employee::clone).collect(Collectors.toCollection(HashSet::new));
        return replacement;
    }

    private Collection<Employee> getEmployeesViaShallowCopy(@Nonnull Collection<Employee> org) {
        // creating copy of Collection using copy constructor
        return new HashSet<>(org);
    }

    private void convertAllToStaff(@Nonnull Collection<Employee> org) {
        final Consumer<Employee> employeeDesignationMutator = e -> e.setDesignation("staff");
        org.stream().forEach(employeeDesignationMutator);
    }

    private Collection<Employee> getEmployeesOrganization() {
        final Employee[] orgMembers = {
                new Employee("Joe", "Manager"),
                new Employee("Tim", "Developer"),
                new Employee("Frank", "Developer")
        };
        HashSet<Employee> org =
                Arrays.stream(orgMembers).collect(Collectors.toCollection(HashSet::new));
        return org;
    }

    class Employee implements Cloneable {
        private String name;
        private String designation;

        public Employee(String name, String designation) {
            this.name = name;
            this.designation = designation;
        }
        public String getDesignation() {
            return designation;
        }
        public void setDesignation(String designation) {
            this.designation = designation;
        }
        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return String.format("%s: %s", name, designation);
        }
        @Override
        protected Employee clone() {
            Employee clone = null;
            try {
                clone = (Employee) super.clone();

            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e); // won't happen
            }
            return clone;
        }
    }
}

