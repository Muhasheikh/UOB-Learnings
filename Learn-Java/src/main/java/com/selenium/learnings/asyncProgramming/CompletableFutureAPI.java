package com.selenium.learnings.asyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureAPI {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureAPI completableFutureAPI = new CompletableFutureAPI();
        CompletableFuture.runAsync(completableFutureAPI::printHelloworld);
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World " + Thread.currentThread().getName());
        }

    }


    void printHelloworld() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello World " + Thread.currentThread().getName());
        }
    }
}
