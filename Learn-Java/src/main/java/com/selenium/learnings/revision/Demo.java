package com.selenium.learnings.revision;


public class Demo {

    static String color;

    public static void main(String[] args) {

        swap();
        System.out.println(color);
        Greetings.greet();
        System.out.println("Demp clas "+ color);


     }


     public static void swap() {
        color = "Red";
     }


}
