package com.mvc.ecommerce.validators.impl;

import com.mvc.ecommerce.validators.CustomerLoginValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CustomerLoginValidatorImpl implements ConstraintValidator<CustomerLoginValidator,String> {
    private int minLength ;
    private String regexOp;

    public CustomerLoginValidatorImpl() {
        System.out.println("Inside the customValidator");
    }

    @Override
    public void initialize(CustomerLoginValidator validator) {
        this. minLength = validator.min();
        this.regexOp = validator.userNameRegex();
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return userName.length() > minLength && userName.matches(regexOp);

    }
}
