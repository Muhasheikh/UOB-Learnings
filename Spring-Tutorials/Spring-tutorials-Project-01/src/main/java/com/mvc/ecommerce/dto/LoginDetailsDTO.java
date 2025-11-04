package com.mvc.ecommerce.dto;

import com.mvc.ecommerce.validators.CustomerLoginValidator;
import jakarta.validation.constraints.NotBlank;


public class LoginDetailsDTO {
    @NotBlank
    @CustomerLoginValidator
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDetailsDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
