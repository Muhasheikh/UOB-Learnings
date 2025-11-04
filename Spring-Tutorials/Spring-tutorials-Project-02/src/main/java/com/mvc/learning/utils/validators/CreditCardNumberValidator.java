package com.mvc.learning.utils.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = CreditNumberValidatorImp.class)
public @interface CreditCardNumberValidator {

    int max() default 4;
    String regex() default "^\\d+$";

    String message() default "Invalid credit card number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
