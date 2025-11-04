package com.selenium.learnings.problemSolving;

import java.util.Objects;
import java.util.Optional;

public class OptionalHandling {

    Person person;

    private class Person{
        String firstName;
        String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        OptionalHandling obj = new OptionalHandling();
        Person person1 = obj.returnPerson();

        Optional.ofNullable(person1).ifPresent(System.out::println);


    }

    public Person returnPerson() {
        return this.new Person("John", "Doe");
    }
}
