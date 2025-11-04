package com.mvc.learning.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountrySelecValidatorImpl  implements ConstraintValidator<CoutrySelectValidator,String> {
    @Override
    public boolean isValid(String countryVal, ConstraintValidatorContext constraintValidatorContext) {

        return !countryVal.isEmpty();
    }
}
