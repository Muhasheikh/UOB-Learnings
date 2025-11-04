package com.selenium.learnings.revision.oops.polymorphism;

import java.awt.*;

public class Triangle extends Shapes {

    @Override
     double area(int length) {
        return length * length + 1;
    }


    public static void main(String[] args) {
        Shapes s = new Triangle();
        s.area(1);
    }
    }
