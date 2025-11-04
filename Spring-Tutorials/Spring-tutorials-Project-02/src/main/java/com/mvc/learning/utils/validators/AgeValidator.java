package com.mvc.learning.utils.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = AgeValidatorImpl.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AgeValidator {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int upper() default 60;
    int lower() default 18;
    String message()   default "{invalid.message}";
}
