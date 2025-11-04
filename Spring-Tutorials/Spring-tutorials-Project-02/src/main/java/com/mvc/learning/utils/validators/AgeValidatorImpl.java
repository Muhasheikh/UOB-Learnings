package com.mvc.learning.utils.validators;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidatorImpl implements ConstraintValidator<AgeValidator, Integer> {

    private int lower;
    private int upper;
    @Override
    public void initialize(AgeValidator age) {
       this.lower = age.lower();
       this.upper = age.upper();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        if(age == null){
            return false;
        }
        else if(age < lower || age > upper) {
            return false;
        }

        return true;
    }
}
