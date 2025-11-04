package com.mvc.ecommerce.util.exceptions;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public void handleUserExistsException(UserExistsException e,Model model) {
       boolean val =  model.containsAttribute("registerDTO");
        System.out.println("contains " + val );
    }
}
