package com.selenium.learnings.GenericsSorting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoClient {

    public static void main(String[] args) {
        List<StaffEmployee> employeeList = new LinkedList<StaffEmployee>(List.of(new StaffEmployee(10,"Muhassan"),
                new StaffEmployee(2,"Rashid")));

//        Collections.sort(employeeList);
        StaffEmployee.sort(employeeList);
        System.out.println(employeeList);
        
        
        List<List<String>> stringList = List.of(Arrays.asList("Muhassan", "Rashid"));
        List<String> list = stringList.stream().flatMap(str-> str.stream().map(str1 -> str1.toUpperCase() + " Hello")).toList();
        List<List<String>> listMap = stringList.stream().map(str -> str.stream().map(st1 -> st1.toUpperCase() + " Hi").toList()).toList();
        System.out.println(listMap);
        System.out.println(list);

    }

}
