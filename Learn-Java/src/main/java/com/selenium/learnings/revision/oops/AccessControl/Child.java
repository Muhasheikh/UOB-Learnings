package com.selenium.learnings.revision.oops.AccessControl;

public class Child {

    public static void main(String[] args) {
        Parent parent = new Parent(12.0f);
        Parent parent1 =new Parent(12.0f);

        System.out.println(parent1.equals(parent));
        System.out.println(parent1.hashCode());
        System.out.println(parent.hashCode());
    }
}
