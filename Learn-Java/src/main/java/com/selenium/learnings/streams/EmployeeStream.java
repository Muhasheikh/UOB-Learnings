package com.selenium.learnings.streams;

import org.springframework.util.comparator.Comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeStream {

    String name;
    double salary;

    public EmployeeStream(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public static void main(String[] args) {
        List<EmployeeStream> employees = Arrays.asList(
                new EmployeeStream("Muhassan",1200.0),
                new EmployeeStream("Rashid",10000.0)
        );


        Stream<Double> doubleStream = employees.stream().map(e -> e.salary);
        List<Double> sorted = doubleStream.sorted(Comparator.naturalOrder()).limit(1).toList();
        System.out.println(sorted);
        sorted.forEach(System.out::println);
    }
}
