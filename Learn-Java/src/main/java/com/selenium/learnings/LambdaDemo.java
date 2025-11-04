package com.selenium.learnings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LambdaDemo<T,R extends String>  {

    void print(TestLambda testLambda){
        testLambda.printHelloWorld();
    }



    public static void main(String[] args) {
        TestLambda testLambda = () -> System.out.println("Hello World");
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.print(testLambda);

    }



}

interface TestLambda{

    void printHelloWorld();
}
