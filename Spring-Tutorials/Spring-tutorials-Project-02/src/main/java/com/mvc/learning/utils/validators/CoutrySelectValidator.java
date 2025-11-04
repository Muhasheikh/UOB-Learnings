package com.mvc.learning.utils.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = CountrySelecValidatorImpl.class)
public @interface CoutrySelectValidator {

    String message() default "You must select a country";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
