package com.selenium.learnings.revision.oops.inheritance;

import com.selenium.learnings.revision.oops.AccessControl.Parent;

public class Child extends Parent {



    public static void main(String[] args) {
        Child child = new Child();
        child.height = 5.0f;
    }



    void greet(){
        System.out.println("Hello World from Child");
    }
}
