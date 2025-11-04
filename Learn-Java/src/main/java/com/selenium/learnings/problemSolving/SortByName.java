package com.selenium.learnings.problemSolving;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SortByName {

    public static void main(String[] args) {


        BiFunction<Integer,Integer,String> result = (val1,val2) -> {
            return String.valueOf(val1 + val2) + " " + String.valueOf(val2);
        };


        Map<String, Integer> people = new HashMap<>();
        people.put("David", 95);
        people.put("Jane", 80);
        people.put("Mary", 97);
        people.put("Lisa", 78);
        people.put("Dino", 65);


        people.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
