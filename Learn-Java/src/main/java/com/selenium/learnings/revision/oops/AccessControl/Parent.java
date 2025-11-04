package com.selenium.learnings.revision.oops.AccessControl;

public class Parent {

    private int id;
    String name;
    protected double price;
    public float height;

    public Parent() {
    }

    public Parent(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return this.price == ((Parent)obj).price;
    }

    @Override
    public int hashCode() {

      return Double.hashCode(price) ;
    }
}
