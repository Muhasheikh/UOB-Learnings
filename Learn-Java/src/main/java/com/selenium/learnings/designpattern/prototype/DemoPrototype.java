package com.selenium.learnings.designpattern.prototype;

public class DemoPrototype 
{

    public static void main(String[] args) throws CloneNotSupportedException {
        
        Registry registry = new Registry();
        Person person = registry.getPerson("person");
        Person person1 = registry.getPerson("person");

        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());
    }
}
