package com.selenium.learnings.revision.oops.inheritance;

public class Parent {

    String name;

    public Parent(String name) {
        System.out.println("Parent Constructor" + this.name);
    }

    void greet(){
        System.out.println("Hello World");
    }
}
