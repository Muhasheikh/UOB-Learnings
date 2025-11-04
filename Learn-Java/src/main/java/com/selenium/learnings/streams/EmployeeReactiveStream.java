package com.selenium.learnings.streams;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeReactiveStream {

    String name;
    double salary;

    public EmployeeReactiveStream(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeReactiveStream{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {

//        EmployeeReactiveStream.getEmployees()
//                .map(emp -> emp.salary)
//                .subscribe(System.out::println);
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Press any key to exit.");
//        sc.next();

        List<EmployeeReactiveStream> employees = Arrays.asList(
                new EmployeeReactiveStream("Muhassan",1200.0),
                new EmployeeReactiveStream("Rashid",10000.0)
        );

        Map<String, Double> collect =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.name,
                                Collectors.summingDouble(e -> e.salary)));

    }

    public static Flux<EmployeeReactiveStream> getEmployees() {
        List<EmployeeReactiveStream> employees = Arrays.asList(
                new EmployeeReactiveStream("Muhassan",1200.0),
                new EmployeeReactiveStream("Rashid",10000.0)
        );
       return Flux.fromIterable(employees).delayElements(Duration.ofMillis(2000));
    }


}
