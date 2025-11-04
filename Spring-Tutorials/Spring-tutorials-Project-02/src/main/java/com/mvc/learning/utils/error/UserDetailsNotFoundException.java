package com.mvc.learning.utils.error;

public class UserDetailsNotFoundException extends NullPointerException{

    public UserDetailsNotFoundException(String message) {
        super(message);
    }
}
