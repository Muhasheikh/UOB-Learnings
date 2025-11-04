package com.selenium.learnings.asyncProgramming;

public class Demo extends Thread {


    public static void main(String[] args) {

        Demo  test = new Demo();
        test.start();

        for (int i=0; i<10; i++) {
            System.out.println("Thread Running from " + Thread.currentThread().getName());
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World " + Thread.currentThread().getName());
        }

    }
}

