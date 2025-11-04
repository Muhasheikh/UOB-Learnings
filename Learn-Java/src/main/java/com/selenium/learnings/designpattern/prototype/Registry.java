package com.selenium.learnings.designpattern.prototype;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    public Registry() {
        init();
    }

    private Map<String,Person> personMap = new HashMap<>();;

    public Person getPerson(String name) throws CloneNotSupportedException {
        return (Person) personMap.get(name).clone();
    }


    public void init(){
        Person person = new Person("Muhassan",24);
        personMap.put("person",person);
    }
}
