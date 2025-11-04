package com.mvc.learning.utils.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserDetailsNotFoundException.class)
    public String handleExceptionUserNotFound(UserDetailsNotFoundException exception, Model model){
        ErrorResponse errorResponse = new ErrorResponse(404,exception.getMessage(),"");
        model.addAttribute("errorResponse",errorResponse);

        return "error";
    }
}
