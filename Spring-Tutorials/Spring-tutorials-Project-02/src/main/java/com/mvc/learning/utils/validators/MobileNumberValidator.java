package com.mvc.learning.utils.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = MobileNumberValidatorImp.class)
public @interface MobileNumberValidator {

    String message() default "{invalid.mobileNumber}";
    int max() default 10;

    String regexMobile() default "^\\d+$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
