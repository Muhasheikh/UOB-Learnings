package com.mvc.learning.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileNumberValidatorImp implements ConstraintValidator<MobileNumberValidator,String> {


    private int maxLength;
    private String regex;

    @Override
    public void initialize(MobileNumberValidator mobileNumberValidator) {
        this.maxLength = mobileNumberValidator.max();
        this.regex = mobileNumberValidator.regexMobile();
    }

    @Override
    public boolean isValid(String mobileNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(mobileNumber == null || mobileNumber.trim().isEmpty()){
            return false;
        }
        else if(!mobileNumber.matches(regex)){
            return false;
        }
       else return mobileNumber.length() <= maxLength;
    }
}
