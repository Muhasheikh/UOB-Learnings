package com.learning.spring.refOrPassBy;

public class Demo {

    String name;

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.changeName(demo);
        System.out.println(demo.name);


    }
    void changeName(Demo demo) {
        demo.name = "Muhassan";
        demo = new Demo();
        demo.name="Faizal";
    }
}
