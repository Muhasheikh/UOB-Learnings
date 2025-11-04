package com.selenium.learnings.asyncProgramming;

import java.util.concurrent.*;

public class FutureAPIDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureAPIDemo futureAPIDemo = new FutureAPIDemo();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Callable<String> callable = () -> {
            for (int i = 0; i < 10; i++) {
                futureAPIDemo.printHelloworld();
            }
            return "Done Printing";
        };

        Future<String> submit = executor.submit(callable);
        if(submit.isDone()) {
            System.out.println(submit.get());
        }
        System.out.println("Submit done");
    }

    void printHelloworld() {
        System.out.println("Hello World " + Thread.currentThread().getName());
    }
}

