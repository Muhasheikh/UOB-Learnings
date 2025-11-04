package com.mvc.ecommerce.validators;


import com.mvc.ecommerce.validators.impl.CustomerLoginValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomerLoginValidatorImpl.class )
@Target(ElementType.FIELD)
@Documented
public @interface CustomerLoginValidator {

    int min() default 5;
    String userNameRegex() default "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).*$";
    String message() default "{username.invalid.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
