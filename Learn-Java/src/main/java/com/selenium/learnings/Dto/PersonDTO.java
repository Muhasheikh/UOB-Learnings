package com.selenium.learnings.Dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonDTO {

    @Value("first.name")
    private String firstName;


   public void print() {
       System.out.println(firstName);
   }
}
