package com.mvc.learning.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;
import java.util.stream.Collectors;

public class CreditNumberValidatorImp implements ConstraintValidator<CreditCardNumberValidator,String> {
    private Integer digitMaxLength;
    private String regex;
    List<Boolean> containsInvalid = new ArrayList<>();

    @Override
    public void initialize(CreditCardNumberValidator creditCardNumberValidator) {
        this.digitMaxLength = creditCardNumberValidator.max();
        this.regex = creditCardNumberValidator.regex();

    }

    @Override
    public boolean isValid(String creditCardNumber, ConstraintValidatorContext constraintValidatorContext) {

        if(creditCardNumber == null || creditCardNumber.length() != digitMaxLength) {
            return false;
        }
        else if(!creditCardNumber.matches(regex)){
            return false;

        }
        return true;
    }
}
