package com.selenium.learnings.iocDI;


import org.springframework.stereotype.Component;

@Component
public class Keyboard {

    void plugin(){
        System.out.println("Keyboard plugin");
    }

    String callUser(){
        return "user";
    }
}
