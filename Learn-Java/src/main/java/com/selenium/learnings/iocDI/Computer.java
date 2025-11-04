package com.selenium.learnings.iocDI;


import org.springframework.stereotype.Component;

@Component
public class Computer {

   private final Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void start(){
        System.out.println("Computer is running");
        keyboard.plugin();

    }
}
