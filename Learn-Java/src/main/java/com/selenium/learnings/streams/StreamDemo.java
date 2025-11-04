package com.selenium.learnings.streams;

import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .peek(x -> System.out.println("A " + x))
                .skip(1)
                .forEach(y -> System.out.println("B " + y));
    }
}
